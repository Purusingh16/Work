package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver=null;
	
	private By EMAIL_ID=By.id("email");
	private By PASSWORD_ID=By.id("passwd");
	private By SIGN_IN_ID=By.id("SubmitLogin");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void typeEmail(String username){
		driver.findElement(EMAIL_ID).sendKeys(username);
	}
	
	public void typePassword(String password)
	{
		driver.findElement(PASSWORD_ID).sendKeys(password);
	}
	
	public HomePage clickOnSubmit(){
		driver.findElement(SIGN_IN_ID).click();
		return new HomePage(driver);
	}
	
	public boolean isEmailEnable() {
		return driver.findElement(EMAIL_ID).isEnabled();
		
	}


}
