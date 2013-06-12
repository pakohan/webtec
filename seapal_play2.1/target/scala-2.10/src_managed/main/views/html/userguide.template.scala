
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
object userguide extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Html,Html,Html,play.api.templates.Html] {

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
			    	<div class="span3">
				    	<div class="sidebar-nav" id="sidebar">
					    	<ul class="nav nav-list bs-docs-sidenav affix">
						    	<li class="sidebar"><a href="#" class="installing">Installing SeaPal</a></li>
								<li class="sidebar"><a href="#" class="starting">Starting SeaPal</a></li>
								<li class="sidebar"><a href="#" class="map">Map Selection</a></li>
								<li><a href=""""),_display_(Seq[Any](/*29.23*/routes/*29.29*/.Assets.at("images/screenshots/SeaPal-Legend-IBN-Map.pdf"))),format.raw/*29.87*/("""">Legend of IBN Maps</a></li>
					        </ul>
					    </div>
					</div><!-- Sidebar -->
	
					<!-- Content -->
					<div class="span9">
						<div class="post" id="installing">  	
							<h2>Installing SeaPal</h2>
							<div class="entry">
								<p>
									Installing SeaPal on the iPad or iPhone is simple and straight forward. Just search for SeaPal in the App Store, select it and install it. SeaPal comes free of charge, so it is very easy to give it a test drive. During the installation you will see the icon of the SeaPal application show up on your screen. Now you are ready to role.
								</p>
							</div>
						</div>
						<div class="post" id="starting">
							<br><br>
							<h2>Starting SeaPal</h2>
							<div class="entry">
								<p>
									 Tap on the SeaPal application icon to start SeaPal. If you have GPS on your mobile device, the app will ask you if it is ok to access your current position. This of course makes a lot of sense in a navigational app, so please do approve that.
								</p>
								<p>
									The application will then open with the map view. If no maps are loaded, you most likely have no internet connection. For initial setup an internet connection is important. You can set it up for offline operation later. If the displayed location is somewhere in the Pacific close to Ghana, you have not turned your GPS on. You can do so in your settings
								</p>
								<p>
									The map is centered at your current location. You can now pan and zoom by swiping with your finger or pinching with two fingers.
								</p>
								
							</div>
							<figure>
									<img src=""""),_display_(Seq[Any](/*60.21*/routes/*60.27*/.Assets.at("images/screenshots/SeaPal-InitialPosition.jpg"))),format.raw/*60.86*/("""" class="img-rounded" alt="SeaPal-InitialPosition" width="580" height="435"/>
									<figcaption>Map view with current position, initial view. </figcaption>
								</figure>
						</div>
						<div class="post" id="map">
							<br><br>
							<h2>Map Selection</h2>
							<div class="entry">
								<p>
									The map view initially shows maps from Google Maps. This is convenient because it downloads fast and is familiar to most. It is excellent for overview and orientation, but it is not very good for navigational purposes. These maps were created primarily for navigation with cars and not with sailors in mind. The shore line and especially harbors can be very imprecise. So you should know how to switch to different map views. For this, tap on the menu button at the top left.
								</p>
								<figure>
									<img src=""""),_display_(Seq[Any](/*72.21*/routes/*72.27*/.Assets.at("images/screenshots/SeaPal-Gothenborg-Menu.jpg"))),format.raw/*72.86*/("""" class="img-rounded" alt="SeaPal-Gothenborg-Menu" width="580" height="435"/>
									<figcaption>Menu selected.</figcaption>
								</figure>
								<p>
									From this menu, you can select several map views
								</p>
								<ul>
									<li>Google Maps</li>
									<li>Google Satellite view</li>
									<li>Open Sea Maps</li>
									<li>Offline Maps</li>
								</ul>
								<p>
									The Google Satellite view is excellent for near shore or in-harbor manovering. Mind you though, this view shows excellent physical detail of the shore and can also give you some indication on the underwater surface from shades of blue. But you do not have sea signals or depth information.
								</p>
								<figure>
									<img src=""""),_display_(Seq[Any](/*88.21*/routes/*88.27*/.Assets.at("images/screenshots/SeaPal-SatelliteView.jpg"))),format.raw/*88.84*/("""" class="img-rounded" alt="SeaPal-SatelliteView" width="580" height="435"/>
									<figcaption>Satellite view</figcaption>
								</figure>
								<p>
									The OpenSeaMap view is very good for navigation. It is also provided free of charge from the Open Street Map project, but was created for sailing and navigation. It contains sea signals and has more details on shore line. However, it does not have depth information, which can be very vital if you are not familiar with the area. Also, this map view loads slower and uses more calculation power on the mobile device. So you might find you iPad a little slower with this view on. The accuracy is not guaranteed, information is collected by an open community and can be incorrect. Also keep in mind that this is a vector map, the level of detail increases when zooming in. This means some details will not be visible when zoomed out.
								</p>
								<figure>
									<img src=""""),_display_(Seq[Any](/*95.21*/routes/*95.27*/.Assets.at("images/screenshots/SeaPal-Southampton-OSM.jpg"))),format.raw/*95.86*/("""" class="img-rounded" alt="SeaPal-Southampton-OSM" width="580" height="435"/>
									<figcaption>OpenSeaMap Map view</figcaption>
								</figure>
								<p>
									The biggest problem with all of the above is that they are only available online. That is you need to have an internet connection to view them. If you have a cellular built into your device with 3G or 4G connection, this might be good enough for you if you only sail close to shore or in-shore. However, we recommend to download offline maps prior to departure.
								</p>
								<p>
									Offline maps are excellent for navigation. They are always available (as long as your battery does not run out), have excellent sea signal information and show water depth. You can purchase offline maps for selected areas from the AddOn view. The first supported area is the Lake Constance for which maps are provided by IBN. Other areas should follow soon.
								</p>
								<figure>
									<img src=""""),_display_(Seq[Any](/*105.21*/routes/*105.27*/.Assets.at("images/screenshots/SeaPal-Konstanz-IBN.jpg"))),format.raw/*105.83*/("""" class="img-rounded" alt="SeaPal-Konstanz-IBN" width="580" height="435"/>
									<figcaption>Offline map from IBN</figcaption>
								</figure>
								<br><br>
							</div>
						</div>
				    </div><!-- Content -->
				</div>
	    	</div>	
		</div><!-- Container -->
    
		<!-- Footer -->
    	"""),_display_(Seq[Any](/*117.7*/footer)),format.raw/*117.13*/("""
    	
    </body>
</html>"""))}
    }
    
    def render(navigation:Html,header:Html,footer:Html): play.api.templates.Html = apply(navigation,header,footer)
    
    def f:((Html,Html,Html) => play.api.templates.Html) = (navigation,header,footer) => apply(navigation,header,footer)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jun 08 21:43:01 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/app/views/userguide.scala.html
                    HASH: 77cefad4fe330dafa03b4f1f0d4f56ce03145e5d
                    MATRIX: 517->1|717->123|824->195|851->201|955->270|987->280|1574->831|1589->837|1669->895|3350->2540|3365->2546|3446->2605|4326->3449|4341->3455|4422->3514|5207->4263|5222->4269|5301->4326|6283->5272|6298->5278|6379->5337|7391->6312|7407->6318|7486->6374|7826->6678|7855->6684
                    LINES: 19->1|22->1|30->9|30->9|36->15|36->15|50->29|50->29|50->29|81->60|81->60|81->60|93->72|93->72|93->72|109->88|109->88|109->88|116->95|116->95|116->95|126->105|126->105|126->105|138->117|138->117
                    -- GENERATED --
                */
            