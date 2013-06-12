
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Html,Html,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(navigation: Html, header: Html = views.html._include.header.render(), footer: Html = views.html._include.footer.render()):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.124*/("""

<!DOCTYPE html>

<html>
    <head>
    
    	<!-- Header -->
        """),_display_(Seq[Any](/*9.10*/header)),format.raw/*9.16*/("""
        
    </head>
    <body>
    
    	<!-- Navigation -->
    	"""),_display_(Seq[Any](/*15.7*/navigation)),format.raw/*15.17*/("""
    	
	    <!-- Container -->
		<div class="container">
	    	<div class="container-fluid">
		    	<div class="row-fluid">
		    	
		    		<!-- Sidebar -->
			    	<div class="span3 ">
				    	<div class="sidebar-nav">
					    	<ul class="nav nav-list bs-docs-sidenav affix" id="sidebar">
		                        <li class="sidebar"><a href="#" class="welcome">Welcome</a></li>
		                        <li class="sidebar"><a href="#" class="overview">Overview</a></li>
		                        <li class="sidebar"><a href="#" class="extension">Extension</a></li>
		                        <li class="sidebar"><a href="#" class="warning">Warning</a></li>
					        </ul>
					    </div>
					</div><!-- Sidebar -->
	    
					<div class="span9">  
						<div class="post" id="welcome">
							<h2>Welcome to SeaPal</h2>
	                    	<div class="entry">
	                        	<p><img src=""""),_display_(Seq[Any](/*38.41*/routes/*38.47*/.Assets.at("images/screenshots/SeaPal-Horiz2.jpg"))),format.raw/*38.97*/("""" alt="" class="img-rounded" height="200" width="620"></p>
	                        	<p>
		                            <b>SeaPal</b> is an App for sailors and other water sport fanatics that support the skipper in his tasks for navigation, route planing and logbook keeping. The central view shows a map with the current position and forward line. Waypoint and routes can easily be created, distances and courses can quickly be determined and documented in the logbook. The touch interface allows for fast and intuitive interaction.
		                        </p>
		                        <p>
		                            Online maps are available from Google and OpenSeaMap, allong with satellite view. With these a trip can easily be planed and documented. In navigation the offline operation and the precision and depth of detail is of special importance. Thats why digital sea maps for selected areas can be downloaded and used offline.
		                        </p>
		                        <p>
		                            For the area of the Lake Constance excellent sea maps and local information (harbours, shipyards, shops, restaurants) provided by the IBN publishing house are available as extensions. Further areas are in preparation.
		                        </p>
		                        <p>
		                            The application was developed particularly for the iPad in a cooperation between the IBN publishing house and the HTWG Constance University. The specific advantages of a mobile device and the touch interface were taken into account just as well as the special requirements of sailors and skippers. As a result of this cooperation, <b>SeaPal</b> is made available for free. Extensions and sea maps can be purchased and loaded according to your area and needs.
		                        </p>
		                        <p>
		                            This cooperation is open to further extension. Should you be interested to develop or provide further extensions, please contact us.
		                        </p>
		                        <p>
		                            The application runs on the iPad and with reduced functionality on the iPhone. An iPad with 3G or 4G and GPS is recommended. For longer use an external power source (like a USP port of a radio) is required.
		                        </p>
		                   </div>
						</div>
						<br><br>
						<div class="post" id="overview">
	                    	<h2 class="title">Function Overview</h2>
	                    	<div class="entry">
		                        <p><img src=""""),_display_(Seq[Any](/*63.41*/routes/*63.47*/.Assets.at("images/screenshots/SeaPal-Horiz3.jpg"))),format.raw/*63.97*/("""" class="img-rounded" alt="" height="200" width="620"></p>
		                        <p>
		                            <b>SeaPal</b> offers the following functionality
		                        </p>
		                        <ul>
		                            <li> Google Maps </li>
		                            <li> OpenSeaMaps </li>
		                            <li> Satellite view </li>
		                            <li> Follow position </li>
		                            <li> Position from GPS always visible in the map view </li>
		                            <li> Course and speed always visible in the map view </li>
		                            <li> Free navigation on the map with swipe and pinch </li>
		                            <li> Fast return to the current position </li>
		                            <li> Route planing, waypoints are editable </li>
		                            <li> Automatic waypoint switching </li>
		                            <li> Bearing and distance to any particular point with long-touch </li>
		                            <li> Placing of permanent marks on the map </li>
		                            <li> Add marks using bearing or coordinates </li>
		                            <li> Select any mark as target </li>
		                            <li> Bearing and distance to current target always visible in the map view </li>
		                            <li> Distance measurement, even across several waypoints </li>
		                            <li> &quotPerson over Board&quot functionality </li>
		                        </ul>
		                        <br><br>
	                    	</div>
						</div>
	                    <div class="post" id="extension">
	                        <h1>Extensions</h1>
	                        <p>
	                            With extensions <b>SeaPal</b> offers the following functionality:
	                        </p>
	                        <ul>
	                            <li> Logbook function for one or several boats </li>
	                            <li> Automatic tracking </li>
	                            <li> Automatic or manual logbook entries </li>
	                            <li> Fotos for logbook entries </li>
	                            <li> Collection of regional Points of Interest </li>
	                        </ul>
	                    </div>
	                    <br><br>
	                    <div class="post" id="warning">
	                    	<h1>Warning</h1>
	                    	<p>
	                        	<b>SeaPal</b> is a valuable addition to your navigational equipment, but no replacement. Always use official sea maps in conjunction. All positions are provided so that a transition to paper sea maps is simple. The responsibility for the proper use lies with the skipper. The manufacturer of <b>SeaPal</b> assume no liability.
	                        </p>
	                        <br><br>
	                    </div>
	                </div><!-- Content -->
	            </div>
			</div>	
		</div><!-- Container -->

		<!-- Footer -->
    	"""),_display_(Seq[Any](/*116.7*/footer)),format.raw/*116.13*/("""
    	
    </body>
</html>"""))}
    }
    
    def render(navigation:Html,header:Html,footer:Html): play.api.templates.Html = apply(navigation,header,footer)
    
    def f:((Html,Html,Html) => play.api.templates.Html) = (navigation,header,footer) => apply(navigation,header,footer)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jun 08 18:33:07 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/app/views/index.scala.html
                    HASH: 2bea661a2f0943ce70e997cfb3ce70d3cf06b93b
                    MATRIX: 513->1|713->123|820->195|847->201|951->270|983->280|1931->1192|1946->1198|2018->1248|4649->3843|4664->3849|4736->3899|7863->6990|7892->6996
                    LINES: 19->1|22->1|30->9|30->9|36->15|36->15|59->38|59->38|59->38|84->63|84->63|84->63|137->116|137->116
                    -- GENERATED --
                */
            