package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AmericanDiscountcruises 
{
	WebDriver driver;
	
	By click_on_Startdate=By.id("StartDate");
	By select_Startdate=By.linkText("13");
	By click_on_Endate=By.id("EndDate");
	By select_on_Endate=By.linkText("2");
//	By selectbyvisibleText=By.id("Suppliers");
	By click_on_Search_Button=By.id("btnSearch");
	By click_on_details=By.id("PriceLink_0");
	By click_on_CheckBox=By.id("_ctl0_MainContentsPH__ctl0_SearchResults__ctl0__ctl0__ctl0_SimilarPackagesRepeater__ctl1__ctl0_compareCBox");
	By click_on_Select=By.id("Select");
	
	public AmericanDiscountcruises(WebDriver driver)
	{
		this.driver=driver;
	}
	public void Click_on_StartDate()
	{
		driver.findElement(click_on_Startdate).click();
	}
	public void Select_Startdate()
	{
		driver.findElement(select_Startdate).click();
	}
	public void Click_on_Endate()
	{
		driver.findElement(click_on_Endate).click();
	}
	public void Select_on_Endate()
	{
		driver.findElement(select_on_Endate).click();
	}
	public void Select_CruiseLine()
	{
		Select drop=new Select(driver.findElement(By.id("Suppliers")));
		drop.selectByVisibleText("Royal Caribbean");
	}
	public void Click_On_Search_Button()
	{
		driver.findElement(click_on_Search_Button).click();
	}
	public void Click_on_Details()
	{
		driver.findElement(click_on_details).click();
	}
	public void Click_on_CheckBox()
	{
		driver.findElement(click_on_CheckBox).click();
	}
	public void Click_on_Select_Button()
	{
		driver.findElement(click_on_Select).click();
	}
	
	

}
