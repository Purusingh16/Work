package com.cooki;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Data1 extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 PrintWriter out=response.getWriter();
		 response.setContentType("text/html");
         String n=request.getParameter("name");
         Cookie cc=new Cookie("name",n);
         response.addCookie(cc);
         out.println("<html><body bgcolor='pink'><font color='black' size='5'><center>");
         out.println("Name is:"+n);
         out.println("<form action='servlet2'>");
         out.println("<input type='submit' value='Cookie'>");
         out.println("</form></center></font></body></html>");
	}

}
