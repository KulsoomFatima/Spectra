package Spectra.SpecDashboard;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.allcomponents;
import pageObjects.service_waiting;
import resources.base;

public class servicewaitingTest extends base{

	LoginPage lp;
	HomePage hp;
	allcomponents ac;
	service_waiting swc;


	public servicewaitingTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		ac = new allcomponents();
		swc = new service_waiting();
		swc = hp.servicewaitingcounter();
		
		
	}
	
	@Test (priority=1)
	public void serviceTestcase() throws InterruptedException, SQLException {
		swc.avgService_time();
	} 

	
	@Test (priority=2)
	public void Opencounters() throws InterruptedException, SQLException {
		swc.opencounters();
	}
	
	@Test (priority=3)
	public void tickettransfer() throws InterruptedException, SQLException {
		swc.tickettransfer();
	}
	
	@Test (priority=4)
	public void ticketserving() throws InterruptedException, SQLException {
		swc.ticket_in_serving();
	}
	
	@Test (priority=5)
	public void ticketIssued() throws InterruptedException, SQLException {
		swc.ticketIssued();
	}
	
	@Test (priority=6)
	public void ticketserved() throws InterruptedException, SQLException {
		swc.ticketserved();
	}
	
	@Test (priority=7)
	public void avgServiceTime() throws InterruptedException, SQLException {
		swc.avgService_time();
	}
	
	@Test  (priority=8)
	public void avgWaitTime() throws InterruptedException, SQLException {
		swc.avgwait_time();
	}
	
	@Test (priority=9)
	public void maxwait_time() throws InterruptedException, SQLException {
		swc.maxwait_time();
	}
	
	@Test (priority=10)
	public void maxServicetime() throws InterruptedException, SQLException {
		swc.maxservice_time();
	}
	
	@Test  (priority=11)
	public void ticketnoshow() throws InterruptedException, SQLException {
		swc.ticketnoshow();
	}
	
	@Test (priority=12)
	public void servicecomplaince() throws InterruptedException, SQLException {
		swc.serviceComplaince();
	}
	
	@Test (priority=13)
	public void waitingcomplaince() throws InterruptedException, SQLException {
		swc.waitingcomplaince();
	}
	
	@Test (priority=14)
	public void queue() throws InterruptedException, SQLException {
		swc.queuesize();
	}
	
	@Test (priority=15)
	public void ste() throws InterruptedException, SQLException {
		swc.STE();
	}
	
	@Test (priority=16)
	public void wte() throws InterruptedException, SQLException {
		swc.WTE();
	}
	


	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  
}


