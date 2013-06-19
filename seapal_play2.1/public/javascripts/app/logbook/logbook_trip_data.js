$(function() {

	registerTripFields('bootname');
	registerTripFields('typ');
	registerTripFields('baujahr');
	registerTripFields('registernummer');
	registerTripFields('konstrukteur');
	registerTripFields('motor');
	registerTripFields('segelzeichen');
	registerTripFields('laenge');
	registerTripFields('tankgroesse');
	registerTripFields('heimathafen');
	registerTripFields('breite');
	registerTripFields('wassertankgroesse');
	registerTripFields('yachtclub');
	registerTripFields('tiefgang');
	registerTripFields('abwassertankgroesse');
	registerTripFields('eigner');
	registerTripFields('masthoehe');
	registerTripFields('grosssegelgroesse');
	registerTripFields('versicherung');
	registerTripFields('verdraengung');
	registerTripFields('genuagroesse');
	registerTripFields('rufzeichen');
	registerTripFields('rigart');
	registerTripFields('spigroesse');
	registerTripFields('titel');
	registerTripFields('von');
	registerTripFields('nach');
	registerTripFields('tstart');
	registerTripFields('tende');
	registerTripFields('tdauer');
	registerTripFields('skipper');
	registerTripFields('crew');
	registerTripFields('motor');
	registerTripFields('tank');
	
	//prevent weather charts from being edited manually without a marker being clicked before
	weatherChartEditable = false;

});

function registerTripFields(id) {

	$('#' + id).change(function() {
		var value = $(this).val();
		
		if (id !== "tank") {
			saveTripValue(id, value);
		} else {
			var checked = $(this)[0].checked;
			saveTripValue(id, checked);
		}
	});

}


