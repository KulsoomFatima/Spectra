  package pageObjects;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.base;

public class branches_category extends base {

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
	
	@FindBy(xpath="//div[@class='col-md-12 categoriesSection']//select")
	WebElement categorydropdown;
	
	@FindBy(xpath="//real-time-monitoring-component//div[@class='col-xs-6']//select")
	WebElement realtimedropdown;
	
	@FindBy(xpath="//counters-component//div[@class='dataTables_length']//select")
	WebElement counterdropdown;
	
	@FindBy(xpath="//div[@id='categories-table_wrapper']//div//input[@class='form-control input-sm']")
	WebElement categorysearch;
	
	@FindBy(xpath="//div[@id='realTimeMonitoring-table_filter']//div//input[@class='form-control input-sm']")
	WebElement realtimesearch;
	
	public  HashMap<String, String> avgtime = new HashMap<String, String>();
	
	//initializing page objects
	public branches_category() throws SQLException {
		PageFactory.initElements(driver, this);
	
	}

	//Actions
	
	@Test
	public void Tellerstopandbottom_ticketsserved() throws InterruptedException, SQLException {
		Thread.sleep(5000);
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
		/*//last 30 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[2]"));
				date.click();
				System.out.println("7 days Selected");
				*/
				Thread.sleep(5000);
		Thread.sleep(6000);
		Thread.sleep(6000);
		Thread.sleep(6000);
		//select dropdown
	
		Select s =new Select(driver.findElement(By.xpath("//*[@id=\"custom-dashboard\"]/div[1]/div/div/top-teller-component/div/div[1]/div/select")));
		 s.selectByValue("Tktserved");
		 System.out.println("ticket served selected");
		 Thread.sleep(6000);
		 
		 
		Thread.sleep(5000);
	     String verticalbar = "//top-teller-component//*[name()='svg'][1]/*[name()='g']/*[@class='highcharts-series highcharts-series-0 highcharts-column-series highcharts-tracker']/*[@class='highcharts-point']";
		 String text = "//top-teller-component//div[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//span";
		 System.out.println("reading");
		 List<WebElement> barslist = driver.findElements(By.xpath(verticalbar));
		 System.out.println("Number of bars: " +barslist.size());
		// Thread.sleep(5000);
		// Thread.sleep(5000);
		// Thread.sleep(5000);
		 Actions act = new Actions(driver);
		
		 for(WebElement e : barslist) {
			 act.moveToElement(e).perform();
			 Thread.sleep(500);
			 String t = driver.findElement(By.xpath(text)).getText();
			HashMap<String, String> avgticket = new HashMap<String, String>();

			    // Add keys and values (Country, City)
			avgticket.put("", t);
			//sending ST to database class
				branchcat_database gdata=new branchcat_database();
				HashMap<String, String> i=gdata.Tellerstopandbottom_ticketsserved();
				
				System.out.println("");
			//	Assert.assertEquals(t , i);
			    
		 }
	}
	
	@Test
	public void Tellerstopandbottom_avgservicetime() throws InterruptedException, SQLException {
		
		System.out.println("Tellers top and bottom average service time");
		System.out.println("");
		System.out.println("");

		Thread.sleep(5000);
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
		/*//last 7 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[2]"));
				date.click();
				System.out.println("7 days Selected");
				
				Thread.sleep(5000);
		Thread.sleep(6000);
		Thread.sleep(6000); */
		Thread.sleep(6000);
		//select dropdown
		 
	     String verticalbar = "//top-teller-component//*[name()='svg'][1]/*[name()='g']/*[@class='highcharts-series highcharts-series-0 highcharts-column-series highcharts-tracker']/*[@class='highcharts-point']";
		 String text = "//top-teller-component//div[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//span";
		// System.out.println("reading");
		 List<WebElement> barslist = driver.findElements(By.xpath(verticalbar));
		 System.out.println("Number of bars: " +barslist.size());
		 Thread.sleep(5000);
		 Thread.sleep(5000);
		 Thread.sleep(5000);
		 Actions act = new Actions(driver);
		 for(WebElement e : barslist) {
			 act.moveToElement(e).perform();
			 Thread.sleep(500);
			
			 String t = driver.findElement(By.xpath(text)).getText();
			//System.out.println(t);
			
			// HashMap<String, String> avgtime = new HashMap<String, String>();

			    // Add keys and values (Country, City)
			    avgtime.put("", t);
			   // avgtime.put("avgservicetime", avgservicetime);
			   // System.out.println("hash map value from web "+avgtime);
			
		 
		
			//sending ST to database class
				branchcat_database gdata=new branchcat_database();
				HashMap<String, String> i=gdata.Tellerstopandbottom_avgservicetime();
				System.out.println("web: " +avgtime);
				System.out.println("db: " +i);
				
				System.out.println("");
			//	Assert.assertEquals(t , i);
			    
		 }
			 }
	
	
	
