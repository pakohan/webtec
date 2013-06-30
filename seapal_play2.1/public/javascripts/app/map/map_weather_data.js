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

	//wind data
	var winData = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
	var speed = 0;
	var deg = 0;
	
	if (data.wind !== undefined
			&& data.wind.speed !== undefined) {
		speed = msToBeauf(data.wind.speed);
	}

	if (data.wind !== undefined && data.wind.deg !== undefined) {
		deg = degToDirection(data.wind.deg);
	}
	setWindValues(deg, speed);
	var waveHeight = processWind(speed);
	setWaveValues(deg, waveHeight);
	
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
		var date = [Math.round(data.clouds.all / 100.0 * 8.0)];
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

function degToDirection(degree) {
	if (degree >= 348.75 || degree < 11.25) {
		return 0;
	} else {
		return Math.round((degree / 360) * 16);
	}
}

function processWind(speed) {

	return calculateWaveHeight(speed);
	
}
