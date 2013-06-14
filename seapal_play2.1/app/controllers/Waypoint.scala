package controllers

import play.api.mvc._
import play.api.db.DB
import play.api.Play.current
import play.api.libs.json._

import views.html._
import views.html._include._

import anorm._


object Waypoint extends Controller {

	def index(wnr: Int) = Action {	    
		load(wnr)
	  	Ok(waypoint(navigation.render("app_map"), 
				    navigation_app.render("app_waypoint")))
  	}


	def load(wnr: Int) = Action {
	    var respJSON = Json.obj()

	    DB.withConnection { implicit c =>
	        var result = SQL("SELECT * FROM seapal.wegpunkte WHERE wnr = " + wnr).resultSet
	        
            val rsmd = result.getMetaData
            val numColumns = rsmd.getColumnCount

            while (result.next) {
                for (i <- 1 to numColumns) {
                    val columnName = rsmd.getColumnName(i)
                    respJSON = respJSON ++ Json.obj(columnName -> result.getString(i))
                }
            }
	  }
	  Ok(respJSON)
	}
}