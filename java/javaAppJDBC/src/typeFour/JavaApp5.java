package typeFour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JavaApp5 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
		Statement st=con.createStatement();
		boolean b=st.execute("update emp1 set esal=esal+500 where esal<5000");
		System.out.println(b);
		int rowCount=st.getUpdateCount();
		System.out.println("RowCount :"+rowCount);
		st.close();
		st.close();
	}

}
