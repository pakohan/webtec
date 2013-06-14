
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
object impressum extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Html,Html,Html,play.api.templates.Html] {

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
				    	<div class="sidebar-nav">
					    	<ul class="nav nav-list bs-docs-sidenav affix" id="sidebar">
						    	<li class="sidebar"><a href="#" class="legal">Legal responsibility</a></li>
						    	<li class="sidebar"><a href="#" class="content">Content</a></li>
						    	<li class="sidebar"><a href="#" class="design">Design</a></li>
					        </ul>
					    </div>
					</div><!-- Sidebar -->
	
					<!-- Content -->
					<div class="span9">
						<div class="post" id="legal">
							<h2>Legal responsibility</h2>
							<div class="entry">
								<p>IBN is a subsidiary of Druck- und Verlagshaus Hermann Daniel.</p>
								<p>Druck- und Verlagshaus Hermann Daniel GmbH &amp; Co. KG. Betriebsgesellschaft<br><br>
								Postfach 10 02 64<br>
								72334 Balingen <br><br>
								Grünewaldstr. 15<br>
								72336 Balingen<br><br>
								Tel.: (07433) 266-0<br>
								Fax: (07433) 266-201<br>
								eMail: zentrale at zak.de <br><br>
								Geschäftsführer: Klaus Jetter<br>
								Handelsregisternummer: HRA 410912<br>
								Registergericht: Stuttgart<br>
								USt-Id-Nr.: DE 219563581<strong>&nbsp;</strong></p> 
							</div>
						</div>
						<div class="post" id="content">
							<br><br>
							<h2>Content</h2>
							<div class="entry">
								<p>
									The content of this web site was created by Prof. Dr. Marko Boger in cooperation with IBN.
								</p>
							</div>
						</div>
						<div class="post" id="design">
							<br><br>
							<h2>Design</h2>
							<div class="entry">
								<p>
									The design of this web site was created by Prof. Dr. Marko Boger.
								</p>
								<br><br>
							</div>
						</div>
					</div><!-- Content -->
		
				</div>
			</div>		
		</div><!-- Container -->
    
		<!-- Footer -->
    	"""),_display_(Seq[Any](/*79.7*/footer)),format.raw/*79.13*/("""
    	
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
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/seapal_play2.1/app/views/impressum.scala.html
                    HASH: 909caade5c5ef29c9a7854319c360b210f0b6873
                    MATRIX: 517->1|717->123|824->195|851->201|955->270|987->280|2988->2246|3016->2252
                    LINES: 19->1|22->1|30->9|30->9|36->15|36->15|100->79|100->79
                    -- GENERATED --
                */
            