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

public class hardware_monitoring extends base {

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
	public hardware_monitoring() throws SQLException {
		PageFactory.initElements(driver, this);
	
	}

	//Actions
	
	@Test
	public void heatmap() {
		
	}
	
	@Test
	public void Hardware_Monitoring_Tabular() throws InterruptedException {
	
				Thread.sleep(5000);
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				

				//Thread.sleep(5000);
				Thread.sleep(5000);
	   //last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				Select s = new Select(hardwaredropdown);
				s.selectByIndex(1);
		
		Thread.sleep(5000);
	//print table heading
		String table_heading = driver.findElement(By.xpath("//table[@id='hardwareMonitoringTabular-table']//tr[@role='row']")).getText();
		System.out.println(table_heading);
		
		Thread.sleep(5000);
		
	//branch text
		String branch = driver.findElement(By.xpath("//table[@id='hardwareMonitoringTabular-table']//tr//td[2]")).getText();
		System.out.println("Branch= " + branch);
		
	//branch info
		String branchinfo = driver.findElement(By.xpath("//table[@id='hardwareMonitoringTabular-table']//tr//td[3]")).getText();
		System.out.println("Branch info= " + branchinfo);
		
	//last updated at
		String last_updated = driver.findElement(By.xpath("//table[@id='hardwareMonitoringTabular-table']//tr//td[4]")).getText();
		System.out.println("last updated at= " + last_updated);
		
	//status
		String Status = driver.findElement(By.xpath("//table[@id='hardwareMonitoringTabular-table']//tr//td[5]")).getText();
		System.out.println("Status = " + Status);
		
	//search input
		hardwaresearch.sendKeys("hello");
		Thread.sleep(5000);
		//verify the search result text
		String tablesearxchresult = driver.findElement(By.xpath("//table[@id='hardwareMonitoringTabular-table']//tr[1]//td")).getText();
		System.out.println("Search result:" + tablesearxchresult);
		
	//pagination
		
	//Firstbutton 
		WebElement first = driver.findElement(By.xpath("//div[@id='hardwareMonitoringTabular-table_paginate']//a[@class='first']"));
		first.click();
		
	//previous
		WebElement previous = driver.findElement(By.xpath("//div[@id='hardwareMonitoringTabular-table_paginate']//a[@class='previous']"));
		previous.click();
		
	//next
		WebElement next = driver.findElement(By.xpath("//div[@id='hardwareMonitoringTabular-table_paginate']//a[@class='next']"));
		next.click();
		
	//last
		WebElement last = driver.findElement(By.xpath("//div[@id='hardwareMonitoringTabular-table_paginate']//a[@class='last']"));
		last.click();
		
	/*	//page no
		WebElement pageno = driver.findElement(By.xpath("//div[@id='hardwareMonitoringTabular-table_paginate']//li[@class='active']//a"));
		System.out.println("Current page no: " + pageno.getText());
		*/
		
		
	}

}
