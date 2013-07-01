//fade-in menu for route selection
$(function() {
    $('#load_route').click(function(){
        $('#overlay_route').fadeIn('fast',function(){
            $('#box_route').animate({'top':'160px'},500);
        });
    });
    $('#boxclose_route').click(function(){
    	$('#box_route').animate({'top':'-1000px'},500,function(){
            $('#overlay_route').fadeOut('fast');
        });
    });
    $('a.view').click(function(){
        $('#box_route').animate({'top':'-1000px'},500,function(){
            $('#overlay_route').fadeOut('fast');
        });
    });
    $('a.remove').click(function(){
        $('#box_route').animate({'top':'-1000px'},500,function(){
            $('#overlay_route').fadeOut('fast');
        });
    });
 
});