package Spectra.SpecDashboard;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.TellerCategory;
import pageObjects.TellerCustomerfeedback;
import pageObjects.TellerDaily;
import pageObjects.TellerResp;
import pageObjects.TellerSummary;
import pageObjects.allcomponents;
import pageObjects.serviceSummary;
import pageObjects.service_waiting;
import resources.base;

public class TellerCustomerfeedbackTest extends base{

	LoginPage lp;
	HomePage hp;
	serviceSummary sr;
	TellerCustomerfeedback tcf;


	public TellerCustomerfeedbackTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		tcf = new TellerCustomerfeedback();
		tcf = hp.TellerCustomerfeedback();
		
		
	}
	
	@Test (priority=1)
	public void serviceTestcase() throws InterruptedException, SQLException {
		tcf.tellercustomerfeedbacktable();
	//	tcf.summaryrecord();
		
	} 

	
/*
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  */
}


