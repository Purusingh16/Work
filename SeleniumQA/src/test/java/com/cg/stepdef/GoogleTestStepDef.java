package com.cg.stepdef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cg.utils.Utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleTestStepDef {
	
	private WebDriver driver;
	@Before
	public void setUpEnv() 
	{
		driver=Utils.getWebDriver();
	}
	
	@Given("^User is on google home page$")
	public void user_is_on_google_home_page() throws Throwable 
	{
		driver.get("https://www.google.com/");
	}

	@When("^User enter 'Agile Methodology' in search box$")
	public void user_enter_Agile_Methodology_in_search_box() throws Throwable 
	{
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys("Agile Methodology");
	}

	@When("^enter 'submit' button$")
	public void enter_submit_button() throws Throwable {
		WebElement searchBtn=driver.findElement(By.name("btnK"));
		searchBtn.click();
	}

	@Then("^google search engine should display all links for blog associated with 'Agile Methodlogy'$")
	public void google_search_engine_should_display_all_links_for_blog_associated_with_Agile_Methodlogy() throws Throwable {
		String expectedTitle="Agile Methodology - Google Search";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@When("^User enterd 'Pune Mumbai Distance' in search box$")
	public void user_enterd_Pune_Mumbai_Distance_in_search_box() throws Throwable {
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys("Pune Mumbai Distance");
	}

	@When("^Click on submit button$")
	public void click_on_submit_button() throws Throwable {
		WebElement searchBtn=driver.findElement(By.name("btnK"));
		searchBtn.click();
	}
	
	@Then("^google search engin should open google map between 'Pune and Mumbai' and also show distance in KM$")
	public void google_search_engin_should_open_google_map_between_Pune_and_Mumbai_and_also_show_distance_in_KM() throws Throwable {
		String expectedDistance="148.4 km";
		WebElement actualDistance=driver.findElement(By.xpath("//*[text()='148.4 km']"));
		actualDistance.getText();
		System.out.println("KM :" + actualDistance);
		Assert.assertEquals(expectedDistance, actualDistance);
	}

	@When("^User enterd 'Cucumber' in english language text box$")
	public void user_enterd_Cucumber_in_english_language_text_box() throws Throwable {
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys("Cucumber");
	}

	@When("^Clicked on submit button$")
	public void clicked_on_submit_button() throws Throwable {
		WebElement searchBtn=driver.findElement(By.name("btnK"));
		searchBtn.click();
	}

	@Then("^google search engine should translate 'Cucumber' word into 'Fench language'$")
	public void google_search_engine_should_translate_Cucumber_word_into_Fench_language() throws Throwable {
		
	}

	@After
	public void tearDownEnv()
	{
		if(driver!=null)
		{
			driver.close();
		}
		
	}


}
