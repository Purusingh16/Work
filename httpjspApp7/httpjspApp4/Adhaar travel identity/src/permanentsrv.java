
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class permanentsrv extends HttpServlet 
{
      public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
			{
    	  
    	 
    	  res.setContentType("text/html");
		  PrintWriter pw = res.getWriter();
		  pw.println("<body bgcolor='cyan'>");
		  try{
			PreparedStatement ps=con.prepareStatement("select * from citizenpermanentregister");
			ResultSet rs=ps.executeQuery();
			pw.println("<body bgcolor='cyan'>");

				while(rs.next())
				{
				pw.println("<center><table bgcolor='red'>");
				pw.println("<tr><td>Emailid</td>");
				pw.println("<td>"+rs.getString(1)+"</td></tr><br/>");
				pw.println("<tr><td>Registration date</td>");
				pw.println("<td>"+rs.getString(2)+"</td></tr><br/>");
				pw.println("<tr><td>Citizen name</td>");
				pw.println("<td>"+rs.getString(3)+"</td></tr><br/>");
				pw.println("<tr><td>birth date</td>");
				pw.println("<td>"+rs.getString(4)+"</td></tr><br/>");
				pw.println("<tr><td>Contactno</td>");
				pw.println("<td>"+rs.getString(5)+"</td></tr><br/>");
				pw.println("<tr><td>Photo</td>");
		        pw.println("<td><img src='"+rs.getString(15)+"' width=100 height=100/></td></tr><br/>");
				pw.println("<tr><td>Gender</td>");
				pw.println("<td>"+rs.getString(6)+"</td></tr><br/>");
				pw.println("<tr><td>Martial Status</td>");
				pw.println("<td>"+rs.getString(7)+"</td></tr><br/>");
				pw.println("<tr><td>Permanent Address</td>");
				pw.println("<td>"+rs.getString(8)+"</td></tr><br/>");
				pw.println("<tr><td>Current Address</td>");
				pw.println("<td>"+rs.getString(9)+"</td></tr><br/>");
				pw.println("<tr><td>Father name</td>");
				pw.println("<td>"+rs.getString(10)+"</td></tr><br/>");
				pw.println("<tr><td>Mother name</td>");
				pw.println("<td>"+rs.getString(11)+"</td></tr><br/>");
				pw.println("<tr><td>Occupation</td>");
				pw.println("<td>"+rs.getString(12)+"</td></tr><br/>");
				pw.println("<tr><td>Pincode</td>");
				pw.println("<td>"+rs.getString(13)+"</td></tr><br/>");
				pw.println("<tr><td>PAN no</td>");
				pw.println("<td>"+rs.getString(14)+"</td></tr><br/>");
				pw.println("</table>");
				}
				pw.println("/<body>");
		  }
				catch(Exception ee)
				{
				System.out.println(ee);	
				}
		  }
		
			Connection con;
            public void init(ServletConfig cg)throws ServletException
                {
	         try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
			}
		    catch(Exception ee)
		     {
			System.out.println(ee);
			
		     }
		
           }
}
	
