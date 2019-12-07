package com.wordpress.testcaes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.wordpress.pages.AmericanDiscountcruises;

public class Verify_Cruise_Test 
{
  @Test
  public void Verify_FunctionalityTes() throws InterruptedException
  {
	  	WebDriver driver=new FirefoxDriver();
	  	driver.get("https://deals.americandiscountcruises.com/web/cruises/search.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 AmericanDiscountcruises americanDiscountcruises=new AmericanDiscountcruises(driver);
		 americanDiscountcruises.Click_on_StartDate();
		 americanDiscountcruises.Select_Startdate();
		 americanDiscountcruises.Click_on_Endate();
		 americanDiscountcruises.Select_on_Endate();
		 americanDiscountcruises.Select_CruiseLine();
		 americanDiscountcruises.Click_On_Search_Button();
		 Thread.sleep(10000);
		 americanDiscountcruises.Click_on_Details();
		// americanDiscountcruises.Click_on_CheckBox();
		// americanDiscountcruises.Click_On_Search_Button();
  }
}
