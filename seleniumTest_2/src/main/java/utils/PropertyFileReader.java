package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader 
{
	private static Properties prop=null;
	private static File file=null;
	
	public static void main(String[] args)
	{
		loadProperties();
		System.out.println(getProperty("username"));
	}
	
	public static String getProperty(String propertyName) 
	{
			if(prop!=null)
			return prop.getProperty(propertyName);
			return null;
	}
	
	private void getFile()
	{
		ClassLoader classLoader = getClass().getClassLoader();
		file = new File(classLoader.getResource("configs/config.properties").getFile());
	}
   public static void loadProperties()
   {
	   	prop = new Properties();
		InputStream input = null;
		try 
		{
			PropertyFileReader propertyFileReader=new PropertyFileReader();
			propertyFileReader.getFile();

			input = new FileInputStream(file);
			// load a properties file
			prop.load(input);

		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
		finally 
		{
			if (input != null)
			{
				try
				{
					input.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
   }
}
