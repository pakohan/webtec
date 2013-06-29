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
	//set route menu position
    document.getElementById('followCurrentPositionContainer').style.width = document.body.offsetWidth + "px";
    document.getElementById('routeMenuContainer').style.width = document.body.offsetWidth + "px";
    document.getElementById('routeMenuContainer').style.display = "none";
    document.getElementById('distanceToolContainer').style.width = document.body.offsetWidth + "px";
    document.getElementById('distanceToolContainer').style.display = "none";
    document.getElementById('navigationContainer').style.width = document.body.offsetWidth + "px";
    document.getElementById('navigationContainer').style.display = "none";
    document.getElementById('chat').style.display = "none";
    
    // set client position
    currentPosition = new google.maps.LatLng(47.65521295468833, 9.2010498046875);
    
    var currentMarkerOptions = {
        position: currentPosition,
        map: map,
        icon: currentPositionMarkerImage
    }

    // initialize marker for current position

    currentPositionMarker = new google.maps.Marker(currentMarkerOptions);
    
    google.maps.event.addListener(currentPositionMarker, 'position_changed', function () {
        
        if (followCurrentPosition) {
            map.setCenter(currentPositionMarker.getPosition());
        }
        
        if (currentMode == MODE.NAVIGATION) {
            updateNavigation(currentPositionMarker.position, destinationMarker.position);
        }
    });
    
    overlay.draw = function () { };
    overlay.setMap(map);

    // click on map
    google.maps.event.addListener(map, 'click', function (event) {

        // handler for default mode
        if (currentMode == MODE.DEFAULT) {
            setTemporaryMarker(event.latLng);
        } else if (currentMode == MODE.ROUTE || currentMode == MODE.DISTANCE) {
            addRouteMarker(event.latLng);
        }
    });

    google.maps.event.addListener(map, 'dragend', function () { 
        getWeather(map.getCenter());
        getWeatherForecast(map.getCenter());
    });
    
    google.maps.event.addListener(map, 'zoom_changed', function() {
        var level = map.getZoom();
        if (level === 8) {
        	$("#mapDiv").attr('class', 'span7');
        	$("#chartDiv").show();
        	$("#weatherMode_choices").hide();
        	google.maps.event.trigger(map, 'resize');
        } else if (level === 7) {
        	$("#chartDiv").hide();
        	$("#weatherMode_choices").show();
        	$("#mapDiv").attr('class', 'span12');
        	google.maps.event.trigger(map, 'resize');
        }
    });
    
    getWeather(map.getCenter());
    getWeatherForecast(map.getCenter());
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
        
            if (key == "marker") {
                setFixedMarker(temporaryMarker.position)
            } else if (key == "startroute") {
                startNewRoute(temporaryMarker.position, false);
            } else if (key == "distance") {
                startNewRoute(temporaryMarker.position, true);
            } else if (key == "destination") {
            	startNewNavigation(currentPositionMarker.position, temporaryMarker.position);
            } else if (key == "delete") {
                temporaryMarker.setMap(null);
                temporaryMarkerInfobox.setMap(null);
            }
        },
        items: {
            "marker": { name: "Markierung setzen", icon: "marker" },
            "startroute": { name: "Neue Route setzen", icon: "startroute" },
            "distance": { name: "Distanz messen", icon: "distance" },
            "destination": { name: "Zum Ziel machen", icon: "destination" },
            "sep1": "---------",
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
            "destination": { name: "Zum Ziel machen", icon: "destination" },
            "sep1": "---------",
            "delete": { name: "L&ouml;schen", icon: "delete" }
        }
    });
});

function toggleFollowCurrentPosition() {
    followCurrentPosition = !followCurrentPosition;
    if (followCurrentPosition) {
        document.getElementById("followCurrentPositionbutton").value = "Eigener Position nicht mehr folgen";
        noToggleOfFollowCurrentPositionButton = true;
        map.setCenter(currentPositionMarker.getPosition());
    } else {
        document.getElementById("followCurrentPositionbutton").value = "Eigener Position folgen";
    }
    document.getElementById('followCurrentPositionContainer').style.width = document.body.offsetWidth + "px";
}

function setFixedMarker(position) {

	temporaryMarker.setMap(null);
	temporaryMarkerInfobox.setMap(null);
	stopTimeout();

	fixedMarkerCount++;
	var fixedMarkerOptions = {
		position : position,
		map : map,
		title : 'Markierung ' + fixedMarkerCount,
		icon : fixedMarkerImage,
		draggable : true
	}

	fixedMarker = new google.maps.Marker(fixedMarkerOptions);

	// click on fixed marker
	google.maps.event.addListener(fixedMarker, 'click', function(event) {
		selectedMarker = getMarkerWithInfobox(event);
		var pixel = fromLatLngToPixel(event.latLng);

		if (currentMode != MODE.NAVIGATION) {
			$('#fixedMarkerContextMenu').contextMenu({
				x : pixel.x,
				y : pixel.y
			});
		}
	});

	// marker is dragged
	google.maps.event.addListener(fixedMarker, 'drag', function(event) {
		selectedMarker = getMarkerWithInfobox(event);
		selectedMarker.infobox.setMap(null);
		selectedMarker.infobox = drawFixedMarkerInfobox(event.latLng,
				selectedMarker.counter);
	});

	fixedMarker.setMap(map);
	fixedMarkerInfoBox = drawFixedMarkerInfobox(temporaryMarker.position,
			fixedMarkerCount);
	fixedMarkerArray.push(new MarkerWithInfobox(fixedMarker,
			fixedMarkerInfoBox, fixedMarkerCount));
}