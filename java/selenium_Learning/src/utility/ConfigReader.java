package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader 
{
	Properties properties;
	public ConfigReader()
	{
	try 
	{
		File file=new File("./Configuration/Config.property");
		
		FileInputStream fileInputStream=new FileInputStream(file);
		properties=new Properties();
		properties.load(fileInputStream);
	} 
	catch (Exception e) 
	{
		System.out.println("Exception is:"+e.getMessage());
	}
	}
	public String getChromePath()
	{
		String path=properties.getProperty("ChromeDriver");
		return path;
	}
	public String getApplicationUrl()
	{
		return properties.getProperty("URL");
	}
}
