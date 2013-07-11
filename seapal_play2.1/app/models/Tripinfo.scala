package models

import play.api.mvc._
import play.api.db.DB
import play.api.Play.current
import play.api.libs.json._

import anorm._ 

object Tripinfo {
	//totally unused right now
	
	def insert(implicit request: Request[AnyContent]) = {
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

				Json.obj("wnr" -> (nextId - 1).toString)
			}
		} catch {
  		  case e: Exception => Json.obj("wnr" -> ("Error: " + e.toString))
  		}
	}

	def delete(wnr: Int) = {
		DB.withConnection { implicit c =>
		    SQL("DELETE FROM seapal.wegpunkte WHERE wnr = " + wnr).execute
		    Json.obj("wnr" -> "ok")
		}
	}
  
	def load(wnr: Int) = {
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
		respJSON
	}

def index(tnr: Int) = {
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
		data.toString
	}
}