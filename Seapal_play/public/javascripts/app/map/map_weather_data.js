function getWeather(position) {

	var lat = position.lat();
	var lon = position.lng();
	
	var weather = 'http://openweathermap.org/data/2.5/weather?'
					+ 'lat='
					+ lat
					+ '&lon='
					+ lon;

	$.ajax({
		dataType : "jsonp",
		url : weather,
		success : fillInData
	});

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
	winData[deg] = speed;
	$("#windContainer").highcharts().series[0].setData(winData);
	processWind(speed, deg);
	
	//pressure data
	if (data.main !== undefined	&& data.main.pressure !== undefined) {
		
		var date = [data.main.pressure];
		$("#pressureContainer").highcharts().series[0].setData(date);
	}

	//cloud data
	if (data.clouds !== undefined && data.clouds.all !== undefined) {
		var date = [Math.round(data.clouds.all / 100.0 * 8.0)];
		$("#cloudContainer").highcharts().series[0].setData(date);
	}

	//temp data
	if (data.main !== undefined && data.main.temp !== undefined) {
		var date = [Math.round(data.main.temp - 273.15)];
		$("#tempContainer").highcharts().series[0].setData(date);
	}

}

function degToDirection(degree) {
	if (degree >= 348.75 || degree < 11.25) {
		return 0;
	} else if (degree >= 11.25 && degree < 33.75) {
		return 1;
	} else if (degree >= 33.75 && degree < 56.25) {
		return 2;
	} else if (degree >= 56.25 && degree < 78.75) {
		return 3;
	} else if (degree >= 78.75 && degree < 101.25) {
		return 4;
	} else if (degree >= 101.25 && degree < 123.75) {
		return 5;
	} else if (degree >= 123.75 && degree < 146.25) {
		return 6;
	} else if (degree >= 146.25 && degree < 168.75) {
		return 7;
	} else if (degree >= 168.75 && degree < 191.25) {
		return 8;
	} else if (degree >= 191.25 && degree < 213.75) {
		return 9;
	} else if (degree >= 213.75 && degree < 236.25) {
		return 10;
	} else if (degree >= 236.25 && degree < 258.75) {
		return 11;
	} else if (degree >= 258.75 && degree < 281.25) {
		return 12;
	} else if (degree >= 281.25 && degree < 303.75) {
		return 13;
	} else if (degree >= 303.75 && degree < 326.25) {
		return 14;
	} else if (degree >= 326.25 && degree < 348.75) {
		return 15;
	}
}

function msToBeauf(ms) {

	if (ms > 0 && ms < 0.3) {
		return 0;
	} else if (ms >= 0.3 && ms < 1.6) {
		return 1;
	} else if (ms >= 1.6 && ms < 3.4) {
		return 2;
	} else if (ms >= 3.4 && ms < 5.5) {
		return 3;
	} else if (ms >= 5.5 && ms < 8.0) {
		return 4;
	} else if (ms >= 8.0 && ms < 10.8) {
		return 5;
	} else if (ms >= 10.8 && ms < 13.9) {
		return 6;
	} else if (ms >= 13.9 && ms < 17.2) {
		return 7;
	} else if (ms >= 17.2 && ms < 20.8) {
		return 8;
	} else if (ms >= 20.8 && ms < 24.5) {
		return 9;
	} else if (ms >= 24.5 && ms < 28.5) {
		return 10;
	} else if (ms >= 28.5 && ms < 32.7) {
		return 11;
	} else if (ms > 32.7) {
		return 12;
	}

}

function processWind(speed, deg) {

	var height = predictWaveHeight(speed);
	
	var date = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
	
	date[deg] = height;

	$("#waveContainer").highcharts().series[0].setData(date);

}

function predictWaveHeight(value) {
	return value / 2;
}