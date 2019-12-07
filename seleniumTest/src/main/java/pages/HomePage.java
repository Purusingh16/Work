package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 
{
	WebDriver driver=null;
	private By myAccount=By.xpath("//h1[text()='My account']");
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getHomePageTitle() {
		return driver.findElement(myAccount).getText();
	}
}
