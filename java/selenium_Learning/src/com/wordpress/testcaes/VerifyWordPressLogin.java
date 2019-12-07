/**
 * 
 */
package com.wordpress.testcaes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.wordpress.pages.LoginPages;

/**
 * @author purusingh
 *
 */
public class VerifyWordPressLogin 
{
	@Test
	public void verifyvalidLogin()
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		LoginPages loginPages=new LoginPages(driver);
		loginPages.LoginToWordPress("admin","demo");
		/*
		loginPages.typeUserName("admin");
		loginPages.typePassWord("demo123");
		loginPages.clickOnloginbutton();
		*/
		
		/*loginPages.typeUserName();
		loginPages.typePassWord();
		loginPages.clickOnloginbutton();*/
		
		driver.quit();
		
	}

}
