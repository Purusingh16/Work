package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressPage
{
	public WebDriver driver=null;
	
	public By addressCheckOut=By.xpath("//span[contains(text(),'Proceed to checkout')]");
	
	public AddressPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void ClickOnCheckOut()
	{
		driver.findElements(addressCheckOut).get(1).click();
	}

}
