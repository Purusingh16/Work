package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class First extends GenericServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    public First()
    {
    	System.out.println("Servlet Object is constructed.");
    }
    public  void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
         PrintWriter out=response.getWriter();
         out.println("<html><body bgcolor='yellow'>");
         out.println("<font color='red' size=7>");
         out.println("<center><b>This is First Servlet Program.</b></center>");
         out.println("</font></body></html>");
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
