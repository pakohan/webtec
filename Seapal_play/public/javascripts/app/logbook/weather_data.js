$(function() {

	registerWeatherFields('#wind_strength');
	registerWeatherFields('#wind_direction');
	registerWeatherFields('#air_pressure');
	registerWeatherFields('#cloudiness');
	registerWeatherFields('#raininess');
	registerWeatherFields('#wave_height');
	registerWeatherFields('#wave_direction');
	registerWeatherFields('#date_measured');

	function registerWeatherFields(id) {

		$(id).keyup(function(e) {
			if (e.keyCode == 13) {
				var value = $(this).val();
				// sendValue(id, value);
			}
		});
	}

	function sendValue(field, value) {

		$.ajax({
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
		});
	}

	function getHistoricWeatherById(lat, lng) {

		var find = 'http://api.openweathermap.org/data/2.1/find/city?'
				+ 'lat=' + lat + '&lon=' + lng + '&cnt=1';

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

		var date;
		
		if (data.list[0].wind.speed === undefined) {
			date = 0;
		} else {
			date = data.list[0].wind.speed;
		}
		$('#wind_strength').val(msToBeauf(date));
		
		if (data.list[0].wind.deg === undefined) {
			date = 0;
		} else {
			date = data.list[0].wind.deg;
		}
		$('#wind_direction').val(date);
		
		if (data.list[0].main.pressure === undefined) {
			date = 1000;
		} else {
			date = data.list[0].main.pressure;
		}
		$('#air_pressure').val(date);
		
		if (data.list[0].clouds.all === undefined) {
			date = 0;
		} else {
			date = data.list[0].clouds.all;
		}
		$('#cloudiness').val(date);
		
		/*if (data.list[0].rain.day === undefined) {
			date = 0;
		} else {
			date = data.list[0].rain.day;
		}
		$('#raininess').val(date);*/

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

});
