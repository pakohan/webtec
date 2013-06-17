$(function() {

	registerBoatFields('#bootname');
	registerBoatFields('#typ');
	registerBoatFields('#baujahr');
	registerBoatFields('#registernummer');
	registerBoatFields('#konstrukteur');
	registerBoatFields('#motor');
	registerBoatFields('#segelzeichen');
	registerBoatFields('#laenge');
	registerBoatFields('#tankgroesse');
	registerBoatFields('#heimathafen');
	registerBoatFields('#breite');
	registerBoatFields('#wassertankgroesse');
	registerBoatFields('#yachtclub');
	registerBoatFields('#tiefgang');
	registerBoatFields('#abwassertankgroesse');
	registerBoatFields('#eigner');
	registerBoatFields('#masthoehe');
	registerBoatFields('#grosssegelgroesse');
	registerBoatFields('#versicherung');
	registerBoatFields('#verdraengung');
	registerBoatFields('#genuagroesse');
	registerBoatFields('#rufzeichen');
	registerBoatFields('#rigart');
	registerBoatFields('#spigroesse');

});

function registerBoatFields(id) {

	$(id).change(function() {
		var value = $(this).val();
		alert(id + " " + value);
		// saveValue(id, value);
	});

}