	@Test
	public void BranchestopandbottomSVC() throws SQLException, InterruptedException {
	
		System.out.println("");

		Thread.sleep(5000);
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
		/*//last 7 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[2]"));
				date.click();
				System.out.println("7 days Selected");
				
				Thread.sleep(5000);
		Thread.sleep(6000);
		Thread.sleep(6000); */
		
		Thread.sleep(6000);
		Thread.sleep(6000);
		//select dropdown
	//avg service time
		Select s =new Select(driver.findElement(By.xpath("//top-branch-component//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']")));
		 s.selectByValue("Svctime");
		 
		Thread.sleep(5000);
	     List<WebElement> graphlist = 
		 driver.findElements((By.xpath("//top-branch-component//*[name()='svg'][1]/*[name()='g']/*[@class='highcharts-series highcharts-series-0 highcharts-bar-series highcharts-tracker']")));
		 
		 String text = "//*[name()='svg'][1]/*[name()='g']/*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined'][1]";

		 Actions a = new Actions(driver);
		 System.out.print("Top category: ");
		 for(WebElement e : graphlist) {
			 a.moveToElement(e).perform();
			 Thread.sleep(500);
			
			 String t = driver.findElement(By.xpath(text)).getText();
			//System.out.println(t);
			
			// HashMap<String, String> avgtime = new HashMap<String, String>();

			    // Add keys and values (Country, City)
			    avgtime.put("", t);
			   // avgtime.put("avgservicetime", avgservicetime);
			   // System.out.println("hash map value from web "+avgtime);
			
		 
		
			//sending ST to database class
				branchcat_database gdata=new branchcat_database();
				HashMap<String, String> i=gdata.Tellerstopandbottom_avgservicetime();
				//System.out.println("web: " +avgtime);
				//System.out.println("db: " +i);
				
				System.out.println("");
			//	Assert.assertEquals(t , i);
		 }
	}
	
	@Test
	public void BranchestopandbottomWtime() throws SQLException, InterruptedException {
	

		System.out.println("");

		Thread.sleep(5000);
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
		/*//last 7 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[2]"));
				date.click();
				System.out.println("7 days Selected");
				
				Thread.sleep(5000);
		Thread.sleep(6000);
		Thread.sleep(6000); */
		
		Thread.sleep(6000);
		Thread.sleep(6000);
		//select dropdown
		
		//avg wait time
		Select s =new Select(driver.findElement(By.xpath("//top-branch-component//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']")));

		s.selectByValue("Wtime");
		 
		Thread.sleep(5000);
	     List<WebElement> graphlist = 
		 driver.findElements((By.xpath("//top-branch-component//*[name()='svg'][1]/*[name()='g']/*[@class='highcharts-series highcharts-series-0 highcharts-bar-series highcharts-tracker']")));
		 
		 String text = "//*[name()='svg'][1]/*[name()='g']/*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined'][1]";

		 Actions a = new Actions(driver);
		 System.out.print("Top category: ");
		 for(WebElement e : graphlist) {
			 a.moveToElement(e).perform();
			 Thread.sleep(500);
			
			 String t = driver.findElement(By.xpath(text)).getText();
			//System.out.println(t);
			
			// HashMap<String, String> avgtime = new HashMap<String, String>();

			    // Add keys and values (Country, City)
			    avgtime.put("", t);
			   // avgtime.put("avgservicetime", avgservicetime);
			   // System.out.println("hash map value from web "+avgtime);
			
		 
		
			//sending ST to database class
				branchcat_database gdata=new branchcat_database();
				HashMap<String, String> i=gdata.Branchestopandbottomwaittime();
				//System.out.println("web: " +avgtime);
				//System.out.println("db: " +i);
				
				System.out.println("");
			//	Assert.assertEquals(t , i);
		 }
	}
	@Test
	public void Branchestopandbottomticketserved() throws SQLException, InterruptedException {
		

		System.out.println("");

		Thread.sleep(5000);
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
		/*//last 7 days    
				driver.findElement(By.xpath("//div[@class='block-search pull-left']//div[@class='search-box pull-left']")).click();
				Thread.sleep(5000);
				WebElement date = driver.findElement(By.xpath("/html/body/div[7]/div[1]/ul/li[2]"));
				date.click();
				System.out.println("7 days Selected");
				
				Thread.sleep(5000);
		Thread.sleep(6000);
		Thread.sleep(6000); */
		
		Thread.sleep(6000);
		Thread.sleep(6000);
		//select dropdown
		
		//ticket seerved
		Select s =new Select(driver.findElement(By.xpath("//top-branch-component//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty']")));
	 
		s.selectByValue("Tktserved");
			 
		Thread.sleep(5000);
	     List<WebElement> graphlist = 
		 driver.findElements((By.xpath("//top-branch-component//*[name()='svg'][1]/*[name()='g']/*[@class='highcharts-series highcharts-series-0 highcharts-bar-series highcharts-tracker']")));
		 
		 String text = "//*[name()='svg'][1]/*[name()='g']/*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined'][1]";

		 Actions a = new Actions(driver);
		 System.out.print("Top category: ");
		 for(WebElement e : graphlist) {
			 a.moveToElement(e).perform();
			 Thread.sleep(500);
			
			 String t = driver.findElement(By.xpath(text)).getText();
			//System.out.println(t);
			
			// HashMap<String, String> avgtime = new HashMap<String, String>();

			    // Add keys and values (Country, City)
			    avgtime.put("", t);
			   // avgtime.put("avgservicetime", avgservicetime);
			   // System.out.println("hash map value from web "+avgtime);
			
		 
		
			//sending ST to database class
				branchcat_database gdata=new branchcat_database();
				HashMap<String, String> i=gdata.Tellerstopandbottom_avgservicetime();
				//System.out.println("web: " +avgtime);
				//System.out.println("db: " +i);
				
				System.out.println("");
			//	Assert.assertEquals(t , i);
		 }
				

	}
	@Test
	public void latestServey() {
		latestServey.click();
		
		//sending ST to database class
		branchcat_database gdata=new branchcat_database();
			
			String i=gdata.latestServey();
			
			//Assert.assertEquals("", i);
			
	}
	
