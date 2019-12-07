package data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Data extends GenericServlet 
{
	private int x=0;
    public static final int count=5;
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        int y=Integer.parseInt(req.getParameter("name"));
        increment(y);
        out.println("<html><body bgcolor='pink'><font color='black' size=6>");
        out.println("<center>");
        out.println("Value of X is - "+x);
        out.println("</center></font></body></html>");
        }
	void increment(int value)
        {
        x=x+value+count;
        }
		
}


