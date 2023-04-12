package Spectra.SpecDashboard;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TellerAttendence;
import pageObjects.TellerSummary;
import pageObjects.allcomponents;
import pageObjects.serviceSummary;
import pageObjects.service_waiting;
import resources.base;

public class TellerAttendenceTest extends base{

	LoginPage lp;
	HomePage hp;
	serviceSummary sr;
	TellerSummary ts;
	TellerAttendence ta;


	public TellerAttendenceTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		ta = new TellerAttendence();
		ta = hp.TellerAttendence();
		
		
	}
	
	@Test (priority=1)
	public void serviceTestcase() throws InterruptedException, SQLException {
		ta.tellertable();
	} 

	@Test 
	public void tellerattendencerecord() throws InterruptedException, SQLException {
		ta.tellerrecord();
	}
/*
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  */
}


