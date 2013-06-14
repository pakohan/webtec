
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
object screenshots extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Html,Html,Html,play.api.templates.Html] {

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
				    	<div class="sidebar-nav affix-top">
					    	<ul class="nav nav-list bs-docs-sidenav affix" id="sidebar">
						    	<li class="sidebar"><a href="#" class="ipad">iPad</a></li>
						    	<li class="sidebar"><a href="#" class="tools">Tools</a></li>
						    	<li class="sidebar"><a href="#" class="inplace">In-Place-Tools</a></li>
						    	<li class="sidebar"><a href="#" class="iphone">iPhone</a></li>
					        </ul>
					    </div>
					</div><!-- Sidebar -->
	
					<!-- Content -->
					<div class="span9">
	    				<div>
							<div class="post" id="ipad">
				      			<h2>SeaPal on the iPad</h2>
				      			<div class="entry">
									<figure>
										<img src=""""),_display_(Seq[Any](/*41.22*/routes/*41.28*/.Assets.at("images/screenshots/SeaPal-InitialPosition.jpg"))),format.raw/*41.87*/("""" class="img-rounded" alt="SeaPal-InitialPosition" width="580" height="435"/>
										<figcaption>Map view with current position, initial view.</figcaption>
									</figure>
									<br>
									<figure>
										<img src=""""),_display_(Seq[Any](/*46.22*/routes/*46.28*/.Assets.at("images/screenshots/SeaPal-Gothenborg-Menu.jpg"))),format.raw/*46.87*/("""" class="img-rounded" alt="SeaPal-Gothenborg-Menu" width="580" height="435"/>
										<figcaption>Menu selected.</figcaption>
									</figure>
									<br>
									<figure>
										<img src=""""),_display_(Seq[Any](/*51.22*/routes/*51.28*/.Assets.at("images/screenshots/SeaPal-Gothenborg-Tools.jpg"))),format.raw/*51.88*/("""" class="img-rounded" alt="SeaPal-Gothenborg-Tools" width="580" height="435">
										<figcaption>Tools selected.</figcaption>
									</figure>
									<br>
									<figure>
										<img src=""""),_display_(Seq[Any](/*56.22*/routes/*56.28*/.Assets.at("images/screenshots/SeaPal-Gothenborg-OSM.jpg"))),format.raw/*56.86*/("""" class="img-rounded" alt="SeaPal-Gothenborg-OSM" width="580" height="435">
										<figcaption>Map view with OpenSeaMap showing Gothenburg.</figcaption>
									</figure>
									<br>
									<figure>
										<img src=""""),_display_(Seq[Any](/*61.22*/routes/*61.28*/.Assets.at("images/screenshots/SeaPal-SatelliteView.jpg"))),format.raw/*61.85*/("""" class="img-rounded" alt="SeaPal-SatelliteView" width="580" height="435"/>
										<figcaption>Satellite view</figcaption>
									</figure>
									<br>
									<figure>
										<img src=""""),_display_(Seq[Any](/*66.22*/routes/*66.28*/.Assets.at("images/screenshots/SeaPal-Satellite-Closeup.jpg"))),format.raw/*66.89*/("""" class="img-rounded" alt="SeaPal-Satellite-Closeup" width="580" height="435">
										<figcaption>Satellite view - Close-up.</figcaption>
									</figure>
									<br>
									<figure>
										<img src=""""),_display_(Seq[Any](/*71.22*/routes/*71.28*/.Assets.at("images/screenshots/SeaPal-Southampton-OSM.jpg"))),format.raw/*71.87*/("""" class="img-rounded" alt="SeaPal-Southampton-OSM" width="580" height="435"/>
										<figcaption>Map view with OpenSeaMap showing Southampton.</figcaption>
									</figure>
									<br>
									<figure>
										<img src=""""),_display_(Seq[Any](/*76.22*/routes/*76.28*/.Assets.at("images/screenshots/SeaPal-Konstanz-IBN.jpg"))),format.raw/*76.84*/("""" class="img-rounded" alt="SeaPal-Konstanz-IBN" width="580" height="435"/>
										<figcaption>Offline map from IBN</figcaption>
									</figure>
									<br>
									<figure>
										<img src=""""),_display_(Seq[Any](/*81.22*/routes/*81.28*/.Assets.at("images/screenshots/SeaPal-POI-Search.jpg"))),format.raw/*81.82*/("""" class="img-rounded" alt="SeaPal-POI-Search" width="435" height="580">
										<figcaption>Searching for Points of Interest</figcaption>
									</figure>
									<br>
									<figure>
										<img src=""""),_display_(Seq[Any](/*86.22*/routes/*86.28*/.Assets.at("images/screenshots/SeaPal-POI-Harborinfo.jpg"))),format.raw/*86.86*/("""" class="img-rounded" alt="SeaPal-POI-Harborinfo" width="435" height="580">
										<figcaption>Points of Interest: Info for a Harbour</figcaption>
									</figure>						 
								</div>
				      		</div>
						</div>
						<div id="tools">
							<br><br>
							<h2 >SeaPal Tools</h2>
							<div class="entry">
								<figure>
									<img src=""""),_display_(Seq[Any](/*97.21*/routes/*97.27*/.Assets.at("images/screenshots/SeaPal-RouteTool.jpg"))),format.raw/*97.80*/("""" class="img-rounded" alt="SeaPal-RouteTool" width="580" height="435">
									<figcaption>The Route Tool - Melbourne to Sydney. </figcaption>
								</figure>
								<br>
								<figure>
									<img src=""""),_display_(Seq[Any](/*102.21*/routes/*102.27*/.Assets.at("images/screenshots/SeaPal-RouteTool-OSM.jpg"))),format.raw/*102.84*/("""" class="img-rounded" alt="SeaPal-RouteTool-OSM" width="580" height="435">
									<figcaption>The Route Tool - Close-up in Sydney. </figcaption>
								</figure>
								<br>
								<figure>
									<img src=""""),_display_(Seq[Any](/*107.21*/routes/*107.27*/.Assets.at("images/screenshots/SeaPal-DistanceTool.jpg"))),format.raw/*107.83*/("""" class="img-rounded" alt="SeaPal-DistanceTool" width="580" height="435">
									<figcaption>The Distance Tool - Miami to Montego Bay is about 755 nm. </figcaption>
								</figure>
							</div>
						</div>
						<div class="post" id="inplace">
							<br><br>
							<h2>SeaPal In-Place-Tools</h2>
							<div class="entry">
								<figure>
									<img src=""""),_display_(Seq[Any](/*117.21*/routes/*117.27*/.Assets.at("images/screenshots/SeaPal-Longtouch.jpg"))),format.raw/*117.80*/("""" class="img-rounded" alt="SeaPal-Longtouch" width="580" height="435">
									<figcaption>A Longtouch brings up bearing and distance to that point from the current position.</figcaption>
								</figure>
								<br>
								<figure>
									<img src=""""),_display_(Seq[Any](/*122.21*/routes/*122.27*/.Assets.at("images/screenshots/SeaPal-InPlace-Tools.jpg"))),format.raw/*122.84*/("""" class="img-rounded" alt="SeaPal-InPlace-Tools" width="580" height="435">
									<figcaption>Another touch brings up a menu for in-place tools. </figcaption>
								</figure>
								<br>
								<figure>
									<img src=""""),_display_(Seq[Any](/*127.21*/routes/*127.27*/.Assets.at("images/screenshots/SeaPal-Mark.jpg"))),format.raw/*127.75*/("""" class="img-rounded" alt="SeaPal-Mark" width="580" height="435">
									<figcaption>This allows quick creation of Marks, for example. </figcaption>
								</figure>
								<br>
								<figure>
									<img src=""""),_display_(Seq[Any](/*132.21*/routes/*132.27*/.Assets.at("images/screenshots/SeaPal-InPlace-Tools.jpg"))),format.raw/*132.84*/("""" class="img-rounded" alt="SeaPal-InPlace-Tools" width="580" height="435">
									<figcaption>Marks again have a context menu. </figcaption>
								</figure>
								<br>
								<figure>
									<img src=""""),_display_(Seq[Any](/*137.21*/routes/*137.27*/.Assets.at("images/screenshots/SeaPal-Target.jpg"))),format.raw/*137.77*/("""" class="img-rounded" alt="SeaPal-Target" width="580" height="435">
									<figcaption>Marks can be made the target, bearing and distance are displayed at the top. </figcaption>
								</figure>	
							</div>
						</div>
						<div class="post" id="logbook">
							<br><br>
							<h2>SeaPal Logbook and Tracking</h2>
							<div class="entry">
								<figure>
									<img src=""""),_display_(Seq[Any](/*147.21*/routes/*147.27*/.Assets.at("images/screenshots/SeaPal-Tracking.jpg"))),format.raw/*147.79*/("""" class="img-rounded" alt="SeaPal-Tracking" width="580" height="435">
									<figcaption>The Tracking Tool. </figcaption>
								</figure>
								<br>
								<figure>
									<img src=""""),_display_(Seq[Any](/*152.21*/routes/*152.27*/.Assets.at("images/screenshots/SeaPal-Boat.jpg"))),format.raw/*152.75*/("""" class="img-rounded" alt="SeaPal-Boat" width="580" height="435">
									<figcaption>The Logbook view with Boat info. </figcaption>
								</figure>
								<br>
								<figure>
									<img src=""""),_display_(Seq[Any](/*157.21*/routes/*157.27*/.Assets.at("images/screenshots/SeaPal-Logbook.jpg"))),format.raw/*157.78*/("""" class="img-rounded" alt="SeaPal-Logbook" width="580" height="435">
									<figcaption>The Logbook view for a Trip. </figcaption>
								</figure> 
							</div>
						</div>
						<div class="post" id="iphone">
							<br><br>
							<h2>SeaPal on the iPhone</h2>
							<div class="entry">
								<figure>
									<img src=""""),_display_(Seq[Any](/*167.21*/routes/*167.27*/.Assets.at("images/screenshots/SeaPal-iPhone-LaCoruna.jpg"))),format.raw/*167.86*/("""" class="img-rounded" alt="SeaPal-iPhone-LaCoruna" width="218" height="292">
									<figcaption>SeaPal on the iPhone - horizontal</figcaption>
								</figure>
								<br>
								<figure>
									<img src=""""),_display_(Seq[Any](/*172.21*/routes/*172.27*/.Assets.at("images/screenshots/SeaPal-iPhone-wide.jpg"))),format.raw/*172.82*/("""" class="img-rounded" alt="SeaPal-iPhone-wide" width="292" height="218">
									<figcaption>SeaPal on the iPhone - vertical</figcaption>
								</figure>
								<br>
								<figure>
									<img src=""""),_display_(Seq[Any](/*177.21*/routes/*177.27*/.Assets.at("images/screenshots/SeaPal-iPhone-Tools.jpg"))),format.raw/*177.83*/("""" class="img-rounded" alt="SeaPal-iPhone-Tools" width="218" height="292">
									<figcaption>SeaPal on the iPhone - Tools</figcaption>
								</figure>
								<br>
								<figure>
									<img src=""""),_display_(Seq[Any](/*182.21*/routes/*182.27*/.Assets.at("images/screenshots/SeaPal-iPhone-Menu.jpg"))),format.raw/*182.82*/("""" class="img-rounded" alt="SeaPal-iPhone-Menu" width="218" height="292">
									<figcaption>SeaPal on the iPhone - Tools</figcaption>
								</figure>
								<br><br>
							</div>
						</div>
			      	</div><!-- Content -->
	
