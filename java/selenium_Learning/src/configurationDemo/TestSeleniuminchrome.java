package configurationDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utility.ConfigReader;

public class TestSeleniuminchrome
{
	ConfigReader configReader;
	@BeforeTest
	public void setUp()
	{
		configReader=new ConfigReader();
		System.setProperty("webdriver.chrome.driver", configReader.getChromePath());
		System.out.println("======Setup Ready=======");
		
	}
	@Test
	public void testchrome() throws Exception
	{
		System.out.println("======Test Started=======");
		
		/*File file=new File("./Configuration/Config.property");
		
		FileInputStream fileInputStream=new FileInputStream(file);
		Properties properties=new Properties();
		properties.load(fileInputStream);
		String chromepath=properties.getProperty("ChromeDriver");*/
//		ConfigReader configReader=new ConfigReader();
		
		
		
		WebDriver driver=new ChromeDriver();
//		driver.get("http://www.learn-automation.com");
		driver.get(configReader.getApplicationUrl());
		driver.quit();
		System.out.println("======Test Closed=======");
		
	}

}
