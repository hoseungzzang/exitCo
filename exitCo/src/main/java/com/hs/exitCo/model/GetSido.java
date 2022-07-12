package com.hs.exitCo.model;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSido {

	public Body body;
	//public List<TsunamiShelter> tsunamiShelter;
	
	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public  static class Body {
		public List<Items> items;

	
		@Data
		@JsonIgnoreProperties(ignoreUnknown = true)
		public static class Items {
			public Item item;
			
			
			@Data
			@JsonIgnoreProperties(ignoreUnknown = true)
			public static class Item {
				public String shelter_nm;
				public String x;
				public String y;
				public String shelter_di;
			}
		}
	}

}
