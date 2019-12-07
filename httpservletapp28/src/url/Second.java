package url;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Second extends HttpServlet
{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out=res.getWriter();
        res.setContentType("text/html");
        String name=req.getParameter("uname");
        out.println("<html><body bgcolor='pink'><font color='black' size='5'>");
        out.println("<center><b>Name is: "+name);
	}

}
