<?php
$config = json_decode(file_get_contents('../config/mysql.json'),true);

$con = mysql_connect("127.0.0.1",$config['username'],$config['password']);

if (!$con) {
  die('Could not connect: ' . mysql_error().mysql_errno());
}

if (!mysql_query("CREATE DATABASE seapal", $con) && mysql_errno() != 1007) {
  die('Could not create database: ' . mysql_error());
}

$table = "CREATE TABLE seapal.`f_weather` (";
$table.= "  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,";
$table.= "  `wind_strength` tinyint(10) unsigned DEFAULT NULL,";
$table.= "  `wind_direction` smallint(11) DEFAULT NULL,";
$table.= "  `air_pressure` smallint(11) DEFAULT NULL,";
$table.= "  `cloudiness` tinyint(11) DEFAULT NULL,";
$table.= "  `raininess` tinyint(11) DEFAULT NULL,";
$table.= "  `wave_height` varchar(20) DEFAULT NULL,";
$table.= "  `wave_direction` smallint(11) DEFAULT NULL,";
$table.= "  `date_measured` date DEFAULT NULL,";
$table.= "  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,";
$table.= "  PRIMARY KEY (`id`)";
$table.= ") ENGINE=InnoDB DEFAULT CHARSET=utf8";

if (!mysql_query($table,$con) && mysql_errno() != 1050)
{
  die('Could not create table: ' . mysql_error());
}
mysql_close($con);
?>