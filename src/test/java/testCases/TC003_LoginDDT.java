package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "DataDriven")//getting data provider from a different class
	public void verify_loginDDT(String email, String pwd, String exp ) {
		
		logger.info("**** Starting TC003_LoginDDT Test ****");
		//HomePage
		try {
			
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean targetPage = myacc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				myacc.clickLogout();
				Assert.assertTrue(true);
			} 
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid")) {
			if(targetPage==true) {
				myacc.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		} catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**** Finished TC003_LoginDDT Test ****");
		
	}

}
