package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class First extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
         PrintWriter out=response.getWriter();
         String name=request.getParameter("name");
         String pass=request.getParameter("pass");
         String email=request.getParameter("email");
         out.println("<body bgcolor='yellow'><center>Welcome to Mozilla Firefox");
         out.println("<b> Mr. "+name+"<br><br>");
         HttpSession ses=request.getSession();
         ses.setAttribute("uname",name);
         ses.setAttribute("pass",pass);
         out.println("<a href='servlet2'>click me</a>");
         out.println("</center></body>");
         out.close();
	}

}
