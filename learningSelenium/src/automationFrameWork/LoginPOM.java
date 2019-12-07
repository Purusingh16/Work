package automationFrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM 
{
	@FindBy(how=How.ID,using="log")
	WebElement userNameEditBox;
	
	@FindBy(how=How.ID,using="pwd")
	WebElement passwordEditBox;
	
	@FindBy(how=How.ID,using="rememberme")
	WebElement remembermeCheckBox;
	
	@FindBy(how=How.ID,using="login")
	WebElement loginButton;
	
	public LoginPOM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		/*userNameEditBox=driver.findElement(By.id("log"));
		passwordEditBox=driver.findElement(By.id("pwd"));
		remembermeCheckBox=driver.findElement(By.id("rememberme"));
		loginButton=driver.findElement(By.id("login"));*/
	}
	
	public void loginwithoutsavingCookie(String username,String password)
	{
		userNameEditBox.sendKeys(username);
		passwordEditBox.sendKeys(password);
		loginButton.click();
	}
	public void loginwithsavedCookie(String username,String password)
	{
		userNameEditBox.sendKeys(username);
		passwordEditBox.sendKeys(password);
		remembermeCheckBox.click();
		loginButton.click();
	}

}
