function validate() {
	var re = new RegExp("\b\d\d°\d\d\.\d\d'[N|S|W|O][\d]{1,3}°\d\d\.\d\d'[N|S|W|O]\b", "i");
	re.exec(document.Formular.koordinaten.value);
	if (re != true) {
		alert("Falsche Eingabe!");
	}
	alert("Bla");
}