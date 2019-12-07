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


public class passportuid extends HttpServlet 
{
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

	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
try{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String Applicantno=req.getParameter("t1");
		String allotmentdate=req.getParameter("t3");
		String verifyanddatacheckedby=req.getParameter("t5");
		String passportsignedby=req.getParameter("t6");
		String expirydate=req.getParameter("t4");
		String email=req.getParameter("t7");
		PreparedStatement ps=con.prepareStatement("select passportno.nextval from dual");
		ResultSet rs=ps.executeQuery();
		rs.next();
		String passportno=rs.getString(1);
		 PreparedStatement ps2=con.prepareStatement(" insert into passportinfo values(?,?,?,?,?,?,?)");
			ps2.setString(1,Applicantno);
			ps2.setString(2,passportno);
			ps2.setString(3,allotmentdate);
			ps2.setString(4,expirydate);
			ps2.setString(5,verifyanddatacheckedby);
			ps2.setString(6,passportsignedby);
			ps2.setString(7,email);
			int k=ps2.executeUpdate();
			String msg="your passportno is : "+passportno;
			Mail.sendMail("subhrajit678@gmail.com","rathchandan678",email,msg);
			
	
	        pw.println(k+"row inserted<br/>");
	        pw.println("A UNIQUE PASSPORT NO IS PROVIDED TO THE USER<br/>");
	        pw.println("<a href='passportofficerhome.html'>GO TO HOME PAGE</a><br/>");
	        pw.println("<a href='login.html'>LOGOUT</a>");
	        
	       
			}
	        catch(Exception ee)
	        {
	        	System.out.println(ee);
	        }
	      }
	    
		
		
		
		
	}

