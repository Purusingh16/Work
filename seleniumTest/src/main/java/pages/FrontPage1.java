package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontPage1 
{
	WebDriver driver=null;
	
	@FindBy(partialLinkText="Sign in")
	WebElement SIGN_IN_LINKTEXT;
	
	
	public FrontPage1(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	
	public LoginPage1 clickOnSignIn()
	{
		SIGN_IN_LINKTEXT.click();
		return new LoginPage1(driver);
	}

}
