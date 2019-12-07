package stepDefination;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.sun.tools.internal.xjc.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.SeleniumUtils;

public class Hook 
{
	@Before
	public void setup()
	{
		
	}
	@After
	public void embedScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			try 
			{
				scenario.write("Current Page URL is"+ SeleniumUtils.driver.getCurrentUrl());
				byte[] screenshot=((TakesScreenshot)SeleniumUtils.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
				
			} catch (WebDriverException somePlatformsDontSupportScreenshots)
			{
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}
		}
		SeleniumUtils.closeBrowser();
	}
	

}
