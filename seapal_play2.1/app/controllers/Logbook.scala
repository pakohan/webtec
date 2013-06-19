package controllers

import play.api.mvc._

import views.html._
import views.html._include._
import views.html._include.logbookInc._


object Logbook extends Controller {

	def index = Action {	    
		val boatData = ""

		val tripData = models.Logbook.tripMenu
		
	  	Ok(logbook(header_app_logbook.render(),
	  				navigation.render("app_map"), 
				    navigation_app.render("app_boatinfo"), 
				    logbook_boatinfo_menu.render(boatData),
				    logbook_trip_menu.render(tripData),
				    logbook_boatinfo.render(),
				    logbook_tripinfo.render(),
				    logbook_weatherinfo.render(),
				    simple_map.render()))
  	}

  	def insertTripValue() = Action { implicit request =>
		Ok(models.Logbook.insertTripValue)
	}
	
	def insertWeatherValue() = Action { implicit request =>
		Ok(models.Logbook.insertWeatherValue)
	}

  	def deleteTrip() = Action {
		Ok(models.Logbook.deleteTrip)
	}

	def loadTrip() = Action {
	  Ok(models.Logbook.loadTrip)
	}
	
	def loadRoute() = Action {
	  Ok(models.Logbook.loadRoute)
	}
	
	def loadBoat() = Action {
	  Ok(models.Logbook.loadBoat)
	}

}