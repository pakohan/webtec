package controllers

import play.api._
import play.api.mvc._
import play.api.db.DB
import play.api.Play.current
import play.api.libs.json._

import play.data.DynamicForm

import views.html._
import views.html._include._

import anorm._ 
import anorm.SqlParser._


object Tripinfo extends Controller {
	
	def insert() = Action { implicit request =>
		try {
			val data = request.body.asFormUrlEncoded
			var nextId = 0

			DB.withConnection { implicit c =>
			    SQL("INSERT INTO seapal.wegpunkte(tnr, name, btm, dtm, lat, lng, sog, cog, manoever, vorsegel, wdate, wtime, marker) VALUES ("
	                + "'" + data.get("tnr")(0) + "',"
	                + "'" + data.get("name")(0) + "',"
	                + "'" + data.get("btm")(0) + "',"
	                + "'" + data.get("dtm")(0) + "',"
	                + "'" + data.get("lat")(0) + "',"
	                + "'" + data.get("lng")(0) + "',"
	                + "'" + data.get("sog")(0) + "',"
	                + "'" + data.get("cog")(0) + "',"
	                + "'" + data.get("manoever")(0) + "',"
	                + "'" + data.get("vorsegel")(0) + "',"
	                + "'" + data.get("wdate")(0) + "',"
	                + "'" + data.get("wtime")(0) + "',"
	                + "'" + data.get("marker")(0) + "');").execute

			    val result = SQL("SHOW TABLE STATUS FROM seapal LIKE 'wegpunkte'").resultSet
				
				if (result.next()) {
					nextId = result.getInt("Auto_increment")
				}

				Ok(Json.obj("wnr" -> (nextId - 1).toString))
			}
		} catch {
  		  case e: Exception => Ok(Json.obj("wnr" -> ("Error: " + e.toString)))
  		}
	}

	def delete(wnr: Int) = Action {
		DB.withConnection { implicit c =>
		    SQL("DELETE FROM seapal.wegpunkte WHERE wnr = " + wnr).execute
		    Ok(Json.obj("wnr" -> "ok"))
		}
	}
  
	def load(wnr: Int) = Action {
		try {
			var respJSON = Json.obj()

			DB.withConnection { implicit c =>
			    val result = SQL("SELECT * FROM seapal.wegpunkte WHERE wnr = " + wnr).resultSet
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
		} catch {
  		  case e: Exception => BadRequest("Error: " + e.toString)
  		}
	}

	def index(tnr: Int) = Action {
		try {
			val data = new java.lang.StringBuilder()
			    
			DB.withConnection { implicit c =>
		        val result = SQL("SELECT * " + "FROM wegpunkte WHERE tnr = " + tnr).resultSet
		    
				while (result.next) {
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
			Ok(tripinfo(navigation.render("app_map"), navigation_app.render("app_tripinfo"), data.toString))
		} catch {
  		  case e: Exception => BadRequest("Error: " + e.toString)
  		}
	}
}