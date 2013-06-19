package models

import play.api.mvc._
import play.api.db.DB
import play.api.Play.current
import play.api.libs.json._

import anorm._


object Logbook {

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

		// val jsonreturn = Json.toJson("0" -> ("lat" -> 47.655733, "lng" -> 9.206272, "time" -> 1360938650),
		// 								"1" -> ("lat" -> 47.656196, "lng" -> 9.223953, "time" -> 1360938700),
		// 								"2" -> ("lat" -> 47.656080, "lng" -> 9.254681, "time" -> 1360938750),
		// 								"3" -> ("lat" -> 47.656369, "lng" -> 9.288326, "time" -> 1360938800),
		// 								"4" -> ("lat" -> 47.521780, "lng" -> 9.719282, "time" -> 1360938850))
		// Json.stringify(jsonreturn)
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

		"<tbody id='entries_boat_info'><tr class='selectable' id='1'><td>Reise nach Jerusalem</td><td>Captain Kirk</td><td>11.11.2014</td><td>12.11.2014</td><td>2</td>" +
		"<td>nein</td><td style='width:30px; text-align:left;'><div class='btn-group'><a class='btn btn-small view' id='1'><span><i class='icon-eye-open'></i></span>" +
		"</a><a class='btn btn-small remove' id='1'><span><i class='icon-remove'></i></span></a></div></td></tr></table>";
	}

	def boatMenu = {
		""
	}
}