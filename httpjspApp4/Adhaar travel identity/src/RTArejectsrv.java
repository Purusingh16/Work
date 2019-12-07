import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RTArejectsrv extends HttpServlet 

{
	Connection con;
	public void init(ServletConfig cg) throws ServletException
	{
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		}
	catch(Exception ee)
	{
		System.out.println(ee);
		
	}
	}

		public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
			{

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String email=req.getParameter("reject");
		

 		try
		{
			PreparedStatement ps=con.prepareStatement("delete RTAtable where emailid=?");
		    ps.setString(1,email);
			int k=ps.executeUpdate();
			pw.println("deleted");
			pw.println(" DATAS ARE REJECTED <br/>");
			pw.println("<a href='RTAofficerhome.html'>GO TO HOME PAGE</a><br/>");
			pw.println("<a href='login.html'>LOGOUT</a>");
		
		}
 		catch(Exception ee)
 		{
 			System.out.println(ee);
 		}
		}
         
        
   }
	