package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage 
{	
	public WebDriver driver=null;
	
	public By checkBox=By.id("cgv");
	public By shippingCheckOut=By.xpath("//span[contains(text(),'Proceed to checkout')]");
	
	public ShippingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void verifyCheckBox()
	{
		driver.findElement(checkBox).click();
	}
	public void ClickOnShippingCheckOut()
	{
		driver.findElements(shippingCheckOut).get(1).click();
	}
}
