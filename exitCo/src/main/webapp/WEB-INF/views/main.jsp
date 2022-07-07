<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전국 대피소 찾기</title>
<script charset="UTF-8">
	new daum.roughmap.Lander({
		"timestamp" : "1613788870358",
		"key" : "24iif",
		"mapWidth" : "640",
		"mapHeight" : "360"
	}).render();
</script>
<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

</head>
<style>
html,body{
width:100%;  height:100%;
overflow: visible;
}


</style>
<body>
<%@ include file="./layout/header.jsp"%>
<div id="map" style="width:100%; height:83%;">
</div>





<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9cfa94286fc9d288f6ba24e2389deba7"></script>
<script src="/js/kakao.js"></script>
<%@ include file="./layout/footer.jsp"%>
</body>
</html>