	@Test
	public void categorydetail() throws InterruptedException, SQLException {
	
		Thread.sleep(5000);
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				Thread.sleep(500);
				

				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				
		WebElement category = driver.findElement(By.xpath("//div//details-categories-component//div[@class='row component ng-scope']//select"));
		Select s = new Select(category);
		Thread.sleep(500);
		s.selectByValue("EMO-EMOS");
		
		String ticketserved = driver.findElement(By.xpath("//div//details-categories-component//div[@class='row component ng-scope']//div//ul//li")).getText();
		System.out.println(ticketserved);
		
		String avgservicetime = driver.findElement(By.xpath("//div//details-categories-component//div[@class='row component ng-scope']//div//ul//li[1]//span[ contains(.,'0')]")).getText();
		System.out.println(avgservicetime);
		
		String targetservicetime = driver.findElement(By.xpath(ticketserved)).getText();
		System.out.println(targetservicetime);
		
		
		System.out.println("--------------------------------------------------------");

		String ticket_waiting = driver.findElement(By.xpath("//div//details-categories-component//div[@class='row component ng-scope']//div//ul//li[3]")).getText();
		System.out.println(ticket_waiting);
		
		String currentavgwaittime = driver.findElement(By.xpath(ticketserved)).getText();
		System.out.println(currentavgwaittime);
		
		String targetwaittime = driver.findElement(By.xpath(ticketserved)).getText();
		System.out.println(targetwaittime);
		

	    HashMap<String, String> catdetail = new HashMap<String, String>();

	    // Add keys and values (Country, City)
	    catdetail.put("ticket served", ticketserved);
	    catdetail.put("avg service time", avgservicetime);
	    catdetail.put("target service time", targetservicetime);
	    
	    catdetail.put("ticket waiting ", ticket_waiting);
	    catdetail.put("current avg wait time", currentavgwaittime);
	    catdetail.put("target wait time", targetwaittime);
	    
	    
	    System.out.println(catdetail);
	    System.out.println("");

		//sending ST to database class
		branchcat_database gdata=new branchcat_database();
			
			String i=gdata.category_detail();
			System.out.println(i);
			//Assert.assertEquals(catdetail, i);	
		
	}
	
