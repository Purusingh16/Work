package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
         PrintWriter out=response.getWriter();
         String exp=request.getParameter("exp");
         String skills=request.getParameter("skills");
         HttpSession session=request.getSession();
         session.setAttribute("exp", exp);
         session.setAttribute("skills", skills);
         out.println("<body bgcolor='cyan'>");
         out.println("<center><h1><font color='black'>");
         out.println("Provide City and Salary");
         out.println("</font></h1></center>");
         out.println("<form method='get' action='third'>");
         out.println("<table align='center'>");
         out.println("<tr><td><font color='red' size='5'>");
         out.println("Enter selected City</td>");
         out.println("<td><input type='text' name='city' size='8'></td>");
         out.println("</tr>");
         out.println("<tr><td>Enter your Expected Salary</td>");
         out.println("<td><input type='text' name='salary'></td></font>");
         out.println("</tr><tr><td><input type='submit' value='continue'>");
         out.println("</td></tr></table></form>");
		
	}

}
