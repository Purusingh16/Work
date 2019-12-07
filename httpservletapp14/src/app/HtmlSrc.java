package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class HtmlSrc extends GenericServlet
{
	
	public void service(ServletRequest request, ServletResponse res) throws ServletException, IOException 
	{
		 PrintWriter out=res.getWriter();
         res.setContentType("text/html");
         out.println("<table border='2'><tr><th>");
         out.println("Odisha</th><th>Maharashtra</th><th>Karnataka</th></table>");
         out.println("<tr><td>Bhubaneswar</td><td>Mumbai</td><td>Bangalore</td></tr></table>");
         out.close();
	}

}
