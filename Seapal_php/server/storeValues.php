<?php
	$action = $_POST['action'];
	$field = $_POST['field'];
	$value = $_POST['value'];
	$change_value;

	switch($action) {
		case('send'):
			switch($field) {
				case '#wind_strength':
					// get predicted value for wave height from database. 0.5 is a dummy.
					$valueFromDatabase = 0.5;
					$change_value = $valueFromDatabase;
					// store wind_strength in database.
					break;
				case '#wind_direction':
					// get predicted value for wave direction from database. 275 is a dummy.
					$valueFromDatabase = 275;
					$change_value = $valueFromDatabase;
					// store wind_direction in database.
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
                	// get number of values from database. 5 is a dummy.
                	$numberOfValuesFromDatabase = 5;
                	// get value from database. 3 is a dummy.
                	$valueFromDatabase = 3;
                	// calculate new wave direction value for wind strength.
                	$valueToDatabase = ($value + $valueFromDatabase) / ($numberOfValuesFromDatabase + 1);
                	// store $valueToDatabase in database.
                	break;
                case '#wave_direction':
                	// get number of values from database. 5 is a dummy.
                	$numberOfValuesFromDatabase = 5;
                	// get value from database. 3 is a dummy.
                	$valueFromDatabase = 3;
                	// calculate new wave direction value for wind strength.
                	$valueToDatabase = ($value + $valueFromDatabase) / ($numberOfValuesFromDatabase + 1);
                	// store $valueToDatabase in database.
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