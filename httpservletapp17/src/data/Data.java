package data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Data extends GenericServlet 
{

	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		 res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         out.println("<html><body bgcolor='cyan'><font color='red' size='6'><center>");
         out.println("<br><br>This is the servlet page.<br><br>");
         String name=req.getParameter("uname");
         out.println("<b>Name is - "+name+"</b></center></font></body></html>");
	}

}
