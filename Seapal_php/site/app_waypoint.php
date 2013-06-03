<!DOCTYPE html>

<html lang="de">
	<head>
		
		<!-- Header -->
		<?php include('_include/header.php'); ?>
		<?php include('_include/initialiseMap.php'); ?>
		
	</head>
	<body onload=initialiseMap()>
		
		<!-- Navigation -->
		<?php include('_include/navigation.php'); ?>
		
		<!-- Container -->
		<div class="container-fluid">
			
			<!-- App Navigation -->
			<?php include('_include/navigation_app.php'); ?>
			
			<!-- Content -->		
			<div id="appWrapper" align="center">
			    <br />
			    <h2>Wegpunkt</h2>
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
		            </form>      	 
	            </div>
	        </div>
			<br />
			<br />
			<div class="container" align="center">
			    <div class="row" style="margin-left:5%;">
			        <div class="span4" id="appNotes">
			        	<h4>Notes</h4>
			            <textarea style="width:96%; height:360px;"></textarea>
			        </div>
			        <div class="span4" id="markerMap">
			        	<h4>Map</h4>
			            <img src="../img/icons/marker_map.png" id="appInfoPhoto" style="width:100%; heigt: 100%;"/>
			        </div>
			        <div class="span4" id="appPhotos">
			        	<h4>Photos</h4>
				        <img src="../img/icons/no_image.jpg" id="appInfoPhoto" style="width:100%; heigt: 100%;"/>
				    </div>
				</div>
			</div>
			<div class="container" align="left">
			  	<div class="row">
			    	<div class="span6" id="appNotes">
			            <p>Map Mode:</p>
			            <p>
				            <div id="radio_form">
				                <input type="radio" name="map_mode" id="sailor_mode" value="sailor_mode"> Sailor
				                <input type="radio" name="map_mode" id="tourist_mode" value="tourist_mode"> Tourist
				                <input type="radio" name="map_mode" id="expert_mode" value="expert_mode"> Expert
				            </div>
				            <div id="checkbox_form">
				                <input type="checkbox" name="exp_mode_chkbx_value[]" id="exp_mode_chkbx_Wind" value="Wind"> Wind
				                <input type="checkbox" name="exp_mode_chkbx_value[]" id="exp_mode_chkbx_Pressure" value="Pressure"> Pressure
				                <input type="checkbox" name="exp_mode_chkbx_value[]" id="exp_mode_chkbx_Waves" value="Waves"> Waves
				                <input type="checkbox" name="exp_mode_chkbx_value[]" id="exp_mode_chkbx_Temperature" value="Temperature"> Temperature
				                <input type="checkbox" name="exp_mode_chkbx_value[]" id="exp_mode_chkbx_Rain" value="Rain"> Rain
				            </div>
			            </p>
			            
			        </div>
				</div>
			</div><!-- Content -->

			<div class="container">
				<div class="row" style="width:100%; height:600px;">
					<div class="span6" id="map_canvas" style="width:100%; height:100%"></div>
				</div>
			</div>
		</div><!-- Content -->
		
		<!-- Java Script -->
		<script src="../js/bootstrap/bootstrap-transition.js"></script>
	    <script src="../js/bootstrap/bootstrap-button.js"></script>
	    <script src="../js/bootstrap/bootstrap-collapse.js"></script>
	    <script src="../js/bootstrap/bootstrap-affix.js"></script>
		
		<!-- Additional Java-Script -->
		<script src="../js/app/ajax/waypoint.js" type="text/javascript"></script>

		<script src="../js/app/map/weatherMap.js" type="text/javascript"></script>
		
	</body>
</html>