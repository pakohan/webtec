$(function() {
    $('#load_trip').click(function(){
        $('#overlay_trip_info').fadeIn('fast',function(){
            $('#box_trip_info').animate({'top':'160px'},500);
        });
    });
    $('#boxclose_trip_info').click(function(){
        $('#box_trip_info').animate({'top':'-1000px'},500,function(){
            $('#overlay_trip_info').fadeOut('fast');
        });
    });
    $('a.view').click(function(){
        $('#box_trip_info').animate({'top':'-1000px'},500,function(){
            $('#overlay_trip_info').fadeOut('fast');
        });
    });
    $('a.remove').click(function(){
        $('#box_trip_info').animate({'top':'-1000px'},500,function(){
            $('#overlay_trip_info').fadeOut('fast');
        });
    });
 
});