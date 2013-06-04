<!DOCTYPE html>

<html lang="de">
	<head>
		
		<!-- Header -->
	  	<?php include('_include/header.php'); include('_include/header_app.php'); ?>
		
	</head>
	<body onload="initialize();">
		
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
    		
    		<!-- Route Menu -->
    		<div id="routeMenuContainer">
            	<div id="routeMenu" class="well">
            		<h4>Routen Menü</h4>
	            	<div class="btn-group btn-group-vertical">
	                    <input type="button" class="btn" value="l&ouml;schen" id="deleteRouteButton" class="routeButton" onclick="javascript: deleteRoute()" />
	                    <input type="button" class="btn" value="speichern" id="saveRouteButton" class="routeButton" onclick="javascript: saveRoute()" />
	                    <input type="button" class="btn" value="beenden" id="stopRouteButton" class="routeButton" onclick="javascript: stopRouteMode()" />
	                </div>
	            	<br><br>
	                <div id="route_distance">Routen-L&auml;nge: <span id="route_distance_number"></span> m</div>
	            </div>
	        </div>
	        
	        <!-- Distance Menu -->
	        <div id="distanceToolContainer">
	            <div id="distanceToolMenu" class="well">
	            	<h4>Distanztool</h4>
	            	<input type="button" class="btn" value="beenden" id="stopDistanceToolButton" class="distanceToolbutton" onclick="javascript: stopDistanceToolMode()" />
	            	<br><br>
	            	<div id="distanceTool_distance">Distanz: <span id="distanceTool_number"></span> m</div>
	            </div>
	        </div>
	        
	         <!-- Navigation Menu -->
	        <div id="navigationContainer">
	            <div id="navigationMenu" class="well">
	            	<h4>Navigation</h4>
	            	<input type="button" class="btn" value="beenden" id="stopNavigationButton" class="distanceToolbutton" onclick="javascript: stopNavigationMode()" />
	            	<br><br>
	            	<div id="navigation_distance">Distanz: <span id="navigation_number"></span> m</div>
	            </div>
	        </div>
	        
	        <!-- Current Position -->
	        <div id="followCurrentPositionContainer">
	        </div>

	        <br>

	        <div id="mapOverlaySelectionContainer">
	            <div id="mapOverlaySelection" class="well">
	                <div class="radio_form" id="radio_form">
				        <input type="radio" name="map_mode" id="sailor_mode" value="sailor_mode"><label for="sailor_mode">Sailor</label>
				        <input type="radio" name="map_mode" id="tourist_mode" value="tourist_mode"><label for="tourist_mode">Tourist</label>
				        <input type="radio" name="map_mode" id="expert_mode" value="expert_mode"><label for="expert_mode">Expert</label>
				    </div>
				    <div id="checkbox_form">
				        <input type="checkbox" name="exp_mode_chkbx_value[]" id="exp_mode_chkbx_Wind" value="Wind"><label for="exp_mode_chkbx_Wind">Wind</label>
				        <input type="checkbox" name="exp_mode_chkbx_value[]" id="exp_mode_chkbx_Pressure" value="Pressure"><label for="exp_mode_chkbx_Pressure">Pressure</label>
				        <input type="checkbox" name="exp_mode_chkbx_value[]" id="exp_mode_chkbx_Waves" value="Waves"><label for="exp_mode_chkbx_Waves">Waves</label>
				        <input type="checkbox" name="exp_mode_chkbx_value[]" id="exp_mode_chkbx_Temperature" value="Temperature"><label for="exp_mode_chkbx_Temperature">Temperature</label>
				        <input type="checkbox" name="exp_mode_chkbx_value[]" id="exp_mode_chkbx_Rain" value="Rain"><label for="exp_mode_chkbx_Rain">Rain</label>
				    </div>
	            </div>
	        </div>
	        
	        <!-- Map -->
	        <div id="appWrapper">
	            <div id="map_canvas"></div>
            </div>
 
	        <!-- Context Menus -->
	        <div id="temporaryMarkerContextMenu"></div>
	        <div id="fixedMarkerContextMenu"></div>
	        <div id="routeContextMenu_active"></div>
	        <div id="routeContextMenu_inactive"></div>	
			<div id="chat" align="center">
                <div id="chat-area" style="height:200px; width:200px; background-color: white; overflow: auto;"></div>
			</div>
		
		</div><!-- Container -->
	    
	    <!-- Java-Script -->
	    <script src="../js/bootstrap/bootstrap-dropdown.js"></script>
	    <script src="../js/bootstrap/bootstrap-modal.js"></script>
	    
	    <!-- Additional Java-Script -->
	    <script src="../js/app/map/fancywebsocket.js" type="text/javascript" ></script>
	    <script src="../js/app/map/chat.js" type="text/javascript" ></script>
	    <script src="../js/app/map/labels.js" type="text/javascript"></script>
	    <script src="../js/app/map/map.js" type="text/javascript"></script>
	    <script src="../js/app/map/map_routes.js" type="text/javascript"></script>
	    <script src="../js/app/map/validation.js" type="text/javascript"></script>
	    <script src="../js/app/map/contextMenu.js" type="text/javascript"></script>
	    <script src="../js/app/map/TxtOverlay.js" type="text/javascript"></script>
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