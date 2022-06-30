
function current_position(position) {
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude),
		level: 2
	};
	var map = new kakao.maps.Map(container, options);
	return map;
}
var map = window.navigator.geolocation.getCurrentPosition(current_position);
