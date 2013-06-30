function msToBeauf(ms) {
	
	return Math.round(Math.pow((ms / 0.8360), (2/3)));

}

function calculateWaveHeight(strength) {

	return Math.round(strength / 2);

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
