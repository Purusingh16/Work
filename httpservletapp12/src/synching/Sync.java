package synching;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SingleThreadModel;


public class Sync extends GenericServlet implements SingleThreadModel
{
	private static final long serialVersionUID = 1L;
	String name="Raj";
    int roll=26;
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		 res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         out.println("Hello");
         name=req.getParameter("name");
         roll=Integer.parseInt(req.getParameter("roll"));
         try{
         Thread.sleep(2000);
         }catch(InterruptedException ie){}
         out.println("<center><font color='red' size=6>");
         out.println("Name is - "+name+"<br>Roll is - "+roll);
         out.println("</font></center>");
		
	}

}
