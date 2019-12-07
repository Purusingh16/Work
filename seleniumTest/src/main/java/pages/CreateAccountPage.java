package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage 
{
	WebDriver driver=null;
	
	private By TITLE_ID=By.id("id_gender1");
	private By FIRST_NAME_ID=By.id("customer_firstname");
	private By LAST_NAME_ID=By.id("customer_lastname");
	private By EMAIL_ID=By.id("email");
	private By PASSWORD_ID=By.id("passwd");
	private By DAYS_ID=By.id("days");
	private By MONTHS_ID=By.id("months");
	private By YEARS_ID=By.id("years");
	private By USER_FIRST_NAME_ID=By.id("firstname");
	private By USER_LAST_NAME_ID=By.id("lastname");
	private By USER_COMPANY_ID=By.id("company");
	private By USER_ADDRESS_ID=By.id("address1");
	private By USER_ADDRESS_LINE2_ID=By.id("address2");
	private By USER_CITY_ID=By.id("city");
	private By SELECT_USER_STATE_ID=By.id("id_state");
	private By USER_ZIP_POSTAL_CODE_ID=By.id("postcode");
	private By USER_COUNTRY_ID=By.id("id_country");
	private By USER_ADDITIONAL_INFO_ID=By.id("other");
	private By USER_HOME_PHONE_ID=By.id("phone");
	private By USER_MOBILE_NUM_ID=By.id("phone_mobile");
	private By USER_REF_ID=By.id("alias");
	private By navigate_TSHIRTS=By.xpath("//a[text()='T-shirts']");
	
	public CreateAccountPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void clickonButton(String title)
	{
		driver.findElement(TITLE_ID).click();
	}
	public void typeFirst_name(String firstname)
	{
		driver.findElement(FIRST_NAME_ID).sendKeys(firstname);
	}
	public void typeLast_name(String lastname)
	{
		driver.findElement(LAST_NAME_ID).sendKeys(lastname);
	}
	public void typeEmail(String username)
	{
		driver.findElement(EMAIL_ID).sendKeys(username);
	}
	public void typePassword(String password)
	{
		driver.findElement(PASSWORD_ID).sendKeys(password);
	}
	public void selectDate_of_Birth(String birthdays,String birthmonths,String birthyears)
	{
		driver.findElement(DAYS_ID).sendKeys(birthdays);
		driver.findElement(MONTHS_ID).sendKeys(birthmonths);
		driver.findElement(YEARS_ID).sendKeys(birthyears);
	}
	public void typeUserFirstName(String fname)
	{
		driver.findElement(USER_FIRST_NAME_ID).sendKeys(fname);
	}
	public void typeUserLastName(String lname)
	{
		driver.findElement(USER_FIRST_NAME_ID).sendKeys(lname);
	}
	public void typeUserCompanyName(String cname)
	{
		driver.findElement(USER_COMPANY_ID).sendKeys(cname);
	}
	public void typeUserAddress(String firstaddress)
	{
		driver.findElement(USER_ADDRESS_ID).sendKeys(firstaddress);
	}
	public void typeUserAddressLine2(String secondaddress)
	{
		driver.findElement(USER_ADDRESS_LINE2_ID).sendKeys(secondaddress);
	}
	public void typeUserCity(String cities)
	{
		driver.findElement(USER_CITY_ID).sendKeys(cities);
	}
	public void selectUserState(String state)
	{
		driver.findElement(SELECT_USER_STATE_ID).sendKeys(state);
	}
	public void typeUserCode(String zipcode)
	{
		driver.findElement(USER_ZIP_POSTAL_CODE_ID).sendKeys(zipcode);
	}
	public void selectUserCountry(String countries)
	{
		driver.findElement(USER_COUNTRY_ID).sendKeys(countries);
	}
	public void typeAdditionalInfo(String info)
	{
		driver.findElement(USER_ADDITIONAL_INFO_ID).sendKeys(info);
	}
	public void typeHomePhoneNum(String number)
	{
		driver.findElement(USER_HOME_PHONE_ID).sendKeys(number);
	}
	public void typeMobileNumber(String number1)
	{
		driver.findElement(USER_MOBILE_NUM_ID).sendKeys(number1);
	}
	public void typeRefInfo(String alias)
	{
		driver.findElement(USER_REF_ID).sendKeys(alias);
	}
	
	public void clickOnTShirts() 
	{
		 driver.findElements(navigate_TSHIRTS).get(1).click();
		
	}
}
	

	
	
	

