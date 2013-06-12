
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object map extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Html,Html,Html,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(header_app: Html, navigation: Html, navigation_app: Html, header: Html = views.html._include.header.render()):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.112*/("""

<!DOCTYPE html>

<html>
    <head>
    
    	<!-- Header -->
        """),_display_(Seq[Any](/*9.10*/header)),format.raw/*9.16*/("""
        
        <!-- Header App -->
        """),_display_(Seq[Any](/*12.10*/header_app)),format.raw/*12.20*/("""
        
    </head>
    <body onload="initialize();">
    
    	<!-- Navigation -->
    	"""),_display_(Seq[Any](/*18.7*/navigation)),format.raw/*18.17*/("""
    	
    	<!-- Container -->
    	<div class="container-fluid">
    	
    		<!-- Navigation -->
    		"""),_display_(Seq[Any](/*24.8*/navigation_app)),format.raw/*24.22*/("""

			<!-- Route Menu -->
			<div id="routeMenuContainer">
		    	<div id="routeMenu" class="well">
		    		<h4>Routen Menü</h4>
		        	<div class="btn-group btn-group-vertical">
		                <input type="button" class="btn" value="l&ouml;schen" id="deleteRouteButton" class="routeButton" onclick="javascript: deleteRoute()" />
		                <input type="button" class="btn" value="speichern" id="saveRouteButton" class="routeButton" onclick="javascript: saveRoute()" />
		                <input type="button" class="btn" value="beenden" id="stopRouteButton" class="routeButton" onclick="javascript: stopRouteMode()" />
		            </div>
		        	<br><br>
		            <div id="route_distance">Routen-L&auml;nge: <span id="route_distance_number"></span> m</div>
		        </div>
		    </div>
		    
		    <!-- Distance Menu -->
		    <div id="distanceToolContainer">
		        <div id="distanceToolMenu" class="well">
		        	<h4>Distanztool</h4>
		        	<input type="button" class="btn" value="beenden" id="stopDistanceToolButton" class="distanceToolbutton" onclick="javascript: stopDistanceToolMode()" />
		        	<br><br>
		        	<div id="distanceTool_distance">Distanz: <span id="distanceTool_number"></span> m</div>
		        </div>
		    </div>
		    
		     <!-- Navigation Menu -->
		    <div id="navigationContainer">
		        <div id="navigationMenu" class="well">
		        	<h4>Navigation</h4>
		        	<input type="button" class="btn" value="beenden" id="stopNavigationButton" class="distanceToolbutton" onclick="javascript: stopNavigationMode()" />
		        	<br><br>
		        	<div id="navigation_distance">Distanz: <span id="navigation_number"></span> m</div>
		        </div>
		    </div>
		    
		    <!-- Current Position -->
		    <div id="followCurrentPositionContainer">
		        <div id="followCurrentPosition_button" class="well">
		            <input type="button" class="btn" value="Eigener Position folgen" id="followCurrentPositionbutton" onclick="javascript: toggleFollowCurrentPosition()" />
		        </div>
		    </div>
		    
		    <!-- Map -->
		    <div id="appWrapper">
		        <div id="map_canvas"></div>
		    </div>
		
		    <!-- Context Menus -->
		    <div id="temporaryMarkerContextMenu"></div>
		    <div id="fixedMarkerContextMenu"></div>
		    <div id="routeContextMenu_active"></div>
		    <div id="routeContextMenu_inactive"></div>	
			<div id="chat" align="center">
		        <div id="chat-area" style="height:200px; width:200px; background-color: white; overflow: auto;"></div>
			</div>
		</div><!-- Container -->
	</body>
</html>"""))}
    }
    
    def render(header_app:Html,navigation:Html,navigation_app:Html,header:Html): play.api.templates.Html = apply(header_app,navigation,navigation_app,header)
    
    def f:((Html,Html,Html,Html) => play.api.templates.Html) = (header_app,navigation,navigation_app,header) => apply(header_app,navigation,navigation_app,header)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jun 08 18:49:41 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/app/views/map.scala.html
                    HASH: dd6e9810686f0313b63781471f34916f55241666
                    MATRIX: 516->1|704->111|811->183|838->189|921->236|953->246|1080->338|1112->348|1252->453|1288->467
                    LINES: 19->1|22->1|30->9|30->9|33->12|33->12|39->18|39->18|45->24|45->24
                    -- GENERATED --
                */
            