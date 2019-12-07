package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TshirtPage 
{
	public WebDriver driver=null;
	
	public By image=By.xpath("//img[@title='Faded Short Sleeve T-shirts']");
	public By Add_to_Cart=By.xpath("//span[text()='Add to cart']");
	
	public TshirtPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void hover_on_Image()
	{
		WebElement element=driver.findElement(image);
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	public void Click_on_AddtoCart()
	{
		driver.findElement(Add_to_Cart).click();
	}

}
