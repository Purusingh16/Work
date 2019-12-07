package imageDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ImageDemo extends HttpServlet 
{
	
	public void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException
	{
		 res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         out.println("<html><body bgcolor='pink'><center><font color='black' size='5'>");
         Random r=new Random();
         int i=r.nextInt(5);
         String a[]={"a.jpeg","b.jpeg","c.jpeg","d.jpeg","e.jpeg"};
         res.setHeader("refresh","2");
         out.println("<table border='2'>");
         out.println("<tr><td><img src='"+a[i]+"'>");
         out.println("</td></tr>");
         out.println("<tr><td bgcolor='yellow'><font color='red' size='5'>");
         out.println("Date is : "+new Date());
         out.println("</font></td></tr></table>");
         out.println("</font></center></body></html>");
         out.close();
		
	}

}
