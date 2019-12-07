package config;

import java.util.concurrent.TimeUnit;

import executionEngine.DriverScript;
import utility.Log;

public class ActionKeywords() 
{
	 public static WebDriver driver;
//	private static Logger Log = Logger.getLogger(Log4j.class.getName());


	public static void openBrowser(String Object,String data)
	{
		Log.info("open the browser");
	try{
		
		if(data.equals("Mozilla Firefox"))
		{
			driver=new FirefoxDriver();
			Log.info("Mozilla browser Strated");
		}
		else if(data.equals("IE"))
		{
			
			driver=new InternetExplorerDriver();
			Log.info("Internet Explorer browser Started");
		}
		
		else if(data.equals("Chrome"))
		{
			driver=new ChromeDriver();
			Log.info("Chrome driver started");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
	}
	
	public static void navigate(String Object,String data)
	{
		try{
		Log.info("navigate the website");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(Constants.URL);
		}
		catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
	}
	public static void click(String Object,String data)
	{
		try{
		Log.info("click on login button"+Object);
		driver.findElement(By.xpath(OR.getProperty(Object))).click();
		}
		catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
		
    }
    public static void input(String Object,String data)
   {
    	try
    	{
    	Log.info("enter the text in"+Object);
	   driver.findElement(By.xpath(OR.getProperty(Object))).sendKeys(data);
    	}
    	catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
   }
   
   
   public static void  waitFor(String Object,String data) throws InterruptedException
   {
	   try{
	   Log.info("Wait for 5 Seconds");
	   Thread.sleep(5000);
	   }
	   catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
   }
	
	
	public static void closeBrowser(String Object,String data)
	{
		try{
		Log.info("close the browser");
		driver.quit();
		}
		catch(Exception e){
			Log.info("Not able to navigate --- " + e.getMessage());
			DriverScript.bResult = false;
			}
	}
}
