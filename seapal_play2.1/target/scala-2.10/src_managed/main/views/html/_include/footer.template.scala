
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
object footer extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*2.2*/("""<!-- Footer -->
	<footer class="footer">
		<div class="container">
			<br>
			<div class="span4">
				<h4>Where to get Seapal</h4>
				<p>
					Seapal is available in the following stores.
				</p>
				<div>
					<a href="http://itunes.apple.com/us/app/seapal/id561903907?mt=8&amp;uo=4" target="itunes_store"><img src=""""),_display_(Seq[Any](/*12.113*/routes/*12.119*/.Assets.at("images/icons/seapal_normal.png"))),format.raw/*12.163*/("""" alt="Icon-Small-50" width="50" height="50"> iPad App Store</a></li>
					<br>
					<br>
					<a href="http://itunes.apple.com/us/app/seapal/id561903907?mt=8&amp;uo=4" target="itunes_store"><img src=""""),_display_(Seq[Any](/*15.113*/routes/*15.119*/.Assets.at("images/icons/seapal_normal.png"))),format.raw/*15.163*/("""" alt="Icon-Small-50" width="50" height="50"> iPhone App Store</a></li>		
				</div>
			</div>
			<div class="span4">
				<h4>Help us promote SeaPal</h4>
				<div style="height: 131px; width: 300px; display: inline-block; text-indent: 0px; margin: 0px; padding: 0px; background-color: transparent; border-style: none; float: none; line-height: normal; font-size: 1px; vertical-align: baseline; background-position: initial initial; background-repeat: initial initial;" id="___plus_0"><iframe frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" style="position: static; top: 0px; width: 300px; margin: 0px; border-style: none; left: 0px; visibility: visible; height: 131px; " tabindex="0" vspace="0" width="100%" id="I0_1356941711310" name="I0_1356941711310" src="https://plusone.google.com/u/0/_/pages/badge?bsv&amp;rel=publisher&amp;hl=en-US&amp;origin=http%3A%2F%2Fseapal.info&amp;url=http%3A%2F%2Fplus.google.com%2F100825752167882077539&amp;ic=1&amp;jsh=m%3B%2F_%2Fscs%2Fapps-static%2F_%2Fjs%2Fk%3Doz.gapi.de.f1WRxP0Oh4Y.O%2Fm%3D__features__%2Fam%3DiQ%2Frt%3Dj%2Fd%3D1%2Frs%3DAItRSTMT8TDsRgVQeBTUMugU-bYVVfOduQ#_methods=onPlusOne%2C_ready%2C_close%2C_open%2C_resizeMe%2C_renderstart%2Concircled%2Conauth%2Conload&amp;id=I0_1356941711310&amp;parent=http%3A%2F%2Fseapal.info" allowtransparency="true" title="Google+ Badge"></iframe>
				</div>
				<div class="fb-like fb_edge_widget_with_comment fb_iframe_widget" data-href="http://www.SeaPal.info" data-send="true" data-width="300" data-show-faces="true" fb-xfbml-state="rendered"><span style="height: 28px; width: 300px; "><iframe id="f179f2c544" name="f324c881c8" scrolling="no" style="border: none; overflow: hidden; height: 28px; width: 300px; " title="Like this content on Facebook." class="fb_ltr" src="http://www.facebook.com/plugins/like.php?api_key=&amp;locale=en_US&amp;sdk=joey&amp;channel_url=http%3A%2F%2Fstatic.ak.facebook.com%2Fconnect%2Fxd_arbiter.php%3Fversion%3D18%23cb%3Dfaf249d74%26origin%3Dhttp%253A%252F%252Fseapal.info%252Ff395176298%26domain%3Dseapal.info%26relation%3Dparent.parent&amp;href=http%3A%2F%2Fwww.SeaPal.info&amp;node_type=link&amp;width=300&amp;layout=standard&amp;colorscheme=light&amp;show_faces=true&amp;send=true&amp;extended_social_context=false"></iframe></span>
				</div>
				<div>
				<iframe allowtransparency="true" frameborder="0" scrolling="no" src="http://platform.twitter.com/widgets/tweet_button.1355514129.html#_=1356941711205&amp;count=horizontal&amp;id=twitter-widget-0&amp;lang=en&amp;original_referer=http%3A%2F%2Fseapal.info%2F&amp;size=m&amp;text=SeaPal&amp;url=http%3A%2F%2Fseapal.info%2F" class="twitter-share-button twitter-count-horizontal" style="width: 107px; height: 20px; " title="Twitter Tweet Button" data-twttr-rendered="true"></iframe>
					<script>!function(d,s,id)"""),format.raw/*26.31*/("""{"""),format.raw/*26.32*/("""var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id))"""),format.raw/*26.97*/("""{"""),format.raw/*26.98*/("""js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);"""),format.raw/*26.208*/("""}"""),format.raw/*26.209*/("""}"""),format.raw/*26.210*/("""(document,"script","twitter-wjs");</script>
				</div>
			</div>
			<div class="span4">
				<h4>Further Informations</h4>
				<p>
					SeaPal is a cooperation that is open for participation. If you have ideas for extensions or want to provide content, please send us a message.
				</p>
				<ul class="list-style2" style="list-style:none; margin-left:0px;">
					<li class="first"><a href="impressum.html">Impressum</a></li>
					<li><a href="legal.html">Legal notice</a></li>
				</ul>
			</div>
		</div>
		<div class="container" align="center">
			<br>
			<p>&copy; 2012 IBN Verlag</p>
		</div>
	</footer>
	"""))}
    }
    
    def render(): play.api.templates.Html = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jun 12 16:41:29 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/seapal_play2.1/app/views/_include/footer.scala.html
                    HASH: 4cc0e488118f810fc749e3e9f429d2eca0310290
                    MATRIX: 579->2|936->322|952->328|1019->372|1258->574|1274->580|1341->624|4182->3437|4211->3438|4304->3503|4333->3504|4472->3614|4502->3615|4532->3616
                    LINES: 22->2|32->12|32->12|32->12|35->15|35->15|35->15|46->26|46->26|46->26|46->26|46->26|46->26|46->26
                    -- GENERATED --
                */
            