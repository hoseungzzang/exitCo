
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

			var positions = [];
			for (var i = 0; i < data.length; i++) {
				var obj = {};

				obj.title = data[i][0];
				obj.latlng = new kakao.maps.LatLng(data[i][1], data[i][2]);

				positions[i] = obj;
			}

			var map = new kakao.maps.Map(container, options);
			var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";


			for (var i = 0; i < data.length; i++) {
				// 마커 이미지의 이미지 크기 입니다
				var imageSize = new kakao.maps.Size(24, 35);

				// 마커 이미지를 생성합니다    
				var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

				// 마커를 생성합니다
				var marker = new kakao.maps.Marker({
					position: positions[i].latlng,// 마커를 표시할 위치
					clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다

				});
				marker.setMap(map);
				// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
				var content = '<div class="wrap">' +
					'    <div class="info">' +
					'        <div class="title">' +
					'            카카오 스페이스닷원' +
					'            <div class="close" onclick="closeOverlay()" title="닫기"></div>' +
					'        </div>' +
					'        <div class="body">' +
					'            <div class="desc">' +
					'                <div class="ellipsis">제주특별자치도 제주시 첨단로 242</div>' +
					'                <div class="jibun ellipsis">(우) 63309 (지번) 영평동 2181</div>' +
					'                <div><a href="https://www.kakaocorp.com/main" target="_blank" class="link">홈페이지</a></div>' +
					'            </div>' +
					'        </div>' +
					'    </div>' +
					'</div>';
				// 마커 위에 커스텀오버레이를 표시합니다
				// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
				var overlay = new kakao.maps.CustomOverlay({
					content: content,
					map: map,
					position: marker.getPosition()
				});
				kakao.maps.event.addListener(marker, 'click', function() {
					overlay.setMap(map);
				});
			}
	
			function closeOverlay() {

				overlay.setMap(null);

			}

		}

	})


}





