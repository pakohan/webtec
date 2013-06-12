$(document).ready(function(){
  $("input").focus(function(){
    $(this).css("background-color","#dddddd");
  });
  $("input").blur(function(){
    $(this).css("background-color","#ffffff");
  });
});