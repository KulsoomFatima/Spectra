package Spectra.SpecDashboard;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TellerCategory;
import pageObjects.TellerSummary;
import pageObjects.allcomponents;
import pageObjects.serviceSummary;
import pageObjects.service_waiting;
import resources.base;

public class TellerCategoryTest extends base{

	LoginPage lp;
	HomePage hp;
	serviceSummary sr;
	TellerCategory tc;


	public TellerCategoryTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		tc = new TellerCategory();
		tc = hp.TellerCategory();
		
		
	}
	
	@Test (priority=1)
	public void serviceTestcase() throws InterruptedException, SQLException {
		tc.tellercategorytable();
		//tc.qualityrecord();
		//tc.qualitygraph();
	} 

	
/*
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  */
}


