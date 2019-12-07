package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontPage {

	WebDriver driver=null;
	
//	private String SIGNIN_LINKTXT="Sign in";
//	private String CONTACT_US_LINKTXT="Contact us";
	
//	private By SIGNIN_LINKTXT=By.partialLinkText("Sign in");
//	private By CONTACT_US_LINKTXT=By.partialLinkText("Contact us");
	
	@FindBy(partialLinkText="Sign in")
	WebElement SIGNIN_LINKTXT;

	@FindBy(partialLinkText="Contact us")
	WebElement CONTACT_US_LINKTXT;
	
	public FrontPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignin()
	{
//		driver.findElement(By.partialLinkText(SIGNIN_LINKTXT)).click();
//		driver.findElement(SIGNIN_LINKTXT).click();
		SIGNIN_LINKTXT.click();
		return new LoginPage(driver);
	}
	
	public ContactUsPage clickOnContactUs()
	{
//		driver.findElement(By.partialLinkText(CONTACT_US_LINKTXT)).click();
//		driver.findElement(CONTACT_US_LINKTXT).click();
		CONTACT_US_LINKTXT.click();
		return new ContactUsPage(driver);
	}
}

