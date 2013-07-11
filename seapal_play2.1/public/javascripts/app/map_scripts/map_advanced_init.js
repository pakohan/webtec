var temporaryMarker = null;
var temporaryMarkerInfobox = null;
var temporaryMarkerTimeout = null;

var fixedMarker = null;
var fixedMarkerInfoBox = null;
var fixedMarkerCount = 0;
var fixedMarkerArray = new Array();

var selectedMarker = null;

// helper functions --------------------------------------------------------- //

// start marker timout
function startTimeout() {

	temporaryMarkerTimeout = setTimeout(function() {
		temporaryMarker.setMap(null);
		temporaryMarkerInfobox.setMap(null);
	}, 5000);
}

// stop marker timout
function stopTimeout() {
	clearTimeout(temporaryMarkerTimeout);
}

// draw temporaryMarkerInfobox
function drawTemporaryMarkerInfobox(latLng) {
	customTxt = "<div class='markerInfoBox well' id='temporaryMarkerInfobox'>"
			+ formatCoordinate(latLng.lat(), "lat")
			+ " "
			+ formatCoordinate(latLng.lng(), "long")
			+ "</br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspDTM "
			+ getDistance(latLng, currentPositionMarker.position) + "m</div>";
	// return new TxtOverlay(latLng, customTxt, "coordinate_info_box", map,
	// -110, -60);
	// $('body').append("<span>" + latLng.lat() + " " + latLng.lng() +
	// "</span><br>");
	return new TxtOverlay(latLng, customTxt, "coordinate_info_box", map, -113,
			-92);
}

// draw fixedMarkerInfobox
function drawFixedMarkerInfobox(latLng, counter) {

	customTxt = "<div class='markerInfoBox label' id='fixedMarkerInfobox'>"
			+ "Markierung " + (counter) + "</div>";
	return new TxtOverlay(latLng, customTxt, "coordinate_info_box", map, 40,
			-29);
}

function getMarkerWithInfobox(event) {

	for ( var i = 0; i < fixedMarkerArray.length; i++) {
		if (fixedMarkerArray[i].reference.position == event.latLng) {
			return fixedMarkerArray[i];
		}
	}
	return null;
}

function setTemporaryMarker(position) {

	var temporaryMarkerOptions = {
		position : position,
		map : map,
		icon : temporaryMarkerImage,
		draggable : true
	}

	// delete temp marker & infobox
	if (temporaryMarker != null) {
		temporaryMarker.setMap(null);
	}
	if (temporaryMarkerInfobox != null) {
		temporaryMarkerInfobox.setMap(null);
	}

	stopTimeout();
	temporaryMarker = new google.maps.Marker(temporaryMarkerOptions);

	// click on marker
	google.maps.event.addListener(temporaryMarker, 'click', function(event) {
		var pixel = fromLatLngToPixel(event.latLng);

		if (currentMode == MODE.DEFAULT) {
			$('#temporaryMarkerContextMenu').contextMenu({
				x : pixel.x,
				y : pixel.y
			});
		}

		stopTimeout();
	});

	// marker is dragged
	google.maps.event.addListener(temporaryMarker, 'drag', function(event) {
		temporaryMarkerInfobox.setMap(null);
		temporaryMarkerInfobox = drawTemporaryMarkerInfobox(event.latLng);
	});

	// marker drag start
	google.maps.event.addListener(temporaryMarker, 'dragstart',
			function(event) {
				stopTimeout();
			});

	// marker drag end
	google.maps.event.addListener(temporaryMarker, 'dragend', function(event) {
		startTimeout();
	});

	startTimeout();
	temporaryMarkerInfobox = drawTemporaryMarkerInfobox(position);
}

function getDistance(coord1, coord2) {
	return Math.round(google.maps.geometry.spherical.computeDistanceBetween(
			coord1, coord2));
}

function fromLatLngToPixel(latLng) {

	var pixel = overlay.getProjection().fromLatLngToContainerPixel(latLng);
	pixel.x += document.getElementById('map_canvas').offsetLeft;
	pixel.y += document.getElementById('map_canvas').offsetTop;
	return pixel;
}