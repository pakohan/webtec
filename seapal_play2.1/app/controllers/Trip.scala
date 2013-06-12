package controllers

import play.api.mvc._
import play.api.db.DB
import play.api.Play.current
import play.data.DynamicForm
import play.api.libs.json._

import views.html._
import views.html._include._

import anorm._ 


object Trip extends Controller {
	
	def insert() = Action {
		val data = new DynamicForm().bindFromRequest()
		var nextId = 0

		DB.withConnection { implicit c =>
		    SQL("INSERT INTO seapal.tripinfo (titel, von, nach, skipper, crew, tstart, tende, tdauer, motor, tank) VALUES ("
		            + "'" + data.get("titel") + "',"
		            + "'" + data.get("von") + "',"
		            + "'" + data.get("nach") + "',"
		            + "'" + data.get("skipper") + "',"
		            + "'" + data.get("crew") + "',"
		            + "'" + data.get("tstart") + "',"
		            + "'" + data.get("tende") + "',"
		            + "'" + data.get("tdauer") + "',"
		            + "'" + data.get("motor") + "',"
		            + " " + data.get("tank") + ");").execute

		     val result = SQL("SHOW TABLE STATUS FROM seapal LIKE 'tripinfo'").resultSet
		     
		     if (result.next) {
		         nextId = result.getInt("Auto_increment")
		     }
		 }
		Ok(Json.obj("status" -> "OK", "tnr" -> (nextId - 1).toString))
	}

	def delete(tnr: Int) = Action {
		DB.withConnection { implicit c =>
		    SQL("DELETE FROM seapal.tripinfo WHERE tnr = " + tnr).execute
		}
		Ok(Json.obj("status" -> "OK", "tnr" -> "ok"))
	}
  
	def load(tnr: Int) = Action {
		val respJSON = Json.obj()

		DB.withConnection { implicit c =>
		    val result = SQL("SELECT * FROM seapal.tripinfo WHERE tnr = " + tnr).resultSet
		    
		    val rsmd = result.getMetaData
		    val numColumns = rsmd.getColumnCount

		    while (result.next) {
		        for (i <- 1 to numColumns) {
		            val columnName = rsmd.getColumnName(i)
		            respJSON ++ Json.obj(columnName -> result.getString(i))
		        }
		    }
		}
		Ok(respJSON)
	}

	def index() = Action {
		val data = new java.lang.StringBuilder()
		    
		DB.withConnection { implicit c =>
	        val result = SQL("SELECT * " + "FROM seapal.tripinfo ").resultSet
	    
	        while (result.next) {
		        data.append("<tr class='selectable' id='" + result.getString("tnr") + "'>")
		        data.append("<td>" + result.getString("titel") + "</td>")
		        data.append("<td>" + result.getString("skipper") + "</td>")
		        data.append("<td>" + result.getString("tstart") + "</td>")
		        data.append("<td>" + result.getString("tende") + "</td>")
		        data.append("<td>" + result.getString("tdauer") + "</td>")
		        data.append("<td>" + result.getString("motor") + "</td>")
		        data.append("<td style='width:30px; text-align:left;'><div class='btn-group'>")
		        data.append("<a class='btn btn-small view' id='" + result.getString("tnr")
		          + "'><span><i class='icon-eye-open'></i></span></a>")
		        data.append("<a class='btn btn-small remove' id='" + result.getString("tnr")
		          + "'><span><i class='icon-remove'></i></span></a>")
		        data.append("<a class='btn btn-small redirect' id='" + result.getString("tnr")
		          + "' href='app_tripinfo.html?tnr=" + result.getString("tnr")
		          + "'><span><i class='icon-chevron-right'></i></span></a>")
		        data.append("</div></td>")
		        data.append("</tr>")
		    }
		}
		Ok(trip(navigation.render("app_map"), navigation_app.render("app_trip"), data.toString))
	}
}