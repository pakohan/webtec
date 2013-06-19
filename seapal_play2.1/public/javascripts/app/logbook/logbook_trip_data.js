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
	registerBoatFields('#titel');
	registerBoatFields('#von');
	registerBoatFields('#nach');
	registerBoatFields('#tstart');
	registerBoatFields('#tende');
	registerBoatFields('#tdauer');
	registerBoatFields('#skipper');
	registerBoatFields('#crew');
	registerBoatFields('#motor');
	registerBoatFields('#tank');
	
	//prevent weather charts from being edited manually without a marker being clicked before
	weatherChartEditable = false;

});

function registerBoatFields(id) {

	$(id).change(function() {
		var value = $(this).val();
		
		if (id !== "#tank") {
			saveValue(id, value);
		} else {
			var checked = $(this)[0].checked;
			saveValue(id, checked);
		}
	});

}


