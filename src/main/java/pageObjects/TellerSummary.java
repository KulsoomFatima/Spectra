  package pageObjects;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.base;

public class TellerSummary extends base {

	//ExtentReports extent;
	//WebDriver driver;

	//page factory 
	@FindBy(xpath="/html/body/div[3]/div/div[2]/div[1]/div/div/div/div/div[2]/div[1]/select")
	WebElement Group;

	@FindBy(xpath="/html/body/div[3]/div/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[2]/branchfilter-component/div/div/am-multiselect/div/button/span[1]")
	WebElement RegionBranches;

	@FindBy(xpath="	//div[@class='search-box pull-left']//input\r\n"
			+ " ")
	WebElement Calendar;
	
	@FindBy(xpath= "/html/body/div[3]/div/div[3]/div/div[2]/div[2]/latest-surveys-component/div")
	WebElement latestServey;
	
	@FindBy(xpath="//div[@class='dataTables_length']//select[@name='hardwareMonitoringTabular-table_length']")
	WebElement hardwaredropdown;
	
	@FindBy(xpath="//div[@id='hardwareMonitoringTabular-table_filter']//div//input[@class='form-control input-sm']")
	WebElement hardwaresearch;
	
	//initializing page objects
	public TellerSummary() throws SQLException {
		PageFactory.initElements(driver, this);
	
	}

	//Actions
	
	@Test
	public void tellersummarytable() throws InterruptedException, SQLException {
	
		driver.findElement(By.xpath("//div[@class='scroll-horizontal']//ul//li[2]")).click();

		Thread.sleep(5000);
		
		/*
		//select all
		Select g = new Select(Group);
		g.selectByValue("1041");
		*/
		
		Thread.sleep(5000);

		//select demo branch
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
		Thread.sleep(500);

		//click on unselect all
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
		Thread.sleep(500);		
		Thread.sleep(500);

		//search in text demo
		driver.findElement(By.xpath("//*[@id='srchBoxBranch']/input")).sendKeys("demo");
		Thread.sleep(5000);

		//select demo
		driver.findElement(By.xpath("//*[@id='branches-filter']/div/ul/li[4]/a")).click();
		Thread.sleep(5000);
		//click on location
		driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();		
		Thread.sleep(5000);

		// click back button
		//driver.findElement(By.xpath("//datefilter-component//a")).click();
	//	Thread.sleep(5000);
		//Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//div[@class='section-header']//h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		
		
		// printing table
		
		WebElement table = driver.findElement(By.xpath("//div[@class='table-responsive border-radius-xs']//div//table"));
		List<WebElement> col=table.findElements(By.tagName("th"));
        System.out.println("No of cols are : " +col.size()); 

		
		List<WebElement> rows =table.findElements(By.tagName("tr"));
        System.out.println("No of rows are : " +rows.size()); 
   	 WebElement tableRow = table.findElement(By.xpath("//div[@class='table-responsive border-radius-xs']//div//table//tbody"));
     String rowtext = tableRow.getText();
	 System.out.println("Rows of table:");
	 System.out.println(rowtext);
	 
		//sending ST to database class
	 TellerSummary_database gdata=new TellerSummary_database();
			
			String i=gdata.tellersummarytable();
			System.out.println(i);
	
		
	
		 }
	
}

