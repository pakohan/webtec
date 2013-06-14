// initialize map and all event listeners
function initialize() {

	// set different map types
	var mapTypeIds = [ "roadmap", "satellite", "OSM" ];

	// set map Options
	var mapOptions = {
		center : new google.maps.LatLng(47.65521295468833, 9.2010498046875),
		zoom : 14,
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

	google.maps.event.addListener(map, 'click', function() {
		var marker = new google.maps.Marker({
			position : event.latLng,
			map : map,
			title : "Hello World!",
			draggable: true
		});
	});
}