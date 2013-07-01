//get historic weather data by lat and lng; calls getWeather
function getHistoricWeatherById(lat, lng, time, markerID) {

	var find = 'http://api.openweathermap.org/data/2.1/find/city?' + 'lat='
			+ lat + '&lon=' + lng + '&cnt=1';

	$.ajax({
		dataType : "jsonp",
		url : find,
		success : function(data) {
			getWeather(data, time, markerID);
		}
	});

}

//fetches historic weather data by city id; calls fillInData
function getWeather(data, time, markerID) {

	var weather = 'http://openweathermap.org/data/2.1/history/city/?id='
			+ data.list[0].id + '&start=' + time + '&cnt=1';
	
	$.ajax({
		dataType : "jsonp",
		url : weather,
		success : function(data) {
			fillInData(data, markerID);
		}
	});

}

//fills in historic weather data into weather charts
function fillInData(data, markerID) {

	//wind and wave data
	if (data.list[0].wind !== undefined
			&& data.list[0].wind.speed !== undefined
			&& data.list[0].wind !== undefined
			&& data.list[0].wind.deg !== undefined) {

		var strength = msToBeauf(data.list[0].wind.speed);
		var direction = degToDirection(data.list[0].wind.deg);
		
		setWindValues(direction, strength, markerID);
		setWaveValues(direction, calculateWaveHeight(strength), markerID);
		//to ensure that the wave height is only predicted if it was not edited manually before
		waveChanged = false;
	}

	//pressure data
	if (data.list[0].main !== undefined
			&& data.list[0].main.pressure !== undefined) {
		var value = data.list[0].main.pressure;
		
		if (value < 960) {
			value = 960;
		} else if (value > 1060) {
			value = 1060;
		}

		setPressure(value, markerID);
	}

	//cloud data
	if (data.list[0].clouds !== undefined
			&& data.list[0].clouds.all !== undefined) {
		
		var value = data.list[0].clouds.all;
		value = Math.round((value * 8) / 100);
		setClouds(value, markerID);
	}

	//temp data
	if (data.list[0].main !== undefined && data.list[0].main.temp !== undefined) {
		var value = data.list[0].main.temp - 273.15;
		if (value < -10) {
			value = -10;
		} else if (value > 40) {
			value = 40;
		}
		setTemperature(value, markerID);
	}

}
