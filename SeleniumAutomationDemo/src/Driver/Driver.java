package Driver;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//import org.openqa.selenium.remote.InternetExplorerDriver;
import FunctionLibrary.ExcelDataPoolManager;
import FunctionLibrary.Global;
import FunctionLibrary.TestCaseReader;


public class Driver{


	 public static final String USERNAME = "riteshyadav";
	  public static final String AUTOMATE_KEY = "uD6ptGhPQg4x8ncqppps";  
	  
//    public static final String USERNAME = "Priyank43";
//    public static final String AUTOMATE_KEY = "wFaaK5kCqzMBxmz1JM8o";
//    public static final String USERNAME = "kiranbhadale1";
//    public static final String AUTOMATE_KEY = "x1psvaR1zqfU4683MqzG";
 //kiran.yahoo.com@gmail.com----temp1234


 
 public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";


	public void cfnDriver(String mstrTestCase, String msrtMachineAddress, String mstrBrowser)throws InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException 
	{	
		WebDriver webdriver;
		DesiredCapabilities cap = new DesiredCapabilities();	
		int x= mstrTestCase.length();
		//Converting Test case name to ClassName Format
		String s="Modules."+Global.gstrModuleName+".TestScript.";
		String mstrClassName =s.concat(mstrTestCase.substring(0,1).toUpperCase().concat(mstrTestCase.substring(1, x).toLowerCase()));
		//Method Name to call From respective class
		String mstrFunctionName="script";
		try
		{	
			//---------------Getting TestCase information from TestCaseReader Class
			TestCaseReader mxlobj=new TestCaseReader();
			mxlobj.getInfo(mstrTestCase);
			String msrtTC_desc=mxlobj.mstrTest_Desc;
			String msrtModuleName=Global.gstrModuleName;
					
			org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
			//-------Setting PROXY for Machine
			proxy.setHttpProxy(Global.gstrProxy);
			//--------Selecting mention BROWSER as per config file
			if(mstrBrowser.equalsIgnoreCase("firefox"))
			{
				cap=DesiredCapabilities.firefox();
			//	cap.setCapability(CapabilityType.PROXY, proxy);
			}
			else if(mstrBrowser.equalsIgnoreCase("IE"))
			{
				cap=DesiredCapabilities.internetExplorer();
				//cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				
				//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				//capabilities.set(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true); 
				
			}
			else if(mstrBrowser.equalsIgnoreCase("Chrome"))
			{
				cap=DesiredCapabilities.chrome();	
			}
			cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			//----------Creating Remote machine url to execute for RemoteWebDriver
			String url="http://"+msrtMachineAddress+":4445/wd/hub";
			webdriver = new RemoteWebDriver(new URL(url), cap);
			//Wait For Element
			//webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//------Creating Reflection class Object of respective class
			Class<?> c = Class.forName(mstrClassName);
			Object scriptClassObj = c.newInstance();
			//-------accessing member variable from respective testcase class 
			Field mwebdriver=c.getDeclaredField("webdriver");
			mwebdriver.set(scriptClassObj,webdriver);
			//---------------Setting TestCase Name
			Field mTC_Name=c.getDeclaredField("mstrTC_Name"); 
			mTC_Name.set(scriptClassObj,mstrTestCase);
			//---------------Setting TestCase Description
			Field mTC_Desc=c.getDeclaredField("mstrTC_Desc"); 
			mTC_Desc.set(scriptClassObj,msrtTC_desc);
			//---------------Setting Module Name
			Field mTC_Module=c.getDeclaredField("mstrModuleName"); 
			mTC_Module.set(scriptClassObj,msrtModuleName);
			//-------accessing member function from testscript class
			Method m = c.getDeclaredMethod(mstrFunctionName);
			m.invoke(scriptClassObj);

		}catch(Exception e)
		{			
			e.printStackTrace();
			System.out.println("asd==="+e.getMessage());
		}		
	}

