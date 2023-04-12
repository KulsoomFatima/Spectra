package Spectra.SpecDashboard;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.allcomponents;
import pageObjects.serviceSummary;
import pageObjects.service_waiting;
import resources.base;

public class serviceSummaryTest extends base{

	LoginPage lp;
	HomePage hp;
	serviceSummary sr;


	public serviceSummaryTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		sr = new serviceSummary();
		sr = hp.serviceReport();
		
		
	}
	
	@Test (priority=1)
	public void serviceTestcase() throws InterruptedException, SQLException {
		sr.summarytable();
	} 
	
	@Test
	public void records() throws InterruptedException, SQLException {
		sr.summaryrecord();
		//sr.summarygraph();
	}

	
/*
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  */
}


