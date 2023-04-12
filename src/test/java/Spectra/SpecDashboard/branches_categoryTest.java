package Spectra.SpecDashboard;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.allcomponents;
import pageObjects.branches_category;
import resources.base;

public class branches_categoryTest extends base{

	LoginPage lp;
	HomePage hp;
	branches_category bc;


	public branches_categoryTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws SQLException, InterruptedException {
		initilization();

		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
		bc = new branches_category();
		bc = hp.branches_category();
	}
	


	@Test
	public void Tellerstopandbottom() throws InterruptedException, SQLException {
		bc.Tellerstopandbottom_ticketsserved();
		bc.Tellerstopandbottom_avgservicetime();
	}
	
	@Test
	public void Branchestopandbottom() throws InterruptedException, SQLException {
		bc.BranchestopandbottomSVC();
		bc.Branchestopandbottomticketserved();
		bc.BranchestopandbottomWtime();
	
	}
	
	@Test
	public void latestServey() throws InterruptedException, SQLException {
		bc.latestServey();
	}
	
	@Test
	public void categorydetail() throws InterruptedException, SQLException {
		bc.categorydetail();
		bc.categorydetailgraph();
	}
	
	
	
	@Test
	public void Target_Compliance_Per_Category() throws InterruptedException, SQLException {
		bc.Target_Compliance_Per_Category();
	}
	
	@Test
	public void Average_Time_Per_Category() throws InterruptedException, SQLException {
		bc.Average_Time_Per_Category();
	}
	
	@Test 
	public void Client_waiting_Per_Category() throws InterruptedException, SQLException {
		bc.Client_waiting_Per_Category();
	}
	
	@Test
	public void Service_Rate_Per_Category() throws InterruptedException, SQLException {
		bc.Service_Rate_Per_Category();
	}
	
	@Test
	public void Client_Served_Per_Category() throws InterruptedException, SQLException {
		bc.Client_Served_Per_Category();
	}
	
	@Test
	public void categories() throws InterruptedException, SQLException {
		bc.categories();
	}
	
	@Test
	public void realtime_monitoring() throws InterruptedException, SQLException {
		bc.realtime_monitoring();
	}
	@Test
	public void counters() throws InterruptedException, SQLException {
		bc.counters();
	}

	@Test
	public void Tellergroup() throws InterruptedException, SQLException {
		bc.Tellergroup();
	}

	

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}  
}


