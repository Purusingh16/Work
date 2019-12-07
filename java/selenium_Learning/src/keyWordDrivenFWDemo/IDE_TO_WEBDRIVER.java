package keyWordDrivenFWDemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class IDE_TO_WEBDRIVER extends CommonFunction
{

	public static void main(String[] args) throws Exception
	{
		String data[][]=FetchDataFromExcel("F:\\Work\\java\\selenium_Learning\\TestData\\demoaqa.xlsx");

		WebDriver webDriver=new FirefoxDriver();
		navigate_to(webDriver, data[2][7]);
		click_element(webDriver, data[3][5], data[3][6],data[3][7]);
		
		sendKeys(webDriver, data[4][5], data[4][6], data[4][7]);
		sendKeys(webDriver, data[5][5], data[5][6], data[5][7]);
		
		click_element(webDriver, data[6][5], data[6][6],data[6][7]);
		click_element(webDriver, data[7][5], data[7][6],data[7][7]);
		
		selectByVisibleText(webDriver, data[8][5], data[8][6], data[8][7]);
		selectByVisibleText(webDriver, data[9][5], data[9][6], data[9][7]);
		selectByVisibleText(webDriver, data[10][5], data[10][6], data[10][7]);
		selectByVisibleText(webDriver, data[11][5], data[11][6], data[11][7]);
		
		sendKeys(webDriver, data[12][5], data[12][6], data[12][7]);
		sendKeys(webDriver, data[13][5], data[13][6], data[13][7]);
		sendKeys(webDriver, data[14][5], data[14][6], data[14][7]);
		sendKeys(webDriver, data[15][5], data[15][6], data[15][7]);
		sendKeys(webDriver, data[16][5], data[16][6], data[16][7]);
		sendKeys(webDriver, data[17][5], data[17][6], data[17][7]);
		sendKeys(webDriver, data[18][5], data[18][6], data[18][7]);
		click_element(webDriver, data[19][5], data[19][6], data[19][7]);
		
//		selectByVisibleText(webDriver, "id", "dropdown_7", "India");
//		selectByVisibleText(webDriver, "id1", "mm_date_8", "7");
		
		
		
		
		
		
		
//		navigate_to(webDriver, "http://demoqa.com");
		
		/*click_element(webDriver, "linkText", "Registration");
		
		sendKeys(webDriver, "id", "name_3_firstname", "Purushottam");
		sendKeys(webDriver, "id", "name_3_lastname", "kumar");
		
		click_element(webDriver, "name", "radio_4[]");
		click_element(webDriver, "name", "checkbox_5[]");*/
		
		
		/*webDriver.findElement(By.linkText("Registration")).click();
		webDriver.findElement(By.id("name_3_firstname")).sendKeys("Purushottam");
		webDriver.findElement(By.id("name_3_lastname")).sendKeys("kumar");
		
		webDriver.findElement(By.name("radio_4[]")).click();
//		webDriver.findElement(By.name("checkbox_5[]")).click();
		webDriver.findElements(By.name("checkbox_5[]")).get(1).click();
		
		Select s1=new Select(webDriver.findElement(By.id("dropdown_7")));
		s1.selectByVisibleText("India");
		
		Select s2=new Select(webDriver.findElement(By.id("mm_date_8")));
		s2.selectByVisibleText("7");
		Thread.sleep(2000);
		
		Select s3=new Select(webDriver.findElement(By.id("dd_date_8")));
		s3.selectByVisibleText("7");
		
		Select s4=new Select(webDriver.findElement(By.id("yy_date_8")));
		s4.selectByVisibleText("1993");
		
		webDriver.findElement(By.id("phone_9")).sendKeys("7387933229");
		
		webDriver.findElement(By.id("username")).sendKeys("dipusingh");
		
		webDriver.findElement(By.id("email_1")).sendKeys("dipusingh16@outlook.com");
		
		webDriver.findElement(By.name("description")).sendKeys("selenium classes");
		
		webDriver.findElement(By.id("password_2")).sendKeys("raaj@singh");
		
		webDriver.findElement(By.id("confirm_password_password_2")).sendKeys("raaj@singh");
		
		*/
	}

}
