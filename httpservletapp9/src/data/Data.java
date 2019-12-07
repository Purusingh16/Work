package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Data extends GenericServlet
{
	 Connection cn;
     Statement st;
	
	public void init(ServletConfig config) throws ServletException 
	{
		
        try {
        	ServletConfig sc=getServletConfig();
            String drivername=sc.getInitParameter("driver");
            String url=sc.getInitParameter("url");
			Class.forName(drivername);
			 cn=DriverManager.getConnection(url,"system","manager");
		        st=cn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		 
		try {
			PrintWriter out=res.getWriter();
	         res.setContentType("text/html");
	         int empno=Integer.parseInt(req.getParameter("id"));
	         ResultSet rs = st.executeQuery("select * from employee1 where empno="+empno);
			
			 if (rs.next()) 
	         {
	        	 out.println("<html><body bgcolor='yellow'><font color='red' size='6'>");
	             out.println("<center><table border='9'>");
	             out.println("<tr><th>Emp Name</th>");
	             out.println("<th>Emp Number</th>");
	             out.println("<th>Address</th>");
	             out.println("<th>Salary</th></tr>");
	             out.println("<tr><td>"+rs.getString(1)+"</td>");
	             out.println("<td>"+rs.getInt(2)+"</td>");
	             out.println("<td>"+rs.getString(3)+"</td>");
	             out.println("<td>"+rs.getDouble(4)+"</td>");
	             out.println("</tr></table></center></font></body></html>");
	    
				
			} else 
			{
				out.println("<center>Wrong Entry</center>");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
         
        
	}

}
