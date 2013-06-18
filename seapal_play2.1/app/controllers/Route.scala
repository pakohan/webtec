package controllers

import play.api.mvc._

import views.html._
import views.html._include._
import views.html._include.routeInc._

import anorm._ 

object Route extends Controller {
	
	def insert = Action { implicit request =>
		Ok(models.Route.insert)
	}

	def delete(tnr: Int) = Action {
		Ok(models.Route.delete(tnr))
	}
  
	def load(tnr: Int) = Action {
		try {
			Ok(models.Route.load(tnr))
		} catch {
  		  case e: Exception => BadRequest("Error: " + e.toString)
  		}
	}

	def index() = Action {
		Ok(route(header_app_route.render(),
				navigation.render("app_map"),
				navigation_app.render("app_trip"),
				route_menu.render(models.Route.index),
				route_map.render()))
	}
}