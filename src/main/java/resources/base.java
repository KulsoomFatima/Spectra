package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class base {

	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public base() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\SpecDashboard\\src\\main\\java\\resources\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
		@SuppressWarnings("deprecation")
		public static void initilization() {

			//DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome ()    ;   
				//	handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
			
         ChromeOptions capability = new ChromeOptions();
         capability.setPageLoadStrategy(PageLoadStrategy.EAGER);
         capability.addArguments("disable-features=NetworkService") ;

         capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
         capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
			String browserName= prop.getProperty("browser");
			
			if(browserName.equals("chrome")) { 
				System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
				driver = new ChromeDriver(capability);
				 //driver = new ChromeDriver (handlSSLErr);

			}
		
	        JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGGGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		js.executeScript("window.scrollBy(0,500)");
	
	
		}
		
		public String getScreenshotab(String testCaseName, WebDriver driver) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir") +"//reports//" +testCaseName +".png" );
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir") + "//reports//" +testCaseName + ".png";
			
		}
}
