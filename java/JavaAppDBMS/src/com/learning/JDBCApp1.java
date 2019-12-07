package com.learning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBCApp1
{
	public static void main(String[] args)throws Exception
	{
//		1.Load and Register Driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//		2.Establish Connection between java appl and database
		Connection con=(Connection) DriverManager.getConnection("jdbc:odbc:puru", "system", "manager");
//		3.Create Either Statement or preparedStatement or CallableStatement
		Statement st=(Statement) con.createStatement();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Table Name:");
		String tname=br.readLine();
//		4.Write and Execute SQL Query.
		st.executeUpdate("create table "+tname+"(eno number primary key,ename varchar2(10),esal number,eaddr varchar2(10)");
		System.out.println("Table "+tname+"Created successfully");
//		5.close resource
		st.close();
		con.close();
		
	}

}
