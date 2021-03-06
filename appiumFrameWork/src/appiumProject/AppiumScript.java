package appiumProject;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumScript
{
	static AndroidDriver driver;
	static String deviceName = "Google Nexus 5 - 4.4.4 - API 19 - 1080x1920";

	public static void main(String[] args) throws ExecuteException, IOException, InterruptedException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();

        DefaultExecutor executor = new DefaultExecutor();
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();

        CommandLine launchEmul = new CommandLine("C:\\Program Files\\Genymobile\\Genymotion\\player");
        launchEmul.addArgument("--vm-name");
        launchEmul.addArgument("\""+deviceName+"\"");
        executor.setExitValue(1);
        executor.execute(launchEmul, resultHandler);
        Thread.sleep(40);

        capabilities.setCapability("deviceName","Google Nexus 5 - 4.4.4 API 19 - 1080x1920");   
        capabilities.setCapability("platformVersion", "4.4.4");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        capabilities.setCapability("app","E:\\Appium\\apk\\selendroid-test-app-0.17.0.apk");
        

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        System.out.println("SetUp is successful and Appium Driver is launched successfully");
		
	}

}
