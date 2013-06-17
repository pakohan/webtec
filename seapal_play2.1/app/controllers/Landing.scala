package controllers

import play.api._
import play.api.mvc._

import views.html._
import views.html._include._

object Landing extends Controller {

  def index = Action {	    
	  Ok(landing(navigation.render("landing")))
  }
}