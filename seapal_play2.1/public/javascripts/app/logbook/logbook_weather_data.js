
function saveValue(field, value) {

	var save = "save " + field + "with value: " + value;
	alert(save);
	/*$.ajax({
		type : "POST",
		url : "../../../server/storeValues.php",
		data : {
			'action' : 'send',
			'field' : field,
			'value' : value
		},
		dataType : "json",
		success : function(data) {
			if (data.field == '#wind_strength') {
				$('#wave_height').val(data.value);
			} else if (data.field == '#wind_direction') {
				$('#wave_direction').val(data.value);
			}
		},
	});*/
}

function getHistoricWeatherById(lat, lng, time) {

	var find = 'http://api.openweathermap.org/data/2.1/find/city?' + 'lat='
			+ lat + '&lon=' + lng + '&cnt=1';

	$.ajax({
		dataType : "jsonp",
		url : find,
		success : function(data) {
			getWeather(data, time);
		}
	});

}

function getWeather(data, time) {

	var weather = 'http://openweathermap.org/data/2.1/history/city/?id='
			+ data.list[0].id + '&start=' + time + '&cnt=1';
	alert(weather);

	$.ajax({
		dataType : "jsonp",
		url : weather,
		success : fillInData
	});

}

function fillInData(data) {

	var date = '';

	if (data.list[0].wind !== undefined
			&& data.list[0].wind.speed !== undefined
			&& data.list[0].wind !== undefined
			&& data.list[0].wind.deg !== undefined) {

		var strength = msToBeauf(data.list[0].wind.speed);
		var direction = data.list[0].wind.deg;
		
		setWindValues(direction, strength);
		setWaveValues(direction, calculateWaveHeight(strength));
		//to ensure that the wave height is only predicted if it was not edited manually before
		waveChanged = false;
	}

	if (data.list[0].main !== undefined
			&& data.list[0].main.pressure !== undefined) {
		var value = data.list[0].main.pressure;

		setPressure(value);
	}

	if (data.list[0].clouds !== undefined
			&& data.list[0].clouds.all !== undefined) {
		var value = data.list[0].clouds.all;

		setClouds(value);
	}

	if (data.list[0].main !== undefined && data.list[0].main.temp !== undefined) {
		var value = data.list[0].main.temp - 273.15;

		setTemperature(value);
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
