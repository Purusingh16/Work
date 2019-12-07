package cooki;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Data1
 */
public class Data1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter out=res.getWriter();
        res.setContentType("text/html");
        String n=req.getParameter("name");
        Cookie cc=new Cookie("name",n);
        res.addCookie(cc);
        out.println("<html><body bgcolor='pink'><font color='black' size='5'><center>");
        out.println("Name is:"+n);
        out.println("<form action='servlet2'>");
        out.println("<input type='submit' value='Cookie'>");
        out.println("</form></center></font></body></html>");
		
	}

}
