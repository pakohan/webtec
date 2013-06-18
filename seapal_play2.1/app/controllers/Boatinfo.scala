package controllers

import play.api.mvc._

import views.html._
import views.html._include._


object Boatinfo extends Controller {

	def index = Action {	    
		val data = loadEntries();
		
	  	Ok(boatinfo(navigation.render("app_map"), 
				    navigation_app.render("app_boatinfo"), 
				    data))
  	}

  	def insert() = Action { implicit request =>
		Ok(models.Boatinfo.insert)
	}

  	def delete(bnr: Int) = Action {
		Ok(models.Boatinfo.delete(bnr))
	}

	def load(bnr: Int) = Action {
	  Ok(models.Boatinfo.load(bnr))
	}

	private def loadEntries() = {
		models.Boatinfo.loadEntries
	}
}