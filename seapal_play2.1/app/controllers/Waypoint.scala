package controllers

import play.api.mvc._

import views.html._
import views.html._include._


object Waypoint extends Controller {

	def index(wnr: Int) = Action {	    
		load(wnr)
	  	Ok(waypoint(navigation.render("app_map"), 
				    navigation_app.render("app_waypoint")))
  	}


	def load(wnr: Int) = Action {
	  Ok(models.Waypoint.load(wnr))
	}
}