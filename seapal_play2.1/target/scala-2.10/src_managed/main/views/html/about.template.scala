
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
object about extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Html,Html,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(header: Html)(navigation: Html)(footer: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.48*/("""

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
				    	<div class="sidebar-nav">
					    	<ul class="nav nav-list bs-docs-sidenav affix" id="sidebar">
						    	<li class="first"><a href="userguide.html">User Guide</a></li>
								<li><a href="contact.html">Contact us</a></li>
					        </ul>
					    </div>
					</div><!-- Sidebar -->
	
					<!-- Content -->
					<div class="span9">
						<div class="post">
							<h2>About SeaPal</h2>
							<div class="entry">
								<p>
									 The <b>SeaPal</b> application was developed in a cooperation between the IBN publishing house and the HTWG Constance University. 								</p>
								<p>IBN is a publishing house specialized in sailing and boating in the southern part of Germany. IBN has a long tradition of providing high quality maps, harbor guides and news for sailors for the lake Constance and the south of Germany. IBN initiated this project to bring their content to new mobile platforms like the iPad and the iPhone. 
									
								</p>	
								<p>The University HTWG Constance is a University of Applied Sciences located in Constance right on the shores of the lake. Prof. Dr. Marko Boger leads the project and did the original concept. He works in the computer science department as professor for Software Architecture and Software Engineering. Software development for mobile platforms as well as for the web are included in this research and teaching. He is also an active sailor with more than 5,000 nm of experience in all waters of Europe.  
								</p>
								<p>These two partners initiated this project as an open cooperation to provide a modern, simple, yet powerful application for mobile devices. It is our goal to provide a base version of SeaPal free of charge with free online maps to sailors around the world. We also provide extensions to finance this project. Please view purchases as sponsoring to help advance our ambitious project. It will be used to further advance and develop this app.  
								</p> 
								<p>The development is partly done by a team of experienced software developers and partly in research and study groups at the University.
								</p>
								<p>Our cooperation is also open for other partners. If you are interested to join our partnership, to provide further content or develop extension, please contact us. You can also sponsor the development of specific functionalities or extensions. 
								</p>
								<br>
								<br>
								<img src=""""),_display_(Seq[Any](/*52.20*/routes/*52.26*/.Assets.at("images/icons/ibn.jpg"))),format.raw/*52.60*/("""" class="img-rounded" alt="SeaPal-InitialPosition"/>
								<figcaption>IBN Publishing House</figcaption>
								<br>
								<img src=""""),_display_(Seq[Any](/*55.20*/routes/*55.26*/.Assets.at("images/icons/htwg.png"))),format.raw/*55.61*/("""" class="img-rounded" alt="SeaPal-InitialPosition"/>
								<figcaption>HTWG Constance University</figcaption>
								<br>
								<br>
							</div>
						</div>
			      	</div><!-- Content -->
				</div>
			</div>		
		</div><!-- Container -->
    
		<!-- Footer -->
    	"""),_display_(Seq[Any](/*67.7*/footer)),format.raw/*67.13*/("""
    	
    </body>
</html>"""))}
    }
    
    def render(header:Html,navigation:Html,footer:Html): play.api.templates.Html = apply(header)(navigation)(footer)
    
    def f:((Html) => (Html) => (Html) => play.api.templates.Html) = (header) => (navigation) => (footer) => apply(header)(navigation)(footer)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jun 12 16:41:29 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/seapal_play2.1/app/views/about.scala.html
                    HASH: 89112ed3f7e677cf8cfd5fe6cb4f95db5eea039a
                    MATRIX: 513->1|636->47|743->119|770->125|874->194|906->204|3556->2818|3571->2824|3627->2858|3802->2997|3817->3003|3874->3038|4186->3315|4214->3321
                    LINES: 19->1|22->1|30->9|30->9|36->15|36->15|73->52|73->52|73->52|76->55|76->55|76->55|88->67|88->67
                    -- GENERATED --
                */
            