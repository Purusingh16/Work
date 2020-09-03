package com.github.project.stepdef;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.project.pagebeans.LogingPageBean;
import com.github.project.utils.Utils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class LoginStepDef {
	private WebDriver driver;
	private LogingPageBean pageBean;
	@Before
	public void setUpStepScenarioEnv() {
			driver=Utils.getWebDriver();
	}
	@Given("^User is on GitHub login Page$")
	public void user_is_on_GitHub_login_Page() throws Throwable {
		driver.get("https://github.com/login");
		pageBean = PageFactory.initElements(driver, LogingPageBean.class);
	}
	@When("^user enter Invalid username and password$")
	public void user_enter_Invalid_username_and_password() throws Throwable {		

		pageBean.setLogin("Purusingh15");
		pageBean.setPassword("Purusingh16");
		pageBean.signIn();
	}
	@Then("^'Incorrect username or password\\.' Message should display$")
	public void incorrect_username_or_password_Message_should_display() throws Throwable {
		String expectedErrorMsg = "Incorrect username or password.";
		String actualErrorMsg = pageBean.getActualErrorMessage();
		Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
	}

	@When("^user enter valid username and password$")
	public void user_enter_valid_username_and_password() throws Throwable {
		pageBean.setLogin("Purusingh16");
		pageBean.setPassword("Purusingh@16");
		pageBean.signIn();
	}

	@Then("^user should successfully Sigin on his Github Account$")
	public void user_should_successfully_Sigin_on_his_Github_Account() throws Throwable {
//		WebDriverWait wait=new WebDriverWait(driver, 30l);
//		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/header/div[7]/details/summary/img")));
		driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/summary/img")).click();
		String getName=driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/div[1]/a/strong")).getText();
		System.out.println("Username:"+getName);
	}
	@After
	public void tearDownScenarioEnv() {
//			driver.close();
//			driver=null;
	}
}
