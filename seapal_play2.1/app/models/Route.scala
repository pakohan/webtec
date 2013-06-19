package models

import play.api.mvc._
import play.api.db.DB
import play.api.Play.current
import play.api.libs.json._

import anorm._ 


object Route {
	
	def insert(implicit request: Request[AnyContent]) = {
		try {
			val data = request.body.asFormUrlEncoded
			var nextId = 0

			DB.withConnection { implicit c =>
			    SQL("INSERT INTO seapal.tripinfo (titel, von, nach, skipper, crew, tstart, tende, tdauer, motor, tank) VALUES ("
			            + "'" + data.get("titel")(0) + "',"
			            + "'" + data.get("von")(0) + "',"
			            + "'" + data.get("nach")(0) + "',"
			            + "'" + data.get("skipper")(0) + "',"
			            + "'" + data.get("crew")(0) + "',"
			            + "'" + data.get("tstart")(0) + "',"
			            + "'" + data.get("tende")(0) + "',"
			            + "'" + data.get("tdauer")(0) + "',"
			            + "'" + data.get("motor")(0) + "',"
			            + " " + data.get("tank")(0) + ");").execute

			     val result = SQL("SHOW TABLE STATUS FROM seapal LIKE 'tripinfo'").resultSet
			     
			     if (result.next) {
			         nextId = result.getInt("Auto_increment")
			     }
			 }
			Json.obj("tnr" -> (nextId - 1).toString)
		} catch {
  		  case e: Exception => Json.obj("tnr" -> ("Error: " + e.toString))
  		}
	}

	def delete(tnr: Int) = {
		DB.withConnection { implicit c =>
		    SQL("DELETE FROM seapal.tripinfo WHERE tnr = " + tnr).execute
		}
		Json.obj("tnr" -> "ok")
	}
  
	def load(tnr: Int) = {
		var respJSON = Json.obj()

		DB.withConnection { implicit c =>
		    val result = SQL("SELECT * FROM seapal.tripinfo WHERE tnr = " + tnr).resultSet
		    
		    val rsmd = result.getMetaData
		    val numColumns = rsmd.getColumnCount

		    while (result.next) {
		        for (i <- 1 to numColumns) {
		            val columnName = rsmd.getColumnName(i)
		            respJSON = respJSON ++ Json.obj(columnName -> result.getString(i))
		        }
		    }
		}
		Json.toJson(respJSON)
	}

	def index = {
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
		        data.append("</div></td>")
		        data.append("</tr>")
		    }
		}
		data.toString
	}
}