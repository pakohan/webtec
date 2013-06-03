<?php
	$action = $_POST['action'];
	$field = $_POST['field'];
	$value = $_POST['value'];
	$change_value = 2;

	switch($action) {
		case('send'):
			switch($field) {
				case '#wind_strength':
					// get predicted value for wave height from database.
					$change_value = $value / 2;
					// store ind_strength in database.
					break;
				case '#wind_direction':
					// get predicted value for wave direction from database.
					$change_value = $value;
					// store value in database.
				    break;
				case '#air_pressure':
					// store value in database.
					break;
				case '#cloudiness':
					// store value in database.
					break;
				case '#raininess':
					// store value in database.
					break;
                case '#wave_height':
                	// calculate new wave height value for wind strength and
                	// store value in database.
                	break;
                case '#wave_direction':
                	// calculate new wave direction value for wind strength and
                	// store value in database.
                	break;
                case '#date_measured':
                	// store value in database.
                	break;
			}
			
			break;
	}
	$result = array('field' => $field, 'value' => $change_value);
	echo json_encode($result);
?>