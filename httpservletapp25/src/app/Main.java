package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Main extends HttpServlet
{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        String s=req.getParameter("name");
        int age=Integer.parseInt(req.getParameter("age"));
        if(age>17)
                {
                out.println("<body bgcolor='cyan'><font color='black' size='5'>");
                out.println("<center>Hello Mr. "+s+", You are eligible to cast your vote.");
                out.println("</center></font></body>");
                }
        else
                {
                RequestDispatcher rd=req.getRequestDispatcher("/failure.html");
                rd.forward(req,res);
                }
		
	}

}
