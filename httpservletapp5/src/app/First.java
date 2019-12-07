package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class First implements Servlet 
{
//	private static final long serialVersionUID = 1L;
   
    public First()
    {
//        super();
        System.out.println("Object is constructed.");
    }

	
	public void init(ServletConfig config) throws ServletException
	{
		
	}
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 PrintWriter out=response.getWriter();
         out.println("<html><body bgcolor='cyan'>");
         out.println("<font color='red' size='8'>");
         out.println("<b><center>This is my 1st Servlet.</center></b>");
         out.println("</font></body></html>");
         
	}

	
	public void destroy()
	{
		System.out.println("Servlet object destroyed.");
	}

	
	public ServletConfig getServletConfig() 
	{
		ServletConfig ss=getServletConfig();
		return ss;
	}

	
	public String getServletInfo() 
	{
		String s=getServletInfo();
		return s; 
	}

	
	

}
