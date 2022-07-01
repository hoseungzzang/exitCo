package com.hs.exitCo.kakao;

import lombok.Data;

@Data
public class KakaoGetDong {

	private meta meta;
	private documents documents;
	
	@Data
	public class meta{
		public int total_count;
	}
	
	@Data
	public class documents{
		private String region_type;
		private String address_name;
		private String region_1depth_name;
		private String region_2depth_name;
		private String region_3depth_name;
		private String region_4depth_name;
		private String code;
		private double x;
		private double y;
		
	}
		
	

}
