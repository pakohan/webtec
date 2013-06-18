// initialize map and all event listeners
function initialize() {

	// set different map types
	var mapTypeIds = [ "roadmap", "satellite", "OSM" ];

	// set map Options
	var mapOptions = {
		center : new google.maps.LatLng(47.639485, 9.329345),
		zoom : 10,
		mapTypeId : google.maps.MapTypeId.ROADMAP,
		mapTypeControlOptions : {
			mapTypeIds : mapTypeIds
		},
		disableDefaultUI : true,
		mapTypeControl : true
	};

	// initialize map
	map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);

	// set map types
	map.mapTypes.set("OSM", new google.maps.ImageMapType({
		getTileUrl : function(coord, zoom) {
			return "http://tile.openstreetmap.org/" + zoom + "/" + coord.x
					+ "/" + coord.y + ".png";
		},
		tileSize : new google.maps.Size(256, 256),
		name : "OpenStreetMap",
		maxZoom : 18
	}));

	map.overlayMapTypes.push(new google.maps.ImageMapType({
		getTileUrl : function(coord, zoom) {
			return "http://tiles.openseamap.org/seamark/" + zoom + "/"
					+ coord.x + "/" + coord.y + ".png";
		},
		tileSize : new google.maps.Size(256, 256),
		name : "OpenSeaMap",
		maxZoom : 18
	}));

	connect();
}

function connect() {
	$.ajax({
		type : 'get',
		url : server_url,
		dataType : 'json',
		data : {
			'timestamp' : timestamp
		},
		success : function(response) {
			alert(response);
			noerror = true;
		},
		complete : function(response) {
			// send a new ajax request when this request is finished
			if (!self.noerror) {
				// if a connection problem occurs, try to reconnect each 5
				// seconds
				setTimeout(function() {
					connect();
				}, 5000);
			} else {
				// persistent connection
				connect();
			}
			noerror = false;
		}
	});
}