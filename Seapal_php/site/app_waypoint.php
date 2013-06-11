<!DOCTYPE html>

<html lang="de">
	<head>
		
		<!-- Header -->
		<?php include('_include/header.php'); ?>
		
	</head>
	<body>
		
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
	            	</div>
	            </div>
			    <br />
			    <br />
			    <h2>
                	Weather
            	</h2>
                <form method="post">
                    <fieldset>
                        <div>
                            <div>
                                <div>
                                    <label>Wind strength</label> <select name="wind_strength" id="wind_strength">
                                        <option value="0" selected="selected">0</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                </div>
                                <div>
                                    <label>Wind direction</label> <input type="number" name="wind_direction" id="wind_direction" pattern="\d[\d][\d]" min="0" max="359" value="0">
                                </div>
                                <div>
                                    <label>Air pressure (mBar)</label> <input type="number" name="air_pressure" id="air_pressure" pattern="\d\d\d[\d]" min="500" max="2000" value="1000">
                                </div>
                                <div>
                                    <label>Cloudiness level</label> <select name="cloudiness" id="cloudiness">
                                        <option value="0" selected="selected">0</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                    </select>
                                </div>
                                <div>
                                    <label>Raininess level</label> <select name="raininess" id="raininess">
                                        <option value="0" selected="selected">0</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                    </select>
                                </div>
                                <div>
                                    <label>wave height</label> <input type="text" name="wave_height" id="wave_height">
                                </div>
                                <div>
                                    <label>wave direction</label> <input type="number" name="wave_direction" id="wave_direction" pattern="\d[\d][\d]" min="0" max="359" value="0">
                                </div>
                                <div>
                                    <label>date of recognition</label> <input type="datetime" name="date_measured" id="date_measured">
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </form>
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
			</div><!-- Content -->
			
		</div><!-- Container -->
		
		<!-- Java Script -->
		<script src="../js/bootstrap/bootstrap-transition.js"></script>
	    <script src="../js/bootstrap/bootstrap-button.js"></script>
	    <script src="../js/bootstrap/bootstrap-collapse.js"></script>
	    <script src="../js/bootstrap/bootstrap-affix.js"></script>
		
		<!-- Additional Java-Script -->
		<script src="../js/app/ajax/waypoint.js" type="text/javascript"></script>

		<script src="../js/app/ajax/weatherForm.js" type="text/javascript"></script>
		
	</body>
</html>