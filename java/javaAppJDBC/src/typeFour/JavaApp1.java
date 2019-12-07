package typeFour;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JavaApp1
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
		Statement st=con.createStatement();
		Scanner s=new Scanner(System.in);
		System.out.print("Bonus Amount :");
		int bonus_Amt=s.nextInt();
		System.out.print("Salary Range :");
		float sal_Range=s.nextFloat();
		int rowCount=st.executeUpdate("update emp1 set esal=esal+"+bonus_Amt+" where esal<"+sal_Range);
		System.out.println("No of Records updated :"+rowCount);
		st.close();
		con.close();
	}

}
