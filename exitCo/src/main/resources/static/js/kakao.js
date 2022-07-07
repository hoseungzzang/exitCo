var positions = [];
var marker = [];
var overlay = [];
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
		longitude: position.coords.longitude,
		latitude: position.coords.latitude
	}


	$.ajax({
		type: "POST",
		url: "/mainApi/sidoSelect",
		data: JSON.stringify(data), //http body데이터
		contentType: "application/json; charset=utf-8", //데이터 타입 명시
		dataType: "json", // 응답이 왔을때의 데이터타입을 자바스크립트 오브젝트로 변환해준다.
		success: function(data) {
			window.positions = [];
			for (var i = 0; i < data.length; i++) {
				var obj = {};

				obj.title = data[i][0];
				obj.latlng = new kakao.maps.LatLng(data[i][1], data[i][2]);

				window.positions[i] = obj;
			}

			var map = new kakao.maps.Map(container, options);
			var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";


			for (var i = 0; i < data.length; i++) {
				// 마커 이미지의 이미지 크기 입니다
				var imageSize = new kakao.maps.Size(24, 35);

				// 마커 이미지를 생성합니다    
				var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

				// 마커를 생성합니다
				window.marker[i] = new kakao.maps.Marker({
					position: window.positions[i].latlng,// 마커를 표시할 위치
				});
				marker[i].setMap(map);

				
			}



		}
	})

}


/*
var iwContent = '<div style="padding:8px;">'+positions[i].title
				+' <br><a href="https://map.kakao.com/link/map/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">커뮤니티 조회</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
					iwPosition = positions[i].latlng; //인포윈도우 표시 위치입니다
				// 인포윈도우를 생성합니다
				var infowindow = new kakao.maps.InfoWindow({
					position: iwPosition,
					content: iwContent
				});
				// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
				infowindow.open(map, marker);*/

