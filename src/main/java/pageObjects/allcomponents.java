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

public class allcomponents extends base {

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
	public allcomponents() throws SQLException {
		PageFactory.initElements(driver, this);
	
	}

	//Actions
	
	@Test
	public void latestServey() {
		latestServey.click();
	}
	
	@Test
	public void Feedback_Evolution_By_Hourly_Distribution() {
		
	}
	
	@Test
	public void Hardware_Monitoring_Tabular() throws InterruptedException {
		Thread.sleep(5000);
		//select all
		Select g = new Select(Group);
		g.selectByValue("1036");
		
		Thread.sleep(5000);
		
		Select s = new Select(hardwaredropdown);
		s.selectByIndex(1);
		
		Thread.sleep(5000);
		//print table heading
		String table_heading = driver.findElement(By.xpath("//table[@id='hardwareMonitoringTabular-table']//tr[1]")).getText();
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
	
	
	@Test
	public void Client_Served_Per_Category() throws InterruptedException{
		
		Thread.sleep(5000);
		//select all
		Select g = new Select(Group);
		g.selectByValue("1036");
		
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//clients-served-component//div[@class='component-box height-lg']//h1")).getText();
		System.out.println(heading);
		
		//print clients
		WebElement client = driver.findElement(By.xpath("//clients-served-component//div[@class='highcharts-legend']//div/div"));
		System.out.println(client.getText());
		
		//print no of client served by category
		String clientserved = driver.findElement(By.xpath("//clients-served-component//div[@class='position-bottom']//p//span")).getText();
		System.out.println("Total client served: " + clientserved);
	}
	
	@Test
	public void Client_waiting_Per_Category() throws InterruptedException {
		

		Thread.sleep(5000);
		//select all
		Select g = new Select(Group);
		g.selectByValue("1036");
		
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//clients-waiting-component//div[@class='component-box height-lg']//h1")).getText();
		System.out.println(heading);
		
		//print clients
		WebElement client = driver.findElement(By.xpath("//clients-waiting-component//div[@class='highcharts-legend']//div/div"));
		System.out.println(client.getText());
		
		//print no of client waiting by category
	    String totalclientwaiting = driver.findElement(By.xpath("//clients-waiting-component//div[@class='position-bottom']//p//span")).getText();
	    System.out.println("Total client waiting: " + totalclientwaiting);
	}
	
	@Test
	public void Service_Rate_Per_Category() throws InterruptedException {
		
		Thread.sleep(5000);
		//select all
		Select g = new Select(Group);
		g.selectByValue("1036");
		
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//service-rate-component/div[@class='component-box height-lg']//h1")).getText();
		System.out.println(heading);
		
		//print clients
		WebElement client = driver.findElement(By.xpath("//service-rate-component//div[@class='highcharts-legend']//div/div"));
		System.out.println(client.getText());
		
		//print no of client waiting by category
	    String ticketservedperhour = driver.findElement(By.xpath("//service-rate-component//div[@class='position-bottom']//p//span")).getText();
	    System.out.println("Total client waiting: " + ticketservedperhour);
		
	}
	
	@Test
	public void Average_Time_Per_Category() throws InterruptedException {
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				Thread.sleep(5000);
				String heading = driver.findElement(By.xpath("//avg-time-component//div[@class='component-box height-lg']//h1")).getText();
				System.out.println(heading);
				
	}
	
	@Test
	public void Target_Compliance_Per_Category() throws InterruptedException {
		//select all
		Select g = new Select(Group);
		g.selectByValue("1036");
		
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//target-compliance-component//div[@class='component-box height-lg']//h1")).getText();
		System.out.println(heading);
		
	}
	
	@Test
	public void Branch_Evolution() {
		
	}
	
	@Test
	public void Service() {
		
	}
	
	@Test
	public void waiting() {
		
	}
	
	@Test
	public void Complaince() {
		
	}
	
	@Test
	public void Tellergroup() {
		
	}
	
	@Test
	public void counters() {
		
	}
	
	@Test
	public void opencounters() throws InterruptedException, SQLException {
		/// cannot fetch on 30 days ////
		
		//select all
		Select g = new Select(Group);
		g.selectByValue("1036");
		
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[17]/opencounters-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		String opencounter = driver.findElement(By.xpath("//h2[@class='info-text2 dark-blue-color']//span[@class='ng-binding'][normalize-space()='0']")).getText();
		System.out.println("Open counters: " +opencounter);
		
		
		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.opencounters();
			
			Assert.assertEquals(opencounter, i);
			
		 }

	@Test
	public void tickettransfer() throws InterruptedException, SQLException {
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[18]/tickettransferred-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String tickettransfer = driver.findElement(By.xpath("//tickettransferred-individual-component//div//div[@class='component ng-scope']//h2[@class='info-text2 ng-binding']")).getText();
		System.out.println("Ticket transferred: " + tickettransfer);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.ticket_transffered();
			
			Assert.assertEquals(tickettransfer, i);
			
		
	}
	
	@Test
	public void ticket_in_serving() throws InterruptedException, SQLException {
		//select all
		Select g = new Select(Group);
		g.selectByValue("1036");
		
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[19]/ticketserving-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String ticketserving = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[19]/ticketserving-individual-component/div/div/h2")).getText();
		System.out.println("Ticket serving: " +ticketserving);
		
/*
		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.opencounters();
			
			Assert.assertEquals("", i);
			*/
	}
	
	@Test
	public void ticketIssued() throws InterruptedException, SQLException {
		
		//select all
		Select g = new Select(Group);
		g.selectByValue("1036");
		
		Thread.sleep(6000);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[19]/ticketserving-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String ticketIssued = driver.findElement(By.xpath("//ticketissued-individual-component//div//div//h2")).getText();
		System.out.println("Ticket Issued: " +ticketIssued);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.ticket_issued();
			
			Assert.assertEquals(ticketIssued, i);
			
	
	}
	
	@Test
	public void ticketserved() throws InterruptedException, SQLException {
		
		//select all
		Select g = new Select(Group);
		g.selectByValue("1036");
		
		Thread.sleep(6000);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[21]/ticketserved-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String ticketserved = driver.findElement(By.xpath("//ticketserved-individual-component//div//div//h2[@class='info-text2 dark-blue-color ng-binding']")).getText();
		System.out.println("Ticket served: " +ticketserved);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.ticket_served();
			
			Assert.assertEquals(ticketserved, i);
			
	}
	

	@Test
	public void avgService_time() throws InterruptedException, SQLException {
		//select all
		
		
		Thread.sleep(6000);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[23]/avg-servicetime-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String avgService_time = driver.findElement(By.xpath("//avg-servicetime-individual-component//div//div[@class='component circular-component ng-scope']//h2")).getText();
		System.out.println("avg Service_time: " +avgService_time);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.avgservicetime();
			System.out.println(i);
			Assert.assertEquals(avgService_time, i);
			
	}
	
	@Test
	public void avgwait_time() throws InterruptedException, SQLException {
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[24]/avg-waittime-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(10000);
		Thread.sleep(10000);
		Thread.sleep(10000);
		Thread.sleep(10000);
		Thread.sleep(1200);
		Thread.sleep(2000);
		String avgwait_time = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[24]/avg-waittime-individual-component/div/div/h2")).getText();
		System.out.println("avgwait_time: " +avgwait_time);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.avgwaittime();
			
			Assert.assertEquals(avgwait_time, i);
			
	}
	
	@Test
	public void maxservice_time() throws InterruptedException, SQLException {
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[25]/max-servicetime-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(50000);
		
		String maxservice_time = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[25]/max-servicetime-individual-component/div/div/h2")).getText();
		System.out.println("maxservice_time: " +maxservice_time);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.maxservicetime();
			
			Assert.assertEquals(maxservice_time, i);
			
	}
	
	@Test
	public void ticketnoshow() throws InterruptedException, SQLException {
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[26]/tickets-noshow-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(50000);
		
		String ticketnoshow = driver.findElement(By.xpath("//tickets-noshow-individual-component//h2[@class='info-text2 dark-purple-color ng-binding']")).getText();
		System.out.println("ticket no show xhc: " +ticketnoshow);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.ticketnoshow();
			System.out.println(i);
			Assert.assertEquals(ticketnoshow, i);
			
	}
	
	@Test
	public void serviceComplaince() throws InterruptedException, SQLException {
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[27]/service-compliance-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(60000);
		Thread.sleep(5000);
		String serviceComplaince = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[27]/service-compliance-individual-component/div/div/h2")).getText();
		System.out.println("Service Complaince: " +serviceComplaince);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.servicecomplaince();
			
			Assert.assertEquals(serviceComplaince, i+"%");
			
	}
	
	@Test
	public void waitingcomplaince() throws InterruptedException, SQLException {
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[28]/waiting-compliance-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(60000);
		Thread.sleep(5000);
		String waitingcomplaince = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[28]/waiting-compliance-individual-component/div/div/h2")).getText();
		System.out.println("Waiting Complaince: " +waitingcomplaince);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.waitingcomplaince();
			
			Assert.assertEquals(waitingcomplaince, i+"%");
			
	}
	
	@Test
	public void queuesize() throws InterruptedException, SQLException {
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[29]/queuesize-exception-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(60000);
		Thread.sleep(5000);
		String queuesize = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[29]/queuesize-exception-individual-component/div/div/h2")).getText();
		System.out.println("Queue Size Exception: " +queuesize);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.queuesize();
			
			Assert.assertEquals(queuesize, i);
			
	}
	
	
	@Test
	public void maxwait_time() throws InterruptedException, SQLException {
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[22]/max-waittime-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(60000);
		Thread.sleep(5000);
		String maxwait_time = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[22]/max-waittime-individual-component/div/div/h2")).getText();
		System.out.println("Max wait_time: " +maxwait_time);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.maxwaittime();
			
			Assert.assertEquals(maxwait_time, i);
			
	}
	
	@Test
	public void STE() throws InterruptedException, SQLException {
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[30]/servicetime-exception-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(60000);
		Thread.sleep(5000);
		String STE = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[30]/servicetime-exception-individual-component/div/div/h2")).getText();
		System.out.println("Service Time Exception: " +STE);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.STE();
			
			Assert.assertEquals(STE, i);
			
	}
	
	@Test
	public void WTE() throws InterruptedException, SQLException {
		Thread.sleep(600);
		String heading = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[31]/waittime-exception-individual-component/div/h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(60000);
		Thread.sleep(5000);
		String WTE = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[31]/waittime-exception-individual-component/div/div/h2")).getText();
		System.out.println("Wait Time Exception: " +WTE);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.WTE();
			
			Assert.assertEquals(WTE, i);
			
	}
	
	@Test
	public void categorydetail() throws InterruptedException, SQLException {
	
		Thread.sleep(5000);
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				Thread.sleep(500);
		WebElement category = driver.findElement(By.xpath("//div//details-categories-component//div[@class='row component ng-scope']//select"));
		Select s = new Select(category);
		s.selectByValue("EXT-Extra");
		
		String ticket = driver.findElement(By.xpath("//div//details-categories-component//div[@class='row component ng-scope']//div//ul//li")).getText();
		System.out.println(ticket);
		
		System.out.println("--------------------------------------------------------");

		String ticket_waiting = driver.findElement(By.xpath("//div//details-categories-component//div[@class='row component ng-scope']//div//ul//li[3]")).getText();
		System.out.println(ticket_waiting);
		

		//sending ST to database class
		AllCom_database gdata=new AllCom_database();
			
			String i=gdata.opencounters();
			
			Assert.assertEquals("", i);
			
		
	}
	
	@Test
	public void Branchestopandbottom() {
		
	}
	
	@Test
	public void Tellerstopandbottom() {
		
	}
}
