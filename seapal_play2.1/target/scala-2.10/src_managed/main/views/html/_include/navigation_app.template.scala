
package views.html._include

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
object navigation_app extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(file: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""

<!-- App Navigation -->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">		
			<ul class="nav">
				"""),_display_(Seq[Any](/*8.6*/if(file == "app_map")/*8.27*/ {_display_(Seq[Any](format.raw/*8.29*/(""" <li class="active"> """)))}/*8.52*/else/*8.57*/{_display_(Seq[Any](format.raw/*8.58*/(""" <li> """)))})),format.raw/*8.65*/(""" <a href="app_map.html">Map</a></li>
				"""),_display_(Seq[Any](/*9.6*/if(file == "app_boatinfo")/*9.32*/ {_display_(Seq[Any](format.raw/*9.34*/(""" <li class="active"> """)))}/*9.57*/else/*9.62*/{_display_(Seq[Any](format.raw/*9.63*/(""" <li> """)))})),format.raw/*9.70*/(""" <a href="app_boatinfo.html">Logbuch</a></li>
				"""),_display_(Seq[Any](/*10.6*/if(file == "app_trip" || file == "app_tripinfo" || file == "app_waypoint")/*10.80*/ {_display_(Seq[Any](format.raw/*10.82*/(""" <li class="active"> """)))}/*10.105*/else/*10.110*/{_display_(Seq[Any](format.raw/*10.111*/(""" <li> """)))})),format.raw/*10.118*/(""" <a href="app_trip.html">Routen</a></li>
			</ul>
			<ul class="navbar-form pull-right" style="list-style-type: none;">
				<li><a class="btn" id="startSimulation"><i class="icon-play"></i></a><li>
			</ul>
		</div>
	</div>
</div>"""))}
    }
    
    def render(file:String): play.api.templates.Html = apply(file)
    
    def f:((String) => play.api.templates.Html) = (file) => apply(file)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 14 09:59:07 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/seapal_play2.1/app/views/_include/navigation_app.scala.html
                    HASH: eadd513c1e0197ffbba34716b5b4d39dfb282f11
                    MATRIX: 523->1|614->15|776->143|805->164|844->166|884->189|896->194|934->195|972->202|1048->244|1082->270|1121->272|1161->295|1173->300|1211->301|1249->308|1335->359|1418->433|1458->435|1500->458|1514->463|1554->464|1594->471
                    LINES: 19->1|22->1|29->8|29->8|29->8|29->8|29->8|29->8|29->8|30->9|30->9|30->9|30->9|30->9|30->9|30->9|31->10|31->10|31->10|31->10|31->10|31->10|31->10
                    -- GENERATED --
                */
            