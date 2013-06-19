currentMarkerID = 0;

$(function() {

	$('a.view').click(
			
			function printTrip(wp) {

				document.getElementById("boat_info_table").style.display = 'block';
				document.getElementById("trip_info_table").style.display = 'block';
				document.getElementById("weather_info_table").style.display = 'block';
				document.getElementById("map_canvas").style.visibility = 'visible';
				google.maps.event.trigger(map, 'resize');


				var tripCoordinates = [
						new google.maps.LatLng(47.655733, 9.206272),
						new google.maps.LatLng(47.656196, 9.223953),
						new google.maps.LatLng(47.656080, 9.254681),
						new google.maps.LatLng(47.656369, 9.288326),
						new google.maps.LatLng(47.521780, 9.719282) ];
				
				var time = 1360938650;

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
						title : x
					});

					google.maps.event.addListener(marker, 'click', function() {
						var lat = this.getPosition().lat();
						var lng = this.getPosition().lng();

						map.setCenter(new google.maps.LatLng(lat, lng));
						getHistoricWeatherById(lat, lng, time, this.getTitle());
						currentMarkerID = this.getTitle();
						
						//weather charts can now be edited manually
						weatherChartEditable = true;
					});
				}

				tripPath.setMap(map);
				map.setCenter(tripCoordinates[0]);
			});

});
