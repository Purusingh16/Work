package stepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import applicationpages.FrontPage;
import applicationpages.HomePage;
import applicationpages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.SeleniumUtils;

public class LoginTestSteps {
	private WebDriver driver=null;
	private LoginPage loginPage=null;
	@Given("^user open application on firefox browser$")	
	public void user_open_application_on_firefox_browser()  {
	    driver=SeleniumUtils.openBrowser("chrome", "http://automationpractice.com");
	    
	}
	
	@Given("^user click sign in$")	
	public void clickSignin()  {
	    FrontPage frontPage=new FrontPage(driver);
	    frontPage.clickSignin();
	    
	}

	@When("^user type email into username field$")
	public void user_type_email_into_username_field()  {
	    loginPage=new LoginPage(driver);
	    loginPage.typeEmail("ravieturi@gmail.com");
	    
	}

	@When("^user type password into password field$")
	public void user_type_password_into_password_field()  {
	    loginPage.typePassword("Ravi#19881314");
	    
	}

	@When("^user submit$")
	public void user_submit()  {
	    loginPage.clickSubmit();
	    
	}

	@Then("^user should be logged-in$")
	public void user_should_be_logged_in()  {
	    HomePage homePage=new HomePage(driver);
	    boolean actual= homePage.isUserNameDisplayed();
	    boolean expected=false;
	    Assert.assertEquals(expected, actual);
	    
	}

}
