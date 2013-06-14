
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
object navigation extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(file: String):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.16*/("""

<!-- Navigation -->
<div class="navbar navbar-inverse navbar-fixed-top" id="navigation">
	<div class="navbar-inner" id="navigation">
        <div class="container">
          	<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse" style="margin-top:25px; margin-right:20px;">
            	<span class="icon-bar"></span>
            	<span class="icon-bar"></span>
            	<span class="icon-bar"></span>
            </a>
            <a class="brand" href="index.html">
            	<img src=""""),_display_(Seq[Any](/*13.25*/routes/*13.31*/.Assets.at("images/icons/seapal_normal.png"))),format.raw/*13.75*/("""" alt='Icon-Small-50' width='50' height='50' style="float: left; padding-top: 5px; padding-left: 20px"/>
            	<h2 style="float: left; padding-left:10px; margin-right:100px; font-weight: normal;">Seapal</h2>
            </a>
            <div class="nav-collapse collapse">
            	<ul class="nav nav-pills" style="padding-left:0px; padding-top: 24px; font-size: 18px;">
			        """),_display_(Seq[Any](/*18.13*/if(file == "index")/*18.32*/ {_display_(Seq[Any](format.raw/*18.34*/(""" <li class="active"> """)))}/*18.57*/else/*18.62*/{_display_(Seq[Any](format.raw/*18.63*/(""" <li> """)))})),format.raw/*18.70*/(""" <a href='index.html'>Home</a></li>
			        """),_display_(Seq[Any](/*19.13*/if(file == "app_map")/*19.34*/ {_display_(Seq[Any](format.raw/*19.36*/(""" <li class="active"> """)))}/*19.59*/else/*19.64*/{_display_(Seq[Any](format.raw/*19.65*/(""" <li> """)))})),format.raw/*19.72*/(""" <a href='app_map.html'>App</a></li>
			        """),_display_(Seq[Any](/*20.13*/if(file == "userguide")/*20.36*/ {_display_(Seq[Any](format.raw/*20.38*/(""" <li class="active"> """)))}/*20.61*/else/*20.66*/{_display_(Seq[Any](format.raw/*20.67*/(""" <li> """)))})),format.raw/*20.74*/(""" <a href='userguide.html'>User Guide</a></li>
			        """),_display_(Seq[Any](/*21.13*/if(file == "screenshots")/*21.38*/ {_display_(Seq[Any](format.raw/*21.40*/(""" <li class="active"> """)))}/*21.63*/else/*21.68*/{_display_(Seq[Any](format.raw/*21.69*/(""" <li> """)))})),format.raw/*21.76*/(""" <a href='screenshots.html'>Screenshots</a></li>
			        """),_display_(Seq[Any](/*22.13*/if(file == "about")/*22.32*/ {_display_(Seq[Any](format.raw/*22.34*/(""" <li class="active"> """)))}/*22.57*/else/*22.62*/{_display_(Seq[Any](format.raw/*22.63*/(""" <li> """)))})),format.raw/*22.70*/(""" <a href='about.html'>About</a></li>
			        """),_display_(Seq[Any](/*23.13*/if(file == "contact")/*23.34*/ {_display_(Seq[Any](format.raw/*23.36*/(""" <li class="active"> """)))}/*23.59*/else/*23.64*/{_display_(Seq[Any](format.raw/*23.65*/(""" <li> """)))})),format.raw/*23.72*/(""" <a href='contact.html'>Contact</a></li>
		        </ul>
		    </div>
        </div>
    </div>
</div>

"""))}
    }
    
    def render(file:String): play.api.templates.Html = apply(file)
    
    def f:((String) => play.api.templates.Html) = (file) => apply(file)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jun 12 16:41:29 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/seapal_play2.1/app/views/_include/navigation.scala.html
                    HASH: eb2d3d61c9128457a64dd8c472a5cb9dddc27a14
                    MATRIX: 519->1|610->15|1167->536|1182->542|1248->586|1678->980|1706->999|1746->1001|1787->1024|1800->1029|1839->1030|1878->1037|1962->1085|1992->1106|2032->1108|2073->1131|2086->1136|2125->1137|2164->1144|2249->1193|2281->1216|2321->1218|2362->1241|2375->1246|2414->1247|2453->1254|2547->1312|2581->1337|2621->1339|2662->1362|2675->1367|2714->1368|2753->1375|2850->1436|2878->1455|2918->1457|2959->1480|2972->1485|3011->1486|3050->1493|3135->1542|3165->1563|3205->1565|3246->1588|3259->1593|3298->1594|3337->1601
                    LINES: 19->1|22->1|34->13|34->13|34->13|39->18|39->18|39->18|39->18|39->18|39->18|39->18|40->19|40->19|40->19|40->19|40->19|40->19|40->19|41->20|41->20|41->20|41->20|41->20|41->20|41->20|42->21|42->21|42->21|42->21|42->21|42->21|42->21|43->22|43->22|43->22|43->22|43->22|43->22|43->22|44->23|44->23|44->23|44->23|44->23|44->23|44->23
                    -- GENERATED --
                */
            