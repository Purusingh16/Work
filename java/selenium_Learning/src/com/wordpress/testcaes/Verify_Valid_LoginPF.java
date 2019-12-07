package com.wordpress.testcaes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.wordpress.pages.LoginPagesFactory;

import utility.BrowserFactoryPOF;

public class Verify_Valid_LoginPF 
{
	@Test
	public void check_valid_User()
	{
		WebDriver driver=BrowserFactoryPOF.startbrowser("firefox", "http://demosite.center/wordpress/wp-login.php");
		LoginPagesFactory loginPages=PageFactory.initElements(driver, LoginPagesFactory.class);
		loginPages.login_Wordpress("admin", "demo123");
		driver.close();
	}

}

