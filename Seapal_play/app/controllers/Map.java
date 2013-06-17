package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import views.html._include.*;
import views.html._include.map.*;

public class Map extends Controller {
  
  public static Result index() {
    return ok(map.render(header.render(),
    						header_app.render(),
    						header_app_map.render(),
    						navigation.render("app_map"),
    						navigation_app.render("app_map"),
    						map_content.render(),
    						weather_chart.render()));
  }
  
}