	@Test
	public void categorydetailgraph() throws InterruptedException, SQLException {
	
		Thread.sleep(5000);
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				Thread.sleep(500);
				

				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
				
				//select category
				WebElement category = driver.findElement(By.xpath("//div//details-categories-component//div[@class='row component ng-scope']//select"));
				Select s = new Select(category);
				Thread.sleep(500);
				s.selectByValue("EMO-EMOS");
				Thread.sleep(5000);
				Thread.sleep(5000);
				Thread.sleep(5000);
				
			     List<WebElement> graphlist = 
				 driver.findElements(By.xpath("//details-categories-component//*[name()='svg'][1]/*[name()='g'][7]/*[name()='g'][8]/*[name()='path']"));
				 
				
				 Actions a = new Actions(driver);
				 System.out.print("Category detail graph: ");
				 for(WebElement e : graphlist) {
					 a.moveToElement(e).perform();
					
					 List<WebElement> dynamicElement = driver.findElements(By.xpath("//details-categories-component//div[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//span"));

					 if (dynamicElement.size() != 0) {
					    // System.out.println("Element present");
					     for(int i =0;i<dynamicElement.size();i++) {
					    
					     String elementText = dynamicElement.get(i).getText(); 
					     System.out.println(elementText);
					     }
					 }
				 }
					     
		//sending ST to database class
		branchcat_database gdata=new branchcat_database();
			
		List<String> i=gdata.catgraph();
		System.out.println(i);
		
	}
					 
	
	@Test
	public void Target_Compliance_Per_Category() throws InterruptedException {
		//select all
		Thread.sleep(500);
		Select g = new Select(Group);
		g.selectByValue("1036");
		

		//selecting hbl
		driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
		//click on unselect all
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
		Thread.sleep(500);
		//select hbl
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
		Thread.sleep(500);
		//driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//li[3]")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		//change sync time to 5 min 
		driver.findElement(By.xpath("//div[@class='container-fluid top-content']//div[@class='dropdown interval-dropdown']//button")).click();
		//select 5min
		
		driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//li[3]")).click();
		
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//target-compliance-component//div[@class='component-box height-lg']//h1")).getText();
		System.out.println("Heading" + heading);

		WebElement svg = driver.findElement(By.xpath("//target-compliance-component//*[name()='svg'][1]/*[name()='rect'][1]"));
		
		
		Thread.sleep(5000);
		Thread.sleep(5000);

	     List<WebElement> graphlist = 
		 driver.findElements(By.xpath("//target-compliance-component//*[name()='svg']/*[name()='g']/*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined']"));
	     Thread.sleep(5000);
	     Thread.sleep(5000);

	    // System.out.println("graphlist");
		 
		
		 Actions a = new Actions(driver);
	
		
		 for(WebElement e : graphlist) {
			// a.moveToElement(e).perform();
			 Thread.sleep(5000);
			 Thread.sleep(5000);
			List<WebElement> dynamicElement = driver.findElements(By.xpath("//target-compliance-component//div[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//span"));

			 if (dynamicElement.size() != 0) {
			     System.out.println("Element present");
			     for(int i =0;i<dynamicElement.size();i++) {
			    
			     String elementText = dynamicElement.get(i).getText(); 
			     System.out.println(elementText);

			     }
			 
		 }
		 }
		
		//sending ST to database class
			branchcat_database gdata=new branchcat_database();
					
					String j=gdata.Target_Compliance_Per_Category();
					
					//Assert.assertEquals("", i);
			     }  
	 
		 
			 
	
	@Test
	public void Average_Time_Per_Category() throws InterruptedException {
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
				Thread.sleep(500);
				//driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//li[3]")).click();
				Thread.sleep(5000);
				Thread.sleep(5000);
				//change sync time to 5 min 
				driver.findElement(By.xpath("//div[@class='container-fluid top-content']//div[@class='dropdown interval-dropdown']//button")).click();
				//select 5min
				
				driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//li[3]")).click();
				
				
				Thread.sleep(5000);
				String heading = driver.findElement(By.xpath("//avg-time-component//div[@class='component-box height-lg']//h1")).getText();
				System.out.println(heading);
				
				
				WebElement svg = driver.findElement(By.xpath("//avg-time-component//*[name()='svg'][1]/*[name()='rect'][1]"));
				Thread.sleep(5000);
				Thread.sleep(5000);

			     List<WebElement> graphlist = 
				 driver.findElements(By.xpath("//avg-time-component//*[name()='svg'][1]/*[name()='g'][7]/*[name()='g']"));
				 Actions a = new Actions(driver);
				 System.out.print("Average_Time_Per_Category: ");
				 for(WebElement e : graphlist) {
					 a.moveToElement(e).perform();
					 List<WebElement> dynamicElement = driver.findElements(By.xpath("//avg-time-component//div[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//span"));

					 if (dynamicElement.size() != 0) {
					     System.out.println("Element present");
					     for(int i =0;i<dynamicElement.size();i++) {
					    
					     String elementText = dynamicElement.get(i).getText(); 
					     System.out.println(elementText);
					 }
					 }
				 }

				//sending ST to database class
						branchcat_database gdata=new branchcat_database();
							
							String i=gdata.Average_Time_Per_Category();
							
							//Assert.assertEquals("", i);
					 
	}
	
