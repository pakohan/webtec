package controllers

import play.api._
import play.api.mvc._
import play.api.libs.iteratee._


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
		 * Lat:47°(38-30).XX'N
		 * Long:009°(16-19).XX'E
		 */

		val lat = 30 + scala.util.Random.nextInt(9)
		val longitude = 16 + scala.util.Random.nextInt(4)

		"{Lat;47°%d.01'N, Long:009°%d.05'E}".format(lat, longitude)
	}
}