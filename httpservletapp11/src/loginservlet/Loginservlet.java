package loginservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Loginservlet extends GenericServlet
{
	 Connection cn;
     PreparedStatement ps;

	public void init(ServletConfig config) throws ServletException 
	{
		try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            ps=cn.prepareStatement("select * from user1 where name=? and password=?");
            }catch(Exception ee)
                    {
                    ee.printStackTrace();
                    }
            }
		
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		 res.setContentType("text/html");
         PrintWriter out=res.getWriter();

         try{
         String name=req.getParameter("uname");
         String pass=req.getParameter("pass");
         if ((name==null)&&(name.equals(""))||(pass==null)&&(pass.equals("")))
                 {
                 out.println("<html><body bgcolor='cyan'><center><font color='red' size=6>");
                 out.println("<li><i>User Name and Password can not be blank</i></li><br><br>");
                 out.println("</font></center></body></html>");
                 }
         ps.setString(1,name);
         ps.setString(2,pass);
         ResultSet rs=ps.executeQuery();
         if (rs.next())
                 {
                 out.println("<html><body bgcolor='yellow'><font color='red' size=4><center>");
                 out.println("<b>Welcome To Our Site</b>");
                 out.println("</center></font></body></html>");

                 }
         else
                 {
                 out.println("<b>You are not an authorized User.</b>");
                 }
         }catch(Exception e)
                 {
                 e.printStackTrace();
                 }
		}

}
