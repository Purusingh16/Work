package typeFour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaApp2
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
		Statement st=con.createStatement();
		
		int rowCount1=st.executeUpdate("create table emp100(eno number primary key,ename varchar2(10))");
		System.out.println("Row Count1 :"+rowCount1);
		int rowCount2=st.executeUpdate("drop table emp100");
		System.out.println("Row Count2 :"+rowCount2);
		st.close();
		con.close();
		

	}

}
