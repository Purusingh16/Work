package testScripts;

import org.testng.annotations.Test;


import pages.CreateAccountPage;
import pages.FrontPage;
import pages.FrontPage1;
import pages.LoginPage;
import pages.LoginPage1;
import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestCreate_an_accountPage
{
	WebDriver driver=null;
	
	@Test
	public void verifyAccountpage() throws Exception 
		{
		FrontPage1 frontPage1=new FrontPage1(driver);
		CreateAccountPage createAccountPage=new CreateAccountPage(driver);
		LoginPage1 registerPage=frontPage1.clickOnSignIn();
		registerPage.typeEmatypeEmailAddressil("purusingh16@test.com");
		CreateAccountPage createAccountPage1=registerPage.ClickonCreate_an_account();
		
		createAccountPage.clickonButton("id_gender1");
		createAccountPage.typeFirst_name("Purushottam");
		createAccountPage.typeLast_name("kumar");
		createAccountPage.typeEmail("email");
		createAccountPage.typePassword("passwd");
		createAccountPage.selectDate_of_Birth("16","July","2016");
		createAccountPage.typeUserFirstName("Purushottam");
		createAccountPage.typeUserLastName("singh");
		createAccountPage.typeUserCompanyName("Tech.bodhi");
		createAccountPage.typeUserAddress("nagerRoad");
		createAccountPage.typeUserAddressLine2("AshokaPlaza");
		createAccountPage.typeUserCity("pune");
		createAccountPage.selectUserState("Florida");
		createAccountPage.typeUserCode("411047");
		createAccountPage.selectUserCountry("United States");
		createAccountPage.typeAdditionalInfo("passion to learn programming");
		createAccountPage.typeHomePhoneNum("7735933544");
		createAccountPage.typeMobileNumber("7387933229");
		createAccountPage.typeRefInfo("my guru Ritesh Sir");
		Thread.sleep(5000);
		createAccountPage.clickOnTShirts();
	}
@Parameters("browserName")	
@BeforeMethod
public void beforeMethod()
{
	driver=new FirefoxDriver();
	driver.get("http://automationpractice.com");
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	driver.manage().window().maximize();
}


}
