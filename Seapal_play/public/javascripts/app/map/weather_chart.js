$(function () {

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
    
    $('#pressureContainer')
	.highcharts(
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
});
