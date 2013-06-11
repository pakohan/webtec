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


object TripInfo extends Controller {
	
	def insert() = {
		val data = form().bindFromRequest
		val respJSON = Json.newObject
		var nextId = 0

		DB.withConnection { implicit c =>
		    SQL("INSERT INTO seapal.wegpunkte(tnr, name, btm, dtm, lat, lng, sog, cog, manoever, vorsegel, wdate, wtime, marker) VALUES ("
                + "'" + data.get("tnr") + "',"
                + "'" + data.get("name") + "',"
                + "'" + data.get("btm") + "',"
                + "'" + data.get("dtm") + "',"
                + "'" + data.get("lat") + "',"
                + "'" + data.get("lng") + "',"
                + "'" + data.get("sog") + "',"
                + "'" + data.get("cog") + "',"
                + "'" + data.get("manoever") + "',"
                + "'" + data.get("vorsegel") + "',"
                + "'" + data.get("wdate") + "',"
                + "'" + data.get("wtime") + "',"
                + "'" + data.get("marker") + "');").execute

		    val result = SQL("SHOW TABLE STATUS FROM seapal LIKE 'wegpunkte'").resultSet
			
			if (result.next()) {
				nextId = result.getInt("Auto_increment")
			}

			respJSON.put("wnr", "" + (nextId - 1))
		}
		Ok(respJSON)
	}

	def delete(wnr: Int) = {
		val respJSON = Json.newObject

		DB.withConnection { implicit c =>
		    SQL("DELETE FROM seapal.wegpunkte WHERE wnr = " + wnr).execute
			respJSON.put("wnr", "ok");
		}
		Ok(respJSON)
	}
  
	def load(wnr: Int) = {
		val respJSON = Json.newObject

		DB.withConnection { implicit c =>
		    val result = SQL("SELECT * FROM seapal.wegpunkte WHERE wnr = " + wnr).resultSet
            val rsmd = result.getMetaData
            val numColumns = rsmd.getColumnCount

            while (result.next) {
                for (i <- 1 to numColumns) {
                    val columnName = rsmd.getColumnName(i)
                    respJSON.put(columnName, result.getString(i))
                }
            }
		}
		Ok(respJSON)
	}

	def index(tnr: Int) = {
		val data = new java.lang.StringBuilder()
		    
		DB.withConnection { implicit c =>
	        val result = SQL("SELECT * " + "FROM wegpunkte WHERE tnr = " + tnr).resultSet
	    
			while (result.next()) {

				data.append("<tr class='selectable' id='" + result.getString("wnr") + "'>");
				data.append("<td>" + result.getString("name") + "</td>");
				data.append("<td>" + result.getString("lat") + "</td>");
				data.append("<td>" + result.getString("lng") + "</td>");
				data.append("<td>" + result.getString("btm") + "</td>");
				data.append("<td>" + result.getString("dtm") + "</td>");
				data.append("<td>" + result.getString("manoever") + "</td>");
				data.append("<td style='width:30px; text-align:left;'><div class='btn-group'>");
				data.append("<a class='btn btn-small view' id='" + result.getString("wnr")
				  + "'><span><i class='icon-eye-open'></i></span></a>");
				data.append("<a class='btn btn-small remove' id='" + result.getString("wnr")
				  + "'><span><i class='icon-remove'></i></span></a>");
				data.append("<a class='btn btn-small redirect' id='" + result.getString("wnr")
				  + "' href='app_waypoint.html?wnr=" + result.getString("wnr")
				  + "'><span><i class='icon-chevron-right'></i></span></a>");
				    

				data.append("</div></td>");

				data.append("</tr>");
			}
		}
		Ok(tripinfo(header.render(), navigation.render("app_map"), navigation_app.render("app_tripinfo"), data.toString))
	}
}