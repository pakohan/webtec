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

var marker = [];
var i = 0;

function connect() {
	var boat = new google.maps.MarkerImage('/assets/images/icons/boat.png',
		    new google.maps.Size(50, 50), //size
		    new google.maps.Point(0, 0),  //origin point
		    new google.maps.Point(25, 40)  //offset point
		);
	
	$.ajax({
		type : 'get',
		url : 'getShipPositions',
		dataType : 'json',
		
		success : function(response) {
			
			var pos = [new google.maps.LatLng(response.ship1Lat, response.ship1Lng),
			           new google.maps.LatLng(response.ship2Lat, response.ship2Lng),
			           new google.maps.LatLng(response.ship3Lat, response.ship3Lng)];
			
			for (var j in marker) {
				marker[j].setMap(null);
			}
			
			for (var k = 0; k < 3; k++) {
				marker[k] = new google.maps.Marker({
				      position: pos[k],
				      map: map,
				      icon: boat
				});
			}
			
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