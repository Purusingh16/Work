package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet 
{
	Connection cn;
    PreparedStatement ps;
	
	public void init(ServletConfig config) throws ServletException 
	{
		 try
         {
         ServletContext sc=getServletContext();
         String driver=sc.getInitParameter("driver");
         String url=sc.getInitParameter("url");
         Class.forName(driver);
         cn=DriverManager.getConnection(url,"system","manager");
         ps=cn.prepareStatement("select * from user1 where name=? and password=?");

         }
 catch(Exception ee)
         {
         ee.printStackTrace();
         }
		
	}

	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		 PrintWriter out=res.getWriter();
         res.setContentType("text/html");
         try
                 {
                 String uname=req.getParameter("uname");
                 String pass=req.getParameter("pass");
                 if((uname==null)||(uname.equals(""))||(pass==null)||(pass.equals("")))
                         {
                         out.println("<html><body><font color='red' size=6><center>");
                         out.println("<li><b>Username and Password is should not be empty.</b></li></center></font></body></html>");
                         }
                 ps.setString(1,uname);
                 ps.setString(2,pass);
                 ResultSet rs=ps.executeQuery();
                 if(rs.next())
                         {
                         out.println("<html><body><center><font color='red' size=6>");
                         out.println("<li><b>You are an authorised user.</b></li></font></center></body><html>");
                         }
                 }
         catch(Exception eee)
                 {
                 eee.printStackTrace();
                 }
		
	}

}
