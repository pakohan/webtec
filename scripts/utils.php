<?php
function insert_weather() {
  $config = json_decode(file_get_contents('../config/mysql.json'),true);
  if ($_POST['wind_strength'] != NULL) {
    $con = mysql_connect("localhost",$config['username'],$config['password']);
    if (!$con) {
      die('Could not connect: ' . mysql_error());
    }
    mysql_select_db("seapal", $con);
    $sql = "INSERT INTO seapal.f_weather (wind_strength,wind_direction,air_pressure,cloudiness,raininess,wave_height,wave_direction,date_measured)";
    $sql.= " VALUES (".$_POST['wind_strength'].",".$_POST['wind_direction'].",".$_POST['air_pressure'].",".$_POST['cloudiness'].",".$_POST['raininess'];
    $sql.= ",'".$_POST['wave_height']."',".$_POST['wave_direction'].",'".$_POST['date_measured']."')";
    echo $sql;
    if (!mysql_query($sql,$con))
    {
      die('Error: ' . mysql_error());
    }
    mysql_close($con);
  }
}
?>