package controllers

import play.api.mvc._

import views.html._
import views.html._include._
import views.html._include.logbookInc._


object Logbook extends Controller {

	def index = Action {	    
		val data = loadEntries();

		val testData = "<tbody id='entries_boat_info'><tr class='selectable' id='1'><td>Reise nach Jerusalem</td><td>Captain Kirk</td><td>11.11.2014</td><td>12.11.2014</td><td>2</td>" +
			  		"<td>nein</td><td style='width:30px; text-align:left;'><div class='btn-group'><a class='btn btn-small view' id='1'><span><i class='icon-eye-open'></i></span>" +
			  		"</a><a class='btn btn-small remove' id='1'><span><i class='icon-remove'></i></span></a></div></td></tr><tr class='selectable' id='2'>" +
			  		"<td>Reise nach Jerusalem</td><td>Captain Kirk</td><td>11.11.2014</td><td>12.11.2014</td><td>2</td><td>nein</td><td style='width:30px; text-align:left;'><div class='btn-group'>" +
			  		"<a class='btn btn-small view' id='2'><span><i class='icon-eye-open'></i></span></a><a class='btn btn-small remove' id='2'><span><i class='icon-remove'></i>" +
			  		"</span></a></div></td></tr><tr class='selectable' id='3'><td>Reise nach Jerusalem</td><td>Captain Kirk</td><td>11.11.2014</td>" +
			  		"<td>12.11.2014</td><td>2</td><td>nein</td><td style='width:30px; text-align:left;'><div class='btn-group'><a class='btn btn-small view' id='3'><span><i class='icon-eye-open'>" +
			  		"</i></span></a><a class='btn btn-small remove' id='3'><span><i class='icon-remove'></i></span></a></div></td></tr></table>";
		
	  	Ok(logbook(header_app_logbook.render(),
	  				navigation.render("app_map"), 
				    navigation_app.render("app_boatinfo"), 
				    logbook_boatinfo_menu.render(data),
				    logbook_trip_menu.render(testData),
				    logbook_boatinfo.render(),
				    logbook_tripinfo.render(),
				    logbook_weatherinfo.render(),
				    simple_map.render()))
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