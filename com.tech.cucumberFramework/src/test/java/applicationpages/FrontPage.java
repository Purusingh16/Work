package applicationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrontPage
{ 
	private WebDriver driver=null;
	public FrontPage(WebDriver driver)
	{
		this.driver=driver;
	}
   //locators
	private String SIGNIN_XPATH="//a[@title='Log in to your customer account']";
	//private String CONTACTUS_XPATH="//Contact us";
	//methods
	public void clickSignin()
	{
	  driver.findElement(By.xpath(SIGNIN_XPATH)).click();
	}
}
