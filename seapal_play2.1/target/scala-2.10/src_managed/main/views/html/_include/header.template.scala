
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
object header extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- Header -->
<title>Seapal</title>
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*3.46*/routes/*3.52*/.Assets.at("stylesheets/bootstrap/bootstrap.css"))),format.raw/*3.101*/("""">
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*4.46*/routes/*4.52*/.Assets.at("stylesheets/bootstrap/layout.css"))),format.raw/*4.98*/("""">
<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*5.46*/routes/*5.52*/.Assets.at("stylesheets/bootstrap/bootstrap-responsive.css"))),format.raw/*5.112*/("""">
<link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*6.51*/routes/*6.57*/.Assets.at("images/icons/seapal_normal.png"))),format.raw/*6.101*/("""">
<script src=""""),_display_(Seq[Any](/*7.15*/routes/*7.21*/.Assets.at("javascripts/jquery/jquery.js"))),format.raw/*7.63*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*8.15*/routes/*8.21*/.Assets.at("javascripts/site/scroll.js"))),format.raw/*8.61*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*9.15*/routes/*9.21*/.Assets.at("javascripts/bootstrap/bootstrap-transition.js"))),format.raw/*9.80*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*10.15*/routes/*10.21*/.Assets.at("javascripts/bootstrap/bootstrap-button.js"))),format.raw/*10.76*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*11.15*/routes/*11.21*/.Assets.at("javascripts/bootstrap/bootstrap-collapse.js"))),format.raw/*11.78*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*12.15*/routes/*12.21*/.Assets.at("javascripts/bootstrap/bootstrap-affix.js"))),format.raw/*12.75*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq[Any](/*13.15*/routes/*13.21*/.Assets.at("javascripts/bootstrap/bootstrap-modal.js"))),format.raw/*13.75*/("""" type="text/javascript"></script>"""))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jun 08 14:56:07 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/app/views/_include/header.scala.html
                    HASH: f96f840dd220fca355143890eb45fff26f3b66fd
                    MATRIX: 579->0|697->83|711->89|782->138|865->186|879->192|946->238|1029->286|1043->292|1125->352|1213->405|1227->411|1293->455|1345->472|1359->478|1422->520|1506->569|1520->575|1581->615|1665->664|1679->670|1759->729|1844->778|1859->784|1936->839|2021->888|2036->894|2115->951|2200->1000|2215->1006|2291->1060|2376->1109|2391->1115|2467->1169
                    LINES: 22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5|26->5|26->5|27->6|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|33->12|33->12|33->12|34->13|34->13|34->13
                    -- GENERATED --
                */
            