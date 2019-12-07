package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver=null;
	
//	private String EMAIL_ADDR_ID="email";
//	private String PASSWORD_ID="passwd";
//	private String SIGNIN_ID="SubmitLogin";
//	private String TITLE_XPATH="//h3[text()='Already registered?']";

//	private By EMAIL_ADDR_ID=By.id("email");
//	private By PASSWORD_ID=By.id("passwd");
//	private By SIGNIN_ID=By.id("SubmitLogin");
//	private By TITLE_XPATH=By.xpath("//h3[text()='Already registered?']");
	
	@FindBy(id="email")
	WebElement EMAIL_ADDR_ID;
	
	@FindBy(id="passwd")
	WebElement PASSWORD_ID;
	
	@FindBy(id="SubmitLogin")
	WebElement SIGNIN_ID;
	
	@FindBy(xpath="//h3[text()='Already registered?']")
	WebElement TITLE_XPATH;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void typeEmail(String email)
	{
//		driver.findElement(EMAIL_ADDR_ID).sendKeys(email);
		EMAIL_ADDR_ID.sendKeys(email);
	}

	public void typePassword(String password)
	{
//		driver.findElement(PASSWORD_ID).sendKeys(password);
		PASSWORD_ID.sendKeys(password);
	}
	
	public void clickOnSignin()
	{
//		driver.findElement(SIGNIN_ID).click();
		SIGNIN_ID.click();
	}
	
	public boolean isPageDisplayed()
	{
//		return driver.findElement(TITLE_XPATH).isDisplayed();
		return TITLE_XPATH.isDisplayed();
	}
	
	
}

