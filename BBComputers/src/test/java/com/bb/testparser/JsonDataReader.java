package com.bb.testparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader 
{
	
	public static String readDataFromJsonFile(String testName, String key) throws IOException, ParseException {
		String filePath = System.getProperty("user.dir")+LoadProperties.testConfig.getProperty("testDataJsonPath");

		File file = new File(filePath);
		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
		JSONParser jParser = new JSONParser();
		JSONObject jFileObj = (JSONObject) jParser.parse(inputStreamReader);
		JSONObject jDataObj = (JSONObject) jFileObj.get(testName);
		String value = (String) jDataObj.get(key);
		return value;
	}
	
	
	public String firstname, lastname , email , password  ; 

	public void JsonReader() throws IOException, ParseException 
	{
		
		String filePath = System.getProperty("user.dir")+LoadProperties.testConfig.getProperty("testDataJsonPath");

		File srcFile = new File(filePath); 

		JSONParser parser = new JSONParser(); 
		JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile)); 

		
		for(Object jsonObj : jarray) 
		{
			JSONObject person = (JSONObject) jsonObj ; 
			firstname  = (String) person.get("firstname"); 
			System.out.println(firstname);

			lastname = (String) person.get("lastname"); 
			System.out.println(lastname);

			email = (String) person.get("email"); 
			System.out.println(email);

			password = (String) person.get("password"); 
			System.out.println(password);

		}

	}

}
