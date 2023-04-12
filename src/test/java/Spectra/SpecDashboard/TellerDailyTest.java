package Spectra.SpecDashboard;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TellerCategory;
import pageObjects.TellerDaily;
import pageObjects.TellerSummary;
import pageObjects.allcomponents;
import pageObjects.serviceSummary;
import pageObjects.service_waiting;
import resources.base;

public class TellerDailyTest extends base{

	LoginPage lp;
	HomePage hp;
	serviceSummary sr;
	TellerDaily td;


	public TellerDailyTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		td = new TellerDaily();
		td = hp.TellerDaily();
		
		
	}
	
	@Test (priority=1)
	public void serviceTestcase() throws InterruptedException, SQLException {
		td.tellerdailytable();
		//tc.qualityrecord();
		//tc.qualitygraph();
	} 

	
/*
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  */
}


