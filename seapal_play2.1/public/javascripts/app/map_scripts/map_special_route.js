var overlay = new google.maps.OverlayView();

var MODE = {
	DEFAULT : {
		value : 0,
		name : "default"
	},
	ROUTE : {
		value : 1,
		name : "route"
	},
	DISTANCE : {
		value : 2,
		name : "distance"
	},
	NAVIGATION : {
		value : 3,
		name : "navigation"
	}
};
var currentMode = MODE.DEFAULT;

var currentPositionMarker = null;
var followCurrentPosition = false;
var noToggleOfFollowCurrentPositionButton = false;

var greenTonMarker = new google.maps.MarkerImage(
		'/assets/images/icons/tonne_gruen.png', new google.maps.Size(32, 32), // size
		new google.maps.Point(0, 0), // origin point
		new google.maps.Point(9, 32) // offset point
);

var redTonMarker = new google.maps.MarkerImage(
		'/assets/images/icons/tonne_rot.png', new google.maps.Size(32, 32), // size
		new google.maps.Point(0, 0), // origin point
		new google.maps.Point(9, 32) // offset point
);

var purpleTonMarker = new google.maps.MarkerImage(
		'/assets/images/icons/tonne_lila.png', new google.maps.Size(32, 32), // size
		new google.maps.Point(0, 0), // origin point
		new google.maps.Point(9, 32) // offset point
);

var goalMarker = new google.maps.MarkerImage(
		'/assets/images/icons/lila_tor.png', new google.maps.Size(80, 32), // size
		new google.maps.Point(0, 0), // origin point
		new google.maps.Point(9, 32) // offset point
);

var currentPositionMarkerImage = new google.maps.MarkerImage(
		'/assets/images/icons/boat.png', new google.maps.Size(50, 50), // size
		new google.maps.Point(0, 0), // origin point
		new google.maps.Point(25, 40) // offset point
);

var temporaryMarkerImage = new google.maps.MarkerImage(
		'/assets/images/icons/cross_hair.png', new google.maps.Size(43, 43), // size
		new google.maps.Point(0, 0), // origin point
		new google.maps.Point(22, 22) // offset point
);

var fixedMarkerImage = new google.maps.MarkerImage(
		'/assets/images/icons/flag6.png', new google.maps.Size(40, 40), // size
		new google.maps.Point(0, 0), // origin point
		new google.maps.Point(9, 32) // offset point
);

var routeMarkerImage = new google.maps.MarkerImage(
		'/assets/images/icons/flag4.png', new google.maps.Size(40, 40), // size
		new google.maps.Point(0, 0), // origin point
		new google.maps.Point(7, 34) // offset point
);

var distanceMarkerImage = new google.maps.MarkerImage(
		'/assets/images/icons/flag5.png', new google.maps.Size(40, 40), // size
		new google.maps.Point(0, 0), // origin point
		new google.maps.Point(7, 34) // offset point
);

var destinationMarkerImage = new google.maps.MarkerImage(
		'/assets/images/icons/destination.png', new google.maps.Size(28, 31), // size
		new google.maps.Point(0, 0), // origin point
		new google.maps.Point(7, 9) // offset point
);

function MarkerWithInfobox(marker, infobox, counter) {
	this.reference = marker;
	this.infobox = infobox;
	this.counter = counter;
}

function initialise_rest() {
	// set route menu position
	document.getElementById('distanceToolContainer').style.width = document.body.offsetWidth
			+ "px";
	document.getElementById('distanceToolContainer').style.display = "none";

	// set client position
    currentPosition = new google.maps.LatLng(47.65521295468833, 9.2010498046875);
    
    var currentMarkerOptions = {
        position: currentPosition,
        map: map,
        icon: currentPositionMarkerImage
    }
    
	// initialize marker for current position
	currentPositionMarker = new google.maps.Marker(currentMarkerOptions);

	google.maps.event.addListener(currentPositionMarker, 'position_changed',
			function() {

				if (followCurrentPosition) {
					map.setCenter(currentPositionMarker.getPosition());
				}

				if (currentMode == MODE.NAVIGATION) {
					updateNavigation(currentPositionMarker.position,
							destinationMarker.position);
				}
			});

	overlay.draw = function() {
	};
	overlay.setMap(map);

	// click on map
	google.maps.event.addListener(map, 'click', function(event) {

		// handler for default mode
		if (currentMode == MODE.DEFAULT) {
			setTemporaryMarker(event.latLng);
		} else if (currentMode == MODE.ROUTE || currentMode == MODE.DISTANCE) {
			addRouteMarker(event.latLng);
		}
	});

	google.maps.event.addListener(map, 'center_changed', function() {
		if (followCurrentPosition && !noToggleOfFollowCurrentPositionButton) {
			toggleFollowCurrentPosition();
		} else {
			noToggleOfFollowCurrentPositionButton = false;
		}
	});

	$('#routeMenuContainer').hide();
}

