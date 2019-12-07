package Modules.SeleniumDemo.TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import FunctionLibrary.Global;
import FunctionLibrary.HTML_Report;

public class TC_Verify_Purchase_Functionality {

	private WebDriver driver;
	public String mstrTC_Name,mstrTC_Desc,mstrModuleName;
	public HTML_Report Tc01;
	public Global G = new Global();
	
	@SuppressWarnings("static-access")
	@BeforeTest
	@Parameters("Browser")
	public void beforeTest(String Browser) throws Exception {
		
		if (Browser.equalsIgnoreCase("FireFox")){
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			driver = new FirefoxDriver(capability);				
		}else if (Browser.equalsIgnoreCase("InternetExplorer")){
			System.setProperty("webdriver.ie.driver","../SeleniumAutomationDemo/src/Utils/chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver = new InternetExplorerDriver(capabilities);
		}else{
			System.setProperty("webdriver.chrome.driver","../FresherTraining/Resource/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");		
		
		
		Tc01=new HTML_Report(driver);
		Tc01.mstrTC_Name="TC_Verify_Purchase_Functionality_"+Browser;
		Tc01.mstrTC_Desc="To verify loan emi functionality of application";
		Tc01.mstrModuleName="SeleniumDemo";
		G.gstrModuleName = "SeleniumDemo";
		G.cfnRootPath();
		G.cfnModuleRootPath();		
	}

	@Test
	public void f() throws Exception {
		//-------- Application Launch-------------
		Tc01.details_append("To verify application Login","","","");
		if (driver.findElement(By.className("login")).isDisplayed()){
			Tc01.details_append("To verify application launch","User should able to launch application","User is able to launch application","Pass");
		}
		else{
			Tc01.details_append("To verify application launch","User should able to launch application","User is not able to launch application","Fail");
		}
		driver.findElement(By.className("login")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("email")).sendKeys("naresh@platformx.tech");
		driver.findElement(By.id("passwd")).sendKeys("platform@123");
		driver.findElement(By.id("SubmitLogin")).click();

		Thread.sleep(5000);
		if(driver.findElement(By.className("logout")).isDisplayed()){
			Tc01.details_append("To verify application login","User should able to login in application","User is able to login in application","Pass");
		}else{
			Tc01.details_append("To verify application login","User should able to login in application","User is not able to login in application","Fail");
		}
		//================   Select a casual dress from dress section  ===============
		Tc01.details_append("To verify select product functionality","","","");
		driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='categories_block_left']/div/ul/li[1]/a")).click();
		Thread.sleep(2000);
		//------Select printed dress---------------
		driver.findElement(By.xpath(".//*[@id='center_column']/ul/li/div/div[2]/h5/a")).click();
		Thread.sleep(5000);
		if (driver.findElement(By.xpath(".//*[@id='add_to_cart']/button")).isDisplayed()){
			Tc01.details_append("To verify select product functionality","User should able to select a dress from product list","User is able to select a dress from product list","Pass");
		}else{
			Tc01.details_append("To verify select product functionality","User should able to select a dress from product list","User is not able to select a dress from product list","Fail");
		}
		//============  Add to cart =================
		Tc01.details_append("To verify Add To Cart functionality","","","");
		//---- Quantity and Size -----------
		driver.findElement(By.xpath(".//*[@id='quantity_wanted']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='quantity_wanted']")).sendKeys("2");
		Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='group_1']")));
		dropdown.selectByVisibleText("M");		
		//------------- click 'Add To Cart' button -----------
		driver.findElement(By.xpath(".//*[@id='add_to_cart']/button")).click();
		Thread.sleep(5000);
		//driver.switchTo().frame(0);
		Thread.sleep(5000);
		String mstrProductName = driver.findElement(By.id("layer_cart_product_title")).getText();
		String minQuantity = driver.findElement(By.xpath(".//*[@id='layer_cart_product_quantity']")).getText();
		int mintQNT = Integer.parseInt(minQuantity);
		
		if ((mstrProductName.equalsIgnoreCase("Printed Dress")) && (mintQNT == 2) ){
			Tc01.details_append("To verify Add To Cart functionality","User should able to add product to add to cart","User is able to add product to add to cart","Pass");
		}else{
			Tc01.details_append("To verify Add To Cart functionality","User should able to add product to add to cart","User is not able to add product to add to cart","Fail");
		}
		Thread.sleep(10000);
		
		//============== Proceed to Check Out ================
		//------ Click on Proceed Button -----------
		Tc01.details_append("To verify Payment functionality","","","");
		driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
		if (driver.findElement(By.xpath(".//*[@id='order_step']/li[1]/span")).isDisplayed()){
			Tc01.details_append("To verify Add To Cart Summary functionality","User should able to navigate to Cart Summary page","User is able to navigate to Cart Summary page","Pass");
		}else{
			Tc01.details_append("To verify Add To Cart Summary functionality","User should able to navigate to Cart Summary page","User is not able to navigate to Cart Summary page","Fail");
		}
		//--------- Navigate to address details summary 
		driver.findElement(By.xpath(".//*[@id='center_column']/p[2]/a[1]/span")).click();
		Thread.sleep(5000);
		if (driver.findElement(By.xpath(".//*[@id='columns']/div[1]")).isDisplayed()){
			Tc01.details_append("To verify navigate to address detail summary functionality","User should able to navigate to address detail summary page","User is able to navigate to address detail summary page","Pass");
		}else{
			Tc01.details_append("To verify navigate to address detail summary functionality","User should able to navigate to address detail summary page","User is not able to navigate to address detail summary page","Fail");
		}
		driver.findElement(By.xpath(".//*[@id='center_column']/form/p/button")).click();
		Thread.sleep(5000);
		if (driver.findElement(By.xpath(".//*[@id='columns']/div[1]")).isDisplayed()){
			Tc01.details_append("To verify navigate to shipping detail summary functionality","User should able to navigate to shipping detail summary page","User is able to navigate to shipping detail summary page","Pass");
		}else{
			Tc01.details_append("To verify navigate to shipping detail summary functionality","User should able to navigate to shipping detail summary page","User is not able to navigate to shipping detail summary page","Fail");
		}
		driver.findElement(By.xpath(".//*[@id='cgv']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='form']/p/button")).click();
		Thread.sleep(5000);
		if (driver.findElement(By.xpath(".//*[@id='columns']/div[1]")).isDisplayed()){
			Tc01.details_append("To verify navigate to payment method detail summary functionality","User should able to navigate to payment detail summary page","User is able to navigate to payment detail summary page","Pass");
		}else{
			Tc01.details_append("To verify navigate to payment detail summary functionality","User should able to navigate to payment detail summary page","User is not able to navigate to payment detail summary page","Fail");
		}
		driver.findElement(By.xpath(".//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")).click();
		Thread.sleep(5000);
		if ((driver.findElement(By.xpath(".//*[@id='center_column']/form/div/h3")).getText()).equalsIgnoreCase("Check payment")){
			Tc01.details_append("To verify check out functionality","User should able to navigate to order summary page","User is able to navigate to order before check out summary page","Pass");
		}else{
			Tc01.details_append("To verify check out functionality","User should able to navigate to order summary page","User is not able to navigate to order before check out summary page","Fail");
		}
		driver.findElement(By.xpath(".//*[@id='cart_navigation']/button")).click();
		Thread.sleep(5000);
		
		if ((driver.findElement(By.xpath(".//*[@id='columns']/div[1]/span[2]")).getText()).equalsIgnoreCase("Order confirmation")){
			Tc01.details_append("To verify order confirmation","User should able to place order at mystore","User is able to place order at mystore","Pass");
		}else{
			Tc01.details_append("To verify order confirmation","User should able to place order at mystore","User is not able to place order at mystore","Fail");
		}
		//================ Logout from application ======================
		driver.findElement(By.className("logout")).click();
		Thread.sleep(5000);
		Tc01.details_append("To verify application logout","","","");
		if (driver.findElement(By.className("login")).isDisplayed()){
			Tc01.details_append("To verify application logout","User should able to logout from  application","User is able to logout from application","Pass");
		}
		else{
			Tc01.details_append("To verify application logout","User should able to logout from application","User is not able to logout from application","Fail");
		}
	}

	@AfterTest
	public void afterTest() throws Exception { 
		Tc01.end_Report();
		driver.quit();
	}

}
