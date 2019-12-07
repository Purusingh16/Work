package databaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataBase_Testing 
{

	public static void main(String[] args) 
	{
//		test data
		String name="101";
		String password1="avinash16";
		
//		input testdata using selenium
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(name);
		driver.findElement(By.id("pass")).sendKeys(password1);
		
		
//		connecting to database
		Connection conn=null;
		
		String url="jdbc:mysql://localhost:3306/";
		String databaseName="facebook_login";
		String username="root";
		String password="roor";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url+databaseName, username, password);
			
			String sqlQuery="select * from login";
//			String sqlQuery="select * from login ORDER BY DESC LIMIT 1";
			Statement statement=conn.createStatement();
			ResultSet resultSet=statement.executeQuery(sqlQuery);
			
			resultSet.next();
			System.out.println(resultSet.getString("user_name"));
			System.out.println(resultSet.getString("login_password"));
			
//			database testing
			if (!resultSet.getString("user_name").equals(name)) 
				System.out.println("username is worng");
			if (!resultSet.getString("login_password").equals(password1)) 
				System.out.println("login_password is worng");
				
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		finally
		{
			if (conn!=null)
			{
				conn=null;
			}
		}
	}

}
