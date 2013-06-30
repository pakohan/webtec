function getWeather(position) {

	var lat = position.lat();
	var lon = position.lng();
	
	var weather = 'http://api.openweathermap.org/data/2.5/weather?'
					+ 'lat='
					+ lat
					+ '&lon='
					+ lon;

	$.ajax({
		dataType : "jsonp",
		url : weather,
		success : storeWeatherData
	});

}

function getWeatherForecast(position) {
	var lat = position.lat();
	var lon = position.lng();
	
	var weather = 'http://api.openweathermap.org/data/2.5/forecast?'
					+ 'lat='
					+ lat
					+ '&lon='
					+ lon;

	$.ajax({
		dataType : "jsonp",
		url : weather,
		success : storeWeatherForecast
	});
}

var weatherForecast = [];
var currentWeather = [];

function storeWeatherForecast(data) {

	weatherForecast[0] = data.list[0];
	weatherForecast[1] = data.list[1];
	weatherForecast[2] = data.list[7];
	weatherForecast[3] = data.list[15];
	weatherForecast[4] = data.list[34];
}

function storeWeatherData(data) {
	currentWeather[0] = data;
	fillInData(data);
}

function fillInData(data) {

	// wind and wave data
	if (data.wind !== undefined
			&& data.wind.speed !== undefined
			&& data.wind !== undefined
			&& data.wind.deg !== undefined) {

		var strength = msToBeauf(data.wind.speed);
		var direction = degToDirection(data.wind.deg);

		setWindValues(direction, strength);
		setWaveValues(direction, calculateWaveHeight(strength));
	}
	
	//pressure data
	if (data.main !== undefined	&& data.main.pressure !== undefined) {
		var value = data.main.pressure;
		
		if (value < 960) {
			value = 960;
		} else if (value > 1060) {
			value = 1060;
		}
		
		setPressure(value);
	}

	//cloud data
	if (data.clouds !== undefined && data.clouds.all !== undefined) {
		var value = data.clouds.all;
		value = Math.round((value * 8) / 100);
		setClouds(value);
	}

	//temp data
	if (data.main !== undefined && data.main.temp !== undefined) {
		var value = data.main.temp;
		value = Math.round(value - 273.15);
		if (value < -10) {
			value = -10;
		} else if (value > 40) {
			value = 40;
		}
		var date = [value];
		setTemperature(value);
	}

}

