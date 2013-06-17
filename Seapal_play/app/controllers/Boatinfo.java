package controllers;

import play.*;
import play.mvc.*;
import play.db.*;
import java.sql.*;
import javax.sql.*;
import play.libs.Json;
import play.data.DynamicForm;
import org.codehaus.jackson.node.ObjectNode; 
import views.html.*;
import views.html._include.*;
import views.html._include.logbook.*;

public class Boatinfo extends Controller {
  
  public static Result insert() {
  
    DynamicForm data = form().bindFromRequest();
    Connection conn = DB.getConnection();
		Statement query;            
    ResultSet result;
    ObjectNode respJSON = Json.newObject();
    int nextId = 0;

    try {
	      query = conn.createStatement();

        query.execute("INSERT INTO seapal.bootinfo(bootname, registernummer, segelzeichen, heimathafen, yachtclub, eigner, versicherung,"
                + "rufzeichen, typ, konstrukteur, laenge, breite, tiefgang, masthoehe, verdraengung, rigart,"
                + "baujahr, motor, tankgroesse, wassertankgroesse, abwassertankgroesse, grosssegelgroesse,"
                + "genuagroesse, spigroesse) "
                + "VALUES('" + data.get("bootname") + "',"
                + "'" + data.get("registernummer") + "',"
                + "'" + data.get("segelzeichen") + "',"
                + "'" + data.get("heimathafen") + "',"
                + "'" + data.get("yachtclub") + "',"
                + "'" + data.get("eigner") + "',"
                + "'" + data.get("versicherung") + "',"
                + "'" + data.get("rufzeichen") + "',"
                + "'" + data.get("typ") + "',"
                + "'" + data.get("konstrukteur") + "',"
                + "'" + data.get("laenge") + "',"
                + "'" + data.get("breite") + "',"
                + "'" + data.get("tiefgang") + "',"
                + "'" + data.get("masthoehe") + "',"
                + "'" + data.get("verdraengung") + "',"
                + "'" + data.get("rigart") + "',"
                + "'" + data.get("baujahr") + "',"
                + "'" + data.get("motor") + "',"
                + "'" + data.get("tankgroesse") + "',"
                + "'" + data.get("wassertankgroesse") + "',"
                + "'" + data.get("abwassertankgroesse") + "',"
                + "'" + data.get("grosssegelgroesse") + "',"
                + "'" + data.get("genuagroesse") + "',"
                + "'" + data.get("spigroesse") + "');");

         result = query.executeQuery("SHOW TABLE STATUS FROM seapal LIKE 'bootinfo'");
         if (result.next()) {
             nextId = result.getInt("Auto_increment");
         }
         conn.close();

         respJSON.put("bnr", "" + (nextId - 1));

    } catch (Exception e) {
        respJSON.put("bnr", "Error: " + e);
    }

    return ok(respJSON);
  }
  
  public static Result delete(int bnr) {

    Connection conn = DB.getConnection();
		Statement query;            
    ResultSet result;
    ObjectNode respJSON = Json.newObject();
  
    try {
	      query = conn.createStatement();
        query.execute("DELETE FROM seapal.bootinfo WHERE bnr = " + bnr);

        conn.close();

        respJSON.put("bnr", "ok");

    } catch (Exception e) {
        respJSON.put("bnr", "Error: " + e);
    }
  
    return ok(respJSON);
  }
  
  public static Result load(int bnr) {
  
    Connection conn = DB.getConnection();
		Statement query;
    ResultSet result;
    ObjectNode respJSON = Json.newObject();

		if(conn != null)
		{
        try {
            	
	          query = conn.createStatement();
	 
	          String sql = "SELECT * FROM seapal.bootinfo WHERE bnr = " + bnr;
	        
	          result = query.executeQuery(sql);
            java.sql.ResultSetMetaData rsmd = result.getMetaData();
            int numColumns = rsmd.getColumnCount();

            while (result.next()) {
                for (int i = 1; i < numColumns + 1; i++) {
                    String columnName = rsmd.getColumnName(i);
                    respJSON.put(columnName, result.getString(i));
                }
            }
            conn.close();

        } catch (Exception e) {
	    	   e.printStackTrace();
        }
    }
    return ok(respJSON);
  }

