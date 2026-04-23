package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath="//div[@id='content']/h2")//MyAccount Page Heading
	 WebElement msgHeading;
	
	
	@FindBy(xpath = "//div/a[text()='Logout']")
	WebElement btn_logout;
	
	
	public boolean isMyAccountPageExists() {
		
		try {
			
			return (msgHeading.isDisplayed()); //true
			
		} catch (Exception e) {
		
			return false;  //false
			
		}
		
	}
	
	public void clicklogout() {
		btn_logout.click();
		
	}
	

}
