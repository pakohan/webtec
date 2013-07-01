$(function() {
	
	//load trip information
	function loadEntry(boatnr) { 
			        	
	    jQuery.get("app_logbook_loadTrip.html", function(data) {

	        $('#bootname').val(data['bootname']);
	        $('#typ').val(data['typ']);
	        $('#baujahr').val(data['baujahr']);
	        $('#registernummer').val(data['registernummer']);
	        $('#konstrukteur').val(data['konstrukteur']);
	        $('#motor').val(data['motor']);
	        $('#segelzeichen').val(data['segelzeichen']);
	        $('#laenge').val(data['laenge']);
	        $('#tankgroesse').val(data['tankgroesse']);
	        $('#heimathafen').val(data['heimathafen']);
	        $('#breite').val(data['breite']);
	        $('#wassertankgroesse').val(data['wassertankgroesse']);
	        $('#yachtclub').val(data['yachtclub']);
	        $('#tiefgang').val(data['tiefgang']);
	        $('#abwassertankgroesse').val(data['abwassertankgroesse']);
	        $('#eigner').val(data['eigner']);
	        $('#masthoehe').val(data['masthoehe']);
	        $('#grosssegelgroesse').val(data['grosssegelgroesse']);
	        $('#versicherung').val(data['versicherung']);
	        $('#verdraengung').val(data['verdraengung']);
	        $('#genuagroesse').val(data['genuagroesse']);
	        $('#rufzeichen').val(data['rufzeichen']);
	        $('#rigart').val(data['rigart']);
	        $('#spigroesse').val(data['spigroesse']);
	        $('#titel').val(data['titel']);
	    	$('#von').val(data['von']);
	    	$('#nach').val(data['nach']);
	    	$('#tstart').val(data['tstart']);
	    	$('#tende').val(data['tende']);
	    	$('#tdauer').val(data['tdauer']);
	    	$('#skipper').val(data['skipper']);
	    	$('#crew').val(data['crew']);
	    	$('#motor').val(data['motor']);
	    	$('#tank').val(data['tank']);
	
	    } , "json");
	}
	
	//load route information
	function loadRoute() {
		var waypoints = [];
		
		jQuery.get("app_logbook_loadRoute.html", function(data) {
			
			
		}, "json");
	}

	//load route information and show on map
	$('a.view').click(function(event) {
		loadEntry($(this).attr('id'));
		loadRoute();
	});

	//delete route
	$('a.remove').click(function(event) {

		jQuery.get("app_logbook_deleteTrip.html", "json");
	});

});

//store single trip information value (boatname, type, etc.)
function saveTripValue(id, value) {

	var data = {"id": id, "value": value};
	
	$.post('app_logbook_insertTripValue.html', data, "json");
}

//store single weather value (temperature, wind strength, etc.)
function saveWeatherValue(id, value, markerID) {
	
	var data = {"id": id, "value": value, "markerID": markerID};

	$.post('app_logbook_insertWeatherValue.html', data, "json");
}


