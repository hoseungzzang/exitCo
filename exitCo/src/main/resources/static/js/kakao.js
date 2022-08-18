let positions = new Array();
let overlays = new Array();
let markers = new Array();
let map;
let lat = 1;
let lon;
let cnt;
var clickedOverlay = null;
var url;
// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
if (navigator.geolocation) {
	// GeoLocation을 이용해서 접속 위치를 얻어옵니다
	navigator.geolocation.getCurrentPosition(function(position) {
		lat = position.coords.latitude; // 위도
		lon = position.coords.longitude; // 경도
		selectPosition(lat, lon).then(function(cnt) {
			for (let i = 0; i < cnt; i++) {
				createMarker(i);
			}

		})
	})
}

function selectPosition(lat, lon) {
	return new Promise(function(resolve) {
		setTimeout(function() {
			var container = document.getElementById('map');
			var options = {
				center: new kakao.maps.LatLng(lat, lon),
				level: 2
			}

			var data = {
				longitude: lon,
				latitude: lat
			}
			map = new kakao.maps.Map(container, options);

			$.ajax({
				type: "POST",
				url: "/auth/mainApi/sidoSelect",
				data: JSON.stringify(data), //http body데이터
				contentType: "application/json; charset=utf-8", //데이터 타입 명시
				dataType: "json", // 응답이 왔을때의 데이터타입을 자바스크립트 오브젝트로 변환해준다.
				success: function(data) {
					for (var i = 0; i < data.length; i++) {
						var obj = {};
						obj.title = data[i][0];
						obj.latlng = new kakao.maps.LatLng(data[i][1], data[i][2]);
						obj.doroName = data[i][3];
						obj.index = i;
						positions[i] = obj;
					}

					resolve(data.length);
				}

			})

		}, 500);
	});

}
function createMarker(cnt) {

	// 마커 이미지의 이미지 크기 입니다
	var imageSize = new kakao.maps.Size(24, 35);
	// 마커 이미지를 생성합니다    
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
	var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
		position: positions[cnt].latlng,// 마커를 표시할 위치
		index: cnt

	});
	marker.setMap(map);
	markers.push(marker);
	var CustomOverlay = new kakao.maps.CustomOverlay({
		map: map,
		position: marker.getPosition()
	});
	//마커 위에 커스텀오버레이 콘텐츠 Dom으로 구현 시작
	var Customcontent = document.createElement('div');
	Customcontent.className = "wrap";

	var info = document.createElement('div');
	info.className = "info"
	Customcontent.appendChild(info);

	//커스텀오버레이 타이틀
	var contentTitle = document.createElement("div");
	contentTitle.className = "title"
	contentTitle.appendChild(document.createTextNode(positions[cnt].title));
	info.appendChild(contentTitle);

	//커스텀오버레이 닫기 버튼
	var closeBtn = document.createElement("div");
	closeBtn.className = "close";
	closeBtn.setAttribute("title", "닫기");
	closeBtn.onclick = function() { CustomOverlay.setMap(null); };
	contentTitle.appendChild(closeBtn);

	var bodyContent = document.createElement("div");
	bodyContent.className = "body";
	info.appendChild(bodyContent);

	var imgDiv = document.createElement("div");
	imgDiv.className = "img";
	bodyContent.appendChild(imgDiv);

	//커스텀오버레이 이미지
	var imgContent = document.createElement("img");
	imgContent.setAttribute("src", "http://cfile181.uf.daum.net/image/250649365602043421936D");
	imgContent.setAttribute("width", "73");
	imgContent.setAttribute("heigth", "70");
	imgDiv.appendChild(imgContent);

	var descContent = document.createElement("div");
	descContent.className = "desc"
	bodyContent.appendChild(descContent);

	//커스텀오버레이 주소			
	var addressContent = document.createElement("div");
	addressContent.className = "ellipsis";
	addressContent.appendChild(document.createTextNode(positions[cnt].doroName));
	descContent.appendChild(addressContent);

	var LinkDiv = document.createElement("div");
	descContent.appendChild(LinkDiv);
	//커스텀오버레이 링크
	var LinkContent = document.createElement("a");
	url = "/auth/board/comuSearch/"+positions[cnt].title.trim();
	LinkContent.setAttribute("href", url);
	LinkContent.setAttribute("target", "_blank");

	LinkContent.className = "link";
	LinkContent.appendChild(document.createTextNode("대피소 커뮤니티 이동"));
	LinkDiv.appendChild(LinkContent);


	//마커 위에 커스텀오버레이 콘텐츠 Dom으로 구현 끝

	CustomOverlay.setContent(Customcontent);


	// 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
	kakao.maps.event.addListener(marker, 'click', function() {
		if (clickedOverlay) {
			clickedOverlay.setMap(null);
		}
		CustomOverlay.setMap(map);
		clickedOverlay = CustomOverlay;
	});

	CustomOverlay.setMap(null);



}



