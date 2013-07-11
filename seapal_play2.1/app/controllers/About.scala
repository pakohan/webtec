package controllers

import play.api._
import play.api.mvc._

import views.html._
import views.html._include._

object About extends Controller {
  
  def index = Action {
    Ok(about(header.render)(navigation("about"))(footer.render))
  }
}