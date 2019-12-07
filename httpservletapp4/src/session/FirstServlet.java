package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FirstServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
         PrintWriter out=response.getWriter();
         String name=request.getParameter("name");
         String add=request.getParameter("address");
         int age=Integer.parseInt(request.getParameter("age"));
         HttpSession session=request.getSession();
         session.setAttribute("name",name);
         session.setAttribute("address",add);
         session.setAttribute("age",age);
         out.println("<body bgcolor='pink'><center><h1><font color='black' size='5'>");
         out.println("Provide Your Experience.</font></h1></center>");
         out.println("<form action='second' method='get'>");
         out.println("<table align='center'>");
         out.println("<tr><td>");
         out.println("<font color='black' size='5'>Enter number of years of experience</td>");
         out.println("<td><input type='text' name='exp' size='6'>");
         out.println("</td></tr>");
         out.println("<tr><td>");
         out.println("<b>Select Skill</b>");
         out.println("</td>");
         out.println("<td><select name='skills'>");
         out.println("<option value='java'>J2SE/J2EE</option>");
         out.println("<option value='oracle'>Oracle Administrator</option>");
         out.println("<option value='.Net'>ASP.Net</option>");
         out.println("</select></td></tr>");
         out.println("<tr><td>");
         out.println("<input type='submit' value='continue'>");
         out.println("</td></tr></table></body>");
	}

}
