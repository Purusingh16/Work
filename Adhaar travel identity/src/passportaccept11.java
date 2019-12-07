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


public class passportaccept11 extends HttpServlet 
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
			throws ServletException, IOException 
			{
		

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		try
		{
		
			PreparedStatement ps=con.prepareStatement("select * from passporttablepermanent1");
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
			pw.println("<tr><td>Place of birth </td>");
			pw.println("<td>"+rs.getString(16)+"</td></tr><br/>");
			pw.println("<tr><td>State</td>");
			pw.println("<td>"+rs.getString(17)+"</td></tr><br/>");
			pw.println("<tr><td>country</td>");
			pw.println("<td>"+rs.getString(18)+"</td></tr><br/>");
			pw.println("<tr><td>Height(in cm)</td>");
			pw.println("<td>"+rs.getString(19)+"</td></tr><br/>");
			pw.println("<tr><td>Are you working in central Government/State Govt/PSU/Statutory bodies</td>");
			pw.println("<td>"+rs.getString(20)+"</td></tr><br/>");
			pw.println("<tr><td>If you have ever returned to india on Emergency Certificate or were ever deported or repatriated at govt cost then,EC No.,date and place of issue and attach seizure in original,place and country where deported/repartriated</td>");
			pw.println("<td>"+rs.getString(21)+"</td></tr><br/>");
			pw.println("<tr><td>Are any criminal proceedings pending against you before a court in India?if so,give name of court,case number and offence</td>");
			pw.println("<td>"+rs.getString(22)+"</td></tr><br/>");
			pw.println("<tr><td>have you been ever refused/denied passport?if yes give details</td>");
			pw.println("<td>"+rs.getString(23)+"</td></tr><br/>");
			pw.println("<tr><td>Has your passport been ever impounded/revoked?if yes give details</td>");
			pw.println("<td>"+rs.getString(24)+"</td></tr><br/>");
			pw.println("<tr><td>Date</td>");
			pw.println("<td>"+rs.getString(25)+"</td></tr><br/>");
			pw.println("<tr><td>place</td>");
			pw.println("<td>"+rs.getString(26)+"</td></tr><br/>");
			pw.println("<tr><td>particular of person to be intimated in the event of death or accident,so his name</td>");
			pw.println("<td>"+rs.getString(27)+"</td></tr><br/>");
			pw.println("<tr><td>his address</td>");
			pw.println("<td>"+rs.getString(28)+"</td></tr><br/>");
			pw.println("<tr><td>Attach Birth proof certificate</td>");
			pw.println("<td><a href='"+rs.getString(29)+"' >DOWNLOAD</a></td></tr><br/>");
			pw.println("<tr><td>Attach Eductional certificate</td>");
			pw.println("<td><a href='"+rs.getString(30)+"'>DOWNLOAD</a></td></tr><br/>");
			pw.println("<tr><td>Attach Address proof</td>");
			pw.println("<td><a href='"+rs.getString(31)+"'>DOWNLOAD</a></td></tr><br/>");
			pw.println("<tr><td>policestation name</td>");
			pw.println("<td>"+rs.getString(32)+"</td></tr><br/>");
			pw.println("<tr><td>policeincharge name</td>");
			pw.println("<td>"+rs.getString(33)+"</td></tr><br/>");
			pw.println("</center></table>");
	
			}
			pw.println("</body>");
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
			}
}
		
	       
			




