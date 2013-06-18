package controllers

import play.api.mvc._

import views.html._
import views.html._include._

object Tripinfo extends Controller {
	
	def insert = Action { implicit request =>
		Ok(models.Tripinfo.insert)
	}

	def delete(wnr: Int) = Action {
		Ok(models.Tripinfo.delete(wnr))
	}
  
	def load(wnr: Int) = Action {
		try {
			Ok(models.Tripinfo.load(wnr))
		} catch {
  		  case e: Exception => BadRequest("Error: " + e.toString)
  		}
	}

	def index(tnr: Int) = Action {
		try {
			Ok(tripinfo(navigation.render("app_map"), navigation_app.render("app_tripinfo"), models.Tripinfo.index(tnr)))
		} catch {
  		  case e: Exception => BadRequest("Error: " + e.toString)
  		}
	}
}