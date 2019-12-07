package com.cooki1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
         PrintWriter out=response.getWriter();
         String name=request.getParameter("name");
         String password=request.getParameter("pass");
         request.getRequestDispatcher("link.html").include(request,response); //can be written in 1 line, orelse create RequestDispatcher object then call.
         if(password.equals("platformx"))
                 {
                 out.println("<body bgcolor='pink'><font color='black' size='5'><center>");
                 out.println("<b>You have Successfully Logged In.</b><br>Welcome Mr."+name);
                 out.println("</center></font></body>");
                 Cookie cc=new Cookie("name",name);
                 response.addCookie(cc);
                 }
         else
                 {
                 out.println("<b>Sorry for Wrong Attempt.</b>");
                 RequestDispatcher rr=request.getRequestDispatcher("login.html");
                 rr.include(request,response);
                 }
         
	}

}
