package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		 PrintWriter out=res.getWriter();
         res.setContentType("text/html");
         out.println("<html><body bgcolor='pink'><font color='black' size='5'><center>");
         String name=req.getParameter("name");
         String pass=req.getParameter("pass");
         out.println("name is : "+name);
         out.println("<br>password is : "+pass);
         out.println("</center></font></body></html>");
		
	}

}
