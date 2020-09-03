package com.github.naukri.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.naukri.pagebeans.NaukriPageBean;
import com.github.project.utils.Utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NaukriRegStepdef {
	private WebDriver driver;
	private NaukriPageBean naukriPageBean;
	
	@Before
	public void setUpNaukriScenarioEnv()
	{
		driver=Utils.getWebDriver();
	}
	
	@Given("^User is on naukri registration Page$")
	public void user_is_on_naukri_registration_Page() throws Throwable {
		driver.get("https://www.naukri.com/account/createaccount");
		driver.findElement(By.xpath("/html/body/div/form/div[2]/div/button")).click();
		naukriPageBean=PageFactory.initElements(driver, NaukriPageBean.class);
	}

	@When("^user enter valid name and email ID$")
	public void user_enter_valid_name_and_email_ID() throws Throwable {
		naukriPageBean.setFirstname("Purushottam");
		naukriPageBean.setEmailID("purushottam.f.kumar@capgemini.com");
	}

	@When("^user enter create password and mobile number$")
	public void user_enter_create_password_and_mobile_number() throws Throwable {
		naukriPageBean.setPassword("Indian@123");
		naukriPageBean.setMobNumber("7893452233");
	}

	@When("^user select total work experience (\\d+) year and (\\d+) months$")
	public void user_select_total_work_experience_year_and_months(int arg1, int arg2) throws Throwable {
		Select selectDropDown=new Select(driver.findElement(By.xpath("//*[@id=\"basicDetailForm\"]/resman-experience/div/div[1]/div/div[1]/div[1]/ul/li/div/label/input")));
		selectDropDown.selectByIndex(3);
		
	}

	@Then("^user should able to regeister on naukri registration page$")
	public void user_should_able_to_regeister_on_naukri_registration_page() throws Throwable {
		naukriPageBean.registerNow();
	}
	
	@After
	public void tearDownNaukriScenarioEnv()
	{
//		driver.close();
//		driver=null;
		
	}

}
