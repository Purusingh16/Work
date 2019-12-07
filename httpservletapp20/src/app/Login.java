package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet
{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		 res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         out.println("<html><body bgcolor='pink'><center><font color='black' size='5'>");
         out.println("<br><b>Client Machine IP Address :</b> "+req.getRemoteAddr());
         out.println("<br><b>Server Port Number :</b> "+req.getServerPort());
         out.println("<br><b>Requested Query String is : </b>"+req.getQueryString());
         out.println("<br><b>Username is : </b>"+req.getParameter("uname"));
         out.println("<br><b>Password is : </b>"+req.getParameter("pass"));
         out.close();
	}

}
