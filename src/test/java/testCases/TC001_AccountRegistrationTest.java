package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups = {"Sanity","Master"})
	public void verify_account_registration() {
		logger.info("***Starting TC001_AccountRegistrationTest****");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account link..");
		hp.clickRegister();
		logger.info("Clicked on Register link..");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regpage.setFirstName("John");
		regpage.setLastName("Smith");
		regpage.setEmail("johnsm7@gmail.com");
		regpage.setTelephone("7172192346");
		regpage.setPassword("test123");
		regpage.setConfirmPassword("test123");
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("validating expected message...");
		
		String confmsg = regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		
		} catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("****Finisher TC001_AccountRegistrationTest****");
	}
	
//	public String randomString() {
//		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('a', 'z').build();
//		String randomString = generator.generate(5);
//		return randomString;
//	}
}
