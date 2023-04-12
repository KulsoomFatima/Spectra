package Spectra.SpecDashboard;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.allcomponents;
import pageObjects.serviceBranches;
import pageObjects.serviceQuality;
import pageObjects.serviceSummary;
import pageObjects.service_waiting;
import resources.base;

public class serviceBranchesTest extends base{

	LoginPage lp;
	HomePage hp;
	serviceSummary sr;
	serviceQuality sq;
	serviceBranches sb;


	public serviceBranchesTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		sb = new serviceBranches();
		sb = hp.serviceBranches();
		
		
	}
	
	@Test (priority=1)
	public void serviceTestcase() throws InterruptedException, SQLException {
		sb.branchestable();
	} 
	
	@Test
	public void records() throws InterruptedException, SQLException {
		//sq.qualityrecord();
		sb.branchgraph();
	}

	
/*
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  */
}


