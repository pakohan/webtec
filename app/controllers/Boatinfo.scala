package controllers

import play.api._
import play.api.mvc._

import views.html._
import views.html._include._

import anorm._ 
import play.api.db.DB
import play.api.Play.current
import anorm.SqlParser._


object Boatinfo extends Controller {

	def index = Action {	    
		val data = loadEntries();
		
	  	Ok(boatinfo(header.render(), 
			    	navigation.render("app_map"), 
				    navigation_app.render("app_boatinfo"), 
				    data))
  	}

	def loadEntries() = {
		DB.withConnection { implicit c =>
			val result = SQL("select * from bootinfo").resultSet
			val data = new java.lang.StringBuilder()

			while (result.next) {
				data.append("<tr class='selectable' id='" + result.getString("bnr") + "'>")
				data.append("<td>" + result.getString("bootname") + "</td>")
				data.append("<td>" + result.getString("typ") + "</td>")
				data.append("<td>" + result.getString("konstrukteur") + "</td>")
				data.append("<td>" + result.getString("baujahr") + "</td>")
				data.append("<td>" + result.getString("heimathafen") + "</td>")
				data.append("<td>" + result.getString("laenge") + "</td>")
				data.append("<td>" + result.getString("breite") + "</td>")
				data.append("<td>" + result.getString("tiefgang") + "</td>")
				data.append("<td>" + result.getString("eigner") + "</td>")
				data.append("<td style='width:30px; text-align:left;'><div class='btn-group'>")
				data.append("<a class='btn btn-small view' id='" + result.getString("bnr")
				  + "'><span><i class='icon-eye-open'></i></span></a>")
				data.append("<a class='btn btn-small remove' id='" + result.getString("bnr")
				  + "'><span><i class='icon-remove'></i></span></a>")
				data.append("</div></td>")
				data.append("</tr>")
			}

				data.toString();
			}
	}
}