	@Test
	public void Client_waiting_Per_Category() throws InterruptedException {
		

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
		Thread.sleep(500);
		//driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//li[3]")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		//change sync time to 5 min 
		driver.findElement(By.xpath("//div[@class='container-fluid top-content']//div[@class='dropdown interval-dropdown']//button")).click();
		//select 5min
		
		driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//li[3]")).click();
		
		
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//clients-waiting-component//div[@class='component-box height-lg']//h1")).getText();
		System.out.println(heading);
		
		//print clients
		WebElement client = driver.findElement(By.xpath("//clients-waiting-component//div[@class='highcharts-legend']//div/div"));
		System.out.println(client.getText());
		
		//print no of client waiting by category
	    String totalclientwaiting = driver.findElement(By.xpath("//clients-waiting-component//div[@class='position-bottom']//p//span")).getText();
	    System.out.println("Total client waiting: " + totalclientwaiting);
	    

		//sending ST to database class
	    
	    
	    // SP NOT FOUND
				branchcat_database gdata=new branchcat_database();
					
					//String i=gdata.Client_waiting_Per_Category();
					
					//Assert.assertEquals("", i);
	}
	
	@Test
	public void Service_Rate_Per_Category() throws InterruptedException {
		

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
		Thread.sleep(500);
		//driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//li[3]")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		//change sync time to 5 min 
		driver.findElement(By.xpath("//div[@class='container-fluid top-content']//div[@class='dropdown interval-dropdown']//button")).click();
		//select 5min
		
		driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//li[3]")).click();
		
		
		Thread.sleep(5000);
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//service-rate-component/div[@class='component-box height-lg']//h1")).getText();
		System.out.println(heading);
		
		//print clients
		WebElement client = driver.findElement(By.xpath("//service-rate-component//div[@class='highcharts-legend']//div/div"));
		System.out.println(client.getText());
		
		//print no of client waiting by category
	    String ticketservedperhour = driver.findElement(By.xpath("//service-rate-component//div[@class='position-bottom']//p//span")).getText();
	    System.out.println("Total client waiting: " + ticketservedperhour);
		
//INCOMPLETE QUERY
		//sending ST to database class
				branchcat_database gdata=new branchcat_database();
					
					//String i=gdata.Service_Rate_Per_Category();
					
					//Assert.assertEquals("", i);
	}
	
	
	@Test
	public void Client_Served_Per_Category() throws InterruptedException{
		

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
		Thread.sleep(500);
		//driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//li[3]")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		//change sync time to 5 min 
		driver.findElement(By.xpath("//div[@class='container-fluid top-content']//div[@class='dropdown interval-dropdown']//button")).click();
		//select 5min
		
		driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//li[3]")).click();
		
		
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//clients-served-component//div[@class='component-box height-lg']//h1")).getText();
		System.out.println(heading);
		
		//print clients
		WebElement client = driver.findElement(By.xpath("//clients-served-component//div[@class='highcharts-legend']//div/div"));
		System.out.println(client.getText());
		
		//print no of client served by category
		String clientserved = driver.findElement(By.xpath("//clients-served-component//div[@class='position-bottom']//p//span")).getText();
		System.out.println("Total client served: " + clientserved);
		
		//NO SP

		//sending ST to database class
				branchcat_database gdata=new branchcat_database();
					
					String i=gdata.Client_Served_Per_Category();
					
					//Assert.assertEquals("", i);
	}
	
	
	@Test
	public void categories() throws InterruptedException {
	
		//not in use 
		/*	Thread.sleep(5000);
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				Thread.sleep(5000);
		//only for today date
	   
				Select s = new Select(categorydropdown);
				s.selectByIndex(1);
		
		Thread.sleep(5000);
	//print table heading
		String table_heading = driver.findElement(By.xpath("//table[@id='categories-table']//tr[@role='row']")).getText();
		System.out.println(table_heading);
		
		Thread.sleep(5000);
		
	//category name 
		String branch = driver.findElement(By.xpath("//table[@id='categories-table']//tr//td[2]")).getText();
		System.out.println("Branch= " + branch);
		
	//client in waiting
		String branchinfo = driver.findElement(By.xpath("//table[@id='categories-table']//tr//td[3]")).getText();
		System.out.println("Branch info= " + branchinfo);
		
	//avg wait time
		String last_updated = driver.findElement(By.xpath("//table[@id='categories-table']//tr//td[4]")).getText();
		System.out.println("last updated at= " + last_updated);
		
	//target wait time
		String Status = driver.findElement(By.xpath("//table[@id='categories-table']//tr//td[5]")).getText();
		System.out.println("Status = " + Status);
		
	//active tickets
		String active_tickets = driver.findElement(By.xpath("//table[@id='categories-table']//tr//td[6]")).getText();
		System.out.println("Status = " + active_tickets);
				
	//wait KPI
		String waitKPI = driver.findElement(By.xpath("//table[@id='categories-table']//tr//td[7]")).getText();
		System.out.println("Status = " + waitKPI);
		
	//search input
		categorysearch.sendKeys("hello");
		Thread.sleep(5000);
		//verify the search result text
		String tablesearxchresult = driver.findElement(By.xpath("//table[@id='categories-table']//tr[1]//td")).getText();
		System.out.println("Search result:" + tablesearxchresult);
		
	//pagination
		
	//Firstbutton 
		WebElement first = driver.findElement(By.xpath("//div[@id='categories-table_paginate']//a[@class='first']"));
		first.click();
		
	//previous
		WebElement previous = driver.findElement(By.xpath("//div[@id='categories-table_paginate']//a[@class='previous']"));
		previous.click();
		
	//next
		WebElement next = driver.findElement(By.xpath("//div[@id='categories-table_paginatee']//a[@class='next']"));
		next.click();
		
	//last
		WebElement last = driver.findElement(By.xpath("//div[@id='categories-table_paginate']//a[@class='last']"));
		last.click();
		
	/*	//page no
		WebElement pageno = driver.findElement(By.xpath("//div[@id='hardwareMonitoringTabular-table_paginate']//li[@class='active']//a"));
		System.out.println("Current page no: " + pageno.getText());
		*/
		
/*
		//sending ST to database class
				branchcat_database gdata=new branchcat_database();
					
					String i=gdata.categories();
					
					//Assert.assertEquals("", i);
		
		*/
	}
	

