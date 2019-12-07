package url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class First extends HttpServlet
{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		 PrintWriter out=res.getWriter();
         res.setContentType("text/html");
         String name=req.getParameter("name");
         out.println("<html><body bgcolor='yellow'><font color='black' size='5'>");
         out.println("<center>Name is: "+name);
         out.println("<a href='ff?uname="+name+"'>Visit</a>");
         out.println("<>");
	}

}
