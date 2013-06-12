
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
object trip extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template4[Html,Html,String,Html,play.api.templates.Html] {

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
	            <h2>Routen</h2>
	            <br />
	            <div class="container-fluid">
	            	<form class="form-horizontal"> 
		            	<div class="row well" style="margin-left: 15%;">
		            		<div class="span4" align="center">	            		
			            		<div class="control-group">
			            			<label class="control-label">Titel</label>
			            			<input type="text" name="titel" id="titel"/>
			            		</div>
			            		<div class="control-group">
			            			<label class="control-label">Von</label>
			            			<input type="text" name="von" id="von"/>
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Nach</label>
			            			<input type="text" name="von" id="nach"/>
			                    </div>        
		            		</div>
		            		<div class="span4">
		            			<div class="control-group">
			            			<label class="control-label">Start</label>
			            			<input type="text" name="titel" id="tstart"/>
			            		</div>
			            		<div class="control-group">
			            			<label class="control-label">Ende</label>
			            			<input type="text" name="von" id="tende"/>
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Dauer</label>
			            			<input type="text" name="von" id="tdauer"/>
			                    </div>
		            		</div>
		            		<div class="span4">
		            			<div class="control-group">
			            			<label class="control-label">Skipper</label>
			            			<input type="text" name="von" id="skipper"/>
			                    </div>
			                    <div class="control-group">
			            			<label class="control-label">Crew</label>
			            			<textarea cols="20" rows="3" id="crew"></textarea>
			                    </div>			                            
		            		</div>
		            		<div class="span4">
		            			<div class="control-group">
			            			<label class="control-label">Motor</label>
			            			<input type="text" name="motor" id="motor"/>
			                    </div>	
			                    <div class="control-group">
			            			<label class="control-label"></label>
			            			<span>Tank gefüllt<input type="checkbox" value="false" name="tank" id="tank" style="margin-left:20px; margin-top:-5px;"/></span>
			                    </div>			                            
		            		</div>
		            	</div>      	 
		            	<div class="control-group">
			            	<input type="reset" class="btn" id="delete" value="L&ouml;schen" class="button"/>
			                <input type="submit" class="btn" id="save" name="submit" value="Speichern" class="button"/>
			            </div>  
		            </form>
	            </div>
	            <br />
	            <br />
	            <div class="appTableDiv" id="appRoutelist" align="center">
	                <table class="appTable table table-hover" id="tableLinesClickable" cellspacing="0px" cellpadding="5px">
	                    <thead>
	                        <tr>
	                            <th>Titel</th>
	                            <th>Skipper</th>
	                            <th>Start</th>
	                            <th>Ende</th>
	                            <th>Dauer</th>
	                            <th>Motor</th>     
	                            <th></th>
	                        </tr>
	                    </thead>
	                    <tbody id="entries">
	                        """),_display_(Seq[Any](/*102.27*/Html(data))),format.raw/*102.37*/("""
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
		<script src=""""),_display_(Seq[Any](/*124.17*/routes/*124.23*/.Assets.at("javascripts/app/ajax/trip.js"))),format.raw/*124.65*/("""" type="text/javascript"></script>
		
    </body>
</html>"""))}
    }
    
    def render(navigation:Html,navigation_app:Html,data:String,header:Html): play.api.templates.Html = apply(navigation,navigation_app,data,header)
    
    def f:((Html,Html,String,Html) => play.api.templates.Html) = (navigation,navigation_app,data,header) => apply(navigation,navigation_app,data,header)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Jun 11 22:46:11 CEST 2013
                    SOURCE: /home/stefano/Dokumente/Programming/Web/Seapal2/app/views/trip.scala.html
                    HASH: 351c86b5eb138124f58005604a7e41010c09c16c
                    MATRIX: 519->1|703->107|810->179|837->185|941->254|973->264|1113->369|1149->383|4960->4157|4993->4167|5659->4796|5675->4802|5740->4844
                    LINES: 19->1|22->1|30->9|30->9|36->15|36->15|42->21|42->21|123->102|123->102|145->124|145->124|145->124
                    -- GENERATED --
                */
            