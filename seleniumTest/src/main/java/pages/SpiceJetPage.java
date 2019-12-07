package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SpiceJetPage 
{
	WebDriver driver=null;
	
	private By getspicejetTitle_Text=By.className("text-label");
	private By Button_ID=By.id("ctl00_mainContent_rbtnl_Trip_1");
	private By dropDown_ID=By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	private By chooseCity_NameText=By.linkText("Pune (PNQ)");
	private By dropDown_ID1=By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	private By chooseCity_NameText1=By.linkText("Delhi (DEL)");
	private By chooseDate_text=By.linkText("20");
	private By selectAdult_ID=By.id("ctl00_mainContent_ddl_Adult");
	private By selectChildren_ID=By.id("ctl00_mainContent_ddl_Child");
	private By selectInfant_ID=By.id("ctl00_mainContent_ddl_Infant");
	private By findFlight_ID=By.id("ctl00_mainContent_btn_FindFlights");
	
	public SpiceJetPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void infoCommand(String flighttitle)
	{
		driver.findElement(getspicejetTitle_Text).getText();
	}
	public void clickOnButton(String button)
	{
		driver.findElement(Button_ID).click();
	}
	public void clickOnDropDown(String dropdown)
	{
		driver.findElement(dropDown_ID).click();
	}
	public void chooseCity(String cities)
	{
		driver.findElement(chooseCity_NameText).click();
	}
	public void clickOnDropDown1(String dropdown1)
	{
		driver.findElement(dropDown_ID1).click();
	}
	public void chooseCity1(String cities1)
	{
		driver.findElement(chooseCity_NameText1).click();
	}
	public void typeDate(String date)
	{
		driver.findElement(chooseDate_text).click();
	}
	public void selectAdult(String adult)
	{
		new Select(driver.findElement(selectAdult_ID)).selectByVisibleText(adult);
	}
	public void selectChildren(String children)
	{
		new Select(driver.findElement(selectChildren_ID)).selectByVisibleText(children);
	}
	public void selectInfant(String infant)
	{
		new Select(driver.findElement(selectInfant_ID)).selectByVisibleText(infant);
	}
	public void clickOnFindFlight(String findflight)
	{
		driver.findElement(findFlight_ID).click();
	}
	
}