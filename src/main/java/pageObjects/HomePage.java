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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.base;

public class HomePage extends base {

	//ExtentReports extent;
	//WebDriver driver;

	//page factory 
	@FindBy(xpath="/html/body/div[3]/div/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[1]/select")
	WebElement Group;

	@FindBy(xpath="/html/body/div[3]/div/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[2]/branchfilter-component/div/div/am-multiselect/div/button/span[1]")
	WebElement RegionBranches;

	@FindBy(xpath="	//div[@class='search-box pull-left']//input\r\n"
			+ " ")
	WebElement Calendar;
	
	//div[@class='search-box pull-left']//input

	@FindBy(xpath="//*[@id=\"avatarTop\"]/div/span[1]/button")
	WebElement ActivityLog;
	
	@FindBy(xpath="//*[@id=\"avatarTop\"]/div/span[2]/button")
	WebElement Alerts;
	
	@FindBy(xpath="//*[@id=\"lgout\"]")
	WebElement logout;
	
	@FindBy(xpath="//li[@class='active'][normalize-space()='Last 7 days']")
	WebElement last7days;
	
	@FindBy(xpath="")
	WebElement lastupdated;
	
	
	@FindBy(xpath="(//*[local-name()='svg' and @class='highcharts-root'])[1]/*[@class='highcharts-plot-bands-0']/*")
	WebElement servicesvg;

	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/ul[3]/li[1]/a[1]")
	WebElement allcomponents;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/ul[2]/li[1]/a[1]")
	WebElement servicewaiting;
	
	@FindBy(xpath="//div[@class='ng-scope']//li[@class='ng-scope'][2]")
	WebElement hardwaremonitoring;
	
	@FindBy(xpath="//div[@class='ng-scope']//li[@class='ng-scope'][3]")
	WebElement branches_category;
	
	@FindBy(xpath="//li[@id='dashboardToolTip']//h5[@class='display-480 ng-binding']")
	WebElement reports;
	
	@FindBy(xpath="//div[@class='scroll-horizontal']//ul//li[1]")
	WebElement serviceperformnce;
	
	@FindBy(xpath="//div[@class='scroll-horizontal']//ul//li[2]")
	WebElement Tellerperformnce;
	
	
	
	//initializing page objects
	public HomePage() throws SQLException {
		PageFactory.initElements(driver, this);
	
	}
	public allcomponents ClickallcomponentsTest() throws SQLException, InterruptedException {
		
		Thread.sleep(5000);
		allcomponents.click();
		return new allcomponents();
	}
	
	public service_waiting servicewaitingcounter() throws SQLException, InterruptedException {
		
		Thread.sleep(5000);
		servicewaiting.click();
		return new service_waiting();
	}
	
	public pageObjects.hardware_monitoring hardware_monitoring() throws SQLException, InterruptedException {
		
		Thread.sleep(5000);
		hardwaremonitoring.click();
		return new hardware_monitoring();
	}
	
	public pageObjects.branches_category branches_category() throws SQLException, InterruptedException {
		
		Thread.sleep(5000);
		branches_category.click();
		return new branches_category();
	}
	
	public serviceSummary serviceReport() throws InterruptedException, SQLException {
	// TODO Auto-generated method stub
		
		Thread.sleep(5000);
	
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/img[1]")).click();
		//reports.click();
		serviceperformnce.click();
		return new serviceSummary();
}
	public pageObjects.serviceQuality serviceQuality() throws InterruptedException, SQLException {
	// TODO Auto-generated method stub
		
		Thread.sleep(5000);
	
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/img[1]")).click();
		//reports.click();
		serviceperformnce.click();
		Thread.sleep(5000);
		//click quality
		driver.findElement(By.xpath("//ul[@class='nav big-tabs nav-tabs']//li[2]")).click();
		Thread.sleep(5000);
		System.out.println("service click");
		return new serviceQuality();
	}
	
	public serviceBranches serviceBranches() throws InterruptedException, SQLException {
		// TODO Auto-generated method stub

		Thread.sleep(5000);
	
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/img[1]")).click();
		//reports.click();
		serviceperformnce.click();
		Thread.sleep(5000);
		//click quality
		driver.findElement(By.xpath("//ul[@class='nav big-tabs nav-tabs']//li[3]")).click();
		Thread.sleep(5000);
		System.out.println("Branches click");
		return new serviceBranches();
	}
	
