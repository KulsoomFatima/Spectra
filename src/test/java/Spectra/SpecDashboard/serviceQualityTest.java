package Spectra.SpecDashboard;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.allcomponents;
import pageObjects.serviceQuality;
import pageObjects.serviceSummary;
import pageObjects.service_waiting;
import resources.base;

public class serviceQualityTest extends base{

	LoginPage lp;
	HomePage hp;
	serviceSummary sr;
	serviceQuality sq;


	public serviceQualityTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		sq = new serviceQuality();
		sq = hp.serviceQuality();
		
		
	}
	
	@Test (priority=1)
	public void serviceTestcase() throws InterruptedException, SQLException {
		sq.qualitytable();
	} 
	
	@Test
	public void records() throws InterruptedException, SQLException {
		//sq.qualityrecord();
		sq.qualitygraph();
	}

	
/*
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  */
}


