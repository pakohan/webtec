
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
object contact extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Html,Html,Html,play.api.templates.Html] {

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
						    	<li class="sidebar"><a href="#" class="ibn">IBN</a></li>
								<li class="sidebar"><a href="#" class="htwg">HTWG Konstanz</a></li>
					        </ul>
					    </div>
					</div><!-- Sidebar -->
	
					<!-- Content -->
					<div class="span9">
						<div class="post" id="ibn">
							<h2>IBN</h2>
							<div class="entry">	
								<img src=""""),_display_(Seq[Any](/*37.20*/routes/*37.26*/.Assets.at("images/icons/ibn.jpg"))),format.raw/*37.60*/("""" class="img-rounded" alt="IBN Konstanz"/>
								<br><br>							
								<p>
									 IBN Redaktion <br>
									 Hans-Dieter M&ouml;hlhenrich<br>
									 Malvine-Schiesser-Weg 3<br>
									 78315 Radolfzell<br>
									 Germany<br>
									 <br>
									 <a href="http://www.ibn-online.de">www.ibn-online.de</a><br>
									 ibn at ibn-online.de
								</p>		 
							</div>
						</div>
						<br><br>
						<div class="post" id="htwg">
							<h2>HTWG Konstanz</h2>
							<div class="entry">
								<img src=""""),_display_(Seq[Any](/*55.20*/routes/*55.26*/.Assets.at("images/icons/htwg.png"))),format.raw/*55.61*/("""" class="img-rounded" alt="HTWG Konstanz"/>
								<br><br>
								<p>
									 HTWG Konstanz<br>
									 Informatik<br>
									 Prof. Dr. Marko Boger<br>
									 Brauneggerstr. 55<br>
									 78462 Konstanz<br>
									 Germany<br>
									 <br>
									 <a href="http://www.htwg-konstanz.de">www.htwg-konstanz.de</a><br>
									 marko.boger at htwg-konstanz.de
								</p>
								<br>
								<br>	 
							</div>
				      	</div>
					</div><!-- Content -->
				</div>
			</div>		
		</div><!-- Container -->
    
		<!-- Footer -->
    	"""),_display_(Seq[Any](/*78.7*/footer)),format.raw/*78.13*/("""
    	
    </body>
</html>"""))}
    }
    
    def render(navigation:Html,header:Html,footer:Html): play.api.templates.Html = apply(navigation,header,footer)
    
    def f:((Html,Html,Html) => play.api.templates.Html) = (navigation,header,footer) => apply(navigation,header,footer)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 14 09:59:07 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/seapal_play2.1/app/views/contact.scala.html
                    HASH: 496e191bb9d8e7144b1a006868d1696ba622a160
                    MATRIX: 515->1|715->123|822->195|849->201|953->270|985->280|1672->931|1687->937|1743->971|2307->1499|2322->1505|2379->1540|2973->2099|3001->2105
                    LINES: 19->1|22->1|30->9|30->9|36->15|36->15|58->37|58->37|58->37|76->55|76->55|76->55|99->78|99->78
                    -- GENERATED --
                */
            