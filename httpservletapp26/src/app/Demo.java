package app;

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
		 PrintWriter out=res.getWriter();
         res.setContentType("text/html");
         String ss=req.getParameter("tsearch");
         String se=req.getParameter("seng");
         String url=null;
         if(se.equals("google"))
                 {
                 url="http://www.google.co.in/search?q="+ss;
                 }
        else if(se.equals("bing"))
                 {
                 url="http://www.bing.com/search?q="+ss;
                 }
         else
                 {
                 url="http://search.yahoo.com/search?q="+ss;
                 }

         res.sendRedirect(url);
	}

}
