package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo extends HttpServlet
{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try{
		int first=Integer.parseInt(req.getParameter("no1"));
		int second=Integer.parseInt(req.getParameter("no2"));
		String b1=req.getParameter("btn");
		out.println("<html><body bgcolor='cyan'><center>");
		out.println("<font color='red' size=6>");
		if(b1.equals("+"))
		        {
		        int data=first+second;
		        out.println("Sum is - "+data);
		        }
		else if(b1.equals("-"))
		        {
		        int data=first-second;
		        out.println("Difference is - "+data);
		        }
		else if(b1.equals("*"))
		        {
		        int data=first*second;
		        out.println("Product is - "+data);
		        }
		else
		        {
		        int data=first/second;
		        out.println("Division is - "+data);
		        }
		}catch(ArithmeticException ae)
		        {
		        out.println("Enter 2nd number more than > 0");
		        out.println("<br><br>");
		        out.println("<a href='index.html'>Try again</a>");
		        }
		  catch(NumberFormatException ne)
		        {
		        out.println("Input field should not be empty or any alphabet.");
		        out.println("<br><br>");
		        out.println("<a href='index.html'>Try again</a>");
		        }
		out.println("</font></center></body></html>");
	}

}
