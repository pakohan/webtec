<!DOCTYPE html>
<html lang="de">
    <head>
        <?php include("header.php") ?>
    <script>
     $('.datepicker').datepicker();
    </script>
    </head>
    <body>
        <?php include("navigation.php") ?><!-- Container -->
        <div class="container">
            <!-- Content -->
            <div>
                <br>
                <h2>
                    Wegpunkt
                </h2><br>
                <div>
                    <form>
                        <div class="row">
                            <div class="span6 well">
                                <div class="row">
                                    <label class="span3">Name</label> <input type="text" id="name" class="span3">
                                </div>
                                <div class="row">
                                    <label class="span3">Time</label> <input type="date" id="wdate" class="span3">
                                </div>
                                <div class="row">
                                    <label class="span3">Date</label> <input type="text" class="span3 input-append date datepicker" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
                                </div>
                                <div class="row">
                                    <label class="span3">Latitude</label> <input type="text" id="lat" class="span3">
                                </div>
                                <div class="row">
                                    <label class="span3">Longitude</label> <input type="text" id="lng" class="span3">
                                </div>
                                <div class="row">
                                    <label class="span3">Fahrt nach</label> <select name="fahrtziel" id="marker" class="span3">
                                        </select>
                                </div>
                                <div class="row">
                                    <label class="span3">COG</label> <input type="text" id="cog" class="span3">
                                </div>
                                <div class="row">
                                    <label class="span3">SOG</label> <input type="text" id="sog" class="span3">
                                </div>
                                <div class="row">
                                    <label class="span3">Manoever</label> <select name="manoever" id="manoever" class="span3">
                                        </select>
                                </div>
                                <div class="row">
                                    <label class="span3">BTM</label> <input type="text" id="btm" class="span3">
                                </div>
                                <div class="row">
                                    <label class="span3">DTM</label> <input type="text" id="dtm" class="span3">
                                </div>
                                <div class="row">
                                    <label class="span3">Vorsegel</label> <select name="vorsegel" id="vorsegel" class="span3">
                                        </select>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <h2>
                    Weather
                </h2>
                <?php
                  //TODO validate form, SQL injection!!!
                  if ($_POST['wind_strength'] != NULL) {
                    $con = mysql_connect("localhost","server","server");
                    if (!$con) {
                      die('Could not connect: ' . mysql_error());
                    }
                    mysql_select_db("seapal", $con);
                    $sql = "INSERT INTO seapal.f_weather (wind_strength,wind_direction,air_pressure,cloudiness,raininess,wave_height,wave_direction,date_measured) VALUES (".$_POST['wind_strength'].",".$_POST['wind_direction'].",".$_POST['air_pressure'].",".$_POST['cloudiness'].",".$_POST['raininess'].",'".$_POST['wave_height']."',".$_POST['wave_direction'].",'".$_POST['date_measured']."')";
                    if (!mysql_query($sql,$con))
                    {
                      die('Error: ' . mysql_error());
                    }
                    mysql_close($con);
                  }
                ?>
                <form>
                    <fieldset>
                        <div>
                            <div>
                                <div>
                                    <label>Wind strength</label> <select name="windStrength">
                                        <option value="0" selected="selected">
                                            0
                                        </option>
                                        <option value="1">
                                            1
                                        </option>
                                        <option value="2">
                                            2
                                        </option>
                                        <option value="3">
                                            3
                                        </option>
                                        <option value="4">
                                            4
                                        </option>
                                        <option value="5">
                                            5
                                        </option>
                                        <option value="6">
                                            6
                                        </option>
                                        <option value="7">
                                            7
                                        </option>
                                        <option value="8">
                                            8
                                        </option>
                                        <option value="9">
                                            9
                                        </option>
                                        <option value="10">
                                            10
                                        </option>
                                        <option value="11">
                                            11
                                        </option>
                                        <option value="12">
                                            12
                                        </option>
                                    </select>
                                </div>
                                <div>
                                    <label>Wind direction</label> <input type="number" name="windDirection" pattern="\d[\d][\d]" min="0" max="359" value="0">
                                </div>
                                <div>
                                    <label>Air pressure (mBar)</label> <input type="number" name="airPressure" pattern="\d\d\d[\d]" min="500" max="2000" value="1000">
                                </div>
                                <div>
                                    <label>Cloudiness level</label> <select name="cloudiness">
                                        <option value="0" selected="selected">
                                            0
                                        </option>
                                        <option value="1">
                                            1
                                        </option>
                                        <option value="2">
                                            2
                                        </option>
                                        <option value="3">
                                            3
                                        </option>
                                        <option value="4">
                                            4
                                        </option>
                                        <option value="5">
                                            5
                                        </option>
                                        <option value="6">
                                            6
                                        </option>
                                        <option value="7">
                                            7
                                        </option><!--option value="8">8</option>
                      <option value="9">9</option>
                      <option value="10">10</option>
                      <option value="11">11</option>
                      <option value="12">12</option-->
                                    </select>
                                </div>
                                <div>
                                    <label>Raininess level</label> <select name="raininess">
                                        <option value="0" selected="selected">
                                            0
                                        </option>
                                        <option value="1">
                                            1
                                        </option>
                                        <option value="2">
                                            2
                                        </option>
                                        <option value="3">
                                            3
                                        </option>
                                        <option value="4">
                                            4
                                        </option>
                                        <option value="5">
                                            5
                                        </option>
                                        <option value="6">
                                            6
                                        </option>
                                        <option value="7">
                                            7
                                        </option><!--option value="8">8</option>
                      <option value="9">9</option>
                      <option value="10">10</option>
                      <option value="11">11</option>
                      <option value="12">12</option-->
                                    </select>
                                </div>
                                <div>
                                    <label>wave height</label> <input type="text" name="waveHeight">
                                </div>
                                <div>
                                    <label>wave direction</label> <input type="number" name="waveDirection" pattern="\d[\d][\d]" min="0" max="359" value="0">
                                </div>
                                <div>
                                    <label>date of recognition</label> <input type="datetime" name="date">
                                </div>
                            </div>
                        </div><input type="submit" class="btn btn-primary">
                    </fieldset>
                </form>
            </div><br>
            <br>
            <div>
                <div>
                    <div id="appNotes">
                        <h4>
                            Notes
                        </h4>
                        <textarea></textarea>
                    </div>
                    <div id="markerMap">
                        <h4>
                            Map
                        </h4><img src="../img/icons/marker_map.png" id="appInfoPhoto" class="logo">
                    </div>
                    <div id="appPhotos">
                        <h4>
                            Photos
                        </h4><img src="../img/icons/no_image.jpg" id="appInfoPhoto2" class="logo">
                    </div>
                </div>
            </div>
        </div><!-- Content -->
        <!-- Container -->
    </body>
</html>


