$(function() {

	$('#show_trip').click(
			function printTrip() {

				// should get coordinates from server

				var tripCoordinates = [ new google.maps.LatLng(47.39, 9.14),
						new google.maps.LatLng(47.39, 9.15),
						new google.maps.LatLng(47.39, 9.16),
						new google.maps.LatLng(47.39, 9.17) ];

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

					google.maps.event.addListener(marker, 'click',
						function() {
							alert(this.title);
						});
				}

				tripPath.setMap(map);
				map.setCenter(new google.maps.LatLng(47.39, 9.14));
			});

});