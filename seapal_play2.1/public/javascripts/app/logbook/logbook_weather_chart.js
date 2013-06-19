$(function () {

    $('#windContainer').highcharts({
        series: [{
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        }],
	    
	    chart: {
	        polar: true,
	        type: 'column',
            events: {
                click: function(event) {
                	if (weatherChartEditable) {
	                    var x = event.xAxis[0].value;
	                    var y = event.yAxis[0].value;
	                    
	                    var series = this.series[0];
	                    
	                    var xVal = Math.round(x);
	                    var yVal = Math.round(y);
	                    var data = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
	                    
	                    if (yVal > 12) {
	                    	yVal = 12;
	                    }
	                    data[xVal] = yVal;
	                    setWindValues(xVal, yVal);
	                    //wave height is only set if the wave values have not been edited manually before
	                    if (waveChanged === false) {
	                    	setWaveValues(xVal, calculateWaveHeight(yVal));
	                    }
                	}
                }
            }
	    },
	    
	    title: {
	        text: null
	    },
	    
	    pane: {
	    	size: '85%'
	    },
	    
	    xAxis: {
	    	tickmarkPlacement: 'on',
            categories: ['N', 'NNO', 'NO', 'ONO', 'O', 'OSO', 'SO', 'SSO', 'S',
                         'SSW', 'SW', 'WSW', 'W','WNW', 'NW', 'NNW']
	    },
	        
	    yAxis: {
            min: 0,
            max: 12,
            tickInterval: 1,
            title: {
	        	text: 'Beaufort'
	        }
	    },
	        
	    plotOptions: {
	        series: {
	        	stacking: 'normal',
	        	shadow: false,
	        	groupPadding: 0,
	        	pointPlacement: 'on'
	        }
	    },
	    
	    tooltip: {
	    	enabled: false
	    },
	    
	    legend: {
	    	enabled: false
	    },
	    
	    credits: {
            enabled: false
        },
        
        exporting: {
        	enabled: false
        }
	});
    
    $('#waveContainer').highcharts({
        series: [{
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        }],
	    
	    chart: {
	        polar: true,
	        type: 'column',
            events: {
                click: function(event) {
                	if (weatherChartEditable) {
	                    var x = event.xAxis[0].value;
	                    var y = event.yAxis[0].value;
	                    
	                    var series = this.series[0];
	                    
	                    var xVal = Math.round(x);
	                    var yVal = Math.round(y);
	                    var data = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
	                    
	                    if (yVal > 12) {
	                    	yVal = 12;
	                    }
	                    setWaveValues(xVal, yVal);
	                    //indicates that the wave direction and height are edited manually
	                    // so no wave height prediction is needed any more.
	                    waveChanged = true;
                	}
                }
            }
	    },
	    
	    title: {
	        text: null
	    },
	    
	    pane: {
	    	size: '85%'
	    },
	    
	    xAxis: {
	    	tickmarkPlacement: 'on',
            categories: ['N', 'NNO', 'NO', 'ONO', 'O', 'OSO', 'SO', 'SSO', 'S',
                         'SSW', 'SW', 'WSW', 'W','WNW', 'NW', 'NNW']
	    },
	        
	    yAxis: {
            min: 0,
            max: 12,
            tickInterval: 1,
            title: {
	        	text: 'Meter'
	        }
	    },
	        
	    plotOptions: {
	        series: {
	        	stacking: 'normal',
	        	shadow: false,
	        	groupPadding: 0,
	        	pointPlacement: 'on'
	        }
	    },
	    
	    tooltip: {
	    	enabled: false
	    },
	    
	    legend: {
	    	enabled: false
	    },
	    
	    credits: {
            enabled: false
        },
        
        exporting: {
        	enabled: false
        }
	});
    
    $('#pressureContainer').highcharts(
			{
				series: [{
		            data: [1010]
		        }],

				chart : {
					type : 'gauge',
					plotBackgroundColor : null,
					plotBackgroundImage : null,
					plotBorderWidth : 0,
					plotShadow : false
				},

				title: {
			        text: null
			    },

				pane : {
					startAngle : -150,
					endAngle : 150,
					background : [ {
						backgroundColor : '#AAA',
						borderWidth : 0,
						outerRadius : '105%',
						innerRadius : '103%'
					} ]
				},

				// the value axis
				yAxis : {
					min : 960,
					max : 1060,
					tickInterval : 10,
					minorTickInterval : 1,
					minorTickWidth : 1,
					minorTickLength : 10,
					minorTickPosition : 'inside',
					minorTickColor : '#666',

					tickPixelInterval : 30,
					tickWidth : 2,
					tickPosition : 'inside',
					tickLength : 10,
					tickColor : '#666',
					labels : {
						step : 2,
						rotation : 'auto'
					},
					title : {
						text : 'mBar'
					}
				},
				
				tooltip: {
			    	enabled: false
			    },
				
				legend: {
			    	enabled: false
			    },
				
				credits: {
		            enabled: false
		        },
		        
		        exporting: {
		        	enabled: false
		        }

			});
    
    $('#cloudContainer').highcharts(
			{
				series: [{
		            data: [0],
		            dataLabels: {
			            formatter: function () {
			                return '<span>'+ this.y + '/8</span>';
			            }
		            }
		        }],

				chart : {
					type : 'gauge',
					plotBackgroundColor : null,
					plotBackgroundImage : null,
					plotBorderWidth : 0,
					plotShadow : false
				},

				title: {
			        text: null
			    },

				pane : {
					startAngle : -150,
					endAngle : 150,
					background : [ {
						backgroundColor : '#AAA',
						borderWidth : 0,
						outerRadius : '105%',
						innerRadius : '103%'
					} ]
				},

				// the value axis
				yAxis : {
					min : 0,
					max : 8,
					tickInterval : 1,

					tickPixelInterval : 30,
					tickWidth : 2,
					tickPosition : 'inside',
					tickLength : 10,
					tickColor : '#666',
					labels : {
						step : 1,
						rotation : 'auto',
						formatter: function () {
					        return this.value + '/8';
					    }
					}
				},
				
				tooltip: {
			    	enabled: false
			    },
				
				legend: {
			    	enabled: false
			    },
				
				credits: {
		            enabled: false
		        },
		        
		        exporting: {
		        	enabled: false
		        }

			});
    
    $('#tempContainer').highcharts(
			{
				series: [{
		            data: [20]
		        }],

				chart : {
					type : 'gauge',
					plotBackgroundColor : null,
					plotBackgroundImage : null,
					plotBorderWidth : 0,
					plotShadow : false
				},

				title: {
			        text: null
			    },

				pane : {
					startAngle : -150,
					endAngle : 150,
					background : [ {
						backgroundColor : '#AAA',
						borderWidth : 0,
						outerRadius : '105%',
						innerRadius : '103%'
					} ]
				},

				// the value axis
				yAxis : {
					min : -10,
					max : 40,
					tickInterval : 5,
					minorTickInterval : 1,
					minorTickWidth : 1,
					minorTickLength : 10,
					minorTickPosition : 'inside',
					minorTickColor : '#666',

					tickPixelInterval : 30,
					tickWidth : 2,
					tickPosition : 'inside',
					tickLength : 10,
					tickColor : '#666',
					labels : {
						step : 1,
						rotation : 'auto'
					},
					title : {
						text : 'C'
					}
				},
				
				tooltip: {
			    	enabled: false
			    },
				
				legend: {
			    	enabled: false
			    },
				
				credits: {
		            enabled: false
		        },
		        
		        exporting: {
		        	enabled: false
		        }

			});
    
    

    $('#highcharts-4').click(function(e) {
    	if (weatherChartEditable) {
	        var pos = findPos(this);
	        var x = e.pageX - pos.x;
	        var y = e.pageY - pos.y;
	        var divHeight = $('#highcharts-4').height();
	        var divWidth = $('#highcharts-4').width();
	        
	        var value = getGaugeValue(x, y, divHeight, divWidth, 300, 100, 1010);
	
			setPressure(value);
    	}
    });
    
    $('#highcharts-6').click(function(e) {
    	if (weatherChartEditable) {
	        var pos = findPos(this);
	        var x = e.pageX - pos.x;
	        var y = e.pageY - pos.y;
	        var divHeight = $('#highcharts-6').height();
	        var divWidth = $('#highcharts-6').width();
	        
	        var value = getGaugeValue(x, y, divHeight, divWidth, 300, 8, 4);
	        
	        setClouds(value);
    	}
    });
    
    $('#highcharts-8').click(function(e) {
    	if (weatherChartEditable) {
	        var pos = findPos(this);
	        var x = e.pageX - pos.x;
	        var y = e.pageY - pos.y;
	        var divHeight = $('#highcharts-8').height();
	        var divWidth = $('#highcharts-8').width();
	        
	        var value = getGaugeValue(x, y, divHeight, divWidth, 300, 50, 15);
		    
	        setTemperature(value);
    	}
    });
    
    function findPos(obj) {
        var curleft = 0, curtop = 0;
        if (obj.offsetParent) {
            do {
                curleft += obj.offsetLeft;
                curtop += obj.offsetTop;
            } while (obj = obj.offsetParent);
            return { x: curleft, y: curtop };
        }
        return undefined;
    }
    
    function getGaugeValue(x, y, divHeight, divWidth, degree, steps, middleValue) {
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

function setWindValues(direction, strength, markerID) {
	var date = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
	date[direction] = strength;
	
	$("#windContainer").highcharts().series[0].setData(date);
	
	saveWeatherValue('wind_strength', strength, markerID);
	saveWeatherValue('wind_direction', direction, markerID);
}

function setWaveValues(direction, height, markerID) {
    var date = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    date[direction] = height;
    
    $("#waveContainer").highcharts().series[0].setData(date);
    
    saveWeatherValue('wave_height', height, markerID);
    saveWeatherValue('wave_direction', direction, markerID);
}

function setPressure(value, markerID) {
	var date = [value];
	
	$("#pressureContainer").highcharts().series[0].setData(date);
	
	saveWeatherValue('air_pressure', value, markerID);
}

function setClouds(value, markerID) {
	var tmpValue = Math.round((value * 8) / 100);
	var date = [tmpValue];
    
	$("#cloudContainer").highcharts().series[0].setData(date);
    
	saveWeatherValue('cloudiness', tmpValue, markerID);
}

function setTemperature(value, markerID) {
	tmpValue = Math.round(value);
	
	if (tmpValue > 40) {
		tmpValue = 40;
	} else if (tmpValue < -10) {
		tmpValue = -10;
	}
	var date = [tmpValue];
	
	$("#tempContainer").highcharts().series[0].setData(date);
    
	saveWeatherValue('temperature', tmpValue, markerID);
}