	public serviceMattercode serviceMattercode() throws InterruptedException, SQLException {
		// TODO Auto-generated method stub

		Thread.sleep(5000);
	
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/img[1]")).click();
		//reports.click();
		serviceperformnce.click();
		Thread.sleep(5000);
		//click quality
		driver.findElement(By.xpath("//ul[@class='nav big-tabs nav-tabs']//li[4]")).click();
		Thread.sleep(5000);
		System.out.println("Matter code click");
		return new serviceMattercode();
	}
	
	public pageObjects.servicehourly servicehourly() throws SQLException, InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/img[1]")).click();
		//reports.click();
		serviceperformnce.click();
		Thread.sleep(5000);
		//click quality
		driver.findElement(By.xpath("//ul[@class='nav big-tabs nav-tabs']//li[5]")).click();
		Thread.sleep(5000);
		System.out.println("Matter code click");
		return new servicehourly();
	}
	
	
	public pageObjects.TellerSummary TellerSummary() throws SQLException, InterruptedException {
		// TODO Auto-generated method stub
		//Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(500);

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/img[1]")).click();
		Thread.sleep(500);
		Thread.sleep(5000);

		Tellerperformnce.click();
		Thread.sleep(5000);
		System.out.println("Teller performnce click");
		return new TellerSummary();
	}
	
	public TellerAttendence TellerAttendence() throws InterruptedException, SQLException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/img[1]")).click();
		Thread.sleep(500);
		Thread.sleep(5000);

		Tellerperformnce.click();
		driver.findElement(By.xpath("//ul[@class='nav big-tabs nav-tabs']//li[2]")).click();
		Thread.sleep(5000);
		System.out.println("Teller Attendence performnce click");
		return new TellerAttendence();
	}
	
	public TellerCategory TellerCategory() throws InterruptedException, SQLException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/img[1]")).click();
		Thread.sleep(500);
		Thread.sleep(5000);

		Tellerperformnce.click();
		driver.findElement(By.xpath("//ul[@class='nav big-tabs nav-tabs']//li[3]")).click();
		Thread.sleep(5000);
		System.out.println("Teller Category performnce click");
		return new TellerCategory();
		
	}
	
	public TellerDaily TellerDaily() throws InterruptedException, SQLException {
		// TODO Auto-generated method stub
	   Thread.sleep(5000);
	   Thread.sleep(5000);

	   Thread.sleep(5000);

		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/img[1]")).click();
		Thread.sleep(500);
		Thread.sleep(5000);

		Tellerperformnce.click();
		driver.findElement(By.xpath("//ul[@class='nav big-tabs nav-tabs']//li[4]")).click();
		Thread.sleep(5000);
		System.out.println("Teller Daily performnce click");
		return new TellerDaily();	
		}

	public TellerActivity TellerActivity() throws InterruptedException, SQLException {
		// TODO Auto-generated method stub
		 Thread.sleep(5000);
			
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/img[1]")).click();
			Thread.sleep(500);
			Thread.sleep(5000);

			Tellerperformnce.click();
			driver.findElement(By.xpath("//ul[@class='nav big-tabs nav-tabs']//li[5]")).click();
			Thread.sleep(5000);
			System.out.println("Teller Daily performnce click");
			return new TellerActivity();
			}
	
	public TellerResp TellerResp() throws InterruptedException, SQLException {
		// TODO Auto-generated method stub
		 Thread.sleep(5000);
			Thread.sleep(500);

			
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/img[1]")).click();
			Thread.sleep(500);
			Thread.sleep(5000);

			Tellerperformnce.click();
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);

		//	driver.findElement(By.xpath("//*[@id='sectionContent']/div[1]/div/ul/li[6]")).click();
			Thread.sleep(5000);
			System.out.println("Teller Resp performnce click");
			return new TellerResp();	
			}
	
	public TellerCustomerfeedback TellerCustomerfeedback() throws InterruptedException, SQLException {
		// TODO Auto-generated method stub
		
		 Thread.sleep(5000);
			Thread.sleep(500);

			
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/ul[1]/li[2]/a[1]/img[1]")).click();
			Thread.sleep(500);
			Thread.sleep(5000);

			Tellerperformnce.click();
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);

		//	driver.findElement(By.xpath("//*[@id='sectionContent']/div[1]/div/ul/li[6]")).click();
			Thread.sleep(5000);
			System.out.println("Teller customer feedback performnce click");
			return new TellerCustomerfeedback();	
			}
	
	//Actions
	@Test
	public void service() throws InterruptedException, SQLException {
		int Service ;
		
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
		
		System.out.println("Starting service testcase");
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      
	      

		//String serviceheading = driver.findElement(By.xpath("//*[@id=\"sectionContent\"]/div[2]/div[1]/service-component/div/h1")).getText();
		//System.out.println(serviceheading);
		
		//svg tag    
		WebElement servicesvg = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[1]"));
		
		// gauge %
		String guagepercentage = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[1]/div/div/div/div/span/div/div[1]")).getText();
		System.out.println(guagepercentage);
		
		//guage no
		String guagename = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[1]/div/div/div/div/span/div/div[2]")).getText();
		System.out.println(guagename);
		
		//total client served reading
		String CS = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[2]/p[1]")).getText();
		System.out.println(CS); 
		
		//avg service time
		String ST = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[2]/p[2]")).getText();
		System.out.println(ST);
		
		
	}
	
	//test case 29 "Test to verify the Service Compliance % when ticket is served and no any state and percentage is showing for Today on assigned 1 Branch and 1 Category."
	@Test
	public void serviceCal() throws InterruptedException, SQLException {
		
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
		
		System.out.println("Starting service calculation");
		Thread.sleep(5000);

		Thread.sleep(5000);
		String servicePercentage = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[1]/div/div/div/div/span/div/div[1]")).getText();
		System.out.println("Service compliance= " + servicePercentage);
	
		  //clik on group
		Thread.sleep(5000);
		Thread.sleep(500);
		String no_of_ticket = driver.findElement(By.xpath("//*[@id=\"sectionContent\"]/div[2]/div[1]/service-component/div/div/div[2]/p[1]/span")).getText();
		int j=Integer.parseInt(no_of_ticket);  
		System.out.println("No of tickets:  " + no_of_ticket);
		
		Thread.sleep(500);
	
		String total_served_tickets = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[2]/p[2]/span")).getText();
		System.out.println("Avg. Service Time:  " + total_served_tickets);

		
		//sending ST to database class
			homepage_database gdata=new homepage_database();
			
			//double i=gdata.test();
			//String com = i+"%";

			//Assert.assertEquals(servicePercentage, com);
			
			
			
			/*
// converting into mili seconds
		
		String[] parts = total_served_tickets.split(":");
		String hour = parts[0]; 
		String mintues = parts[1];
		String seconds = parts[2];
		
		String str = total_served_tickets;
        String[] arrOfStr = str.split(":", 3  );
  
        for (String a : arrOfStr)
            System.out.println(a);
        double dhour = Double.parseDouble(hour);
        double dmintues = Double.parseDouble(mintues);
        double dseconds = Double.parseDouble(seconds);
        
        double actualtime = ((dhour*60*60) + (dmintues*60) +dseconds);
		 	System.out.println("Check time here "+ actualtime );
		 	
		 	
		 	double kip_time;
		 	kip_time=120*j;
		 	
		 	double result = (kip_time/(actualtime))*100; 
		 	
		 	System.out.println("Check percentage % "+ result );
		 	
		 	*/
		 	

	}
	
	//test case 30 "Test to verify the Service Compliance % when ticket is served and no any state and percentage is showing for Last 7 Days on assigned 1 Branch and 1 Category."
	@Test
	public void service_cal_7days_allgroup() throws InterruptedException, SQLException {
		System.out.println("Starting service calculation fo 7 days");
		Thread.sleep(5000);
//
//		Thread.sleep(5000);
//		Select s = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]")));
//				
//		s.selectByValue("1036");
//		Thread.sleep(5000);
//		
//		Calendar.click();
//		Thread.sleep(5000);
//		//last7days.click();
//		driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/ul[1]/li[2]")).click();
//		
//		
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
				
		// calculating service complaince 
		Thread.sleep(5000);
		String servicePercentage = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[1]/div/div/div/div/span/div/div[1]")).getText();
		System.out.println("Service compliance %=" + servicePercentage);
		int Service ;
		System.out.println("");
	
		  //clik on group
		Thread.sleep(5000);
		Thread.sleep(500);
		String no_of_ticket = driver.findElement(By.xpath("//*[@id=\"sectionContent\"]/div[2]/div[1]/service-component/div/div/div[2]/p[1]/span")).getText();
		int j=Integer.parseInt(no_of_ticket);  
		System.out.println("No of tickets:  " + no_of_ticket);
		
		Thread.sleep(500);
	
		String total_served_tickets = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[2]/p[2]/span")).getText();
		System.out.println("Avg. Service Time:  " + total_served_tickets);

		
		//sending ST to database class
			/*database gdata=new database();
			
			double i=gdata.test();
			String com = i+"%";

			Assert.assertEquals(servicePercentage, com);
			*/
	}
	
	//test case 31 "Test to verify the Service Compliance % when ticket is served and no any state and percentage is showing for Last 30 Days on assigned 1 Branch and 1 Category."
	@Test
	public void servic_cal_30thdays_allgroup() throws InterruptedException {
	
	
	System.out.println("Starting service calculation fo 30 days");
	Thread.sleep(5000);

	//select all group
	Thread.sleep(5000);
	Select s = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]")));		
	s.selectByValue("1036");
	Thread.sleep(5000);
	

			//selecting hbl
			driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
			//click on unselect all
			driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
			Thread.sleep(500);
			//select hbl
			driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
			Thread.sleep(5000);
	