  public static Result index() {
	    
	  String data = loadEntries();
	  
	  String test = "<tbody id='entries_boat_info'><tr class='selectable' id='1'><td>Reise nach Jerusalem</td><td>Captain Kirk</td><td>11.11.2014</td><td>12.11.2014</td><td>2</td>" +
			  		"<td>nein</td><td style='width:30px; text-align:left;'><div class='btn-group'><a class='btn btn-small view' id='1'><span><i class='icon-eye-open'></i></span>" +
			  		"</a><a class='btn btn-small remove' id='1'><span><i class='icon-remove'></i></span></a></div></td></tr><tr class='selectable' id='2'>" +
			  		"<td>Reise nach Jerusalem</td><td>Captain Kirk</td><td>11.11.2014</td><td>12.11.2014</td><td>2</td><td>nein</td><td style='width:30px; text-align:left;'><div class='btn-group'>" +
			  		"<a class='btn btn-small view' id='2'><span><i class='icon-eye-open'></i></span></a><a class='btn btn-small remove' id='2'><span><i class='icon-remove'></i>" +
			  		"</span></a></div></td></tr><tr class='selectable' id='3'><td>Reise nach Jerusalem</td><td>Captain Kirk</td><td>11.11.2014</td>" +
			  		"<td>12.11.2014</td><td>2</td><td>nein</td><td style='width:30px; text-align:left;'><div class='btn-group'><a class='btn btn-small view' id='3'><span><i class='icon-eye-open'>" +
			  		"</i></span></a><a class='btn btn-small remove' id='3'><span><i class='icon-remove'></i></span></a></div></td></tr></table>";
		
	  return ok(boatinfo.render(header.render(),
			  					header_app_trip.render(),
    						    navigation.render("app_map"), 
    						    navigation_app.render("app_boatinfo"),
    						    logbook_boatinfo_menu.render(data),
    						    logbook_trip_menu.render(test),
    						    logbook_boatinfo.render(),
    						    logbook_tripinfo.render(),
    						    logbook_weatherinfo.render(),
    						    simple_map.render()
    						    ));
  }

	public static String loadEntries() {
	
		Connection conn = DB.getConnection();
		
		String data = "";
    
		if(conn != null)
		{
            Statement query;
            ResultSet result;
            
            try {
            	
	            query = conn.createStatement();
	 
	            String sql = "SELECT * " + "FROM bootinfo ";
	        
	            result = query.executeQuery(sql);
	        
	            while (result.next()) {
              
	        		  StringBuilder row = new StringBuilder();

                row.append("<tr class='selectable' id='" + result.getString("bnr") + "'>");
                row.append("<td>" + result.getString("bootname") + "</td>");
                row.append("<td>" + result.getString("typ") + "</td>");
                row.append("<td>" + result.getString("konstrukteur") + "</td>");
                row.append("<td>" + result.getString("baujahr") + "</td>");
                row.append("<td>" + result.getString("heimathafen") + "</td>");
                row.append("<td>" + result.getString("laenge") + "</td>");
                row.append("<td>" + result.getString("breite") + "</td>");
                row.append("<td>" + result.getString("tiefgang") + "</td>");
                row.append("<td>" + result.getString("eigner") + "</td>");
                row.append("<td style='width:30px; text-align:left;'><div class='btn-group'>");
                row.append("<a class='btn btn-small view' id='" + result.getString("bnr")
                  + "'><span><i class='icon-eye-open'></i></span></a>");
                row.append("<a class='btn btn-small remove' id='" + result.getString("bnr")
                  + "'><span><i class='icon-remove'></i></span></a>");
                row.append("</div></td>");

                row.append("</tr>");
            
		            data += row.toString();
			    }
               
	       } catch (Exception e) {
	    	   e.printStackTrace();
	       }
        }
            
        return data;
	}

  
}