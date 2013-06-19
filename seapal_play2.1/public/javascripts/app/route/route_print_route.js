var currentPath = null;

$(function() {

	$('a.view')
			.click(

					function printTrip(coordinates) {

						document.getElementById("map_canvas").style.visibility = 'visible';

						if (currentPath !== null) {
							currentPath.setMap(null);
						}
							
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
						
						currentPath = tripPath;

						google.maps.event.addListener(tripPath, "mouseup", getRoutePath);

						function getRoutePath() {
							var path = tripPath.getPath();
							var data = "route";
							$.post('app_route_insert.html', data, "json");
						}

						tripPath.setMap(map);
						map.setCenter(tripCoordinates[0]);

					});

});
