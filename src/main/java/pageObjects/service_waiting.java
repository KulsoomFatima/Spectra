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

public class service_waiting extends base {

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
	public service_waiting() throws SQLException {
		PageFactory.initElements(driver, this);
	
	}

	//Actions
	
	@Test
	public void opencounters() throws InterruptedException, SQLException {
		/// cannot fetch on 30 days ////
		Thread.sleep(5000);
		//select all
		Select g = new Select(Group);
		g.selectByValue("1036");
		//selecting hbl
		driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
		//click on unselect all
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
		Thread.sleep(500);
		//select hbl
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
		Thread.sleep(5000);
		//click on group
		driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();		

		//Thread.sleep(5000);
		Thread.sleep(5000);
	/*	//last 30 days    
		driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
		Thread.sleep(5000);
		WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
		date.click();
		System.out.println("30 days Selected");
		
		*/
		Thread.sleep(5000);
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div[1]/div[2]/div[1]/div/div/opencounters-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		String opencounter = driver.findElement(By.xpath("//opencounters-individual-component//div//h2[@class='info-text2 dark-blue-color']//span")).getText();
		System.out.println("Open counters from web: " +opencounter);
		
		
		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.opencounters();
			System.out.println(i);
			
		Assert.assertEquals(opencounter, i);
			
		 }
	
	@Test
	public void localwait() throws InterruptedException, SQLException {
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();

				//Thread.sleep(5000);
				Thread.sleep(5000);
		/*		//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				
				*/
		
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[17]/opencounters-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		String localwait = driver.findElement(By.xpath("//local-wait-individual-component//div//h2[@class='info-text2 ng-binding']")).getText();
		System.out.println("Open counters: " +localwait);
		
		
		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.opencounters();
			
			Assert.assertEquals(localwait, i);
			
		 }
	
