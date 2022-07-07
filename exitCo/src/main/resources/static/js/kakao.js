
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
				var map = new kakao.maps.Map(container, options);
				var positions=[];
				
			for (var i = 0; i < data.length; i++) {
				var obj={};
			
			obj.title = data[i][0];
			obj.latlng = new kakao.maps.LatLng( data[i][1],  data[i][2]);
			
				positions[i] = obj;
			}
			console.log(positions.length);

			
			var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

			
for (var i = 0; i < data.length; i++) {
				// 마커 이미지의 이미지 크기 입니다
				var imageSize = new kakao.maps.Size(24, 35);

				// 마커 이미지를 생성합니다    
				var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({
					map: map, // 마커를 표시할 지도
					position: positions[i].latlng,// 마커를 표시할 위치
					title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
					image: markerImage // 마커 이미지 
				});
			}
		}
	})

}
