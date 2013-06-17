package controllers

import play.api.mvc._
import play.api.db.DB
import play.api.Play.current
import play.api.libs.json._

import views.html._
import views.html._include._
import views.html._include.logbook._

import anorm._


object Boatinfo extends Controller {

	def index = Action {	    
		val data = loadEntries();

		val testData = "<tbody id='entries_boat_info'><tr class='selectable' id='1'><td>Reise nach Jerusalem</td><td>Captain Kirk</td><td>11.11.2014</td><td>12.11.2014</td><td>2</td>" +
			  		"<td>nein</td><td style='width:30px; text-align:left;'><div class='btn-group'><a class='btn btn-small view' id='1'><span><i class='icon-eye-open'></i></span>" +
			  		"</a><a class='btn btn-small remove' id='1'><span><i class='icon-remove'></i></span></a></div></td></tr><tr class='selectable' id='2'>" +
			  		"<td>Reise nach Jerusalem</td><td>Captain Kirk</td><td>11.11.2014</td><td>12.11.2014</td><td>2</td><td>nein</td><td style='width:30px; text-align:left;'><div class='btn-group'>" +
			  		"<a class='btn btn-small view' id='2'><span><i class='icon-eye-open'></i></span></a><a class='btn btn-small remove' id='2'><span><i class='icon-remove'></i>" +
			  		"</span></a></div></td></tr><tr class='selectable' id='3'><td>Reise nach Jerusalem</td><td>Captain Kirk</td><td>11.11.2014</td>" +
			  		"<td>12.11.2014</td><td>2</td><td>nein</td><td style='width:30px; text-align:left;'><div class='btn-group'><a class='btn btn-small view' id='3'><span><i class='icon-eye-open'>" +
			  		"</i></span></a><a class='btn btn-small remove' id='3'><span><i class='icon-remove'></i></span></a></div></td></tr></table>";
		
	  	Ok(boatinfo(header_app_trip.render(),
	  				navigation.render("app_map"), 
				    navigation_app.render("app_boatinfo"), 
				    logbook_boatinfo_menu.render(data),
				    logbook_trip_menu.render(testData),
				    logbook_boatinfo.render(),
				    logbook_tripinfo.render(),
				    logbook_weatherinfo.render(),
				    simple_map.render()))
  	}

  	def insert() = Action { implicit request =>
  		try {
		    val data = request.body.asFormUrlEncoded
		    var nextId = 0

		    DB.withConnection { implicit c =>
		        SQL("INSERT INTO seapal.bootinfo(bootname, registernummer, segelzeichen, heimathafen, yachtclub, eigner, versicherung,"
		                + "rufzeichen, typ, konstrukteur, laenge, breite, tiefgang, masthoehe, verdraengung, rigart,"
		                + "baujahr, motor, tankgroesse, wassertankgroesse, abwassertankgroesse, grosssegelgroesse,"
		                + "genuagroesse, spigroesse) "
		                + "VALUES('" + data.get("bootname")(0) + "',"
		                + "'" + data.get("registernummer")(0) + "',"
		                + "'" + data.get("segelzeichen")(0)  + "',"
		                + "'" + data.get("heimathafen")(0) + "',"
		                + "'" + data.get("yachtclub")(0) + "',"
		                + "'" + data.get("eigner")(0) + "',"
		                + "'" + data.get("versicherung")(0) + "',"
		                + "'" + data.get("rufzeichen")(0) + "',"
		                + "'" + data.get("typ")(0) + "',"
		                + "'" + data.get("konstrukteur")(0) + "',"
		                + "'" + data.get("laenge")(0) + "',"
		                + "'" + data.get("breite")(0) + "',"
		                + "'" + data.get("tiefgang")(0) + "',"
		                + "'" + data.get("masthoehe")(0) + "',"
		                + "'" + data.get("verdraengung")(0) + "',"
		                + "'" + data.get("rigart")(0) + "',"
		                + "'" + data.get("baujahr")(0) + "',"
		                + "'" + data.get("motor")(0) + "',"
		                + "'" + data.get("tankgroesse")(0) + "',"
		                + "'" + data.get("wassertankgroesse")(0) + "',"
		                + "'" + data.get("abwassertankgroesse")(0) + "',"
		                + "'" + data.get("grosssegelgroesse")(0) + "',"
		                + "'" + data.get("genuagroesse")(0) + "',"
		                + "'" + data.get("spigroesse")(0) + "');").execute
				

		         val result = SQL("SHOW TABLE STATUS FROM seapal LIKE 'bootinfo'").resultSet
		         
		         if (result.next) {
		             nextId = result.getInt("Auto_increment")
		         }
		    }
		    Ok(Json.obj("bnr" -> (nextId - 1).toString))
	    } catch {
  		  case e: Exception => Ok(Json.obj("bnr" -> ("Error: " + e.toString)))
  		} 
	    
	}

  	def delete(bnr: Int) = Action {
		DB.withConnection { implicit c =>
		    SQL("DELETE FROM seapal.bootinfo WHERE bnr = " + bnr).execute
		}
		Ok(Json.obj("bnr" -> "ok"))
	}

	def load(bnr: Int) = Action {
	    var respJSON = Json.obj()

	    DB.withConnection { implicit c =>
	        val result = SQL("SELECT * FROM seapal.bootinfo WHERE bnr = " + bnr).resultSet
	        
            val rsmd = result.getMetaData
            val numColumns = rsmd.getColumnCount

            while (result.next) {
                for (i <- 1 to numColumns) {
                    val columnName = rsmd.getColumnName(i)
                    respJSON = respJSON ++ Json.obj(columnName -> result.getString(i))
                }
            }
	  }
	  Ok(respJSON)
	}

	def loadEntries() = {
		DB.withConnection { implicit c =>
			val result = SQL("SELECT * FROM bootinfo").resultSet
			val data = new java.lang.StringBuilder()

			while (result.next) {
				data.append("<tr class='selectable' id='" + result.getString("bnr") + "'>")
				data.append("<td>" + result.getString("bootname") + "</td>")
				data.append("<td>" + result.getString("typ") + "</td>")
				data.append("<td>" + result.getString("konstrukteur") + "</td>")
				data.append("<td>" + result.getString("baujahr") + "</td>")
				data.append("<td>" + result.getString("heimathafen") + "</td>")
				data.append("<td>" + result.getString("laenge") + "</td>")
				data.append("<td>" + result.getString("breite") + "</td>")
				data.append("<td>" + result.getString("tiefgang") + "</td>")
				data.append("<td>" + result.getString("eigner") + "</td>")
				data.append("<td style='width:30px; text-align:left;'><div class='btn-group'>")
				data.append("<a class='btn btn-small view' id='" + result.getString("bnr")
				  + "'><span><i class='icon-eye-open'></i></span></a>")
				data.append("<a class='btn btn-small remove' id='" + result.getString("bnr")
				  + "'><span><i class='icon-remove'></i></span></a>")
				data.append("</div></td>")
				data.append("</tr>")
			}
			data.toString
		}
	}
}