$(function() {

	$('a.view')
			.click(

					function printTrip(coordinates) {

						document.getElementById("route_info_table").style.display = 'block';
						document.getElementById("map_canvas").style.visibility = 'visible';
						document.getElementById("markers").style.visibility = 'visible';

						// TODO: should get coordinates from server

						var tripCoordinates = [
								new google.maps.LatLng(47.655733, 9.206272),
								new google.maps.LatLng(47.656196, 9.223953),
								new google.maps.LatLng(47.656080, 9.254681),
								new google.maps.LatLng(47.656369, 9.288326),
								new google.maps.LatLng(47.521780, 9.719282) ];

						var tripPath = new google.maps.Polyline({
							path : tripCoordinates,
							strokeColor : '#FF0000',
							strokeOpacity : 1.0,
							strokeWeight : 2,
							editable : true
						});

						google.maps.event.addListener(tripPath, "mouseup", getPath);

						function getPath() {
							var path = tripPath.getPath();
							var len = path.getLength();
							alert("store route");
						}

						tripPath.setMap(map);
						map.setCenter(tripCoordinates[0]);

					});

});
