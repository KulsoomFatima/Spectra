package resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	

	public static long PAGGGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10000;
	


	public static String getScreenshot(WebDriver driver) {

	TakesScreenshot ts=(TakesScreenshot) driver;
	
	File src= ts.getScreenshotAs(OutputType.FILE);
	String path= System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
	File destination = new File(path);
	
	try
	{
		FileUtils.copyFile(src, destination);
	}
	catch(IOException e) {
		System.out.println("Capture Failed" +e.getMessage());
	}
	return path;
}
}
