package models

import play.api.mvc._
import play.api.db.DB
import play.api.Play.current
import play.api.libs.json._

import anorm._ 


object Route {
	
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