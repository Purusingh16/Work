package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Footer extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException 
	{
		 res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         out.println("<html><body bgcolor='yellow'><font color='black' size='5'>");
         out.println("<center>IDCO Tower, Rupali Square");
         out.println("</center></font></body></html>");
	}

}
