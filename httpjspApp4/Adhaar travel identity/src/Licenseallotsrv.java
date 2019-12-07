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


public class Licenseallotsrv extends HttpServlet 
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
			throws ServletException, IOException 
			{
    	  try{
        res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String Applicationno=req.getParameter("t1");
		String allotmentdate=req.getParameter("t2");
		String expirydate=req.getParameter("t3");
		String email=req.getParameter("t4");
		PreparedStatement ps=con.prepareStatement("select licenseno.nextval from dual");
		ResultSet rs=ps.executeQuery();
		rs.next();
		String licenseno=rs.getString(1);
		 PreparedStatement ps2=con.prepareStatement(" insert into rtagenerate values(?,?,?,?,?)");
			ps2.setString(1,Applicationno);
			ps2.setString(2,allotmentdate);
			ps2.setString(3,expirydate);
			ps2.setString(4,email);
			ps2.setString(5,licenseno);
		    
			int k1=ps2.executeUpdate();
		
		String msg="YOUR LICENSE NO :  "+licenseno;
			Mail.sendMail("subhrajit678@gmail.com","rathchandan678",email,msg);
			pw.println("LICENSE NO IS ALLOTED TO THE REGISTERED USER<br/>");
			pw.println("<a href='RTAofficerhome.html'>GO TO HOMEPAGE</a><br/>");
			pw.println("<a href='login.html'>LOGOUT</a>");
    	  }
			 catch(Exception ee)
		        {
		        	System.out.println(ee);
		        }
			}
}

		
		
		
		
		
		