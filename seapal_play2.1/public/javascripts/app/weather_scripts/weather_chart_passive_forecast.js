//normal wind rose and wave wind rose
$(function () {
	
	//wind rose
	$('#windContainer').highcharts({
        series: [{
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        }],
	    
	    chart: {
	        polar: true,
	        type: 'column'
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
    
	//wave wind rose
    $('#waveContainer').highcharts({
        series: [{
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        }],
	    
	    chart: {
	        polar: true,
	        type: 'column'
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

    //forecast buttons
	$("#btnAkt").click(function() {
    	fillInData(currentWeather[0]);
    });
    
	$("#btn3h").click(function() {
		fillInData(weatherForecast[0]);
	});
	
	$("#btn6h").click(function() {
		fillInData(weatherForecast[1]);
	});
	
	$("#btn1D").click(function() {
		fillInData(weatherForecast[2]);
	});
	
	$("#btn2D").click(function() {
		fillInData(weatherForecast[3]);
	});
	
	$("#btn5D").click(function() {
		fillInData(weatherForecast[4]);
	});
	
	//initialise basic charts (pressure, clouds, temperature)
	init_basic_charts();
});

//set and store wind strength and direction
function setWindValues(direction, strength) {
	var date = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];
	date[direction] = strength;

	$("#windContainer").highcharts().series[0].setData(date);
}

//set wave and store height and direction
function setWaveValues(direction, height) {
	var date = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];
	date[direction] = height;

	$("#waveContainer").highcharts().series[0].setData(date);
}

//set and store air pressure
function setPressure(value) {
	var date = [ value ];

	$("#pressureContainer").highcharts().series[0].setData(date);
}

//set and store clouds
function setClouds(value) {

	if (value < 0) {
		value = 0;
	} else if (value > 8) {
		value = 8;
	}
	var date = [ value ];

	$("#cloudContainer").highcharts().series[0].setData(date);
}

//set and store temperature
function setTemperature(value) {
	tmpValue = Math.round(value);

	if (tmpValue > 40) {
		tmpValue = 40;
	} else if (tmpValue < -10) {
		tmpValue = -10;
	}
	var date = [ tmpValue ];

	$("#tempContainer").highcharts().series[0].setData(date);
}