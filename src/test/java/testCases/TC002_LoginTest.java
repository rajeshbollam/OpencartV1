package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"Regression", "Master"})
	public void verify_login() {
		
		try {
			
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
			
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean msgDisplayed = macc.isMyAccountPageExists();
		Assert.assertEquals(msgDisplayed, true);
		} catch(Exception e) {
			Assert.fail();
		}
	}
	

}
