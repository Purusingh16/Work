package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrontMenuBarPage 
{
	public WebDriver driver=null;
	
	private By navigate_TSHIRTS=By.xpath("//a[text()='T-shirts']");
	
	public FrontMenuBarPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void ClickOnTshirt()
	{
		driver.findElements(navigate_TSHIRTS).get(1).click();
	}
	
}
