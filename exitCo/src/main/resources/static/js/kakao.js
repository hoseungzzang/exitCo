

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
				var iwContent = '<div style="padding:5px;">' + positions[i].title + '</div><br><a href="">커뮤니티 이동</a>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
					iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
				// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
				// 이벤트 리스너로는 클로저를 만들어 등록합니다 
				// for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
				var infowindow = new kakao.maps.InfoWindow({
					content: iwContent,
					removable: iwRemoveable
				});
				kakao.maps.event.addListener(marker, 'click', makeOverListener(map, marker, infowindow));
			}

			// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
			function makeOverListener(map, marker, infowindow) {
				return function() {
					infowindow.open(map, marker);
				};
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

