package models

import play.api.mvc._
import play.api.db.DB
import play.api.Play.current
import play.api.libs.json._

import anorm._


object Logbook {

	//unused code <!--
    def insert(implicit request: Request[AnyContent]) = {
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
	        Json.obj("bnr" -> (nextId - 1).toString)
	    } catch {
	        case e: Exception => Json.obj("bnr" -> ("Error: " + e.toString))
	    } 
    }

    def delete(bnr: Int) = {
	    DB.withConnection { implicit c =>
	        SQL("DELETE FROM seapal.bootinfo WHERE bnr = " + bnr).execute
    	}

    	Json.obj("bnr" -> "ok")
    }

    def load(bnr: Int) = {
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
    	respJSON
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

    //until here --> following used code
  	def insertTripValue(implicit request: Request[AnyContent]) = {

		val data = request.body.asFormUrlEncoded

  		println("Inserted: ")
  		println("Field: " + data.get("id")(0))
  		println("Value: " + data.get("value")(0))

  		"ok"
	}

	def insertWeatherValue(implicit request: Request[AnyContent]) = {

		val data = request.body.asFormUrlEncoded

  		println("Inserted: ")
  		println("Field: " + data.get("id")(0))
  		println("Marker: " + data.get("markerID")(0))
  		println("Value: " + data.get("value")(0))

  		"ok"
	}

  	def deleteTrip = {
		
		println("Trip deleted")
		"ok"
	}

	def loadTrip = {

	  	Json.obj("bootname" -> "Titanic", "registernummer" -> 101, "segelzeichen" -> "TI101", "heimathafen" -> "New York",
	  				"yachtclub" -> "New York Yacht Club", "eigner" -> "George Boat", "versicherung" -> "Württembergische",
	  				"rufzeichen" -> "TI", "typ" -> "Schiff", "konstrukteur" -> "Peter Schiff", "laenge" -> 200, "breite" -> 50,
	  				"tiefgang" -> 7, "masthoehe" -> 10, "verdraengung" -> 1000, "rigart" -> "T20", "baujahr" -> 1993,
	  				"motor" -> "Duotec 100", "tankgroesse" -> 500, "wassertankgroesse" -> 50, "abwassertankgroesse" -> 30,
	  				"grosssegelgroesse" -> 10, "genuagroesse" -> 25, "spigroesse" -> 13, "titel" -> "Langer Trip nach England",
	  				"von" -> "Hamburg", "nach" -> "Dover", "skipper" -> "Hr. Hein", "crew" -> "Martin Felix Manuel",
	  				"tstart" -> "01-07-2012", "tende" -> "02-07-2012", "tdauer" -> 300, "motor" -> 1241, "tank" -> true).toString
	}

	def loadRoute = {

		"ok"
	}

	def loadBoat = {

		Json.obj("bootname" -> "MS Deutschland", "registernummer" -> 101, "segelzeichen" -> "TI101", "heimathafen" -> "New York",
	  				"yachtclub" -> "New York Yacht Club", "eigner" -> "George Boat", "versicherung" -> "Württembergische",
	  				"rufzeichen" -> "TI", "typ" -> "Schiff", "konstrukteur" -> "Peter Schiff", "laenge" -> 200, "breite" -> 50,
	  				"tiefgang" -> 7, "masthoehe" -> 10, "verdraengung" -> 1000, "rigart" -> "T20", "baujahr" -> 1993,
	  				"motor" -> "Duotec 100", "tankgroesse" -> 500, "wassertankgroesse" -> 50, "abwassertankgroesse" -> 30,
	  				"grosssegelgroesse" -> 10, "genuagroesse" -> 25, "spigroesse" -> 13).toString
	}

	def tripMenu = {

		"<tbody id='entries_boat_info'><tr class='selectable' id='1'><td>Reise nach Jerusalem</td><td>Captain Kirk</td><td>11.11.2011</td><td>12.11.2011</td><td>2</td>" +
		"<td>nein</td><td style='width:30px; text-align:left;'><div class='btn-group'><a class='btn btn-small view' id='1'><span><i class='icon-eye-open'></i></span>" +
		"</a><a class='btn btn-small remove' id='1'><span><i class='icon-remove'></i></span></a></div></td></tr></table>";
	}

	def boatMenu = {
		""
	}
}