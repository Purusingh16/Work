package stepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import applicationpages.FrontPage;
import applicationpages.HomePage;
import applicationpages.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utils.SeleniumUtils;
import cucumber.api.java.en.Then;

public class LoginSteps{
	WebDriver driver=null;
	FrontPage frontpage;
	LoginPage loginpage;
	HomePage homepage;
@Given("^User should open application \"(.*?)\" on \"(.*?)\" browser$")
public void user_should_open_application_url_on_firefox_browser(String url,String browserName) 
{
	 driver= SeleniumUtils.openBrowser( browserName,url);
   
}


@When("^User clicks on sign in link$")
public void user_clicks_on_sign_in_link()  {
   
   // throw new PendingException();
	
	frontpage=new FrontPage(driver);
	  frontpage.clickSignin();
}

@When("^User enters \"(.*?)\" in username field$")
public void user_enters_email_in_username_field(String email)  {
	loginpage=new LoginPage(driver);
	  loginpage.typeEmail(email);
    
}

@When("^User enters \"(.*?)\" in password field$")
public void user_enters_password_in_password_field(String password) 
{
	loginpage.typePassword(password);
	  
    
}

@When("^user clicks Signin button$")
public void user_clicks_Signin_button()
{
	loginpage.clickSubmit();
    
}

@Then("^User should (be|not be) login$")
public void user_should_login(String positive)  
{   if(positive.equalsIgnoreCase("be")){
	

	homepage=new HomePage(driver);
String actual= homepage.getUserName();
String expected="NIdhi Jaipuria";
Assert.assertEquals(actual, expected);
 homepage.isUserNameDisplayed();
}  
else
{
	loginpage=new LoginPage(driver);
	String actual= loginpage.signInError();
	String expected="Authentication failed.";
	Assert.assertEquals(actual, expected);
}

}
}

	
/*@Then("^User should not login successfully$")
public void user_should_not_login_successfully() 
{
   
   
}
} */


 

