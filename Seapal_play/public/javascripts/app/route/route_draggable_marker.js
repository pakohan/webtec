var map
var infoWindow
var drag_area
var actual
var obj;
var dummy = 0;
var z_index = 0;

function DummyOView() {
	this.setMap(map);
	this.draw = function() {
	}
}

DummyOView.prototype = new google.maps.OverlayView();

function fillMarker(param) {
	var div = document.createElement("div");
	div.style.backgroundImage = "url(" + param + ")";
	var space;

	if (obj.id == "m1") {
		space = "0px"
	} else if (obj.id == "m2") {
		space = "50px"
	} else if (obj.id == "m3") {
		space = "100px"
	}

	div.style.left = space;
	div.id = obj.id;
	div.className = "drag";
	div.onmousedown = div.ontouchstart = initDrag;
	drag_area.replaceChild(div, obj);

	obj = null
}

function highestOrder() {
	return z_index
}

function createDraggedMarker(positionParam, urlParam) {

	var iconOptions = {
		url : urlParam,
		size : new google.maps.Size(32, 32),
		anchor : new google.maps.Point(15, 32)
	};

	var shadowOptions = {
		url : "http://maps.gstatic.com/mapfiles/kml/paddle/A_maps.shadow.png",
		size : new google.maps.Size(59, 32),
		anchor : new google.maps.Point(15, 32)
	};

	var marker = new google.maps.Marker({
		position : positionParam,
		map : map,
		clickable : true,
		draggable : true,
		optimized : false,
		raiseOnDrag : false,
		icon : iconOptions,
		shadow : shadowOptions,
		zIndex : highestOrder()
	});

	google.maps.event.addListener(marker, "click", function() {
		actual = marker;
		var a = actual.getPosition().lat();
		var b = actual.getPosition().lng();
		infoWindow.setContent(a.toFixed(6) + ", " + b.toFixed(6));
		infoWindow.open(map, this)
	});

	google.maps.event.addListener(marker, "dragstart", function() {
		if (actual == marker)
			infoWindow.close();
		z_index += 1;
		marker.setZIndex(highestOrder())
	})
}

function initDrag(eventParam) {
	var hpFunc = function(param) {
		var b = {};
		if (param && param.touches && param.touches.length) {
			b.x = param.touches[0].clientX;
			b.y = param.touches[0].clientY
		} else {
			if (!param)
				var param = window.event;
			b.x = param.clientX;
			b.y = param.clientY
		}
		return b
	};

	var markerDragFunc = function(param) {
		if (obj && obj.className == "drag") {
			var n = hpFunc(param), s = n.x - o.x, t = n.y - o.y;
			obj.style.left = (obj.x + s) + "px";
			obj.style.top = (obj.y + t) + "px";
			obj.onmouseup = obj.ontouchend = function() {
				var mapDiv = map.getDiv();
				var offLeft = mapDiv.offsetLeft;
				var offTop = mapDiv.offsetTop;
				var offWidth = mapDiv.offsetWidth;
				var offHeight = mapDiv.offsetHeight;
				var areaOffLeft = drag_area.offsetLeft;
				var areaOffTop = drag_area.offsetTop;
				var objOffWidth = obj.offsetWidth;
				var objOffHeight = obj.offsetHeight;
				var objOffsetLeft = obj.offsetLeft + areaOffLeft + objOffWidth
						/ 2;
				var objOffsetTop = obj.offsetTop + areaOffTop + objOffHeight
						/ 2;

				if (objOffsetLeft > offLeft
						&& objOffsetLeft < (offLeft + offWidth)
						&& objOffsetTop > offTop
						&& objOffsetTop < (offTop + offHeight)) {
					var u = 1;
					var w = new google.maps.Point(objOffsetLeft - offLeft - u,
							objOffsetTop - offTop + (objOffHeight / 2));
					var projection = dummy.getProjection();
					var pos = projection.fromContainerPixelToLatLng(w);
					var backimg = obj.style.backgroundImage.slice(4, -1)
							.replace(/"/g, "");
					createDraggedMarker(pos, backimg);
					fillMarker(backimg)
				}
			}
		}
		return false
	};

	if (!eventParam) {
		var eventParam = window.event;
	}

	obj = eventParam.target ? eventParam.target
			: eventParam.srcElement ? eventParam.srcElement
					: eventParam.touches ? eventParam.touches[0].target : null;

	if (obj.className != "drag") {
		if (eventParam.cancelable) {
			eventParam.preventDefault();
		}

		obj = null;
		return

		

	} else {
		z_index += 1;
		obj.style.zIndex = z_index.toString();
		obj.x = obj.offsetLeft;
		obj.y = obj.offsetTop;
		var o = hpFunc(eventParam);

		if (eventParam.type === "touchstart") {
			obj.onmousedown = null;
			obj.ontouchmove = markerDragFunc;

			obj.ontouchend = function() {
				obj.ontouchmove = null;
				obj.ontouchend = null;
				obj.ontouchstart = initDrag
			}

		} else {
			document.onmousemove = markerDragFunc;
			document.onmouseup = function() {
				document.onmousemove = null;
				document.onmouseup = null;
				if (obj)
					obj = null
			}
		}
	}
	return false;
}

function buildDraggable() {

	infoWindow = new google.maps.InfoWindow();

	google.maps.event.addListener(map, "click", function() {
		if (infoWindow)
			infoWindow.close()
	});

	drag_area = document.getElementById("markers");
	var markerDivs = drag_area.getElementsByTagName("div");

	for ( var i = 0; i < markerDivs.length; i++) {
		var div = markerDivs[i];
		div.onmousedown = div.ontouchstart = initDrag
	}

	dummy = new DummyOView()
}
