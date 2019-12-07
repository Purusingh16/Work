package testScripts;

import utils.PropertyFileReader;

public class TestBase 
{
	protected  String url=null;
	protected  String userName=null;
	protected  String passWord=null;
 
public TestBase()
 	{
	loadProperties();
	}
 
public void loadProperties()
 	{
	 	PropertyFileReader.loadProperties();	
	 	url= PropertyFileReader.getProperty("url");
	 	userName= PropertyFileReader.getProperty("username");
	 	passWord= PropertyFileReader.getProperty("password"); 
 	}
 
}
