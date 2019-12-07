package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class UpdateTable 
{
	static final String driver="com.mysql.jdbc.Driver";
    static final String dbConString="jdbc:mysql://localhost/firstschema";
    static final String uname="root";
    static final String password="root";
    
	public static void main(String[] args)
	{
		try 
		{
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(dbConString, uname, password);
			System.out.println("sql connection successfull!!!");
			Statement statement=connection.createStatement();
//			String updatequery="update employee" + " set name= 'kumar'  where id= 101";
//			String updatequery="update employee" + " set name= 'singh',salary=10000  where id= 101";
			String updatequery="Delete  from employee" + " where id= 105";
//			String updatequery="update employee set name= ? where id= ? ";
			PreparedStatement preparedStatement=(PreparedStatement) connection.prepareStatement(updatequery);
//			preparedStatement.setString(1, "101");
//			preparedStatement.setString(2, "kumar");
			
			preparedStatement.execute();
			connection.close();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	    

	}

}
