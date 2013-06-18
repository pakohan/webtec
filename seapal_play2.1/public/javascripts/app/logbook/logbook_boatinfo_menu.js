$(function() {
    $('#load_boat_info').click(function(){
        $('#overlay_boat_info').fadeIn('fast',function(){
            $('#box_boat_info').animate({'top':'160px'},500);
        });
    });
    $('#boxclose_boat_info').click(function(){
        $('#box_boat_info').animate({'top':'-1000px'},500,function(){
            $('#overlay_boat_info').fadeOut('fast');
        });
    });
    $('a.view').click(function(){
        $('#box_boat_info').animate({'top':'-1000px'},500,function(){
            $('#overlay_boat_info').fadeOut('fast');
        });
    });
    $('a.remove').click(function(){
        $('#box_boat_info').animate({'top':'-1000px'},500,function(){
            $('#overlay_boat_info').fadeOut('fast');
        });
    });
 
});