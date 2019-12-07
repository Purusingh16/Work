package applicationpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs 
{ 
	private WebDriver driver=null;
	public ContactUs(WebDriver driver)
	{
		this.driver = driver;
	}
	private String CONTACTUS_XPATH="//a[@title='Contact Us']";
	public void clickContactUs()
	{
		driver.findElement(By.xpath(CONTACTUS_XPATH)).click();
	}
}
