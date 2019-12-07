package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Register extends GenericServlet 
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
         ps=cn.prepareStatement("insert into user1 values(?,?)");
         }
 catch (Exception ee)
         {
         ee.printStackTrace();
         }
		
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		 res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         try
                 {
                 String uname=req.getParameter("uname");
                 String pass=req.getParameter("pass");
                 String repass=req.getParameter("repass");
                 if((uname==null)||(uname.equals(""))||(pass==null)||(pass.equals(""))||(!pass.equals(repass)))
                         {
                         out.println("<html><body><center>");
                         out.println("<font color='red' size=6>");
                         out.println("<li><b>Try Again.</b></li>");
                         out.println("</font></center></body></html>");
                         }
                 ps.setString(1,uname);
                 ps.setString(2,pass);
                 int count=ps.executeUpdate();
                 if(count==1)
                         {
                         out.println("<html><body><center><font color='red' size='6'>");
                         out.println("<b>Welcome Mr. "+uname+"</b>");
                         out.println("</font></center></body></html>");
                         }
                 }
         catch(Exception e)
                 {
                 e.printStackTrace();
                 }
		
	}

}
