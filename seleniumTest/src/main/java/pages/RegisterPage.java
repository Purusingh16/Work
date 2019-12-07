package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage 
{
 WebDriver driver=null;
 private By EMAIL_ID=By.id("email_create");
 private By CREATE_ID=By.id("SubmitCreate");

public RegisterPage(WebDriver driver)
{
	this.driver=driver;
}
public void typeEmailAddress(String username)
{
	driver.findElement(EMAIL_ID).sendKeys(username);
}
public CreateAccountPage ClickonCreate_an_account()
{
	driver.findElement(CREATE_ID).click();
	return new  CreateAccountPage(driver);
	
}

}
