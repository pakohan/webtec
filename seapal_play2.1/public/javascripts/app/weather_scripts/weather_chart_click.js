//clickable wind and wave roses
//makes standard gauges clickable
//calls weather_chart_basic initialise function
$(function() {

	//wind rose
	$('#windContainer').highcharts(
			{
				series : [ {
					data : [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
				} ],

				chart : {
					polar : true,
					type : 'column',
					events : {
						click : function(event) {
							if (weatherChartEditable) {
								var x = event.xAxis[0].value;
								var y = event.yAxis[0].value;

								var series = this.series[0];

								var xVal = Math.round(x);
								var yVal = Math.round(y);
								var data = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
										0, 0, 0, 0, 0 ];

								if (yVal > 12) {
									yVal = 12;
								}
								
								if (xVal >= 15.5) {
									xVal = 0;
								}
								
								data[xVal] = yVal;
								setWindValues(xVal, yVal, currentMarkerID);
								// wave height is only set if the wave values
								// have not been edited manually before
								if (waveChanged === false) {
									setWaveValues(xVal,
											calculateWaveHeight(yVal),
											currentMarkerID);
								}
							}
						}
					}
				},

				title : {
					text : null
				},

				pane : {
					size : '85%'
				},

				xAxis : {
					tickmarkPlacement : 'on',
					categories : [ 'N', 'NNO', 'NO', 'ONO', 'O', 'OSO', 'SO',
							'SSO', 'S', 'SSW', 'SW', 'WSW', 'W', 'WNW', 'NW',
							'NNW' ]
				},

				yAxis : {
					min : 0,
					max : 12,
					tickInterval : 1,
					title : {
						text : 'Beaufort'
					}
				},

				plotOptions : {
					series : {
						stacking : 'normal',
						shadow : false,
						groupPadding : 0,
						pointPlacement : 'on'
					}
				},

				tooltip : {
					enabled : false
				},

				legend : {
					enabled : false
				},

				credits : {
					enabled : false
				},

				exporting : {
					enabled : false
				}
			});

	//wave wind rose
	$('#waveContainer').highcharts(
			{
				series : [ {
					data : [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
				} ],

				chart : {
					polar : true,
					type : 'column',
					events : {
						click : function(event) {
							if (weatherChartEditable) {
								var x = event.xAxis[0].value;
								var y = event.yAxis[0].value;

								var series = this.series[0];

								var xVal = Math.round(x);
								var yVal = Math.round(y);
								var data = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
										0, 0, 0, 0, 0 ];

								if (yVal > 12) {
									yVal = 12;
								}

								if (xVal >= 15.5) {
									xVal = 0;
								}
								
								setWaveValues(xVal, yVal, currentMarkerID);
								// indicates that the wave direction and height
								// are edited manually
								// so no wave height prediction is needed any
								// more.
								waveChanged = true;
							}
						}
					}
				},

				title : {
					text : null
				},

				pane : {
					size : '85%'
				},

				xAxis : {
					tickmarkPlacement : 'on',
					categories : [ 'N', 'NNO', 'NO', 'ONO', 'O', 'OSO', 'SO',
							'SSO', 'S', 'SSW', 'SW', 'WSW', 'W', 'WNW', 'NW',
							'NNW' ]
				},

				yAxis : {
					min : 0,
					max : 12,
					tickInterval : 1,
					title : {
						text : 'Meter'
					}
				},

				plotOptions : {
					series : {
						stacking : 'normal',
						shadow : false,
						groupPadding : 0,
						pointPlacement : 'on'
					}
				},

				tooltip : {
					enabled : false
				},

				legend : {
					enabled : false
				},

				credits : {
					enabled : false
				},

				exporting : {
					enabled : false
				}
			});
	
	//initialise basic charts (pressure, clouds, temperature)
	init_basic_charts();

	//make pressure gauge clickable
	$('#highcharts-4').click(
			function(e) {
				if (weatherChartEditable) {
					var pos = findPos(this);
					var x = e.pageX - pos.x;
					var y = e.pageY - pos.y;
					var divHeight = $('#highcharts-4').height();
					var divWidth = $('#highcharts-4').width();

					var value = getGaugeValue(x, y, divHeight, divWidth, 300,
							100, 1010);

					setPressure(value, currentMarkerID);
				}
			});

	//make clouds gauge clickable
	$('#highcharts-6').click(function(e) {
		if (weatherChartEditable) {
			var pos = findPos(this);
			var x = e.pageX - pos.x;
			var y = e.pageY - pos.y;
			var divHeight = $('#highcharts-6').height();
			var divWidth = $('#highcharts-6').width();

			var value = getGaugeValue(x, y, divHeight, divWidth, 300, 8, 4);

			setClouds(value, currentMarkerID);
		}
	});

	//make temperature gauge clickable
	$('#highcharts-8').click(function(e) {
		if (weatherChartEditable) {
			var pos = findPos(this);
			var x = e.pageX - pos.x;
			var y = e.pageY - pos.y;
			var divHeight = $('#highcharts-8').height();
			var divWidth = $('#highcharts-8').width();

			var value = getGaugeValue(x, y, divHeight, divWidth, 300, 50, 15);

			setTemperature(value, currentMarkerID);
		}
	});

	//find position of left upper corner of object
	function findPos(obj) {
		var curleft = 0, curtop = 0;
		if (obj.offsetParent) {
			do {
				curleft += obj.offsetLeft;
				curtop += obj.offsetTop;
			} while (obj = obj.offsetParent);
			return {
				x : curleft,
				y : curtop
			};
		}
		return undefined;
	}

	//calculates gauge value of click position with polar coordinates
	function getGaugeValue(x, y, divHeight, divWidth, degree, steps,
			middleValue) {
		var centerX = divWidth / 2;
		var centerY = divHeight / 2;
		var normX = x - centerX;
		var normY = centerY - y;

		var phi = Math.atan2(normX, normY);
		var phiGrad = phi * 180 / Math.PI;

		var value = Math.round(phiGrad * (steps / degree) + middleValue);

		return value;
	}

});

//set wind strength and direction
function setWindValues(direction, strength, markerID) {
	var date = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];
	date[direction] = strength;

	$("#windContainer").highcharts().series[0].setData(date);

	saveWeatherValue('wind_strength', strength, markerID);
	saveWeatherValue('wind_direction', direction, markerID);
}

//set wave height and direction
function setWaveValues(direction, height, markerID) {
	var date = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];
	date[direction] = height;

	$("#waveContainer").highcharts().series[0].setData(date);

	saveWeatherValue('wave_height', height, markerID);
	saveWeatherValue('wave_direction', direction, markerID);
}

//set air pressure
function setPressure(value, markerID) {
	var date = [ value ];

	$("#pressureContainer").highcharts().series[0].setData(date);

	saveWeatherValue('air_pressure', value, markerID);
}

//set clouds
function setClouds(value, markerID) {

	if (value < 0) {
		value = 0;
	} else if (value > 8) {
		value = 8;
	}
	var date = [ value ];

	$("#cloudContainer").highcharts().series[0].setData(date);

	saveWeatherValue('cloudiness', value, markerID);
}

//set temperature
function setTemperature(value, markerID) {
	tmpValue = Math.round(value);

	if (tmpValue > 40) {
		tmpValue = 40;
	} else if (tmpValue < -10) {
		tmpValue = -10;
	}
	var date = [ tmpValue ];

	$("#tempContainer").highcharts().series[0].setData(date);

	saveWeatherValue('temperature', tmpValue, markerID);
}