//temporary marker context menu ----------------------------------------- //
$(function () {
    $.contextMenu({
        selector: '#temporaryMarkerContextMenu',
        events: {
            hide: function () {
                startTimeout();
            }
        },
        callback: function (key, options) {
        
            if (key == "red_ton") {
                setFixedMarker(temporaryMarker.position, redTonMarker);
            } else if (key == "purple_ton") {
            	setFixedMarker(temporaryMarker.position, purpleTonMarker);
            } else if (key == "green_ton") {
            	setFixedMarker(temporaryMarker.position, greenTonMarker);
            } else if (key == "goal") {
            	setFixedMarker(temporaryMarker.position, goalMarker);
            } else if (key == "distance") {
                startNewRoute(temporaryMarker.position, true);
            } else if (key == "delete") {
                temporaryMarker.setMap(null);
                temporaryMarkerInfobox.setMap(null);
            }
        },
        items: {
            "red_ton": { name: "Rote Tonne setzen", icon: "marker" },
            "purple_ton": { name: "Lila Tonne setzen", icon: "marker" },
            "green_ton": { name: "Gr&uuml;ne Tonne setzen", icon: "marker" },
            "goal": { name: "Tor setzen", icon: "marker" },
            "distance": { name: "Distanz messen", icon: "distance" },
            "delete": { name: "L&ouml;schen", icon: "delete" }
        }
    });
});

//fixed marker context menu ------------------------------------------------ //
$(function () {
    $.contextMenu({
        selector: '#fixedMarkerContextMenu',
        callback: function (key, options) {
            if (key == "destination") {

                startNewNavigation(currentPositionMarker.position, selectedMarker.reference.position);
            
            } else if (key == "delete") {
                selectedMarker.reference.setMap(null);
                selectedMarker.infobox.setMap(null);
                fixedMarkerArray.splice(fixedMarkerArray.indexOf(selectedMarker), 1);
            }
        },
        items: {
            "delete": { name: "L&ouml;schen", icon: "delete" }
        }
    });
});

function setFixedMarker(position, type) {

    temporaryMarker.setMap(null);
    temporaryMarkerInfobox.setMap(null);
    stopTimeout();

    fixedMarkerCount++;
    var fixedMarkerOptions = {
        position: position,
        map: map,
        title: 'Markierung ' + fixedMarkerCount,
        icon: type,
        draggable: true
    }

    fixedMarker = new google.maps.Marker(fixedMarkerOptions);

    // click on fixed marker
    google.maps.event.addListener(fixedMarker, 'click', function (event) {
        selectedMarker = getMarkerWithInfobox(event);
        var pixel = fromLatLngToPixel(event.latLng);
        
        if (currentMode != MODE.NAVIGATION) {
	        $('#fixedMarkerContextMenu').contextMenu({ x: pixel.x, y: pixel.y });
        }
    });

    // marker is dragged
    google.maps.event.addListener(fixedMarker, 'drag', function (event) {
        selectedMarker = getMarkerWithInfobox(event);
        selectedMarker.infobox.setMap(null);
        selectedMarker.infobox = drawFixedMarkerInfobox(event.latLng, selectedMarker.counter);
    });
    
 // marker is dragged
    google.maps.event.addListener(fixedMarker, 'dragend', function (event) {
		var data = "marker";
		$.post('app_marker_insert.html', data, "json");
    });

    fixedMarker.setMap(map);
    fixedMarkerInfoBox = drawFixedMarkerInfobox(temporaryMarker.position, fixedMarkerCount);
    fixedMarkerArray.push(new MarkerWithInfobox(fixedMarker, fixedMarkerInfoBox, fixedMarkerCount));
    
    var data = "marker";
	$.post('app_marker_insert.html', data, "json");
}
