package com.cg.bddapp.stepdefs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.cg.bddapp.utils.Utils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class GoogleSerachStepDef {
	private WebDriver driver;
	@Before
	public void setUpStepsEnv() {
		driver=Utils.geWebDriver();
	}
	@Given("^User is on google home page$")
	public void user_is_on_google_home_page() throws Throwable {
		driver.get("https://www.google.in");
	}
	@When("^User enter 'Agile Methodology' in serach box$")
	public void user_enter_Agile_Methodology_in_serach_box() throws Throwable {
		WebElement serachBoxElement = driver.findElement(By.name("q"));
		serachBoxElement.sendKeys("Agile Methodology");
	}
	@When("^enter 'submit' button$")
	public void enter_submit_button() throws Throwable {
		  WebElement serachBtn = driver.findElement(By.name("btnK"));
		    serachBtn.click();
	}

	@Then("^google serach engin should display all links for blogs associated with 'Agile Methodology'$")
	public void google_serach_engin_should_display_all_links_for_blogs_associated_with_Agile_Methodology() throws Throwable {
		String expectedTitle ="Agile Methodology - Google Search";
		String actualTitle =driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@When("^User enterd 'Pune Mumbai Distance' in serach box$")
	public void user_enterd_Pune_Mumbai_Distance_in_serach_box() throws Throwable {
	}

	@When("^Clicked on submit button$")
	public void clicked_on_submit_button() throws Throwable {
	}

	@Then("^google serach engin should open google map between 'Pune and Mumbai' and also show distance in KM$")
	public void google_serach_engin_should_open_google_map_between_Pune_and_Mumbai_and_also_show_distance_in_KM() throws Throwable {
	}

	@When("^User enterd 'Cucumber' in english language text box$")
	public void user_enterd_Cucumber_in_english_language_text_box() throws Throwable {
	}

	@Then("^google serach engin should tanslate 'Cucumber' word into 'French language'$")
	public void google_serach_engin_should_tanslate_Cucumber_word_into_French_language() throws Throwable {
	}

	@After
	public void  tearDownStepsEnv() {
		driver.close();
		driver = null;
	}
}
