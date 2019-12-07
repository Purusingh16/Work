package param;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class Param extends GenericServlet
{
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
        out.println("<html><body bgcolor='cyan'>");
        out.println("<font color='red' size=7><center>");
        out.println("Init Parameter are - ");
        ServletConfig config=getServletConfig();
        Enumeration ee=config.getInitParameterNames();
        while(ee.hasMoreElements())
                {
                out.println(ee.nextElement()+"\t");
                }
        out.println("<br>The email address is - "+config.getInitParameter("email"));
        out.println("<br>Phone no. is - "+config.getInitParameter("phone"));
	}

}
