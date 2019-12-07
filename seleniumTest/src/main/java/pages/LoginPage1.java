package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

public class LoginPage1 
{
	
	WebDriver driver=null;
	
	@FindBy(id="email")
	WebElement EMAIL_ID;
	
	@FindBy(id="passwd")
	WebElement PASSWORD_ID;
	
	@FindBy(id="SubmitLogin")
	WebElement SIGN_IN_ID;
	
	@FindBy(xpath="//h3[text()='Already registered?']")
	WebElement TITLE_XPATH;
	
	public LoginPage1(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	public void typeEmail(String username)
	{
		EMAIL_ID.sendKeys(username);
	}
	
	public void typePassword(String password)
	{
		PASSWORD_ID.sendKeys(password);
	}
	
	public HomePage clickOnSubmit()
	{
		SIGN_IN_ID.click();
		return new HomePage(driver);
	}
	
	public boolean isEmailEnable() 
	{
		return EMAIL_ID.isEnabled();
	}
	public boolean isPageDisplayed()
	{
		return TITLE_XPATH.isDisplayed();
	}
}