	@Test
	public void realtime_monitoring() throws InterruptedException {
		Thread.sleep(5000);
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				Thread.sleep(5000);
		//only for today date
	   
				Select s = new Select(realtimedropdown);
				s.selectByIndex(1);
		
		Thread.sleep(5000);
	//print table heading
		String table_heading = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr")).getText();
		System.out.println(table_heading);
		
		Thread.sleep(5000);
		
	//category name 
		String branch = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr//td[1]")).getText();
		System.out.println("Branch= " + branch);
		
	//status
		String Status = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr//td[2]")).getText();
		System.out.println("Status= " + Status);
		
	//ticket issue
		String ticketissued = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr//td[3]")).getText();
		System.out.println("ticketissued= " + ticketissued);
		
	//ticket served
		String ticketserved = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr//td[4]")).getText();
		System.out.println("ticket served = " + ticketserved);
		
	//tickets waiting
		String ticketswaiting = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr//td[5]")).getText();
		System.out.println("tickets waiting = " + ticketswaiting);
				
	//total counter
		String total_counter = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr//td[6]")).getText();
		System.out.println("total counter = " + total_counter);
		
		//active counter
		String active_counter = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr//td[7]")).getText();
		System.out.println("active_counter = " + active_counter);
		
		//avg service time
		String avgservicetime = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr//td[8]")).getText();
		System.out.println("avg service time = " + avgservicetime);

		//avg wait time
		String avgwaittime = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr//td[9]")).getText();
		System.out.println("avg wait time = " + avgwaittime);

		//max service time
		String maxservicetime = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr//td[10]")).getText();
		System.out.println("avg wait time = " + maxservicetime);

		//max wait time
		String maxwaittime = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr//td[11]")).getText();
		System.out.println("max wait time = " + maxwaittime);

		//service level
		String servicelevel = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr//td[12]")).getText();
		System.out.println("service level = " + servicelevel);
		
		
		
	//search input
		realtimesearch.sendKeys("hello");
		Thread.sleep(5000);
		//verify the search result text
		String tablesearxchresult = driver.findElement(By.xpath("//table[@id='realTimeMonitoring-table']//tr[1]//td")).getText();
		System.out.println("Search result:" + tablesearxchresult);
		
	//pagination
		
	//Firstbutton 
		WebElement first = driver.findElement(By.xpath("//div[@id='realTimeMonitoring-table_paginate']//a[@class='first']"));
		first.click();
		
	//previous
		WebElement previous = driver.findElement(By.xpath("//div[@id='realTimeMonitoring-table_paginate']//a[@class='previous']"));
		previous.click();
		
	//next
		WebElement next = driver.findElement(By.xpath("//div[@id='realTimeMonitoring-table_paginatee']//a[@class='next']"));
		next.click();
		
	//last
		WebElement last = driver.findElement(By.xpath("//div[@id='realTimeMonitoring-table_paginate']//a[@class='last']"));
		last.click();
		
	/*	//page no
		WebElement pageno = driver.findElement(By.xpath("//div[@id='hardwareMonitoringTabular-table_paginate']//li[@class='active']//a"));
		System.out.println("Current page no: " + pageno.getText());
		*/
		

		//sending ST to database class
				branchcat_database gdata=new branchcat_database();
					
					String i=gdata.realtime_monitoring();
					//System.out.println();
					
					//Assert.assertEquals("", i);
		
		
	}

