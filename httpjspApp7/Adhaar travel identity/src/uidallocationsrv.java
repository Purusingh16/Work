import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class uidallocationsrv extends HttpServlet
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
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
			{
		try{
        res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String Applicationno=req.getParameter("t1");
		String Surveyername=req.getParameter("t2");
		String Adhaarno=req.getParameter("t3");
		String email=req.getParameter("t4");
		PreparedStatement ps=con.prepareStatement("select username.nextval from dual");
		ResultSet rs=ps.executeQuery();
		rs.next();
		String username=rs.getString(1);
		PreparedStatement ps1=con.prepareStatement("select password.nextval from dual");
		ResultSet rs1=ps1.executeQuery();
		rs1.next();
		String password=rs1.getString(1);
		System.out.println("khk");
		
		
		    PreparedStatement ps2=con.prepareStatement(" insert into uidgenerate values(?,?,?,?,?,?)");
			ps2.setString(1,Applicationno);
			ps2.setString(2,Surveyername);
			ps2.setString(3,Adhaarno);
			ps2.setString(4,password);
			ps2.setString(5,email);
			ps2.setString(6,username);
			int k1=ps2.executeUpdate();
			System.out.println("khk1");
			
			PreparedStatement ps3=con.prepareStatement("insert into userlogin values(?,?,?)");
			ps3.setString(1,username);
			ps3.setString(2,password);
			String msg="your username : "+username+"    your password: "+password;
			System.out.println("khk3");
			
		Mail.sendMail("subhrajit678@gmail.com","rathchandan678",email,msg);
			
		int k=ps3.executeUpdate();
        pw.println(k+"row inserted<br/>");
        pw.println(" UID IS ALLOTED TO THE  USER<br/>");
		pw.println("<a href='adminfirstpage.html'>GO TO HOMEPAGE</a><br/>");
		pw.println("<a href='login.html'>LOGOUT</a>");
        
       
		}
        catch(Exception ee)
        {
        	System.out.println(ee);
        }
      }
    }
		
		
		
		
		
		
		