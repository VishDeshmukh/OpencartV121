package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class LoginDDT extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass =utilities.DataProviders.class ,groups="Datadriven")//DataProviders class -> dataProvider LoginData  getting a data provider  from different class
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		
	logger.info("***** Starting LoginDDT test case *****");
	
	try 
	
	{
	//HomePage
    HomePage hp=new HomePage(driver);
    hp.clickMyAccount();
    hp.clickLogin();
    
    //LoginPage
    LoginPage lp=new LoginPage(driver);
    lp.setEmail(email);
    lp.set_login_password(pwd);
    lp.click_btn_login();
    
    //MyAccount
    
    MyAccountPage macc=new MyAccountPage(driver);
    boolean targetpage=macc.isMyAccountPageExists();
	
    //Validation
    
    /*Valid data- login success- test pass-logout
                  login failed-test fail
                  
      Invalid data-login success- test fail-logout
                  login failed-test pass
    */
    
    if(exp.equalsIgnoreCase("valid"))
    {
    	if(targetpage==true)
    	{
    		macc.clicklogout();
    	    Assert.assertTrue(true);
    	}
    	else {
			Assert.assertTrue(false);
		}
    }
    else
    {
    	if(targetpage==true)
    	{
    		macc.clicklogout();
    		Assert.assertTrue(false);
    	}
    	else 
    	{
			Assert.assertTrue(true);
		}
    	
    }
	}catch (Exception e) {
		Assert.fail();
	}
   
    logger.info("***** Finished LoginDDT test case *****");  
	
	}
}
