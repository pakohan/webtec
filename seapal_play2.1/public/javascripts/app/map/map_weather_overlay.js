$(function() {

    var OVERLAY = {
        WIND : {name: "wind_vector", number: 2},
        PRESSURE : {name: "surface_pressure", number: 3},
        WAVE_HEIGHT : {name: "significant_wave_height", number: 4},
        TEMPERATURE : {name: "air_temperature", number: 5},
        RAIN : {name: "precipitation", number: 6}
    };
    
    //sailor overlays (wind, pressure, wave height)
    $('#sailor_mode').click(function () {

        $('#checkbox_form').hide();
        removeAllOverlays();
        addSeamarkOverlay();

        addMapOverlay(OVERLAY.WIND.name, OVERLAY.WIND.number);
        addMapOverlay(OVERLAY.PRESSURE.name, OVERLAY.PRESSURE.number);
        addMapOverlay(OVERLAY.WAVE_HEIGHT.name, OVERLAY.WAVE_HEIGHT.number);
    });

    //tourist overlays (temperature, rain)
    $('#tourist_mode').click(function () {
                    
        $('#checkbox_form').hide();
        removeAllOverlays();
        addSeamarkOverlay();

        addMapOverlay(OVERLAY.TEMPERATURE.name, OVERLAY.TEMPERATURE.number);
        addMapOverlay(OVERLAY.RAIN.name, OVERLAY.RAIN.number);
    });

    //expert mode (all overlays possible)
    $('#expert_mode').click(function () {
        
        $('#exp_mode_chkbx_Wind').prop('checked', false);
        $('#exp_mode_chkbx_Pressure').prop('checked', false);
        $('#exp_mode_chkbx_Waves').prop('checked', false);
        $('#exp_mode_chkbx_Temperature').prop('checked', false);
        $('#exp_mode_chkbx_Rain').prop('checked', false);
        $('#checkbox_form').show();
        removeAllOverlays();
        addSeamarkOverlay();
                   
    });

    registerCheckboxes('#exp_mode_chkbx_Wind', OVERLAY.WIND);
    registerCheckboxes('#exp_mode_chkbx_Pressure', OVERLAY.PRESSURE);
    registerCheckboxes('#exp_mode_chkbx_Waves', OVERLAY.WAVE_HEIGHT);
    registerCheckboxes('#exp_mode_chkbx_Temperature', OVERLAY.TEMPERATURE);
    registerCheckboxes('#exp_mode_chkbx_Rain', OVERLAY.RAIN);

    $('#checkbox_form').hide();

    registerCheckboxes('#exp_mode_chkbx_Wind', OVERLAY.WIND);
});

//register checkboxes to load specific overlays if checked
function registerCheckboxes(id, overlay) {
    $(id).change(function () {
        if ($(this).is(':checked')) {
            addMapOverlay(overlay.name, overlay.number);
        } else {
            removeMapOverlay(overlay.number);
        }
    });
}

//add specific overlay
function addMapOverlay(name, number) {
                
    map.overlayMapTypes.setAt(number, new google.maps.ImageMapType({
        getTileUrl: function (coord, zoom) {
            return "http://www.openportguide.org/tiles/actual/" + name + "/5/" + zoom + "/" +
                coord.x + "/" + coord.y + ".png";
        },
        tileSize: new google.maps.Size(256, 256),
        name: "OpenSeaMap",
        maxZoom: 18
    }));
}

//add standard seamark overlay
function addSeamarkOverlay() {
    map.overlayMapTypes.setAt(1, new google.maps.ImageMapType({
        getTileUrl: function(coord, zoom) {
            return "http://tiles.openseamap.org/seamark/" + zoom + "/" + coord.x + "/" +
                coord.y + ".png";
        },
        tileSize: new google.maps.Size(256, 256),
        name: "OpenSeaMap",
        maxZoom: 18
    }));
}

//remove specific overlay
function removeMapOverlay(number) {
    map.overlayMapTypes.setAt(number, null);
}

//remove all overlays
function removeAllOverlays() {
    map.overlayMapTypes.clear();
}