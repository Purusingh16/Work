package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Text extends HttpServlet
{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		 res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         out.println("<html><body bgcolor='pink'><font color='black' size='5'><center>");
         out.println("<b>Browser Software Name is : </b>"+req.getHeader("user-agent"));
         out.println("<br><b>Request Protocol is : </b>"+req.getProtocol());
         out.println("</center></font></body></html>");
         out.close();

	}

	
	

}