	public void cfnDriverCompatibility(String mstrTestCase, String msrtMachineAddress, String mstrBrowser)throws InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException 
	{	
		WebDriver webdriver;
		DesiredCapabilities cap = new DesiredCapabilities();	
		ExcelDataPoolManager oExcelFile = new ExcelDataPoolManager();
		String mstrBrwVersion,mstrOS,mstrOSVersion;
		int x= mstrTestCase.length();
		//Converting Test case name to ClassName Format
		String s="Modules."+Global.gstrModuleName+".TestScript.";
		String mstrClassName =s.concat(mstrTestCase.substring(0,1).toUpperCase().concat(mstrTestCase.substring(1, x).toLowerCase()));
		//Method Name to call From respective class
		String mstrFunctionName="script";
		try
		{	
			//---------------Getting TestCase information from TestCaseReader Class
			TestCaseReader mxlobj=new TestCaseReader();
			mxlobj.getInfo(mstrTestCase);
			String msrtTC_desc=mxlobj.mstrTest_Desc;
			String msrtModuleName=Global.gstrModuleName;
					
			//------Creating Reflection class Object of respective class
			
	
			Class<?> c = Class.forName(mstrClassName);
			Object scriptClassObj = c.newInstance();
			//-------accessing member variable from respective testcase class 
		
		//	mwebdriver.set(scriptClassObj,webdriver);
			//---------------Setting TestCase Name
			Field mTC_Name=c.getDeclaredField("mstrTC_Name"); 
			mTC_Name.set(scriptClassObj,mstrTestCase);
			//---------------Setting TestCase Description
			Field mTC_Desc=c.getDeclaredField("mstrTC_Desc"); 
			mTC_Desc.set(scriptClassObj,msrtTC_desc);
			//---------------Setting Module Name
			Field mTC_Module=c.getDeclaredField("mstrModuleName"); 
			mTC_Module.set(scriptClassObj,msrtModuleName);
			//-------accessing member function from test ,script class
			Field mwebdriver=c.getDeclaredField("webdriver");
			Method m1 = c.getDeclaredMethod(mstrFunctionName);		
			String mstrFilePath = Global.gstrModuleTestDataPath+msrtModuleName+".xls";
			int rowcount =oExcelFile.rowCount(mstrFilePath,"Config File");
			
			Map rowData =null;
			int j;
			for (j=1; j<rowcount; j++)
			{
				//----------  Reading Excel Module Suit File On the Basis of Run Flag -------------
				rowData = oExcelFile.readExcelByRow(mstrFilePath,"Config File" , j);
				String mstrRunFlag=rowData.get("RunStatus").toString();
				if(mstrRunFlag.equalsIgnoreCase("run"))
				{
					System.out.println("Executing TestData Row No : "+ j);
					if("Desktop".equalsIgnoreCase(rowData.get("Device").toString().trim())) //Desktop
					{
						webdriver=null;
						mstrBrowser=rowData.get("Browser").toString().trim();
					    mstrBrwVersion = rowData.get("BrwVersion").toString().trim();
						mstrOS=rowData.get("OperatingSystem").toString().trim();
						mstrOSVersion=rowData.get("OSVersion").toString().trim();
						System.out.println("Running Browser with OS: " +mstrOS +": "+mstrOSVersion + " And Broswer: "+mstrBrowser+" "+mstrBrwVersion);
						
						DesiredCapabilities caps = new DesiredCapabilities();
						caps.setCapability("browser", mstrBrowser);
						caps.setCapability("browser_version", mstrBrwVersion);
						caps.setCapability("os", mstrOS);
						caps.setCapability("os_version", mstrOSVersion);
						caps.setCapability("browserstack.debug", "true");
						Field browserName=c.getDeclaredField("BrowserName"); 
						browserName.set(scriptClassObj,mstrBrowser);
						Field browserVersion=c.getDeclaredField("BrowserVersion"); 
						browserVersion.set(scriptClassObj,mstrBrwVersion);
						Field OS=c.getDeclaredField("OS"); 
						OS.set(scriptClassObj,mstrOS);
						Field OSVersion=c.getDeclaredField("OSVersion"); 
						OSVersion.set(scriptClassObj,mstrOSVersion);
						
						webdriver = new RemoteWebDriver(new URL(URL), caps);
						mwebdriver.set(scriptClassObj,webdriver);
						m1.invoke(scriptClassObj);							
					}
					else //Mobile
					{
						webdriver=null;
						mstrBrowser=rowData.get("Browser").toString().trim();
					    String mstrPlatform= rowData.get("Platform").toString().trim();
						String mstrDeviceName=rowData.get("DeviceName").toString();  //.trim();
						System.out.println("Running Mobile Browser with "+mstrBrowser+" "+mstrDeviceName);
						DesiredCapabilities caps = new DesiredCapabilities();
						caps.setCapability("browserName", mstrBrowser);
						caps.setCapability("platform", mstrPlatform);
						caps.setCapability("device", mstrDeviceName);
						caps.setCapability("browserstack.debug", "true");
						
						Field browserName=c.getDeclaredField("BrowserName"); 
						browserName.set(scriptClassObj,mstrBrowser);
						
						Field OS=c.getDeclaredField("OS"); 
						OS.set(scriptClassObj,mstrDeviceName);
						
						webdriver = new RemoteWebDriver(new URL(URL), caps);
						mwebdriver.set(scriptClassObj,webdriver);
						m1.invoke(scriptClassObj);							
					}
				}
			}
			Method m2 = c.getDeclaredMethod("Endrep");
			m2.invoke(scriptClassObj);
			System.out.println("Done Execution");
		}catch(Exception e)
		{			
			e.printStackTrace();
		}
	}
}

