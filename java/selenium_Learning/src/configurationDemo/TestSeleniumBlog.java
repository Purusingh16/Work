package configurationDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class TestSeleniumBlog
{
	@Test
	public void testConfig() throws Exception
	{
		File file=new File("./Configuration/Config.property");
		
		FileInputStream fileInputStream=new FileInputStream(file);
		Properties properties=new Properties();
		properties.load(fileInputStream);
		String chromepath=properties.getProperty("ChromeDriver");
		System.out.println("hey chrome path is ==="+chromepath);
	}
}
