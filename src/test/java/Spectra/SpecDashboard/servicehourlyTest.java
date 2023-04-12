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
import pageObjects.servicehourly;
import resources.base;

public class servicehourlyTest extends base{

	LoginPage lp;
	HomePage hp;
	serviceSummary sr;
	servicehourly sh;


	public servicehourlyTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		sh = new servicehourly();
		sh = hp.servicehourly();
		
		
	}
	
	@Test (priority=1)
	public void serviceTestcase() throws InterruptedException, SQLException {
		sh.hourlytable();
	} 
	
	@Test
	public void records() throws InterruptedException, SQLException {
		sh.hourlyrecord();
		//sh.hourlygraph();
	}

	
/*
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  */
}


