import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;



public class RTAuidsrv extends HttpServlet 
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
try{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String uid=req.getParameter("t1");
		System.out.println("khk"+uid);
		PreparedStatement ps=con.prepareStatement("select emailid from uidgenerate where username=?");
		ps.setString(1,uid);
		ResultSet rs1=ps.executeQuery();
		rs1.next();
		String emailid=rs1.getString(1);
		System.out.println("mailid"+emailid);
		PreparedStatement ps1=con.prepareStatement("select * from citizenpermanentregister where emailid=?");
		ps1.setString(1,emailid);
		ResultSet rs=ps1.executeQuery();
		pw.println("<body bgcolor='cyan'>");
			if(rs.next())
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
			pw.println("</table></center>");
			pw.println("<form action='RTAextraformprocess'>");
			pw.println("age:<input type='number' name='t0'><br/>");
			pw.println("blood group:<input type='text' name='t1'><br/>");
			pw.println("educational qualification:<textarea name='t2'></textarea><br/>");
			pw.println("<input type='hidden' value='"+rs.getString(1)+"' name='processlicense'>");
			pw.println("vehicle:<input type='radio' value='below50cc' name='radio1'>motorcycle below 50cc<br/> <input type='radio' value='above 50cc' name='radio1'>motorcycle above 50cc<br/><input type='radio' value='fourwheeler' name='radio1'/>light motorvehicle(including cars and jeep)<br/><input type='radio' value='transport' name='radio1'/>transport vehicle<br/><input type='radio' value='threewheeler' name='radio1'/>three wheeler <br/> ");
			pw.println("<input type='submit' value='submit'>");
		    pw.println("</form>");
		   
	        }
			pw.println("</body>");
}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
			
	}
				
}
		
		
