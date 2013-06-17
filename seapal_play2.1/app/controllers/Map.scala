package controllers

import play.api._
import play.api.mvc._

import views.html._
import views.html._include._
import views.html._include.mapInc._

object Map extends Controller {

  def index = Action {	    
	  Ok(map(header_app.render(),
	  			header_app_map.render(),
	  			navigation.render("app_map"),
	  			navigation_app.render("app_map"),
	  			map_content.render(),
	  			weather_chart.render()))
  }
}