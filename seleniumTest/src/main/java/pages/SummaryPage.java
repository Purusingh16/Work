package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage 
{
	public WebDriver driver=null;
	
	public By checkout=By.xpath("//span[contains(text(),'Proceed to checkout')]");
	public SummaryPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void ClickOnCheckout()
	{
		driver.findElements(checkout).get(1).click();
	}
}
