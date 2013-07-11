package models

import play.api.mvc._
import play.api.libs.json._

object Simulator {

	var ship1Lat = 47.659260;
	var ship1Lng = 9.274322;
	var ship2Lat = 47.530647;
	var ship2Lng = 9.531959;
	var ship3Lat = 47.555677;
	var ship3Lng = 9.41111;
	
	def simulateShips = {

		Thread.sleep(1000);
			
		ship1Lat = ship1Lat - 0.001;
		ship1Lng = ship1Lng + 0.003;
		ship2Lat = ship2Lat + 0.001;
		ship2Lng = ship2Lng - 0.003;
		ship3Lat = ship3Lat + 0.001;
		ship3Lng = ship3Lng - 0.0003;
			
		Json.obj("ship1Lat" -> ship1Lat, "ship1Lng" -> ship1Lng,
					"ship2Lat" -> ship2Lat, "ship2Lng" -> ship2Lng,
					"ship3Lat" -> ship3Lat, "ship3Lng" -> ship3Lng);
	}
}