	@Test
	public void ticketnoshow() throws InterruptedException, SQLException {
	
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();

				//Thread.sleep(5000);
				Thread.sleep(5000);
			/*	//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				
				
		*/
		//no show heading
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("//tickets-noshow-individual-component//div//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		//no show data
		String ticketnoshow = driver.findElement(By.xpath("//tickets-noshow-individual-component//h2[@class='info-text2 dark-purple-color ng-binding']")).getText();
		System.out.println("ticket no show: " +ticketnoshow);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.ticketnoshow();
			System.out.println(i);
			Assert.assertEquals(ticketnoshow, i);
			
	}


	@Test
	public void WTE() throws InterruptedException, SQLException {
		
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				Thread.sleep(5000);
				
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				/*
				
	    //last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");*/
				
		Thread.sleep(600);
	//WTE heading
		String heading = driver.findElement(By.xpath("//waittime-exception-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(60000);
		Thread.sleep(5000);
	//WTE data
		String WTE = driver.findElement(By.xpath("//waittime-exception-individual-component//h2[@class='info-text2 ng-binding']")).getText();
		System.out.println("Wait Time Exception: " +WTE);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.WTE();
			
			Assert.assertEquals(WTE, i);
			
	}
	
	@Test
	public void STE() throws InterruptedException, SQLException {
	
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
			
				Thread.sleep(5000);
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				
				/*
		//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
		*/
		Thread.sleep(600);
	//STE HEading
		
			String heading = driver.findElement(By.xpath("//servicetime-exception-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(60000);
		Thread.sleep(5000);
	//STE Data
		String STE = driver.findElement(By.xpath("//servicetime-exception-individual-component//h2[@class='info-text2 ng-binding']")).getText();
		System.out.println("Service Time Exception: " +STE);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.STE();
			
			Assert.assertEquals(STE, i);
			
	}
	@Test
	public void queuesize() throws InterruptedException, SQLException {
		
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();

				//Thread.sleep(5000);
				Thread.sleep(5000);
			/*	//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				*/
				
		
		
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("//queuesize-exception-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(60000);
		Thread.sleep(5000);
		String queuesize = driver.findElement(By.xpath("//queuesize-exception-individual-component//h2[@class='info-text2 ng-binding']")).getText();
		System.out.println("Queue Size Exception: " +queuesize);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.queuesize();
			
			Assert.assertEquals(queuesize, i);
			
	}
	
	@Test
	public void waitingcomplaince() throws InterruptedException, SQLException {
		
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();				

				//Thread.sleep(5000);
				Thread.sleep(5000);
			/*	//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				*/
				
		
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("//waiting-compliance-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(60000);
		Thread.sleep(5000);
		String waitingcomplaince = driver.findElement(By.xpath("//waiting-compliance-individual-component//h2[@class='info-text2 ng-binding']")).getText();
		System.out.println("Waiting Complaince: " +waitingcomplaince);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.waitingcomplaince();
			
			Assert.assertEquals(waitingcomplaince, i+"%");
			
	}
	
	@Test
	public void tickettransfer() throws InterruptedException, SQLException {
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				
				//Thread.sleep(5000);
				Thread.sleep(5000);
		/*		//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				*/
				
		String heading = driver.findElement(By.xpath("//tickettransferred-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String tickettransfer = driver.findElement(By.xpath("//tickettransferred-individual-component//div//div[@class='component ng-scope']//h2[@class='info-text2 ng-binding']")).getText();
		System.out.println("Ticket transferred: " + tickettransfer);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.ticket_transffered();
			
			Assert.assertEquals(tickettransfer, i);
			
		
	}
	
	@Test
	public void ticket_in_serving() throws InterruptedException, SQLException {
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();				

				//Thread.sleep(5000);
				Thread.sleep(5000);
			/*	//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				
				*/
		
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("//ticketserving-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		//today data xpath 
		String ticketserving = driver.findElement(By.xpath("//ticketserving-individual-component//p[@class='ng-binding']")).getText();
		System.out.println("Ticket serving: " +ticketserving);
	

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.ticket_in_serving();
			
			Assert.assertEquals(ticketserving, i);
			
	}
	
	@Test
	public void ticketIssued() throws InterruptedException, SQLException {
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();

				//Thread.sleep(5000);
				Thread.sleep(5000);
			/*	//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				
				*/
		Thread.sleep(6000);
		String heading = driver.findElement(By.xpath("//ticketissued-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String ticketIssued = driver.findElement(By.xpath("//ticketissued-individual-component//div//div//h2")).getText();
		System.out.println("Ticket Issued: " +ticketIssued);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.ticket_issued();
			
			Assert.assertEquals(ticketIssued, i);
			
	
	}
	
	@Test
	public void ticketserved() throws InterruptedException, SQLException {
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				
				//Thread.sleep(5000);
				Thread.sleep(5000);
			/*	//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				*/
				
		
		Thread.sleep(6000);
		String heading = driver.findElement(By.xpath("//ticketserved-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String ticketserved = driver.findElement(By.xpath("//ticketserved-individual-component//div//div//h2[@class='info-text2 dark-blue-color ng-binding']")).getText();
		System.out.println("Ticket served: " +ticketserved);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.ticket_served();
			
			Assert.assertEquals(ticketserved, i);
			
	}
	

	@Test
	public void avgService_time() throws InterruptedException, SQLException {
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();

				//Thread.sleep(5000);
				Thread.sleep(5000);
			/*	//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
		*/
		Thread.sleep(6000);
		String heading = driver.findElement(By.xpath("//avg-servicetime-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String avgService_time = driver.findElement(By.xpath("//avg-servicetime-individual-component//div//div[@class='component circular-component ng-scope']//h2")).getText();
		System.out.println("avg Service_time: " +avgService_time);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.avgservicetime();
			System.out.println(i);
			Assert.assertEquals(avgService_time, i);
			
	}
	
	@Test
	public void avgwait_time() throws InterruptedException, SQLException {
	
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();

				//Thread.sleep(5000);
				Thread.sleep(5000);
	/*			//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				
				*/
		
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("//avg-waittime-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(10000);
		Thread.sleep(1200);
		Thread.sleep(2000);
		String avgwait_time = driver.findElement(By.xpath("//avg-waittime-individual-component//h2[@class='info-text ng-binding']")).getText();
		System.out.println("avgwait_time: " +avgwait_time);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.avgwaittime();
			
			Assert.assertEquals(avgwait_time, i);
			
	}
	
	@Test
	public void maxservice_time() throws InterruptedException, SQLException {
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				
				//Thread.sleep(5000);
				Thread.sleep(5000);
		/*		//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				*/
				Thread.sleep(600);
		String heading = driver.findElement(By.xpath("//max-servicetime-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(50000);
		
		String maxservice_time = driver.findElement(By.xpath("//max-servicetime-individual-component//h2[@class='info-text ng-binding']")).getText();
		System.out.println("maxservice_time: " +maxservice_time);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.maxservicetime();
			
			Assert.assertEquals(maxservice_time, i);
			
	}
	
	
	@Test
	public void serviceComplaince() throws InterruptedException, SQLException {
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
			
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();

				//Thread.sleep(5000);
				Thread.sleep(5000);
			/*	//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				*/
				Thread.sleep(600);
		String heading = driver.findElement(By.xpath("//service-compliance-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(60000);
		Thread.sleep(5000);
		String serviceComplaince = driver.findElement(By.xpath("//service-compliance-individual-component//h2[@class='info-text2 ng-binding']")).getText();
		System.out.println("Service Complaince: " +serviceComplaince);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.servicecomplaince();
			
			Assert.assertEquals(serviceComplaince, i+"%");
			
	}
	
	
	
	@Test
	public void maxwait_time() throws InterruptedException, SQLException {
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				//click on group
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();

				//Thread.sleep(5000);
				Thread.sleep(5000);
			/*	//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[3]"));
				date.click();
				System.out.println("30 days Selected");
				*/
					Thread.sleep(600);
		String heading = driver.findElement(By.xpath("//max-waittime-individual-component//h1[@class='component-heading ng-binding']")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(60000);
		Thread.sleep(5000);
		String maxwait_time = driver.findElement(By.xpath("//max-waittime-individual-component//h2[@class='info-text ng-binding']")).getText();
		System.out.println("Max wait_time: " +maxwait_time);
		

		//sending ST to database class
		servicewaiting_database gdata=new servicewaiting_database();
			
			String i=gdata.maxwaittime();
			
			Assert.assertEquals(maxwait_time, i);
			
	}
}
