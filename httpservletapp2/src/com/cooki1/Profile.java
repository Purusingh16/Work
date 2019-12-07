package com.cooki1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Profile extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
         PrintWriter out=response.getWriter();
         RequestDispatcher rd=request.getRequestDispatcher("link.html");
         rd.include(request,response);
         Cookie kk[]=request.getCookies();
         if(kk!=null)
                 {
                 String name=kk[0].getValue();
                 out.println("<b>Welcome to your Profile.</b>");
				 out.println("<br><b>Welcome Mr. "+name+"</b>");
                 }
         else
         		{
        	 	out.println("<b>Another time Login.</b>");
        	 	RequestDispatcher rr=request.getRequestDispatcher("login.html");
        	 	rr.include(request,response);
         		}
		
	}

}
