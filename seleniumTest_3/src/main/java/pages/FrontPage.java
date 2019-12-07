package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrontPage {
	WebDriver driver=null;
	
	public FrontPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private String SIGN_IN_LINKTEXT="Sign in";

	public LoginPage clickOnSignIn() {
		driver.findElement(By.partialLinkText(SIGN_IN_LINKTEXT)).click();
		return new LoginPage(driver);
	}

	

}
