package automationFramework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox_RadioBtn 
{
	static WebDriver driver;

	public static void main(String[] args)
	{
		driver=new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		List<WebElement> rdBtn_Sex=driver.findElements(By.xpath("//input[@type='radio']"));
		
		for (int i = 0; i < rdBtn_Sex.size() ; i++) 
		{
			WebElement local_radio=rdBtn_Sex.get(i);
			String id=local_radio.getAttribute("id");
			System.out.println("value of radio button are:"+id);
			
			if (id.equalsIgnoreCase("sex-1")) 
			{
				System.out.println(".....");
				local_radio.click();
			}
		}
		/*boolean bValue=false;
		
		bValue=rdBtn_Sex.get(0).isSelected();
		
		if(bValue=true)
		{
			rdBtn_Sex.get(1).click();
		}
		else
		{
			rdBtn_Sex.get(0).click();
		}
		
		WebElement rdBtn_Exp =driver.findElement(By.id("exp-0"));
		rdBtn_Exp.click();
		
		List<WebElement> chkBx_Profession = driver.findElements(By.name("profession"));
		
		int iSize=chkBx_Profession.size();
		
		for (int i = 0; i < iSize; i++) 
		{
			String sValue = chkBx_Profession.get(i).getAttribute("value");
			if (sValue.equalsIgnoreCase("Automation Tester"))
			{
				chkBx_Profession.get(i).click();
				break;
			}
			
		}
		WebElement check_box=driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
		check_box.click();
		
		driver.quit();*/
	}

}
