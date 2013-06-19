
function saveTripValue(id, value) {

	var data = {"id": id, "value": value};
	
	$.post('app_logbook_insertTripValue.html', data, "json");
}

function saveWeatherValue(id, value, markerID) {
	
	var data = {"id": id, "value": value, "markerID": markerID};

	$.post('app_logbook_insertWeatherValue.html', data, "json");
}

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

function fillInData(data, markerID) {

	var date = '';

	if (data.list[0].wind !== undefined
			&& data.list[0].wind.speed !== undefined
			&& data.list[0].wind !== undefined
			&& data.list[0].wind.deg !== undefined) {

		var strength = msToBeauf(data.list[0].wind.speed);
		var direction = data.list[0].wind.deg;
		
		setWindValues(direction, strength, markerID);
		setWaveValues(direction, calculateWaveHeight(strength), markerID);
		//to ensure that the wave height is only predicted if it was not edited manually before
		waveChanged = false;
	}

	if (data.list[0].main !== undefined
			&& data.list[0].main.pressure !== undefined) {
		var value = data.list[0].main.pressure;

		setPressure(value, markerID);
	}

	if (data.list[0].clouds !== undefined
			&& data.list[0].clouds.all !== undefined) {
		var value = data.list[0].clouds.all;
		value = Math.round((value * 8) / 100);
		setClouds(value, markerID);
	}

	if (data.list[0].main !== undefined && data.list[0].main.temp !== undefined) {
		var value = data.list[0].main.temp - 273.15;

		setTemperature(value, markerID);
	}

}

function convertToUnixTime(date) {
	var day = $("#day").val();
	var month = $("#month").val();
	var year = $("#year").val();
	var date = new Date();
	date.setFullYear(year, month, day)
	var unixtimeMS = date.getTime();
	var unixtime = parseInt(unixtimeMS / 1000);
	alert(unixtime);
}

function msToBeauf(ms) {
	
	return Math.round(Math.pow((ms / 0.8360), (2/3)));

}

function calculateWaveHeight(strength) {

	return Math.round(strength / 2);

}
