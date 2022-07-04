package com.hs.exitCo.model;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSido {

	public List<TsunamiShelter> TsunamiShelter;
	//public List<TsunamiShelter> tsunamiShelter;
	
	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public  static class TsunamiShelter {
		public List<Row> row;

	
		@Data
		@JsonIgnoreProperties(ignoreUnknown = true)
		public static class Row {
			public String remarks;
			public String shel_nm;
			public Double lon;
			public Double lat;
		}
	}

}
