package mysql;

import java.io.DataInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Insert 
{
	static final String driver="com.mysql.jdbc.Driver";
    static final String dbConString="jdbc:mysql://localhost/firstschema";
    static final String uname="root";
    static final String password="root";
    
	public static void main(String[] args)
	{
		try 
		{
		DataInputStream dataInputStream=new DataInputStream(System.in);
		System.out.println("Enter your ID");
		int id=Integer.parseInt(dataInputStream.readLine());
		System.out.println("Enter your name");
		String name=dataInputStream.readLine();
		System.out.println("Enter your salary");
		double salary=Double.parseDouble(dataInputStream.readLine());
		Class.forName(driver).newInstance();
		Connection connection=DriverManager.getConnection(dbConString,uname,password);
		
		PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement("insert into employee values(?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setDouble(3, salary);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("check the class");
			e.printStackTrace();
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		} catch (NumberFormatException e) 
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (InstantiationException e) 
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}

}
