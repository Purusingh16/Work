package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage 
{
	public WebDriver driver=null;
	
	public By checkout=By.xpath("//a[contains(@title,'Proceed to checkout')]");
	public BasketPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void ClickOnCheckout()
	{
		driver.findElement(checkout).click();
	}
}
