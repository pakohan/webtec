package controllers

import play.api.mvc._

import views.html._
import views.html._include._
import views.html._include.routeInc._

import anorm._ 

object Route extends Controller {
	
	def insertRoute = Action { implicit request =>
		Ok(models.Route.insertRoute)
	}

	def deleteRoute() = Action {
		Ok(models.Route.deleteRoute)
	}
  
	def loadRoute() = Action {
		try {
			Ok(models.Route.loadRoute)
		} catch {
  		  case e: Exception => BadRequest("Error: " + e.toString)
  		}
	}

	def insertMarker = Action { implicit request =>
		Ok(models.Route.insertMarker)
	}

	def index() = Action {
		Ok(route(header_app_route.render(),
				navigation.render("app_map"),
				navigation_app.render("app_trip"),
				route_menu.render(models.Route.index),
				route_map.render()))
	}
}