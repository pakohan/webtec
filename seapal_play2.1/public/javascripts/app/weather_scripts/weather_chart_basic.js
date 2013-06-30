$(function() {

	$('#pressureContainer').highcharts({
		series : [ {
			data : [ 1010 ]
		} ],

		chart : {
			type : 'gauge',
			plotBackgroundColor : null,
			plotBackgroundImage : null,
			plotBorderWidth : 0,
			plotShadow : false
		},

		title : {
			text : null
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

	$('#cloudContainer').highcharts({
		series : [ {
			data : [ 0 ],
			dataLabels : {
				formatter : function() {
					return '<span>' + this.y + '/8</span>';
				}
			}
		} ],

		chart : {
			type : 'gauge',
			plotBackgroundColor : null,
			plotBackgroundImage : null,
			plotBorderWidth : 0,
			plotShadow : false
		},

		title : {
			text : null
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
			minorTickWidth : 0,
			minorTickLength : 0,

			tickPixelInterval : 30,
			tickWidth : 2,
			tickPosition : 'inside',
			tickLength : 10,
			tickColor : '#666',
			labels : {
				step : 1,
				rotation : 'auto',
				formatter : function() {
					return this.value + '/8';
				}
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

	$('#tempContainer').highcharts({
		series : [ {
			data : [ 20 ]
		} ],

		chart : {
			type : 'gauge',
			plotBackgroundColor : null,
			plotBackgroundImage : null,
			plotBorderWidth : 0,
			plotShadow : false
		},

		title : {
			text : null
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
});
