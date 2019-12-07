package counter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class Counter extends GenericServlet
{
//	private static final long serialVersionUID = 1L;
       
    
    public Counter()
    {
//        super();
        System.out.println("Servlet Object Constructed.");
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
         PrintWriter out=response.getWriter();
         int count = 0;
         count++;
         out.println("<html><body bgcolor='cyan'>");
         out.println("<font color='red' size=7><center>");
         out.println("At present service() is called : "+count+" times.");
         out.println("</center></font></body></html>");
		
	}

}
