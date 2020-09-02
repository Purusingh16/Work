package selenium.Demo.Pack1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Add_to_Cart 
{
	public static WebDriver driver;
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\com.selenium.project\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		String[] names={"Cucumber","Brocolli","Beetroot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		List<WebElement> elements=driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < elements.size(); i++) 
		{
			String[] name=elements.get(i).getText().split("-");
			String formatedName=name[0].trim();
			List itemstoAdd=Arrays.asList(names);
			if (itemstoAdd.contains(formatedName))
			{
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}
		
		
		

	}

}
