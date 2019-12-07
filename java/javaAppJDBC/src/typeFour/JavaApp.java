package typeFour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JavaApp
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
		Statement st=con.createStatement();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.print("Employee Number :");
			int eno=Integer.parseInt(br.readLine());
			System.out.print("Employee Name :");
			String ename=br.readLine();
			System.out.print("Employee salary :");
			float esal=Float.parseFloat(br.readLine());
			System.out.print("Employee address :");
			String eaddr=br.readLine();
			
			st.executeUpdate("insert into emp1 values("+eno+",'"+ename+"',"+esal+",'"+eaddr+"')");
			System.out.println("Employee Inserted successfully");
			System.out.print("Onemore Employee[yes/no]? :");
			String option=br.readLine();
			if(option.equals("no"))
			{
				break;
			}
		}
		br.close();
		st.close();
		con.close();
	}

}
