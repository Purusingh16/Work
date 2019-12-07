package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Second extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
         PrintWriter out=response.getWriter();
         HttpSession ses=request.getSession(false);
         String name=(String)ses.getAttribute("uname");  //uname was passed when setAttribute was called.
         String pass=(String)ses.getAttribute("pass");
         out.println("<body bgcolor='pink'><center>Welcome to the 2nd page Mr. "+name);
         out.println("<br><br>Is this your Password? "+pass+" :p ");
         out.println("</center></body>");
         out.close();
	}

}
