package automationFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmericanDiscountcruises 
{
	WebDriver driver;
	
	By click_on_Startdate=By.id("StartDate");
	
	
	
	public AmericanDiscountcruises(WebDriver driver)
	{
		this.driver=driver;
	}
	public void Click_on_StartDate()
	{
		driver.findElement(click_on_Startdate).click();
	}
	

}