//	Calendar.click();
//	Thread.sleep(5000);
//	//30 days
//	driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/ul[1]/li[3]")).click();
//	
	
	// calculating service compliance 
	Thread.sleep(5000);
	String servicePercentage = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[1]/div/div/div/div/span/div/div[1]")).getText();
	System.out.println("Service compliance %=" + servicePercentage);
	int Service ;
	System.out.println("");

	  //clik on group
	Thread.sleep(5000);
	Thread.sleep(500);
	String no_of_ticket = driver.findElement(By.xpath("//*[@id=\"sectionContent\"]/div[2]/div[1]/service-component/div/div/div[2]/p[1]/span")).getText();
	int j=Integer.parseInt(no_of_ticket);  
	System.out.println("No of tickets:  " + no_of_ticket);
	
	Thread.sleep(500);

	String total_served_tickets = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[2]/p[2]/span")).getText();
	System.out.println("Avg. Service Time:  " + total_served_tickets);

	
	//sending ST to database class
		/*database gdata=new database();
		
		double i=gdata.test();
		String com = i+"%";

		Assert.assertEquals(servicePercentage, com);
		*/
	}

	//test case 32 "Test to verify the Service Compliance % when ticket is served and no any state and percentage is showinig for Custom Date Range on assigned 1 Branch and 1 Category.
	@Test
	public void servic_cal_custom_days_allgroup() throws InterruptedException {
		
	System.out.println("Starting service calculation fo 30 days");
	Thread.sleep(5000);

	//select all group
	Thread.sleep(5000);
	Select s = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]")));		
	s.selectByValue("1036");
	Thread.sleep(5000);
	
	Calendar.click();
	Thread.sleep(5000);
	//30 days
	driver.findElement(By.xpath("")).click();
	
	
	// calculating service compliance 
	Thread.sleep(5000);
	String servicePercentage = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[1]/div/div/div/div/span/div/div[1]")).getText();
	System.out.println("Service compliance %=" + servicePercentage);
	int Service ;
	System.out.println("");

	  //clik on group
	Thread.sleep(5000);
	Thread.sleep(500);
	String no_of_ticket = driver.findElement(By.xpath("//*[@id=\"sectionContent\"]/div[2]/div[1]/service-component/div/div/div[2]/p[1]/span")).getText();
	int j=Integer.parseInt(no_of_ticket);  
	System.out.println("No of tickets:  " + no_of_ticket);
	
	Thread.sleep(500);

	String total_served_tickets = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[2]/p[2]/span")).getText();
	System.out.println("Avg. Service Time:  " + total_served_tickets);

	
	//sending ST to database class
		/*database gdata=new database();
		
		double i=gdata.test();
		String com = i+"%";

		Assert.assertEquals(servicePercentage, com);
		*/
	}

	//test case 41 Test to verify the Service Compliance % when it is in Normal state for Today on assigned 1 Branch and 1 Category. (suppose: 71% - 100% > Green)
	@Test
	public void green_colour1_49_today() throws InterruptedException{
	
		System.out.println("Starting service calculation fo 7 days");
		Thread.sleep(5000);

		Thread.sleep(5000);
		Select s = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]")));
				
		s.selectByValue("1036");
		Thread.sleep(5000);
		
		Calendar.click();
		Thread.sleep(5000);
		//last7days.click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/ul[1]/li[2]")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String servicePercentage = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[1]/div/div/div/div/span/div/div[1]")).getText();
		System.out.println(servicePercentage);
		 // int i = Integer.parseInt(servicePercentage);
	
		//String a = servicePercentage.split("%");
	//	System.out.println("String at :" +  a);
		
		// Integer number = Integer.valueOf(a[0]);
		//int i = Integer.parseInte(a);
		//System.out.println("A is A :" +  number);
	     String[] splits = servicePercentage.split("%");
	     int chk = 0;
	       for(int i=0; i<splits.length;i++) {
	    		   
	           System.out.println("loop "+i+" : "+splits[i]);
            chk= Integer.parseInt(splits[0]);
//	            int l = splits;
	        }
	       
	       System.out.println("outsid loop "+" : "+chk);
	       
	       
	       
	
		//int i = Integer.parseInt(splits);
		

		if (chk >= 71) {
		String expectedGreen = "#e0e3e5";
		WebElement servicesvg = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[1]/*[@class='highcharts-plot-bands-0']/*"));
		String guage = servicesvg.getCssValue("fill");
		String hexcolor = Color.fromString(guage).asHex();
		System.out.println("green");
		Assert.assertEquals(expectedGreen, hexcolor);
		}
		else if (chk >= 50){
		String expectedRed = "#fd5254";
		//WebElement servicesvg = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[1]/*[@class='highcharts-plot-bands-0']/*"));
		String Rguage = servicesvg.getCssValue("fill");
		String Rhexcolor = Color.fromString(Rguage).asHex();
		System.out.println(Rhexcolor);
		Assert.assertEquals(expectedRed, Rhexcolor);
		
		}
		
		else {
			String expectedYellow = "#FFEA00";
	//WebElement servicesvg = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[1]/*[@class='highcharts-plot-bands-0']/*"));
		String Yguage = servicesvg.getCssValue("fill");
		String Yhexcolor = Color.fromString(Yguage).asHex();
		System.out.println(Yhexcolor);
	Assert.assertEquals(expectedYellow, Yhexcolor); 
		}
	
	}

	//test case 42 Test to verify the Service Compliance % when it is in Normal state for Today on assigned 1 Branch and 1 Category. (suppose: 71% - 100% > Green) - 7 days
	@Test
	public void green_colour1_49_7days() throws InterruptedException{
	
	
		
		System.out.println("Starting service calculation fo 7 days");
		Thread.sleep(5000);

		Thread.sleep(5000);
		Select s = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]")));
				
		s.selectByValue("1036");
		Thread.sleep(5000);
		
		Calendar.click();
		Thread.sleep(5000);
		//last7days.click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/ul[1]/li[2]")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String servicePercentage = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[1]/div/div/div/div/span/div/div[1]")).getText();
		System.out.println(servicePercentage);
	
	     String[] splits = servicePercentage.split("%");
	        for(int i=0; i<splits.length;i++) {
	            System.out.println(splits[i]);
	         //   int l = splits;
	        }
		
		//int i = Integer.parseInt(splits);
		
		
		//if (splits >= 71) {
		String expectedGreen = "#e0e3e5";
		WebElement servicesvg = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[1]/*[@class='highcharts-plot-bands-0']/*"));
		String guage = servicesvg.getCssValue("fill");
		String hexcolor = Color.fromString(guage).asHex();
		System.out.println(hexcolor);
		
		Assert.assertEquals(expectedGreen, hexcolor);
	//	}
	}

	//test case 43 Test to verify the Service Compliance % when it is in Normal state for Today on assigned 1 Branch and 1 Category. (suppose: 71% - 100% > Green) - 30 days 
	@Test
	public void green_colour1_49_30days() throws InterruptedException{
		
		System.out.println("Starting service calculation fo 7 days");
		Thread.sleep(5000);

		Thread.sleep(5000);
		Select s = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]")));
				
		s.selectByValue("1036");
		Thread.sleep(5000);
		
		Calendar.click();
		Thread.sleep(5000);
		//last7days.click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/ul[1]/li[2]")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String servicePercentage = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[1]/service-component/div/div/div[1]/div/div/div/div/span/div/div[1]")).getText();
		System.out.println(servicePercentage);
	
	     String[] splits = servicePercentage.split("%");
	        for(int i=0; i<splits.length;i++) {
	            System.out.println(splits[i]);
	         //   int l = splits;
	        }
		
		//int i = Integer.parseInt(splits);
		
		
		//if (splits >= 71) {
		String expectedGreen = "#e0e3e5";
		WebElement servicesvg = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[1]/*[@class='highcharts-plot-bands-0']/*"));
		String guage = servicesvg.getCssValue("fill");
		String hexcolor = Color.fromString(guage).asHex();
		System.out.println(hexcolor);
		
		Assert.assertEquals(expectedGreen, hexcolor);
	//	}
	}
	
	@Test
	public void waiting() {
		
		System.out.println("Starting waiting testcase");
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//String serviceheading = driver.findElement(By.xpath("//*[@id=\"sectionContent\"]/div[2]/div[1]/service-component/div/h1")).getText();
		//System.out.println(serviceheading);
		
		//svg tag    
		WebElement waitsvg = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[2]"));
		
		// gauge %
		String Serviceguagepercentage = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[2]/waiting-component/div/div/div[1]/div/div/div/div/span/div/div[1]")).getText();
		System.out.println(Serviceguagepercentage);
		
		//guage no
		String waitguagename = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[2]/waiting-component/div/div/div[1]/div/div/div/div/span/div/div[2]")).getText();
		System.out.println(waitguagename);
		
		//total waiting tickets 
		String TW = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[2]/waiting-component/div/div/div[2]/p[1]")).getText();
		System.out.println(TW);
		
		//avg wait time
		String AW = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[2]/waiting-component/div/div/div[2]/p[2]")).getText();
		System.out.println(AW);
		
	}
	
	@Test
	public void waitingcal() throws InterruptedException, SQLException {
		 
		System.out.println("Starting waiting calculation");
        Thread.sleep(5000);
        
        Thread.sleep(5000);
        Thread.sleep(5000);
		//select all
				/*Select g = new Select(Group);
				g.selectByValue("1036"); */
				Thread.sleep(500);
				

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
				
		
        String complaince = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[2]/waiting-component/div/div/div[1]/div/div/div/div/span/div/div[1]")).getText();
        System.out.println(complaince);
        
		Thread.sleep(500);
		System.out.println("Waiting tickets");
		String waiting_ticket = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[2]/waiting-component/div/div/div[2]/p[1]/span")).getText();
		//int k=Integer.parseInt(waiting_ticket);  
		System.out.println("TOTAL CLIENT(S) SERVED:  " + waiting_ticket);
		
		
		Thread.sleep(500);
		String avg_wait_time = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[2]/waiting-component/div/div/div[2]/p[2]")).getText();

		System.out.println(avg_wait_time);

		//sending ST to database class
		homepage_database gdata=new homepage_database();
		
		String i=gdata.waiting();
	
		System.out.println("Waiting complaince: "+i+"%");
		String com = i+"%";
		System.out.println();
	//	Assert.assertEquals(com, complaince);

	}
	
	@Test
	public void counters() throws InterruptedException {
		System.out.println("Starting counter testcase");
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
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//svg tag    
		WebElement Countersvg = driver.findElement(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[3]"));
		
		// gauge %
		String Counterguagepercentage = driver.findElement(By.xpath("")).getText();
		System.out.println(Counterguagepercentage);
		
		//guage no
		String counterguagename = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[3]/counter-component/div/div/div[1]/div/div/div/div/span/div/div[1]")).getText();
		System.out.println(counterguagename);
		
		//issue tickets per hour 
		String TI = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[3]/counter-component/div/div/div[2]/p[1]/span")).getText();
		System.out.println(TI);
		
		//served per hour time
		String TS = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[3]/counter-component/div/div/div[2]/p[2]")).getText();
		System.out.println(TS);
		
	}
	
	@Test
	public void countercal() throws InterruptedException {
		Thread.sleep(500);
		Thread.sleep(5000);

		Thread.sleep(5000);
		//select all
				/*Select g = new Select(Group);
				g.selectByValue("1036"); */
				Thread.sleep(500);
				

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
				
		String ticketissueperhour = driver.findElement(By.xpath("//*[@id=\"sectionContent\"]/div[2]/div[3]/counter-component/div/div/div[2]/p[1]/span")).getText();
		Thread.sleep(500);
			//System.out.println("No of served tickets");
		

		String total_issued_tickets_perhour = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[3]/counter-component/div/div/div[2]/p[1]/span")).getText();
		System.out.println("TICKET(S) ISSUED PER HOUR:  " + total_issued_tickets_perhour);
		
		String total_served_tickets_perhour = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[3]/counter-component/div/div/div[2]/p[2]/span")).getText();
		System.out.println("TICKET(S) SERVED PER HOUR:  " + total_served_tickets_perhour);
		
		String complaincePer = driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/div/div[2]/div[3]/counter-component/div/div/div[1]/div/div/div/div/span/div/div[1]")).getText();
		System.out.println("COMPLIANCE Percentage= " +complaincePer);
		
		
		//FORMULA//
		
		// j = ticket__issue_per_hour   k=total_served_tickets_perhour
		//  For % = (sum of logged in time of counters/branch working hours up till now * count of total counters) * 100
		
		// j = Total Ticket Issues / Branch Working Hours up till now
		// k = Total Ticket Served / Branch Working Hours up till now
		
		//sending ST to database class
			homepage_database gdata=new homepage_database();
				
			int i=gdata.counters();
			System.out.println(i);
		//	Assert.assertEquals(complaincePer +" ", i);
	
	}
	
	@Test
	 public void branchevolutionreading() throws InterruptedException {		 
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
		 List<WebElement> graphlist = 
				 driver.findElements(By.xpath("//*[name()='svg'][1]/*[name()='g'][7]/*[name()='g'][8]/*[name()='path']"));
		
		 Actions a = new Actions(driver);
		 System.out.print("Branch evolution: ");
		 for(WebElement e : graphlist) {
			 a.moveToElement(e).perform();
		 }
		 homepage_database gdata=new homepage_database();
			
			List<String> i = gdata.brancheva();
			//System.out.print(i);
		 
	 }
	
	//Test to verify the Legend of graph by enable and disable them
	@Test
	public void readingtooltip_G_ALL() throws InterruptedException {
		Thread.sleep(5000);
		Thread.sleep(5000);
		Select s = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/select[1]")));
		s.selectByValue("1036");
		Thread.sleep(5000);
		Thread.sleep(5000);
				//selecting hbl
				driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
				//click on unselect all
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
				Thread.sleep(500);
				//select hbl
				driver.findElement(By.xpath("//ul[@class='dropdown-menu']//li[@class='ng-scope'][7]")).click();
				Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
	     List<WebElement> graphlist = 
		 driver.findElements(By.xpath("//*[name()='svg'][1]/*[name()='g'][7]/*[name()='g'][8]/*[name()='path']"));
		 Actions a = new Actions(driver);
		 System.out.print("Branch evolution: ");
		 for(WebElement e : graphlist) {
			 a.moveToElement(e).perform();
			// String tooltip = driver.findElement(By.xpath("//div[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//span")).getText();
			//	System.out.println(tooltip);
			 
			 List<WebElement> dynamicElement = driver.findElements(By.xpath("//div[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//span"));

			 if (dynamicElement.size() != 0) {
			     System.out.println("Element present");
			     for(int i =0;i<dynamicElement.size();i++) {
			     String elementText = dynamicElement.get(i).getText(); 
			     System.out.println(elementText);
			     //driver.findElement(By.id("element")).click();
			 }    }
			 }
		 homepage_database gdata=new homepage_database();
			List<String> i = gdata.brancheva();
			Assert.assertEquals(s, i);
			System.out.print(i);
		 }
	

	
	
	



}
