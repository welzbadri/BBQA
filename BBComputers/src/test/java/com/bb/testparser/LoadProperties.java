package com.bb.testparser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.bb.appconfig.AppConfiguration;

public class LoadProperties 
{
	// Load the properties file from the folder
			 	
	public static Properties testConfig = loadProperties(System.getProperty("user.dir")+AppConfiguration.APPLICATION_PROPERTIES_FILE_PATH); 

	private static Properties loadProperties(String path)
	{
		Properties pro = new Properties();
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
		System.out.println("Error occurred :  " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occurred :  " + e.getMessage());
		} 
		catch (NullPointerException e) {
			System.out.println("Error occurred :  " + e.getMessage());
		} 
	
		return pro; 
	}
}
