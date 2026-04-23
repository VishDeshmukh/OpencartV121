package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("***** Starting Login TaseCase  **** ");
		try {
			
			//HomePage
		    HomePage hp=new HomePage(driver);
		    hp.clickMyAccount();
		    hp.clickLogin();
		    
		    //LoginPage
		    LoginPage lp=new LoginPage(driver);
		    lp.set_login_password(p.getProperty("password"));
		    lp.setEmail(p.getProperty("email"));
		    lp.click_btn_login();
		    
		    //MyAccount
		    
		    MyAccountPage macc=new MyAccountPage(driver);
		    boolean targetpage=macc.isMyAccountPageExists();
		    // Assert.assertEquals(targetpage, true,"Login failed");
	        //or
		    Thread.sleep(5000);
		    Assert.assertTrue(targetpage);
		    
			
		} 
		catch (Exception e) {
			
			Assert.fail();
		}
		
	    logger.info("***** Finished Login TaseCase  **** ");
		
	}
	
	

}
