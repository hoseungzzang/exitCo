package com.hs.exitCo.controller.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hs.exitCo.dto.KakaoDto;
import com.hs.exitCo.model.GetSido;
import com.hs.exitCo.model.KakaoGetDong;
import com.hs.exitCo.runClass.ExitCsvParsing;
import com.hs.exitCo.runClass.TransCoord;

@Controller
public class MainApiController {
	final String encKey = "QlYtJR%2BvwVIrtLun4CUyEjfxjV8mrqQBpudJ%2BDSKB7bGIdYn7rnj%2FfLm3bYh%2FwvCDCowCpFZmdblGbXmdX99%2BA%3D%3D";
	String sidoCode;

	@ResponseBody
	@PostMapping("/auth/mainApi/sidoSelect" )
	public ArrayList<String[]> callDong(@RequestBody KakaoDto kakao) throws IOException, URISyntaxException {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK cdda625610b1371268e07ad5159c28d9");
		headers.add("content-type", "application/json;charset=utf-8");
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(headers);
		String strUrl = "https://dapi.kakao.com/v2/local/geo/coord2regioncode.json" + "?x=" + kakao.getLongitude()
				+ "&y=" + kakao.getLatitude() + "&input_coord=WGS84";
		ResponseEntity<String> response = restTemplate.exchange(strUrl, HttpMethod.GET, entity, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		KakaoGetDong kakaoGetDong = null;
		try {
			kakaoGetDong = objectMapper.readValue(response.getBody(), KakaoGetDong.class);
			String userSi = "";
			String userGu = "";
			String userDong = "";
			userSi =  kakaoGetDong.getDocuments().get(0).region_1depth_name;
			userGu = kakaoGetDong.getDocuments().get(0).region_2depth_name;
			userDong= kakaoGetDong.getDocuments().get(0).region_3depth_name;
			ExitCsvParsing exitCsvParsing = new ExitCsvParsing();
			sidoCode = exitCsvParsing.exitCsvParsingRun(userSi, userGu, userDong);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RestTemplate restTemplate2 = new RestTemplate();
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("content-type", "application/json;charset=utf-8");
		HttpEntity<String> sidoEntity = new HttpEntity<>(headers2);

		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/B553501/flRescueSpService/getFlRescueSpInfo"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + encKey); /* Service Key */
		urlBuilder
				.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("100", "UTF-8")); /* 한 페이지 결과 수 */
		urlBuilder.append(
				"&" + URLEncoder.encode("adm_cd", "UTF-8") + "=" + URLEncoder.encode(sidoCode, "UTF-8")); /* 호출문서 형식 */
		URI url = new URI(urlBuilder.toString());
		ResponseEntity<String> response2 = restTemplate2.exchange(url, HttpMethod.GET, sidoEntity, String.class);
		ArrayList<String[]> exitList = new ArrayList<String[]>();
		ObjectMapper objectMapper2 = new ObjectMapper();
		GetSido getSido = null;
		try {
			getSido = objectMapper2.readValue(response2.getBody(), GetSido.class);
			TransCoord transCoord = new TransCoord();
			for(int i=0; i<getSido.getBody().getItems().size(); i++) {
				String [] resultSet = new String[4];
				String [] arr = transCoord.transform2(getSido.getBody().getItems().get(i).getItem().getX().toString(), getSido.getBody().getItems().get(i).getItem().getY().toString());
				resultSet[0] = getSido.getBody().getItems().get(i).getItem().getShelter_nm().toString();
				resultSet[1] = arr[1];
				resultSet[2] = arr[0];
				resultSet[3] = getSido.getBody().getItems().get(i).getItem().getShelter_di().toString();
				exitList.add(resultSet);
			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return exitList;
	}
}