	@Test
	public void counters() throws InterruptedException {
		Thread.sleep(5000);
		//select all
				Select g = new Select(Group);
				g.selectByValue("1036");
				
				Thread.sleep(5000);
		//only for today date
	   
				Select s = new Select(counterdropdown);
				s.selectByIndex(1);
		
		Thread.sleep(5000);
	//print table heading
		String table_heading = driver.findElement(By.xpath("//table[@id='counters-table']//tr[@role='row']")).getText();
		System.out.println(table_heading);
		
		Thread.sleep(5000);
		
	//counter no
		String counterno = driver.findElement(By.xpath("//table[@id='counters-table']//tr//td[1]")).getText();
		System.out.println("Branch= " + counterno);
		
	//status
		String Status = driver.findElement(By.xpath("//table[@id='counters-table']//tr//td[2]")).getText();
		System.out.println("Status= " + Status);
		
	//teller
		String teller = driver.findElement(By.xpath("//table[@id='counters-table']//tr//td[3]")).getText();
		System.out.println("ticketissued= " + teller);
		
	//avg service time
		String avgservicetime = driver.findElement(By.xpath("//table[@id='counters-table']//tr//td[4]")).getText();
		System.out.println("avg service time = " + avgservicetime);

	//branch
		String branch = driver.findElement(By.xpath("//table[@id='counters-table']//tr//td[5]")).getText();
		System.out.println("avg wait time = " + branch);
		
		
	//search input
		realtimesearch.sendKeys("hello");
		Thread.sleep(5000);
		//verify the search result text
		String tablesearxchresult = driver.findElement(By.xpath("//table[@id='counters-table']//tr[1]//td")).getText();
		System.out.println("Search result:" + tablesearxchresult);
		
	//pagination
		
	//Firstbutton 
		WebElement first = driver.findElement(By.xpath("//div[@id='counters-table_paginate']//a[@class='first']"));
		first.click();
		
	//previous
		WebElement previous = driver.findElement(By.xpath("//div[@id='counters-table_paginate']//a[@class='previous']"));
		previous.click();
		
	//next
		WebElement next = driver.findElement(By.xpath("//div[@id='counters-table_paginatee']//a[@class='next']"));
		next.click();
		
	//last
		WebElement last = driver.findElement(By.xpath("//div[@id='counters-table_paginate']//a[@class='last']"));
		last.click();
		
	/*	//page no
		WebElement pageno = driver.findElement(By.xpath("//div[@id='hardwareMonitoringTabular-table_paginate']//li[@class='active']//a"));
		System.out.println("Current page no: " + pageno.getText());
		*/
		

		//sending ST to database class
				branchcat_database gdata=new branchcat_database();
					
					String i=gdata.counters();
					
					//Assert.assertEquals("", i);
	}
	

	
	@Test
	public void Tellergroup() throws InterruptedException {

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
		Thread.sleep(500);
		//driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//li[3]")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		//change sync time to 5 min 
		driver.findElement(By.xpath("//div[@class='container-fluid top-content']//div[@class='dropdown interval-dropdown']//button")).click();
		//select 5min
		
		driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right']//li[3]")).click();
		
		
		Thread.sleep(5000);
		//teller heading
		String heading = driver.findElement(By.xpath("//tellers-component//div[@class='col-sm-12']//div[@class='component-box']//h1[@class='ng-binding'][1]")).getText();
		System.out.println("Heading= " +heading);
		//click on orderby
		driver.findElement(By.xpath("//tellers-component//div[@class='dropdown pull-left']")).click();
		
		//select name
		driver.findElement(By.xpath("//tellers-component//div[@class='dropdown pull-left open']//ul//li[1]"));
		
		//telling name / heading
		String tellerinfo = driver.findElement(By.xpath("//tellers-component//div[@class='teller-box text-center cursor-pointer']//h1")).getText();
		System.out.println(tellerinfo);
		
		//branch
				String branch = driver.findElement(By.xpath("//tellers-component//div[@class='teller-box text-center cursor-pointer']//h2")).getText();
				System.out.println(branch);
		
		//percentage
				String percentage = driver.findElement(By.xpath("//tellers-component//div[@class='teller-box text-center cursor-pointer']//h3")).getText();
				System.out.println("SLA: " +percentage);
				
		//ticket served
		 String ticketserved = driver.findElement(By.xpath("//tellers-component//div[@class='teller-box text-center cursor-pointer']//li//span")).getText();
		 System.out.println("TICKET(S) SERVED: " +ticketserved);
		

			//sending ST to database class
					branchcat_database gdata=new branchcat_database();
						
						String i=gdata.Tellergroup();
						
						//Assert.assertEquals(percentage, i);
		
	}
	
	
	@Test
	public void Clients_waiting_Per_Category() throws InterruptedException {
		//select all
		Thread.sleep(500);
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
		
		
		
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//target-compliance-component//div[@class='component-box height-lg']//h1")).getText();
		System.out.println("Heading" + heading);

		WebElement svg = driver.findElement(By.xpath("//target-compliance-component//*[name()='svg'][1]/*[name()='rect'][1]"));
		
		
		Thread.sleep(5000);
		Thread.sleep(5000);

	     List<WebElement> graphlist = 
		 driver.findElements(By.xpath("//target-compliance-component//*[name()='svg']/*[name()='g']/*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined']"));
	     Thread.sleep(5000);
	     Thread.sleep(5000);

	    // System.out.println("graphlist");
		 
		
		 Actions a = new Actions(driver);
	
		
		 for(WebElement e : graphlist) {
			 a.moveToElement(e).perform();
			 Thread.sleep(5000);
			 Thread.sleep(5000);
			List<WebElement> dynamicElement = driver.findElements(By.xpath("//target-compliance-component//div[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//span"));

			 if (dynamicElement.size() != 0) {
			     System.out.println("Element present");
			     for(int i =0;i<dynamicElement.size();i++) {
			    
			     String elementText = dynamicElement.get(i).getText(); 
			     System.out.println(elementText);

			     }
			 }
		 }
		
		//sending ST to database class
				/*branchcat_database gdata=new branchcat_database();
					
					String j=gdata.Target_Compliance_Per_Category();
					
					//Assert.assertEquals("", i);
			     }  */
			 }


