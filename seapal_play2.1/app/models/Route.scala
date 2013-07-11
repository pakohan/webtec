package models

import play.api.mvc._
import play.api.db.DB
import play.api.Play.current
import play.api.libs.json._

import anorm._ 


object Route {

	//unused code from here <!--
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
	
	//until here --> following used code
	def insertRoute(implicit request: Request[AnyContent]) = {
		println("Route inserted")

		"ok"
	}

	def deleteRoute() = {
		println("Route deleted")
		"ok"
	}
  
	def loadRoute() = {
		println("Route loaded")
		"ok"
	}

	def insertMarker(implicit request: Request[AnyContent]) = {
		println("Marker inserted")

		"ok"
	}

	def index = {
		"<tbody id='entries_route'><tr class='selectable' id='1'><td>Kleine Bodensee &Uuml;berquerung</td><td>Konstanz</td><td>Lindau</td>" +
		"<td style='width:30px; text-align:left;'><div class='btn-group'><a class='btn btn-small view' id='1'><span><i class='icon-eye-open'></i></span>" +
		"</a><a class='btn btn-small remove' id='1'><span><i class='icon-remove'></i></span></a></div></td></tr></table>";
	}
}