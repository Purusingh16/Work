package com.cooki;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Data2 extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Cookie kk[]=request.getCookies();
        for(int i=0;i<kk.length;i++)
                {
                out.println("<b>Value is: "+kk[i].getValue()+"</b>");
		
                }

	}
}
