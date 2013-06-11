package controllers

import play.api._
import play.api.mvc._
import play.api.db.DB
import play.api.Play.current
import play.libs.Json
import play.data.DynamicForm

import views.html._
import views.html._include._

import anorm._ 
import anorm.SqlParser._

import org.codehaus.jackson.node.ObjectNode


object Boatinfo extends Controller {

	def index = Action {	    
		val data = loadEntries();
		
	  	Ok(boatinfo(header.render(), 
			    	navigation.render("app_map"), 
				    navigation_app.render("app_boatinfo"), 
				    data))
  	}

  	/*def insert() {
	    val data: DynamicForm = form().bindFromRequest      
	    val respJSON = Json.newObject
	    var nextId = 0

	    DB.withConnection { implicit c =>
	        SQL("INSERT INTO seapal.bootinfo(bootname, registernummer, segelzeichen, heimathafen, yachtclub, eigner, versicherung,"
	                + "rufzeichen, typ, konstrukteur, laenge, breite, tiefgang, masthoehe, verdraengung, rigart,"
	                + "baujahr, motor, tankgroesse, wassertankgroesse, abwassertankgroesse, grosssegelgroesse,"
	                + "genuagroesse, spigroesse) "
	                + "VALUES('" + data.get("bootname") + "',"
	                + "'" + data.get("registernummer") + "',"
	                + "'" + data.get("segelzeichen") + "',"
	                + "'" + data.get("heimathafen") + "',"
	                + "'" + data.get("yachtclub") + "',"
	                + "'" + data.get("eigner") + "',"
	                + "'" + data.get("versicherung") + "',"
	                + "'" + data.get("rufzeichen") + "',"
	                + "'" + data.get("typ") + "',"
	                + "'" + data.get("konstrukteur") + "',"
	                + "'" + data.get("laenge") + "',"
	                + "'" + data.get("breite") + "',"
	                + "'" + data.get("tiefgang") + "',"
	                + "'" + data.get("masthoehe") + "',"
	                + "'" + data.get("verdraengung") + "',"
	                + "'" + data.get("rigart") + "',"
	                + "'" + data.get("baujahr") + "',"
	                + "'" + data.get("motor") + "',"
	                + "'" + data.get("tankgroesse") + "',"
	                + "'" + data.get("wassertankgroesse") + "',"
	                + "'" + data.get("abwassertankgroesse") + "',"
	                + "'" + data.get("grosssegelgroesse") + "',"
	                + "'" + data.get("genuagroesse") + "',"
	                + "'" + data.get("spigroesse") + "');").execute

	         val result = SQL("SHOW TABLE STATUS FROM seapal LIKE 'bootinfo'").resultSet
	         
	         if (result.next) {
	             nextId = result.getInt("Auto_increment")
	         }

	         respJSON.put("bnr", "" + (nextId - 1))
	    }
	    Ok(respJSON)
	}*/

  	/*def delete(bnr: Int) = {
		var respJSON = Json.newObject()

		DB.withConnection { implicit c =>
		    SQL("DELETE FROM seapal.bootinfo WHERE bnr = " + bnr).execute
		    respJSON.put("bnr", "ok");
		}

		Ok(respJSON);
	}*/

	/*def load(bnr: Int) {
	    var respJSON: ObjectNode = Json.newObject

	    DB.withConnection { implicit c =>
	        val result = SQL("SELECT * FROM seapal.bootinfo WHERE bnr = " + bnr).resultSet
	        
            val rsmd = result.getMetaData
            val numColumns = rsmd.getColumnCount

            while (result.next) {
                for (i <- 1 to numColumns) {
                    val columnName: String = rsmd.getColumnName(i)
                    respJSON.put(columnName, result.getString(i))
                }
            }
	  }
	  Ok(respJSON)
	}*/

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