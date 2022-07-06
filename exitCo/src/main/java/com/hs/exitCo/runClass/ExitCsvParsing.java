package com.hs.exitCo.runClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ExitCsvParsing {
	String path = "src/main/resources/static/csv/sidoCode.csv";
	public String exitCsvParsingRun(String userSi, String userGu, String userDong) {
		List<List<String>> list = new ArrayList<List<String>>();
		File csv = new File(path);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(csv));
			Charset.forName("UTF-8");
			String line = "";
			
			while((line=br.readLine()) != null) {
				String[] token = line.split(",");
				List<String> tempList = new ArrayList<String>(Arrays.asList(token));
				if(tempList.contains(userSi)&&tempList.contains(userGu)&&tempList.contains(userDong)) {
					list.add(tempList);
				}
				
			}
			System.out.println(list.get(0).get(0));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {br.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		return list.get(0).get(0);
	}
}
