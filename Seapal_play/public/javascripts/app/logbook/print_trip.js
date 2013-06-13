$(function() {

	$('a.view').click(
			
			function printTrip(coordinates) {
				
				document.getElementById("load_boat_info").style.visibility = 'visible';
				document.getElementById("delete").style.visibility = 'visible';
				document.getElementById("save").style.visibility = 'visible';
				
				//TODO: should get coordinates from server

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
					strokeWeight : 2
				});

				for (x in tripCoordinates) {

					marker = new google.maps.Marker({
						position : tripCoordinates[x],
						map : map
					});

					google.maps.event.addListener(marker, 'click', function() {
						var lat = this.getPosition().lat();
						var lng = this.getPosition().lng();

						map.setCenter(new google.maps.LatLng(lat, lng));
						getHistoricWeatherById(lat, lng);
					});
				}

				tripPath.setMap(map);
				map.setCenter(tripCoordinates[0]);
			});

});