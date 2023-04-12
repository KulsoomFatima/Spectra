package Spectra.SpecDashboard;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.allcomponents;
import resources.base;

public class HomePageTest extends base{

	LoginPage lp;
	HomePage hp;
	allcomponents ac;


	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();
		//Thread.sleep(50000);
	//	Thread.sleep(500000);

//		driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
//		driver.manage().timeouts().setScriptTimeout(3L, TimeUnit.SECONDS);
//		driver.navigate().refresh();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		
	}
	
	@Test (priority=1)
	public void serviceTestcase() throws InterruptedException, SQLException {
		
		hp.service();
		hp.serviceCal();
	} 

	@Test (priority=2)
	public void waitTestcase() throws InterruptedException, SQLException{
		//hp.waiting();
		hp.waitingcal();
	} 
	
	@Test (priority=3)
	public void CounterTestcase() throws InterruptedException, SQLException{
		//hp.counters();
		hp.countercal();
	} 

	@Test (priority=4)
	public void branchevolutionreadingTest() throws InterruptedException {
		Thread.sleep(600);
		hp.branchevolutionreading();
		hp.readingtooltip_G_ALL();
	}
	
	@Test
	public void colourTest() throws InterruptedException {
		hp.green_colour1_49_30days();
		hp.green_colour1_49_7days();
		hp.green_colour1_49_today();
	}
	
	@Test
	public void clickallcomponents() throws SQLException, InterruptedException {
		ac = hp.ClickallcomponentsTest();
		 return ;
	}

/*	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  */
}


