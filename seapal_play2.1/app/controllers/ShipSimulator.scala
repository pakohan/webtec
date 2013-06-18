package controllers

import play.api._
import play.api.mvc._
import play.api.libs.iteratee._
import play.api.libs.json._

object ShipSimulator extends Controller {


	def websocket = WebSocket.using[String] { request => 
		 // Just consume and ignore the input
		val in = Iteratee.consume[String]()

		// Send a single 'Hello!' message and close
		val out = Enumerator(coordinates).andThen(Enumerator.eof)

		(in, out)
	}


	private def coordinates = {
		/*
		 * Lat:47��(38-30).XX'N
		 * Long:009��(16-19).XX'E
		 */

		val lat = 30 + scala.util.Random.nextInt(9)
		val longitude = 16 + scala.util.Random.nextInt(4)

		"{Lat;47��%d.01'N, Long:009��%d.05'E}".format(lat, longitude)
	}
	
	var ship1Lat = 47.659260;
	var ship1Lng = 9.274322;
	var ship2Lat = 47.530647;
	var ship2Lng = 9.531959;
	var ship3Lat = 47.555677;
	var ship3Lng = 9.41111;
	
	def getShipPositions() = Action {
		Thread.sleep(1000);
		
		ship1Lat = ship1Lat - 0.001;
		ship1Lng = ship1Lng + 0.003;
		ship2Lat = ship2Lat + 0.001;
		ship2Lng = ship2Lng - 0.003;
		ship3Lat = ship3Lat + 0.003;
		ship3Lng = ship3Lng - 0.0003;
		
		val dataJSON = Json.obj("ship1Lat" -> ship1Lat, "ship1Lng" -> ship1Lng,
								"ship2Lat" -> ship2Lat, "ship2Lng" -> ship2Lng,
								"ship3Lat" -> ship3Lat, "ship3Lng" -> ship3Lng);
		Ok(dataJSON);
	}
}