				</div>
			</div>	
		</div><!-- Container -->
    
		<!-- Footer -->
    	"""),_display_(Seq[Any](/*195.7*/footer)),format.raw/*195.13*/("""
    	
    </body>
</html>"""))}
    }
    
    def render(navigation:Html,header:Html,footer:Html): play.api.templates.Html = apply(navigation,header,footer)
    
    def f:((Html,Html,Html) => play.api.templates.Html) = (navigation,header,footer) => apply(navigation,header,footer)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jun 12 16:41:29 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/seapal_play2.1/app/views/screenshots.scala.html
                    HASH: 326b99b4f420a9eedc931dd51ce2b1962e9d0ceb
                    MATRIX: 519->1|719->123|826->195|853->201|957->270|989->280|1893->1148|1908->1154|1989->1213|2256->1444|2271->1450|2352->1509|2588->1709|2603->1715|2685->1775|2922->1976|2937->1982|3017->2040|3281->2268|3296->2274|3375->2331|3609->2529|3624->2535|3707->2596|3956->2809|3971->2815|4052->2874|4319->3105|4334->3111|4412->3167|4651->3370|4666->3376|4742->3430|4990->3642|5005->3648|5085->3706|5477->4062|5492->4068|5567->4121|5816->4333|5832->4339|5912->4396|6164->4611|6180->4617|6259->4673|6664->5041|6680->5047|6756->5100|7050->5357|7066->5363|7146->5420|7412->5649|7428->5655|7499->5703|7755->5922|7771->5928|7851->5985|8099->6196|8115->6202|8188->6252|8613->6640|8629->6646|8704->6698|8933->6890|8949->6896|9020->6944|9259->7146|9275->7152|9349->7203|9719->7536|9735->7542|9817->7601|10067->7814|10083->7820|10161->7875|10405->8082|10421->8088|10500->8144|10742->8349|10758->8355|10836->8410|11183->8721|11212->8727
                    LINES: 19->1|22->1|30->9|30->9|36->15|36->15|62->41|62->41|62->41|67->46|67->46|67->46|72->51|72->51|72->51|77->56|77->56|77->56|82->61|82->61|82->61|87->66|87->66|87->66|92->71|92->71|92->71|97->76|97->76|97->76|102->81|102->81|102->81|107->86|107->86|107->86|118->97|118->97|118->97|123->102|123->102|123->102|128->107|128->107|128->107|138->117|138->117|138->117|143->122|143->122|143->122|148->127|148->127|148->127|153->132|153->132|153->132|158->137|158->137|158->137|168->147|168->147|168->147|173->152|173->152|173->152|178->157|178->157|178->157|188->167|188->167|188->167|193->172|193->172|193->172|198->177|198->177|198->177|203->182|203->182|203->182|216->195|216->195
                    -- GENERATED --
                */
            