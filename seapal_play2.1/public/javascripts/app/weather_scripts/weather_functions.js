//convert meter per second to beaufort
function msToBeauf(ms) {
	
	return Math.round(Math.pow((ms / 0.8360), (2/3)));

}

//calculate wave height
function calculateWaveHeight(strength) {

	return Math.round(strength / 2);

}

//convert normal date and time to unix time
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

//convert degree to direction of wind rose
function degToDirection(degree) {
	if (degree >= 348.75 || degree < 11.25) {
		return 0;
	} else {
		return Math.round((degree / 360) * 16);
	}
}
