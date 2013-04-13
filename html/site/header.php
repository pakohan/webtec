	<!-- Meta Informations -->
	<meta charset="utf-8">
	<meta http-equiv='content-type' content='text/html; charset=utf-8'/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name='keywords' content='sailing, app, navigation, sea map, boat, skipper'/>
	<meta name='description' content='SeaPal is a mobile app for sailors to do navigation, tracking and more.'/>
	<meta name="author" content="Prof. Dr. Marko Boger, Dominic Eschbach und Timo Partl">
	<title>Seapal</title>
    <?php
        $config = file_get_contents('../../config/style.txt');
        $template = "<link rel='stylesheet' href='../css/".$config.".css'/>";
        echo $template;
    ?>
    <script src="../js/jquery-1.9.1.min.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script src="../js/bootstrap-datepicker.js"></script>
    <style type="text/css">
      #picture {
        border-radius: 3px 3px 3px 3px;
        -moz-border-radius: 3px 3px 3px 3px;
        -webkit-border-radius: 3px 3px 3px 3px;
        border: 0px solid #000000;
        -webkit-box-shadow: 0px 0px 15px -2px rgba(0,0,0,1);
        -moz-box-shadow: 0px 0px 15px -2px rgba(0,0,0,1);
        box-shadow: 0px 0px 15px -2px rgba(0,0,0,1);
        margin-right: 14px;
        margin-left: 14px;
      }
      li {
        margin-top: 15px;
      }
    </style>
