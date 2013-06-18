package models

import play.api.mvc._
import play.api.db.DB
import play.api.Play.current
import play.api.libs.json._

import anorm._


object Waypoint {

	def load(wnr: Int) = {
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
	  respJSON
	}
}