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
import javax.servlet.http.HttpSession;


public class policesrv extends HttpServlet 
{
	Connection con;
	public void init(ServletConfig cg) throws ServletException
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
		PreparedStatement ps=con.prepareStatement("select * from userpassport");
		ResultSet rs=ps.executeQuery();
		System.out.println("kjhkhk");
		pw.println("<body bgcolor='cyan'>");
		
		while(rs.next())
		{
			System.out.println("sdsfdfdf");
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
			pw.println("<tr><td>placeofbirth</td>");
			pw.println("<td>"+rs.getString(16)+"</td></tr><br/>");
			pw.println("<tr><td>state</td>");
			pw.println("<td>"+rs.getString(17)+"</td></tr><br/>");
			pw.println("<tr><td>country </td>");
			pw.println("<td>"+rs.getString(18)+"</td></tr><br/>");
			pw.println("<tr><td> height</td>");
			pw.println("<td>"+rs.getString(19)+"</td></tr><br/>");
			pw.println("<tr><td>statement1 </td>");
			pw.println("<td>"+rs.getString(20)+"</td></tr><br/>");
			pw.println("<tr><td>statement2</td>");
			pw.println("<td>"+rs.getString(21)+"</td></tr><br/>");
			pw.println("<tr><td>statement3</td>");
			pw.println("<td>"+rs.getString(22)+"</td></tr><br/>");
			pw.println("<tr><td>statement4</td>");
			pw.println("<td>"+rs.getString(23)+"</td></tr><br/>");
			pw.println("<tr><td>statement5</td>");
			pw.println("<td>"+rs.getString(24)+"</td></tr><br/>");
			pw.println("<tr><td>fillupdate</td>");
			pw.println("<td>"+rs.getString(25)+"</td></tr><br/>");
			pw.println("<tr><td>place </td>");
			pw.println("<td>"+rs.getString(26)+"</td></tr><br/>");
			pw.println("<tr><td> statementaddress</td>");
			pw.println("<td>"+rs.getString(27)+"</td></tr><br/>");
			pw.println("<tr><td>statementname</td>");
			pw.println("<td>"+rs.getString(28)+"</td></tr><br/>");
			pw.println("<tr><td>birthproofcertificate </td>");
			pw.println("<td><a href='"+rs.getString(29)+"' >DOWNLOAD</a></td></tr><br/>");
			pw.println("<tr><td>eductionalcertificate </td>");
			pw.println("<td><a href='"+rs.getString(30)+"'>DOWNLOAD</a></td></tr><br/>");
			pw.println("<tr><td>addressproof </td>");
			pw.println("<td><a href='"+rs.getString(31)+"'>DOWNLOAD</a></td></tr><br/>");
			pw.println("</table>");
			pw.println("<form action='policeacceptsrv'>");
			pw.println("policestation name<input type='text' name='t1'><br/>");
			pw.println("policeincharge name<input type='text' name='t2'><br/>");
			pw.println("<input type='submit' value='accept'><br/>");
			pw.println("<input type='hidden' value='"+rs.getString(1)+"' name='policeaccept'>");
			pw.println("</form>");
			pw.println("<form action='policerejectsrv'>");
			pw.println("<input type='submit' value='reject'>");
			pw.println("<input type='hidden' value='"+rs.getString(1)+"' name='policereject'>");
			pw.println("</form></center>");
			System.out.println("mbvmxbvm");   
		}
		pw.println("</body>");
    }
catch(Exception ee)
{
	System.out.println(ee);
}
	}
}


		
		
		
		