	@Test
	public void Servicee_Rate_Per_Category() throws InterruptedException {
		//select all
		Thread.sleep(500);
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
		
		
		
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//target-compliance-component//div[@class='component-box height-lg']//h1")).getText();
		System.out.println("Heading" + heading);

		WebElement svg = driver.findElement(By.xpath("//target-compliance-component//*[name()='svg'][1]/*[name()='rect'][1]"));
		
		
		Thread.sleep(5000);
		Thread.sleep(5000);

	     List<WebElement> graphlist = 
		 driver.findElements(By.xpath("//target-compliance-component//*[name()='svg']/*[name()='g']/*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined']"));
	     Thread.sleep(5000);
	     Thread.sleep(5000);

	    // System.out.println("graphlist");
		 
		
		 Actions a = new Actions(driver);
	
		
		 for(WebElement e : graphlist) {
			 a.moveToElement(e).perform();
			 Thread.sleep(5000);
			 Thread.sleep(5000);
			List<WebElement> dynamicElement = driver.findElements(By.xpath("//target-compliance-component//div[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//span"));

			 if (dynamicElement.size() != 0) {
			     System.out.println("Element present");
			     for(int i =0;i<dynamicElement.size();i++) {
			    
			     String elementText = dynamicElement.get(i).getText(); 
			     System.out.println(elementText);

			     }
			 }
		 }
		
		//sending ST to database class
				/*branchcat_database gdata=new branchcat_database();
					
					String j=gdata.Target_Compliance_Per_Category();
					
					//Assert.assertEquals("", i);
			     }  */
			 }



}
