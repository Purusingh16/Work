package hidden;

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
        String n=req.getParameter("name");
        out.println("<html><body bgcolor='pink'><font color='black' size='5'>");
        out.println("<center>Name is:"+n);
        out.println("<form action='test'>");
        out.println("<input type='hidden' name='uname' value='"+n+"'>");
        out.println("<input type='text' name='addr'>");
        out.println("<br><input type='submit' name='Retrieve'>");
        out.println("</form></center></font></body></html>");
		
	}

}
