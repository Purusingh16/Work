package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
         out.println("<b>This is the main program.</b>");
         RequestDispatcher rd=req.getRequestDispatcher("/First.html");
         rd.include(req,res);
         out.println("<br><br><br><br><br><br>");
         out.println("<b>Middle of the main page.</b>");
         out.println("<font color='blue' size='6'><center>");
         out.println("Course Offered.<br><br>");
         out.println("C<br>C++<br>Java<br>Oracle<br>");
         out.println("<b>Main End.</b>");
         RequestDispatcher rr=req.getRequestDispatcher("/test1");
         rr.include(req,res);
	}

}
