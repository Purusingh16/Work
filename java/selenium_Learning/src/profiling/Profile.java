package profiling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Profile
{

	public static void main(String[] args) 
	{
		ProfilesIni profile=new ProfilesIni();
		FirefoxProfile myProfile=profile.getProfile("default");
		WebDriver driver=new FirefoxDriver(myProfile);
		driver.navigate().to("https://www.google.co.in");
//		driver.close();
	}

}
