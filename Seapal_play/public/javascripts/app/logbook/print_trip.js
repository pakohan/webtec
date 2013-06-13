$(function() {

	$('a.view').click(
			
			function printTrip(coordinates) {
				
				document.getElementById("load_boat_info").style.visibility = 'visible';
				document.getElementById("delete").style.visibility = 'visible';
				document.getElementById("save").style.visibility = 'visible';
				
				// should get coordinates from server

				var tripCoordinates = [
						new google.maps.LatLng(47.3934, 9.1241),
						new google.maps.LatLng(47.3996, 9.1517),
						new google.maps.LatLng(47.3842, 9.1640),
						new google.maps.LatLng(47.3888, 9.1334) ];

				var tripPath = new google.maps.Polyline({
					path : tripCoordinates,
					strokeColor : '#FF0000',
					strokeOpacity : 1.0,
					strokeWeight : 2
				});

				for (x in tripCoordinates) {

					marker = new google.maps.Marker({
						position : tripCoordinates[x],
						map : map,
						title : 'Marker No ' + x
					});

					google.maps.event.addListener(marker, 'click', function() {
						var lat = marker.getPosition().lat();
						var lng = marker.getPosition().lng();

						getHistoricWeatherById(lat, lng);
					});
				}

				tripPath.setMap(map);
				map.setCenter(tripCoordinates[0]);
			});

});