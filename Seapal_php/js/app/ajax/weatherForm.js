$(function() {

    registerWeatherFields('#wind_strength');
    registerWeatherFields('#wind_direction');
    registerWeatherFields('#air_pressure');
    registerWeatherFields('#cloudiness');
    registerWeatherFields('#raininess');
    registerWeatherFields('#wave_height');
    registerWeatherFields('#wave_direction');
    registerWeatherFields('#date_measured');

});

function registerWeatherFields(id) {
    $(id).keyup(function(e) {
        if (e.keyCode == 13) { //Enter is pressed
            var value = $(this).val();
            // send
            sendValue(id, value);
        }
    });
}

function sendValue(field, value) {
    $.ajax({
        type: "POST",
        url: "../../../server/storeValues.php",
        data: { 
            'action': 'send',
            'field': field,
            'value': value
        },
        dataType: "json",
        success: function(data){
            if (data.field == '#wind_strength') {
                $('#wave_height').val(data.value);
            } else if (data.field == '#wind_direction') {
                $('#wave_direction').val(data.value);
            }
        },
    });
}