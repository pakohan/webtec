<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />

<script type="text/javascript"
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAHIxeGbEooUwevpiSVE2TtZgY2dzQ0Kgs&sensor=false">
</script>
<script type="text/javascript">
    function initialiseMap() {
                
        var mapOptions = {
            center: new google.maps.LatLng(47.66, 9.16),
            zoom: 5,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
            
        map = new google.maps.Map(document.getElementById("map_canvas"),
            mapOptions);
             
        google.maps.event.addListener(map, 'center_changed', function() {
            document.getElementById("lat").firstChild.nodeValue=map.getCenter().lat();
            document.getElementById("long").firstChild.nodeValue=map.getCenter().lng();
        })
    }
</script>