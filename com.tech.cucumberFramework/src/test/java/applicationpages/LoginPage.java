package applicationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{  
	private WebDriver driver=null;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	//locators
	private String EMAIL_XPATH="//input[@id='email']";
	private String PASSWORD_XPATH="//input[@id='passwd']";
	private String SUBMIT_XPATH="//button[@id='SubmitLogin']";
	private String SIGNINERROR_XPATH="//div/div/ol/li";
	
	public void typeEmail(String email)
	{
		WebElement element=driver.findElement(By.xpath(EMAIL_XPATH));
		element.sendKeys(email);
	}
	public void typePassword(String password)
	{
		WebElement element=driver.findElement(By.xpath(PASSWORD_XPATH));
		element.sendKeys(password);
	}
	public void clickSubmit()
	{ 
		WebElement element=driver.findElement(By.xpath(SUBMIT_XPATH));
		element.click();
	}
	public String signInError()
	{
		String str1=driver.findElement(By.xpath(SIGNINERROR_XPATH)).getText();
		return str1;
	}
}
