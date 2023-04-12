package Spectra.SpecDashboard;

import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.base;

public class LoginPageTest extends base{

	LoginPage lp;
	HomePage hp;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initilization();
		lp = new LoginPage();
	}
	
	
	
	//1. Test to verify the Login process with the credentials of non existing user in system
	@Test
	public void IncorrectpassloginTest() throws SQLException, InterruptedException {
		hp = lp.login(prop.getProperty("username"),("Password"));
		
		
	}
	
	
	
	//2. Test to verify the Login process if there is invalid Login Id and valid Password entered
	@Test
	public void IncorrectuserloginTest() throws InterruptedException, SQLException {
		//hp = lp.login(("username"), prop.getProperty("Password"));
	hp =lp.Incorrectuserlogin(("username"), prop.getProperty("Password"));
		
	}
	
	
	//3. valid login id which isnt in sys and invalid pass
		@Test
		public void validusernameloginwithincorrectpassTest() throws SQLException, InterruptedException {
			Thread.sleep(50000);
			Thread.sleep(50000);

			hp = lp.login(prop.getProperty("username1"),("Password"));
		}
	
		
	
	
	//4. Test to verify the Login process with the credentials of valid user which exist in system
	@Test
	public void LoginTest() throws SQLException, InterruptedException {
		hp = lp.login(prop.getProperty("username"), prop.getProperty("Password"));
	}
	
	
	//5. Test to verify the Language selection from top left of the Login button
	@Test
	public void LangTest() throws InterruptedException, SQLException {
		lp.ChangeLanguage();
	}
	
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	} 
}
