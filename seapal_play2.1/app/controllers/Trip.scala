package controllers

import play.api.mvc._

import views.html._
import views.html._include._

object Trip extends Controller {
	
	def insert = Action { implicit request =>
		Ok(models.Trip.insert)
	}

	def delete(tnr: Int) = Action {
		Ok(models.Trip.delete(tnr))
	}
  
	def load(tnr: Int) = Action {
		try {
			Ok(models.Trip.load(tnr))
		} catch {
  		  case e: Exception => BadRequest("Error: " + e.toString)
  		}
	}

	def index = Action {
		Ok(trip(navigation.render("app_map"), navigation_app.render("app_trip"), models.Trip.index))
	}
}