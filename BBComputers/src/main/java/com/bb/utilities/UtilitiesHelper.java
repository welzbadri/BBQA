package com.bb.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilitiesHelper {

	// Method to take screenshot when the test cases fail
	public static void captureScreenshot(WebDriver driver , String screenshotname) 
	{
		Path dest = Paths.get("./screenshots",screenshotname+".png"); 
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Excpetion while taking screenshot"+ e.getMessage());
		}
	}
	
	public static void driverWait(WebDriver driver,int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
}
