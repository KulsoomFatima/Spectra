package Spectra.SpecDashboard;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.allcomponents;
import pageObjects.serviceMattercode;
import pageObjects.serviceQuality;
import pageObjects.serviceSummary;
import pageObjects.service_waiting;
import resources.base;

public class serviceMattercodeTest extends base{

	LoginPage lp;
	HomePage hp;
	serviceSummary sr;
	serviceQuality sq;
	serviceMattercode sm;


	public serviceMattercodeTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		sm = new serviceMattercode();
		sm = hp.serviceMattercode();
		
		
	}
	
	@Test (priority=1)
	public void serviceTestcase() throws InterruptedException, SQLException {
		sm.mattercodetable();
	} 
	
	
/*
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  */
}


