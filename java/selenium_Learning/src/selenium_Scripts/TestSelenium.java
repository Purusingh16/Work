package selenium_Scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium {
	public WebDriver driver;
	
	public void openURL(String url)
	{
		driver=new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	public void signIn() throws Exception
	{
		driver.findElement(By.className("login")).click();
		Thread.sleep(3000);
	}
	public void createAccount()
	{
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("purusingh16@test.com");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
	}
	public void verifyRadioElement()
	{
		List<WebElement>radioELements=driver.findElements(By.name("id_gender"));
		radioELements.get(1).click();
	}
	/*public void verify_signIn() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("purusingh16@outlook.com");
		driver.findElement(By.id("passwd")).sendKeys("dipu123");
		
		driver.findElement(By.id("SubmitLogin")).click();
//		driver.findElement(By.xpath("//*[@id='SubmitLogin']"));
		Thread.sleep(3000);
		
	}
	public void verifyMyAccountElement()
	{
	String text=driver.findElement(By.className("page-heading")).getText();
		System.out.println(text);
	}
	public void verify_Logout()
	{
		driver.findElement(By.className("logout")).click();
//		driver.findElement(By.xpath("//*[@id='SubmitLogin']"));
	}
	
	*/
	public static void main(String[] args) throws Exception 
	{
		TestSelenium ts=new TestSelenium();
		ts.openURL("http://automationpractice.com");
		ts.signIn();
		ts.createAccount();
		/*ts.verify_signIn();
		ts.verifyMyAccountElement();
		ts.verify_Logout();*/
		
	/*	WebDriver driver=new FirefoxDriver();
		driver.get("http://automationpractice.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
//		driver.close();
//		login
//		page-heading
		WebElement signinElement=driver.findElement(By.className("login"));
		signinElement.click();
		
		WebElement emailElement=driver.findElement(By.xpath("//input[@id='email']"));
		emailElement.sendKeys("purusingh16@outlook.com");
		
		WebElement emailElement=driver.findElement(By.id("email"));
		emailElement.sendKeys("purusingh16@outlook.com");
		
		WebElement passwordElement=driver.findElement(By.id("passwd"));
		passwordElement.sendKeys("dipu123");
		
		WebElement submitElement=driver.findElement(By.xpath("//*[@id='SubmitLogin']"));
		submitElement.click();
		
		WebElement myAccountElement=driver.findElement(By.className("page-heading"));
		myAccountElement.getText();
		System.out.println("My Account");
		
		if(myAccountElement.getText().equalsIgnoreCase("My Account"))
			System.out.println("Pass");
		else
			System.out.println("fail");
			
			list<WebElement>radioELements=driver.findElements(By.name("id_gender"));
			radioElements.get(1).click();
			
			
			
*/
	  
	}

}
