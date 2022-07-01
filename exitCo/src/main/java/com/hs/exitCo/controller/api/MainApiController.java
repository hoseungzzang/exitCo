package com.hs.exitCo.controller.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hs.exitCo.dto.KakaoDto;
import com.hs.exitCo.model.KakaoGetDong;

@Controller
public class MainApiController {

	@PostMapping("/mainApi/sidoSelect")
	public String callDong(@RequestBody KakaoDto kakao) {


	        RestTemplate restTemplate = new RestTemplate();
			 HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "KakaoAK cdda625610b1371268e07ad5159c28d9");
			headers.add("content-type", "application/json;charset=utf-8");
			 HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(headers);
			String strUrl = "https://dapi.kakao.com/v2/local/geo/coord2regioncode.json" + "?x=" + kakao.getLongitude()
					+ "&y=" + kakao.getLatitude() + "&input_coord=WGS84";
			ResponseEntity<String> response = restTemplate.exchange(
					strUrl,
					HttpMethod.GET,
					entity,
					String.class
					);

			
			ObjectMapper objectMapper = new ObjectMapper();
			 KakaoGetDong kakaoGetDong =null;
			try {
				System.out.println(response.getBody());
				kakaoGetDong = objectMapper.readValue(response.getBody(), KakaoGetDong.class);
				System.out.println(kakaoGetDong.getDocuments().get(0).region_2depth_name);
				
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		return "";
	}
}
