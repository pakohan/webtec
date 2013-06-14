
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
object tripinfo extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Html,Html,String,Html,play.api.templates.Html] {

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
	            <h2>Routen Informationen</h2>
	            <br />
	            <br />
	            <br />
	            <div class="container-fluid" align="center">
	            	<form class="form-horizontal"> 
		            	<div class="row well" style="margin-left: 15%;" align="center">
		            		<div class="span4" align="center">	            		
			            		<div class="control-group">
			            			<label class="control-label">Name</label>
			            			<input class="input-medium" type="text" id="name"/>
			            		</div>
			            		<div class="control-group">
			            			<label class="control-label">Time</label>
			            			<input class="input-medium" type="date" id="wdate"/>
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Date</label>
			            			<input class="input-medium" type="date" id="wtime"/>
			                    </div>
		            		</div>
		            		<div class="span4">
		            			<div class="control-group">
			            			<label class="control-label">Latitude</label>
			            			<input class="input-medium" type="text" id="lat"/>
			            		</div>
			            		<div class="control-group">
			            			<label class="control-label">Longitude</label>
			            			<input class="input-medium" type="text" id="lng"/>
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Fahrt nach</label>
			            			<select name="fahrtziel" id="marker" style="width: 165px;"></select>
			                    </div>
		            		</div>
		            		<div class="span4">
		            			<div class="control-group">
			            			<label class="control-label">COG</label>
			            			<input class="input-medium" type="text" id="cog"/>
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">SOG</label>
			            			<input class="input-medium" type="text" id="sog"/>
			                    </div>  
			                    <div class="control-group">
			                    	<label class="control-label">Manoever</label>
			            			<select name="manoever" id="manoever" style="width: 165px;"></select>
			                    </div>                 
		            		</div>
		            		<div class="span4">
		            			<div class="control-group">
			            			<label class="control-label">BTM</label>
			            			<input class="input-medium" type="text" id="btm"/>
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">DTM</label>
			            			<input class="input-medium" type="text" id="dtm"/>
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Vorsegel</label>
			            			<select name="vorsegel" id="vorsegel" style="width: 165px;"></select>
			            		</div>
		            		</div>
		            	</div>      	 
		            	<div class="control-group">
			            	<input type="reset" class="btn" id="delete" value="L&ouml;schen" class="button"/>
			                <input type="submit" class="btn" id="save" name="submit" value="Speichern" class="button"/>
			            </div>  
	            	</div>
	            </div>
	            <div class="appTableDiv" id="tripinfo" align="center">
	                <table class="appTable table table-hover" cellspacing="0px" cellpadding="5px">
	                    <thead>
	                        <tr>
	                            <th>Name</th>
	                            <th>Breite</th>
	                            <th>Laenge</th>
	                            <th>Peilung</th>
	                            <th>Abstand</th>
	                            <th>Manoever</th>     
	                            <th></th>
	                        </tr>
	                    </thead>
	                    <tbody id="entries">
	                        """),_display_(Seq[Any](/*110.27*/Html(data))),format.raw/*110.37*/("""
	                    </tbody>
	                </table>
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
		<script src=""""),_display_(Seq[Any](/*132.17*/routes/*132.23*/.Assets.at("javascripts/app/ajax/tripinfo.js"))),format.raw/*132.69*/("""" type="text/javascript"></script>
		
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
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/seapal_play2.1/app/views/tripinfo.scala.html
                    HASH: 6c49d606b36abb8f8fe3dc49eedfe8859ef513b3
                    MATRIX: 523->1|707->107|814->179|841->185|945->254|977->264|1117->369|1153->383|5410->4603|5443->4613|6108->5241|6124->5247|6193->5293
                    LINES: 19->1|22->1|30->9|30->9|36->15|36->15|42->21|42->21|131->110|131->110|153->132|153->132|153->132
                    -- GENERATED --
                */
            