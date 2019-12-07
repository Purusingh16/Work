package keyWordDrivenFrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IDEToWebdriver extends CommonFunctions 
{

	public static void main(String[] args) throws Exception
	{
		String data[][]=FetchDataFromExcel("F:\\Work\\java\\selenium_Learning\\TestData\\blablablacar for keydriven.xlsx");
		WebDriver webDriver=new FirefoxDriver();	
		navigate_to(webDriver, data[2][7]);
		sendKeys(webDriver, data[3][5], data[3][6], data[3][7]);
		sendKeys(webDriver, data[4][5], data[4][6], data[4][7]);
		click_element(webDriver, data[5][5], data[5][6]);
		click_element(webDriver, data[6][5], data[6][6]);
		click_element(webDriver, data[7][5], data[7][6]);
		click_element(webDriver, data[8][5], data[8][6]);
		click_element(webDriver, data[9][5], data[9][6]);
		quite_driver(webDriver);
//		navigate_to(webDriver, "https://www.blablacar.in/");
		
//		webDriver.findElement(By.id("search_from_name")).clear();
//		webDriver.findElement(By.id("search_from_name")).sendKeys("Thane");
//		sendKeys(webDriver, "id", "search_from_name", "Thane");
		
//		webDriver.findElement(By.id("search_to_name")).clear();
//		webDriver.findElement(By.id("search_to_name")).sendKeys("Pune");
//		sendKeys(webDriver, "id", "search_to_name", "Pune");
//		webDriver.findElement(By.xpath("//input[@id='search_to_date']")).click();
//		click_element(webDriver, "xpath", "//input[@id='search_to_date']");
//		webDriver.findElement(By.linkText("21")).click();
//		click_element(webDriver, "linkText", "21");
//		webDriver.findElement(By.xpath("//button[@type='submit']")).click();
//		click_element(webDriver, "xpath", "//button[@type='submit']");
//		webDriver.findElement(By.xpath("//input[@id='dp1479407933764']")).click();
//		click_element(webDriver, "xpath", "//input[@id='dp1479445910918']");
	
//		webDriver.findElement(By.linkText("22")).click();
//		click_element(webDriver, "linkText", "22");
//		quite_driver(webDriver);
//		webDriver.quit();
		


	}

	

}
