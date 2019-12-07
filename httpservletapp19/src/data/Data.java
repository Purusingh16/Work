package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Data extends HttpServlet
{
	  Connection cn;
      PreparedStatement ps;
	
	public void init(ServletConfig config) throws ServletException
	{
		try{
            ServletConfig sc=getServletConfig();
            String driver=sc.getInitParameter("driver");
            String url=sc.getInitParameter("url");
            Class.forName(driver);
            cn=DriverManager.getConnection(url,"system","manager");
            ps=cn.prepareStatement("select empname,sal from employee1 where empno=?");
            }catch(Exception ee)
                    {
                    ee.printStackTrace();
                    }
	}

	
	public void destroy()
	{
		try{
            if(ps!=null)
                    {
                    ps.close();
                    }
            }catch(Exception e)
                    {
                    e.printStackTrace();
                    }
            try{
            if(cn!=null)
                    {
                    cn.close();
                    }
            }catch(Exception eee)
                    {
                    eee.printStackTrace();
                    }
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		 try{
             int no=Integer.parseInt(req.getParameter("id"));
             PrintWriter out=res.getWriter();
             res.setContentType("text/html");
             ps.setInt(1,no);  //this sets the value we give in the input in the browser to the ? in the select command we gave above.
             ResultSet rs=ps.executeQuery();
             if(rs.next())
                     {
                     out.println("<html><body bgcolor='cyan'><center><font color='red' size='6'>");
                     out.println("<br><b><i>Employee Name is - "+rs.getString(1));  //the number in the argument depends on the select command written above. see that, we have displayed only empname and sal. so empname-1 and sal-2. if * would have given, then acc. to the table order/structure, we should have given empname-2 and sal-3.
                     out.println("</i></b><br><br>");
                     out.println("<b><i>Employee Salary is - "+rs.getDouble(2));  
                     out.println("</i></b></font></center></body></html>");
                     }
             }catch(Exception ee)
                     {
                     ee.printStackTrace();
                     }
		
	}

}
