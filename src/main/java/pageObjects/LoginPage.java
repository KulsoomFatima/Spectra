package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;




import resources.base;

public class LoginPage extends base {

	//page factory 
	@FindBy(xpath="//*[@id=\"exampleInputEmail\"]")
	WebElement Username;
	
	@FindBy(xpath="//*[@id=\"exampleInputPassword\"]")
	WebElement Password;
	
	@FindBy(xpath="//*[@id=\"loginBtn\"]")
	WebElement LoginBtn;
	
	@FindBy(xpath="/html/body/div[3]")
	WebElement Error;
	
	@FindBy(xpath="//*[@id=\"activeLanguages\"]/a")
	WebElement ChangeLang;
	
	

//initializing page objects
 public LoginPage() {
	PageFactory.initElements(driver, this);
}
 //Actions

  @SuppressWarnings("deprecation")
public HomePage login(String un, String pwd) throws SQLException, InterruptedException {
	 Thread.sleep(10000);
	//Declare and initialise a fluent wait
	 FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	 //Specify the timout of the wait
	 wait.withTimeout(10000, TimeUnit.MILLISECONDS);
	 //Specify polling time
	 wait.pollingEvery(250, TimeUnit.MILLISECONDS);
	 //Specify what exceptions to ignore
	 wait.ignoring(NoSuchElementException.class);

	 //This is how we specify the condition to wait on.
	// wait.until(ExpectedConditions.alertIsPresent());
		//Thread.sleep(500000);

		
	  Username.sendKeys(un);
	  Password.sendKeys(pwd);
	  LoginBtn.click();
	return new HomePage();
	  
  }
  
  public HomePage IncorrectPasslogin(String un, String pwd) throws SQLException, InterruptedException {
		//Thread.sleep(500000);
	//	 Thread.sleep(10000);

	  Username.sendKeys(un);
	  Password.sendKeys("password");
	// Password.sendKeys(decodeString("YWJjIDEyMw=="));
	  LoginBtn.click();
	return new HomePage();
	  
  }
  
  public HomePage Incorrectuserlogin(String un, String pwd) throws InterruptedException, SQLException {
	//	Thread.sleep(500000);
		// Thread.sleep(10000);

	  Username.sendKeys("username");
	  Password.sendKeys(pwd);
	// Password.sendKeys(decodeString("YWJjIDEyMw=="));
	  LoginBtn.click();
	  Thread.sleep(600);
	  System.out.println("login error");
	  String ErrorMsg = Error.findElement(By.xpath("/html/body/div[3]/p")).getText();
	  System.out.println(ErrorMsg);
	return new HomePage();
	  
  }
  
  public HomePage validusernameloginwithincorrectpass(String un, String pwd) throws InterruptedException, SQLException {
		//Thread.sleep(500000);
		// Thread.sleep(10000);

	  Username.sendKeys("username");
	  Password.sendKeys(pwd);
	// Password.sendKeys(decodeString("YWJjIDEyMw=="));
	  LoginBtn.click();
	  Thread.sleep(600);
	  System.out.println("login error");
	  String ErrorMsg = Error.findElement(By.xpath("/html/body/div[3]/p")).getText();
	  System.out.println(ErrorMsg);
	return new HomePage();
	  
  }
  
  public HomePage ChangeLanguage() throws InterruptedException, SQLException {
	//	Thread.sleep(500000);
		// Thread.sleep(10000);

	  ChangeLang.click();
	  	Thread.sleep(600);
	    System.out.println("Language changed");
	    
		   String expectedlang ="Ingresar identificación"; 
		   String actuallang = driver.findElement(By.xpath("//*[@id=\"emailDiv\"]/label")).getText(); 

		// Compare expected title of the page with actual title of the page and print the result. 
		   if(expectedlang.equals(actuallang)) 
		   { 
		     System.out.println("Verification Successful – Correct lang is displayed on the login webpage."); 
		   } 
		   else 
		   { 
		     System.out.println("Verification Failed: Incorrect lang is displayed on the login webpage."); 
		   } 
	    
		return new HomePage();
		
  }
  
     String decodeString(String password) {
    	 byte[] decodeString=Base64.decodeBase64(password);
    	 return (new String(decodeString)); 
    	 }
    	 
     
     
}