package amazonlogin;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class AmazonAdd_to_Cart 
{
	public WebDriver driver=null;
  @Test
  public void verifyLogin() throws Exception 
  {
	  Logger logger=Logger.getLogger("AmazonAdd_to_Cart");
	  PropertyConfigurator.configure("log4j.properties");
	  driver.findElement(By.id("ap_email")).sendKeys("7387933229");
	  logger.info("pass U-ID");
	  driver.findElement(By.id("ap_password")).sendKeys("dipusingh");
	  logger.info("pass pwd");
	  driver.findElement(By.id("signInSubmit")).click();
	  logger.info("click on sign button");
	  Thread.sleep(3000);
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("chetan bhagat book");
	  driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(".//*[@id='result_0']/div/div/div/div[1]/div/div/a/img")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("add-to-cart-button")).click();
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_signin");
	  driver.manage().window().maximize();
  }

}
