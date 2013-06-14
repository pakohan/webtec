
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
object header_app extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- Header App -->
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*2.46*/routes/*2.52*/.Assets.at("stylesheets/app/map.css"))),format.raw/*2.89*/("""">
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*3.46*/routes/*3.52*/.Assets.at("stylesheets/app/contextMenu.css"))),format.raw/*3.97*/("""">
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBCnaCuuuXCzfGbzbXN699vudQ4fWTNmiY&libraries=geometry&sensor=false"></script> 
<script src=""""),_display_(Seq[Any](/*5.15*/routes/*5.21*/.Assets.at("javascripts/jquery/jquery-ui.js"))),format.raw/*5.66*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*6.15*/routes/*6.21*/.Assets.at("javascripts/app/map/fancywebsocket.js"))),format.raw/*6.72*/("""" type="text/javascript" ></script>
<script src=""""),_display_(Seq[Any](/*7.15*/routes/*7.21*/.Assets.at("javascripts/app/map/chat.js"))),format.raw/*7.62*/("""" type="text/javascript" ></script>
<script src=""""),_display_(Seq[Any](/*8.15*/routes/*8.21*/.Assets.at("javascripts/app/map/labels.js"))),format.raw/*8.64*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*9.15*/routes/*9.21*/.Assets.at("javascripts/app/map/map.js"))),format.raw/*9.61*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*10.15*/routes/*10.21*/.Assets.at("javascripts/app/map/map_routes.js"))),format.raw/*10.68*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*11.15*/routes/*11.21*/.Assets.at("javascripts/app/map/validation.js"))),format.raw/*11.68*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Assets.at("javascripts/app/map/contextMenu.js"))),format.raw/*12.69*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*13.15*/routes/*13.21*/.Assets.at("javascripts/app/map/TxtOverlay.js"))),format.raw/*13.68*/("""" type="text/javascript"></script>"""))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 14 09:59:07 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/seapal_play2.1/app/views/_include/header_app.scala.html
                    HASH: a13ca04200039272cf17b5511b2d828bd41ce85c
                    MATRIX: 583->0|683->65|697->71|755->108|838->156|852->162|918->207|1134->388|1148->394|1214->439|1298->488|1312->494|1384->545|1469->595|1483->601|1545->642|1630->692|1644->698|1708->741|1792->790|1806->796|1867->836|1952->885|1967->891|2036->938|2121->987|2136->993|2205->1040|2290->1089|2305->1095|2375->1143|2460->1192|2475->1198|2544->1245
                    LINES: 22->1|23->2|23->2|23->2|24->3|24->3|24->3|26->5|26->5|26->5|27->6|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|33->12|33->12|33->12|34->13|34->13|34->13
                    -- GENERATED --
                */
            