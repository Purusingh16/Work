package selenium_Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridTest {

	
	public static void main(String[] args) throws MalformedURLException 
	{
//		for running through grid you needs:-
//		1.DesiredCapability class object for setting browser information
//		2.RemoteWebDriver instead of FirefoxDriver/InterExplorerDriver/ChromeDriver
		DesiredCapabilities des=new DesiredCapabilities();
		des.setBrowserName("firefox");
		/*des.setBrowserName("internet explorer");*/
		des.setPlatform(Platform.WIN8_1);
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),des);
		driver.get("http://www.google.co.in");
		}

}
