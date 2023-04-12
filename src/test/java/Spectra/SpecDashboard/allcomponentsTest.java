package Spectra.SpecDashboard;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.allcomponents;
import resources.base;

public class allcomponentsTest extends base{

	LoginPage lp;
	HomePage hp;
	allcomponents ac;


	public allcomponentsTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		ac = new allcomponents();
		ac = hp.ClickallcomponentsTest();
	}
	
	@Test (priority=1)
	public void serviceTestcase() throws InterruptedException, SQLException {
		ac.avgService_time();
	} 

	@Test
	public void hardwareMonitoring() throws InterruptedException {
		ac.Hardware_Monitoring_Tabular();
	}
	
	@Test
	public void Client_Served_Per_Category() throws InterruptedException {
		ac.Client_Served_Per_Category();
	}
	
	@Test
	public void Client_waiting_Per_Category() throws InterruptedException, SQLException {
		ac.Client_waiting_Per_Category();
		ac.opencounters();
	}
	
	@Test
	public void Opencounters() throws InterruptedException, SQLException {
		ac.opencounters();
	}
	
	@Test
	public void tickettransfer() throws InterruptedException, SQLException {
		ac.tickettransfer();
	}
	
	@Test
	public void ticketserving() throws InterruptedException, SQLException {
		ac.ticket_in_serving();
	}
	
	@Test
	public void ticketIssued() throws InterruptedException, SQLException {
		ac.ticketIssued();
	}
	
	@Test
	public void ticketserved() throws InterruptedException, SQLException {
		ac.ticketserved();
	}
	
	@Test
	public void avgServiceTime() throws InterruptedException, SQLException {
		ac.avgService_time();
	}
	
	@Test 
	public void avgWaitTime() throws InterruptedException, SQLException {
		ac.avgwait_time();
	}
	
	@Test
	public void maxwait_time() throws InterruptedException, SQLException {
		ac.maxwait_time();
	}
	
	@Test
	public void maxServicetime() throws InterruptedException, SQLException {
		ac.maxservice_time();
	}
	
	@Test 
	public void ticketnoshow() throws InterruptedException, SQLException {
		ac.ticketnoshow();
	}
	
	@Test
	public void servicecomplaince() throws InterruptedException, SQLException {
		ac.serviceComplaince();
	}
	
	@Test
	public void waitingcomplaince() throws InterruptedException, SQLException {
		ac.waitingcomplaince();
	}
	
	@Test
	public void queue() throws InterruptedException, SQLException {
		ac.queuesize();
	}
	
	@Test
	public void ste() throws InterruptedException, SQLException {
		ac.STE();
	}
	
	@Test
	public void wte() throws InterruptedException, SQLException {
		ac.WTE();
	}
	
	@Test
	public void categorydetail() throws InterruptedException, SQLException {
		ac.categorydetail();
	}

	

	
/*
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  */
}


