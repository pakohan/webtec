
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
object boatinfo extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Html,Html,String,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(navigation: Html, navigation_app: Html, data: String, header: Html = views.html._include.header.render()):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.108*/("""

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
    	<div class="container-fluid">
    	
	    	<!-- Navigation -->
	    	"""),_display_(Seq[Any](/*21.8*/navigation_app)),format.raw/*21.22*/("""
	
			<!-- Content -->
			<div id="appWrapper" align="center">
		        <br />
		        <h2>Boot Informationen</h2>
		        <br />
		        <div class="container-fluid">
		        	<form class="form-horizontal"> 
		            	<div class="row well" style="margin-left: 15%;">
		            		<div class="span4" align="center">	            		
			            		<div class="control-group">
			            			<label class="control-label">Bootname</label>
			            			<input class="input-medium" type="text" name="bootname" id="bootname" />
			            		</div>
			            		<div class="control-group">
			            			<label class="control-label">Baujahr</label>
			            			<input class="input-medium" type="text" name="baujahr" id="baujahr" />
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Konstrukteur</label>
			            			<input class="input-medium" type="text" name="konstrukteur" id="konstrukteur" />
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Registernummer</label>
			            			<input class="input-medium" type="text" name="registernummer" id="registernummer" />
			                    </div> 
			                    <div class="control-group">
			            			<label class="control-label">Eigner</label>
			            			<input class="input-medium" type="text" name="eigner" id="eigner" />
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Yachtclub</label>
			            			<input class="input-medium" type="text" name="yachtclub" id="yachtclub" />
			                    </div>        
		            		</div>
		            		<div class="span4">
		            			<div class="control-group">
			            			<label class="control-label">Typ</label>
			            			<input class="input-medium" type="text" name="typ" id="typ" />
			            		</div>
			            		<div class="control-group">
			            			<label class="control-label">Rig-Art</label>
			            			<input class="input-medium" type="text" name="rigart" id="rigart" />
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Rufzeichen</label>
			            			<input class="input-medium" type="text" name="rufzeichen" id="rufzeichen" />
			            		</div>
			            		<div class="control-group">
			                    	<label class="control-label">Segelzeichen</label>
			            			<input class="input-medium" type="text" name="segelzeichen" id="segelzeichen" />
			                    </div>
			                    <div class="control-group">
			                    	<label class="control-label">Versicherung</label>
			            			<input class="input-medium" type="text" name="versicherung" id="versicherung" />
			                    </div>
			                    <div class="control-group">
			                    	<label class="control-label">Heimathafen</label>
			            			<input class="input-medium" type="text" name="heimathafen" id="heimathafen" />
			                    </div>
		            		</div>
		            		<div class="span4">
		            			<div class="control-group">
			            			<label class="control-label">Breite</label>
			            			<input class="input-medium" type="text" name="breite" id="breite" />
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">L&auml;nge</label>
			            			<input class="input-medium" type="text" name="laenge" id="laenge" />
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Motor</label>
			            			<input class="input-medium" type="text" name="motor" id="motor"/>
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Tankgr&ouml;&szlig;e</label>
			            			<input class="input-medium" type="text" name="tankgroesse" id="tankgroesse" />
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Wassertankgr&ouml;&szlig;e</label>
			            			<input class="input-medium" type="text" name="wassertankgroesse" id="wassertankgroesse" />
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Abwassertankgr&ouml;&szlig;e</label>
			            			<input class="input-medium" type="text" name="abwassertankgroesse" id="abwassertankgroesse" />
			                    </div>		      
			                                          
		            		</div>
		            		<div class="span4">
		            			<div class="control-group">
			            			<label class="control-label">Tiefgang</label>
			            			<input class="input-medium" type="text" name="tiefgang" id="tiefgang" />
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Masth&ouml;he</label>
			            			<input class="input-medium" type="text" name="masthoehe" id="masthoehe" />
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Spigr&ouml;&szlig;e</label>
			            			<input class="input-medium" type="text" name="spigroesse" id="spigroesse" />
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Verdr&auml;ngung</label>
			            			<input class="input-medium" type="text" name="verdraengung" id="verdraengung" />
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Genuagr&ouml;&szlig;e</label>
			            			<input class="input-medium" type="text" name="genuagroesse" id="genuagroesse" />
			                    </div>	
			                    <div class="control-group">
			            			<label class="control-label">Gro&szlig;segelgr&ouml;&szlig;e</label>
			            			<input class="input-medium" type="text" name="grosssegelgroesse" id="grosssegelgroesse" />
			                    </div>	      
		            		</div>
		            	</div>      	 
		            	<div class="control-group">
			            	<input type="reset" class="btn" id="delete" value="L&ouml;schen" class="button"/>
			                <input type="submit" class="btn" id="save" name="submit" value="Speichern" class="button"/>
			            </div>  
		        	</div>
		        </div>   
		        </form>
		        <br />
		        <br />
		        <div class="appTableDiv" align="center">
		            <table class="appTable table table-hover" cellspacing="0px" cellpadding="5px">
		                <thead>
		                    <tr>
		                        <th>Bootsname</th>
		                        <th>Bootstyp</th>
		                        <th>Konstrukteur</th>
		                        <th>Baujahr</th>
		                        <th>Heimathafen</th>
		                        <th>L&auml;nge</th>
		                        <th>Breite</th>
		                        <th>Tiefgang</th>
		                        <th>Inhaber</th>
		                        <th></th>
		                    </tr>
		                </thead>
		                <tbody id="entries">
			                """),_display_(Seq[Any](/*163.21*/Html(data))),format.raw/*163.31*/("""
		                </tbody>
		            </table>
		            <br /><br />
		        </div>
			</div><!-- Content -->   
		</div><!-- Container -->
	
		<!-- Menu Modal -->
		<div class="modal hide fade" id="messageBox">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h3 id="dialogTitle"></h3>
			</div>
			<div class="modal-body">
				<p id="dialogMessage"></p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal"><i class="icon-ok"></i> ok</a>
			</div>
		</div>
		
		<!-- Additional Scripts -->
		<script src=""""),_display_(Seq[Any](/*186.17*/routes/*186.23*/.Assets.at("javascripts/app/ajax/boatinfo.js"))),format.raw/*186.69*/("""" type="text/javascript"></script>
		
	</body>
</html>"""))}
    }
    
    def render(navigation:Html,navigation_app:Html,data:String,header:Html): play.api.templates.Html = apply(navigation,navigation_app,data,header)
    
    def f:((Html,Html,String,Html) => play.api.templates.Html) = (navigation,navigation_app,data,header) => apply(navigation,navigation_app,data,header)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Jun 14 09:59:07 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/seapal_play2.1/app/views/boatinfo.scala.html
                    HASH: a8f9b2d406c10f8b2059563204695004dbb3c0e7
                    MATRIX: 523->1|707->107|814->179|841->185|945->254|977->264|1117->369|1153->383|8797->7990|8830->8000|9505->8638|9521->8644|9590->8690
                    LINES: 19->1|22->1|30->9|30->9|36->15|36->15|42->21|42->21|184->163|184->163|207->186|207->186|207->186
                    -- GENERATED --
                */
            