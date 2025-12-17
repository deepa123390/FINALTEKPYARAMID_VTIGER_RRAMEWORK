package com.generic.fileutilty;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class FileUtility {
	public String getDatafromPropertiesFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./configAppData/vtiger_commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(key);
		
		return data;
	}
	
public String getDataFromJsonFile(String key) throws IOException, ParseException {
	JSONParser parser=new JSONParser();
	Object obj=parser.parse(new FileReader("./configAppData/jsoncommomdata.json"));
	JSONObject map = (JSONObject)obj;
	String data=(String)map.get(key);
	
	return data;
	}
}
