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


public class RTAofficerhomesrv extends HttpServlet 
{
	Connection con;
	public void init(ServletConfig cg)
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

	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		try
		{
		
			PreparedStatement ps=con.prepareStatement("select * from RTAtable");
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
			pw.println("<tr><td>photo</td>");
			pw.println("<td><img src='"+rs.getString(15)+"' width=100 height=100/></td></tr><br/>");
			pw.println("<tr><td>age</td>");
			pw.println("<td>"+rs.getString(16)+"</td></tr><br/>");
			pw.println("<tr><td>bloodgroup</td>");
			pw.println("<td>"+rs.getString(17)+"</td></tr><br/>");
			pw.println("<tr><td>vehicle</td>");
			pw.println("<td>"+rs.getString(19)+"</td></tr><br/>");
			pw.println("<tr><td>educationalqualification</td>");
			pw.println("<td>"+rs.getString(18)+"</td></tr><br/>");
			pw.println("</table>");
			pw.println("<form action='RTAacceptsrv' >");
			pw.println("<input type='submit' value='accept'>");
			pw.println("<input type='hidden' value='"+rs.getString(1)+"' name='accept'>");
			pw.println("</form>");
			pw.println("<form action='RTArejectsrv' >");
			pw.println("<input type='submit' value='reject'>");
			pw.println("<input type='hidden' value='"+rs.getString(1)+"' name='reject'>");
			pw.println("</form></center>");
			}
			pw.println("</body>");
		}
			catch(Exception ee)
		    {
		    System.out.println(ee);	
		    }
		}
}
		
		
		