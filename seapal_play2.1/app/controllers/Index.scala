package controllers

import play.api._
import play.api.mvc._

import views.html._
import views.html._include._

object Index extends Controller {

  def index = Action {	    
	  Ok(views.html.index(navigation.render("index")))
  }
}