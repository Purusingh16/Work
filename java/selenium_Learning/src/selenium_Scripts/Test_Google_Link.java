package selenium_Scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_Google_Link 
{
	public WebDriver driver;
	
	public void openURL()
	{
		driver=new FirefoxDriver();
		driver.get("https://www.google.co.in");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	/*public void clicklinks(String str) throws Exception
	{
		driver.findElement(By.xpath(str)).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("English")).click();
		Thread.sleep(3000);
	}*/
	public void hindi() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='_eEe']/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("English")).click();
		Thread.sleep(3000);
		
	}
	public void bengali() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='_eEe']/a[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("English"));
		Thread.sleep(3000);
	}
	public void telugu() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='_eEe']/a[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("English"));
		Thread.sleep(3000);	}
	
	public static void main(String[] args) throws Exception
	{
		Test_Google_Link gl=new Test_Google_Link();
		gl.openURL();
		
		gl.hindi();
		gl.bengali();
		gl.telugu();
		/*gl.clicklinks("//*[@id='_eEe']/a[1]");//hindi
		gl.clicklinks("//*[@id='_eEe']/a[2]");//bengali
		gl.clicklinks("//*[@id='_eEe']/a[3]");//telegu
*/	
	}

}
