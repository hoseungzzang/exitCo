package com.hs.exitCo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class KakaoGetDong {

	public Meta meta;
	public List<Documents> documents;

	@Data
	@JsonIgnoreProperties(ignoreUnknown=true)
	public class Meta{
		public int total_count;
	}
	
	@Data
	@JsonIgnoreProperties(ignoreUnknown=true)
	public static class Documents{
			public String region_1depth_name;
			public String region_2depth_name;
			public String region_3depth_name;
	}
		

}
