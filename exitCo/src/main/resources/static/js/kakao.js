window.onload = function() {
	window.navigator.geolocation.getCurrentPosition(current_position);

};
function current_position(position) {
	var container = document.getElementById('map');
	var options = {
		center: new kakao.maps.LatLng(position.coords.latitude, position.coords.longitude),
		level: 2
	}

	var data = {
	 longitude : position.coords.longitude,
	 latitude : position.coords.latitude
	}
	

	$.ajax({
		type: "POST",
		url: "/mainApi/sidoSelect",
		data: JSON.stringify(data), //http body데이터
		contentType: "application/json; charset=utf-8", //데이터 타입 명시
		dataType: "json", // 응답이 왔을때의 데이터타입을 자바스크립트 오브젝트로 변환해준다.
		success: function(data) { 
		console.log(data);

	}

	})
	

	var map = new kakao.maps.Map(container, options);

}

