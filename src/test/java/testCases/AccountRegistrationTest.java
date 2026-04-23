package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass{
	
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("*****Starting AccountRegistrationTest TestCase ****** ");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage repage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		
		repage.setFirstName(randomString().toUpperCase());
		repage.setLastName(randomString().toUpperCase());
		repage.setEmail(randomString()+"@gmail.com");
		repage.setTelephone(randomNumber());
		
		String password=randomeAlphaNumberic();
		
		repage.setPassword(password);
		repage.setConfirmPassword(password);
		
		repage.setPrivacyPolicy();
		repage.clickContinue();
		
		logger.info("Validating expected message..");
		
		String confmsg=repage.getConfirmationMsg();
		if(confmsg.equals( "Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);

		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
		catch(Exception e)
		{
			Assert.fail();	
		}
		
		logger.info("***** Finished AccountRegistrationTest TestCase ****** ");
		

}

	
}