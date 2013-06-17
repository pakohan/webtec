$(function() {

	registerWeatherFields('#wind_strength');
	registerWeatherFields('#wind_direction');
	registerWeatherFields('#air_pressure');
	registerWeatherFields('#cloudiness');
	registerWeatherFields('#raininess');
	registerWeatherFields('#wave_height');
	registerWeatherFields('#wave_direction');
	registerWeatherFields('#date_measured');

});

function registerWeatherFields(id) {

	$(id).change(function() {
		var value = $(this).val();
		alert(id, value);
		// saveValue(id, value);

		if (id === '#wind_strength' || id === '#wind_direction') {
			processWind();
		}
	});

}

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

function getHistoricWeatherById(lat, lng) {

	var find = 'http://api.openweathermap.org/data/2.1/find/city?' + 'lat='
			+ lat + '&lon=' + lng + '&cnt=1';

	$.ajax({
		dataType : "jsonp",
		url : find,
		success : getWeather
	});

}

function getWeather(data) {

	var time = 1361670000;
	var day;
	var month;
	var year;

	var weather = 'http://openweathermap.org/data/2.1/history/city/?id='
			+ data.list[0].id + '&start=' + time + '&cnt=1';

	$.ajax({
		dataType : "jsonp",
		url : weather,
		success : fillInData
	});

}

function fillInData(data) {

	var date = '';

	if (data.list[0].wind !== undefined
			&& data.list[0].wind.speed !== undefined) {
		var id = '#wind_strength';
		var value = msToBeauf(data.list[0].wind.speed);

		$(id).val(value);
		saveValue(id, value);
	}

	if (data.list[0].wind !== undefined && data.list[0].wind.deg !== undefined) {
		var id = '#wind_direction';
		var value = data.list[0].wind.deg;

		$(id).val(value);
		saveValue(id, value);
	}

	if (data.list[0].main !== undefined
			&& data.list[0].main.pressure !== undefined) {
		var id = '#air_pressure';
		var value = data.list[0].main.pressure;

		$(id).val(value);
		saveValue(id, value);
	}

	if (data.list[0].clouds !== undefined
			&& data.list[0].clouds.all !== undefined) {
		var id = '#cloudiness';
		var value = data.list[0].clouds.all / 10;

		$(id).val(value);
		saveValue(id, value);
	}

	if (data.list[0].rain !== undefined && data.list[0].rain.day !== undefined) {
		var id = '#raininess';
		var value = data.list[0].rain.day;

		$(id).val(value);
		saveValue(id, value);
	}

	processWind();

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
	var beauf;

	if (ms >= 0 && ms < 0.3) {
		return 0;
	} else if (ms >= 0.3 && ms < 1.6) {
		return 1;
	} else if (ms >= 1.6 && ms < 3.4) {
		return 1;
	} else if (ms >= 3.4 && ms < 5.5) {
		return 1;
	} else if (ms >= 5.5 && ms < 8.0) {
		return 1;
	} else if (ms >= 8.0 && ms < 10.8) {
		return 1;
	} else if (ms >= 10.8 && ms < 13.9) {
		return 1;
	} else if (ms >= 13.9 && ms < 17.2) {
		return 1;
	} else if (ms >= 17.2 && ms < 20.8) {
		return 1;
	} else if (ms >= 20.8 && ms < 24.5) {
		return 1;
	} else if (ms >= 28.5 && ms < 32.7) {
		return 1;
	} else if (ms > 32.7) {
		return 1;
	}

}

function processWind(x, y) {

	var direction = x;
	var strength = y;

	var height = predictWaveHeight(strength);

	saveValue('#wave_height', height);
	saveValue('#wave_direction', direction);
	
	return height;
}

function predictWaveHeight(value) {
	return Math.round(value / 2);
}