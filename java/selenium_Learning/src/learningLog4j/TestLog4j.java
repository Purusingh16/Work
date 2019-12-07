package learningLog4j;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestLog4j
{
	Logger logger;
	@Test
	public void testLog() throws Exception
	{
		logger=Logger.getLogger("testLog");
		
		logger.debug("starting of selenium page");
		WebDriver webDriver=new FirefoxDriver();
		Thread.sleep(2000);
		logger.debug("mozilla firefox open");
		webDriver.get("https://www.google.co.in");
		logger.debug("navigate to google");
	}
	

}
