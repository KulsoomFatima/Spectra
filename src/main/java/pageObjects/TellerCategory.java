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

public class TellerCategory extends base {

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
	public TellerCategory() throws SQLException {
		PageFactory.initElements(driver, this);
	
	}

	//Actions
	
	@Test
	public void tellercategorytable() throws InterruptedException, SQLException {
	
		driver.findElement(By.xpath("//div[@class='scroll-horizontal']//ul//li[2]")).click();

		Thread.sleep(5000);
		//select all
		Select g = new Select(Group);
		g.selectByValue("1041");
		
		Thread.sleep(5000);

		//selecting hbl
		driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
		Thread.sleep(500);

		//click on unselect all
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
		Thread.sleep(500);
		//select wavetec
		driver.findElement(By.xpath("//*[@id=\"branches-filter\"]/div/ul/li[10]/a")).click();
		Thread.sleep(5000);
		//click on group
		driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();		
		Thread.sleep(5000);
		// click back button
		for (int i = 0; i < 9; i++){
			 //click the button
			driver.findElement(By.xpath("//datefilter-component//a")).click();
			 //wait 2 seconds
			  Thread.sleep(2000);
			  //check that data is being generated correctly
			}
		//clcik cat page
		
		driver.findElement(By.xpath("//ul[@class='nav big-tabs nav-tabs']//li[3]")).click();

		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		String heading = driver.findElement(By.xpath("//div[@class='section-header']//h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		//100 record select
				Select d = new Select(driver.findElement(By.xpath("//div//select[@class='form-control input-sm custom-itemSelect-btn']")));
				d.selectByValue("100");
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
	 System.out.println("" + rowtext + "");
	 
		//sending ST to database class
	 TellerSummary_database gdata=new TellerSummary_database();
			
			String i=gdata.tellersummarytable();
			System.out.println(i);
		
			/*
		// print column name
		 List<WebElement> allHeaders = table.findElements(By.tagName("th"));
        System.out.println("This is the total numbers of headers" + allHeaders.size());
        int quantityHead = 0;

        // Get the column where the quantity is listed
        for(WebElement header : allHeaders)
        {
            quantityHead++;
            if(header.getText().equalsIgnoreCase("EMOS"))
            {
                System.out.println(header.getText());
                System.out.println(quantityHead + " is the column number for the quantity");
            }
        }

      	*/			
		
	
		 }
	

	@Test
	public void qualityrecord() throws InterruptedException, SQLException {
	
		driver.findElement(By.xpath("//div[@class='scroll-horizontal']//ul//li[2]")).click();

		Thread.sleep(5000);
		//select all
		Select g = new Select(Group);
		g.selectByValue("1041");
		
		Thread.sleep(5000);

		//selecting hbl
		driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
		Thread.sleep(500);

		//click on unselect all
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
		Thread.sleep(500);
		//select wavetec
		driver.findElement(By.xpath("//*[@id=\"branches-filter\"]/div/ul/li[10]/a")).click();
		Thread.sleep(5000);
		//click on group
		driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();		
		Thread.sleep(5000);

		// click back button
		driver.findElement(By.xpath("//datefilter-component//a")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//datefilter-component//a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//datefilter-component//a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//datefilter-component//a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//datefilter-component//a")).click();
		//clcik cat page
		
		driver.findElement(By.xpath("//ul[@class='nav big-tabs nav-tabs']//li[3]")).click();

		Thread.sleep(5000);
		Thread.sleep(5000);
		
		String heading = driver.findElement(By.xpath("//div[@class='section-header']//h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);
		
	String ticketservedissue = driver.findElement(By.xpath("//div[@class='row summary-reports ng-scope']//div[@class='items-box p-r-md ng-scope pull-left']")).getText();
	System.out.println(ticketservedissue);
	
	String waitingtime = driver.findElement(By.xpath("//div[@class='row summary-reports ng-scope']//div[@class='items-box p-r-md ng-scope pull-left'][2]")).getText();
	System.out.println(waitingtime);
	
	String sla = driver.findElement(By.xpath("//div[@class='row summary-reports ng-scope']//div[@class='items-box p-r-md ng-scope pull-left'][3]")).getText();
	System.out.println(sla);
	
	
	serviceQuality_database gdata=new serviceQuality_database();
		
	//	String i=gdata.qualityrecord();
		//System.out.println(i);
	
		 }
	

	@Test
	public void qualitygraph() throws InterruptedException, SQLException {
	
		driver.findElement(By.xpath("//div[@class='scroll-horizontal']//ul//li[2]")).click();

		Thread.sleep(5000);
		//select all
		Select g = new Select(Group);
		g.selectByValue("1041");
		
		Thread.sleep(5000);

		//selecting hbl
		driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();
		Thread.sleep(500);

		//click on unselect all
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//button[2]")).click();
		Thread.sleep(500);
		//select wavetec
		driver.findElement(By.xpath("//*[@id=\"branches-filter\"]/div/ul/li[10]/a")).click();
		Thread.sleep(5000);
		//click on group
		driver.findElement(By.xpath("//div[@class='branch-select-one block-branches-select']")).click();		
		Thread.sleep(5000);

		// click back button
		driver.findElement(By.xpath("//datefilter-component//a")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//datefilter-component//a")).click();
		
		//clcik cat page
		
		driver.findElement(By.xpath("//ul[@class='nav big-tabs nav-tabs']//li[3]")).click();

		Thread.sleep(5000);
		Thread.sleep(5000);
		
		String heading = driver.findElement(By.xpath("//div[@class='section-header']//h1")).getText();
		System.out.println("Heading: "+ heading);
		Thread.sleep(5000);
		Thread.sleep(5000);

		  List<WebElement> graphlist = 
					 driver.findElements(By.xpath("//*[name()='svg'][1]/*[name()='g' and @class='highcharts-grid highcharts-xaxis-grid']/*"));
					 Actions a = new Actions(driver);
					 System.out.print("Summary Graph: ");
					 for(WebElement e : graphlist) {
						 a.moveToElement(e).perform();
						// String tooltip = driver.findElement(By.xpath("//div[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//span")).getText();
						//	System.out.println(tooltip);
						 
						 List<WebElement> dynamicElement = driver.findElements(By.xpath("//div[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//span"));

						 if (dynamicElement.size() != 0) {
						     for(int i =0;i<dynamicElement.size();i++) {
						     String elementText = dynamicElement.get(i).getText(); 
						     System.out.println(elementText);
						     //driver.findElement(By.id("element")).click();
						 }    }
						 }
		
}
	
}

