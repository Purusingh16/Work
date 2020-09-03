package com.github.reg.stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.github.project.utils.Utils;
import com.github.reg.pagebeans.RegisterPageBean;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDef {
	
	private WebDriver driver;
	private RegisterPageBean registerPagebean;
	
	@Before
	public void setUpStepRegScenarioEnv() {
			driver=Utils.getWebDriver();
	}
	
	@Given("^User is on GitHub Register Page$")
	public void user_is_on_GitHub_Register_Page() throws Throwable {
		driver.get("https://github.com/join?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home");
		registerPagebean=PageFactory.initElements(driver, RegisterPageBean.class);
	}

	@When("^user enter valid username, valid Email and password$")
	public void user_enter_valid_username_valid_Email_and_password() throws Throwable {
		registerPagebean.setUsername("Purusingh16");
		registerPagebean.setUseremail("Purusingh16@outlook.com");
		registerPagebean.setUserpassword("Purusingh@2020");
		
	}
	

	@Then("^user should successfully Sign up for GitHub on his Github Account$")
	public void user_should_successfully_Sign_up_for_GitHub_on_his_Github_Account() throws Throwable {
		registerPagebean.signIn();
	}
	@After
	public void tearDownRegScenarioEnv() {
//			driver.close();
//			driver=null;
	}

}
