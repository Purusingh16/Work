package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest
{
	WebDriver driver;
	@Given("^Open Firefox and Start Application$")
	public void open_Firefox_and_Start_Application() throws Throwable 
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
	}

	@When("^I enter Valid \"([^\"]*)\" and Valid \"([^\"]*)\"$")
	public void i_enter_Valid_Username_and_Valid_password(String username,String password) throws Throwable 
	{
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	}

	@Then("^User should be able to login Successfully$")
	public void user_should_be_able_to_login_Successfully() throws Throwable 
	{
		driver.findElement(By.id("u_0_o")).click();
	}

}
