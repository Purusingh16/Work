package applicationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
	private WebDriver driver=null;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
   private String USERNAME_XPATH="//a[@title='View my customer account']/span";
   //methods
	public String  getUserName()
	{
	  String str=driver.findElement(By.xpath(USERNAME_XPATH)).getText();
	  return str;
	}
	public boolean  isUserNameDisplayed()
	{
	return driver.findElement(By.xpath(USERNAME_XPATH)).isDisplayed();
	}
}


