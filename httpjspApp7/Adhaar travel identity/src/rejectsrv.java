
import java.io.*;
import java.sql.*;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


     public class rejectsrv extends HttpServlet 
            {
	     Connection con;
	
         public void init() throws ServletException
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
     		String email=req.getParameter("rejectform");
     		System.out.println(email);
  
     		try
    		{
    			PreparedStatement ps=con.prepareStatement("delete citizenregister where emailid=?");
    		    ps.setString(1,email);
    			int k=ps.executeUpdate();
    			pw.println("deleted<br/>");
    			pw.println("PROFILE INFORMATION OF USER IS NOT ACCEPTED<br/>");
    			pw.println("<a href='adminfirstpage.html'>CLICK HERE TO GO TO ADMINHOME PAGE</a><br/>");
    			pw.println("<a href='login.html'>LOGOUT</a>");
			
	        }
     		catch(Exception ee)
     		{
     			System.out.println(ee);
     		}
			}
             
            
       }
