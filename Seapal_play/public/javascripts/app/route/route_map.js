$(function() {

	$('a.view').click(
			alert("richtig");
			route = new google.maps.Polyline(activePathOptions);
			currentMode = MODE.ROUTE;
			currentRoute = new Route(route);
			
			
			document.getElementById("route_info_table").style.display = 'block';
			document.getElementById("map_canvas").style.visibility = 'visible';
			
			//TODO: should get coordinates from server

			var tripCoordinates = [
					new google.maps.LatLng(47.655733, 9.206272),
					new google.maps.LatLng(47.656196, 9.223953),
					new google.maps.LatLng(47.656080, 9.254681),
					new google.maps.LatLng(47.656369, 9.288326),
					new google.maps.LatLng(47.521780, 9.719282) ];

			addRouteMarker(tripCoordinates[0]);
			addRouteMarker(tripCoordinates[1]);
			addRouteMarker(tripCoordinates[2]);
			addRouteMarker(tripCoordinates[3]);
			addRouteMarker(tripCoordinates[4]);

			tripPath.setMap(map);
			map.setCenter(tripCoordinates[0]);
			
			route.setMap(map);
			routeArray.push(currentRoute);

});