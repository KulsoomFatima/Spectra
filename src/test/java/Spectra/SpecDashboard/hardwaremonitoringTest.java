package Spectra.SpecDashboard;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.allcomponents;
import pageObjects.hardware_monitoring;
import resources.base;

public class hardwaremonitoringTest extends base{

	LoginPage lp;
	HomePage hp;
	hardware_monitoring hm;


	public hardwaremonitoringTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		hm = new hardware_monitoring();
		hm = hp.hardware_monitoring();
	}
	
	@Test (priority=1)
	public void heatmap() throws InterruptedException, SQLException {
		hm.heatmap();
	} 

	@Test
	public void Hardware_Monitoring_Tabular() throws InterruptedException {
		hm.Hardware_Monitoring_Tabular();
	}
	
	
/*
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  */
}


