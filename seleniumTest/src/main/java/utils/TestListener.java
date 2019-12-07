package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import driver.Browser;

public class TestListener extends TestListenerAdapter {
	WebDriver driver;
	private static String fileSeperator = System.getProperty("file.seperator");
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		Throwable th=result.getThrowable();
		StackTraceElement[] outStack=new StackTraceElement[0];
		th.setStackTrace(outStack);
		System.out.println("******" + result.getName() + "has failed***");
		
		driver=Browser.getDriver();
		
		String testClassName=getTestClassName(result.getInstanceName()).trim();
		String testMethodName=result.getName().toString().trim();
		String screenShotName=testMethodName+".png";
		
		if(driver!=null){
			String imagePath=".."+fileSeperator+"Screenshots"+fileSeperator+"Result"+
								fileSeperator+testClassName+fileSeperator+takeScreenShots(driver,screenShotName,testClassName);
			System.out.println("Screenshot: "+ imagePath);
			}
	}
	
	private static String takeScreenShots(WebDriver driver, String screenShotName, String testName)
	{
		File file =new File("Screenshots"+fileSeperator+"Results");
		if(!file.exists()){
			file.mkdir();
		}
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File targetFile = new File("Screenshots"+fileSeperator+"Results"+fileSeperator+testName,screenShotName);
		try {
			FileUtils.copyFile(screenshotFile, targetFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return screenShotName;
	}		
	
	private String getTestClassName(String testName)
	{
		String[] reqTestClassname = testName.split("\\.");
		int i= reqTestClassname.length-1;
		return reqTestClassname[i];
	}
}
		
		
		