import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class acceptsrv extends HttpServlet 

{
    public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
			{

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String email=req.getParameter("acceptform1");
		  System.out.println("enter");
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from citizenregister where emailid=?");
		    ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			  System.out.println("enter"+email);
			if(rs.next())
					
			{  
				System.out.println("enter");
			String emailid=rs.getString(1);
			String registrationdate=rs.getString(2);
			String citizenname=rs.getString(3);
			String birthdate=rs.getString(4);
			String contactno=rs.getString(5);
			String gender=rs.getString(6);
			String martialstatus=rs.getString(7);
			String permanentaddress=rs.getString(8);
			String currentaddress=rs.getString(9);
			String fathername=rs.getString(10);
			String mothername=rs.getString(11);
			String occupation=rs.getString(12);
			String pincode=rs.getString(13);
			String panno=rs.getString(14);
			String photo=rs.getString(15);
			  System.out.println("enter59");
			
			PreparedStatement ps1=con.prepareStatement("insert into citizenpermanentregister values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			  System.out.println("enter1");
				    ps1.setString(1,emailid );
			        ps1.setString(2,registrationdate );
			        ps1.setString(3,citizenname );
			        ps1.setString(4,birthdate );
			        ps1.setString(5,contactno);
			        ps1.setString(6,gender );
			        ps1.setString(7,martialstatus);
			        ps1.setString(8,permanentaddress);
			        ps1.setString(9,currentaddress );
			        ps1.setString(10,fathername);
			        ps1.setString(11,mothername );
			        ps1.setString(12,occupation);
			        ps1.setString(13,pincode );
			        ps1.setString(14,panno );
			        ps1.setString(15,photo);
			        System.out.println("enter");
		
			       
			        
			        int k=ps1.executeUpdate();
			        PreparedStatement ps3=con.prepareStatement("select username.nextval from dual");
			        ResultSet rs2=ps3.executeQuery();
			        rs2.next();
			        String un=rs2.getString(1);
			        
			        PreparedStatement ps4=con.prepareStatement("select password.nextval from dual");
			        ResultSet rs3=ps4.executeQuery();
			        rs3.next();
			        String pass1=rs3.getString(1);
			        String username="cse"+un;
			        String password="bca"+pass1;
			        
			        String msg="YOUR USER NAME:  "+username+"       PASSWORRD IS:  "+password;
					Mail.sendMail("subhrajit678@gmail.com","rathchandan678",emailid,msg);
			        PreparedStatement ps2=con.prepareStatement("insert into userlogin  values(?,?,?)");
			        ps2.setString(1, username);
			        ps2.setString(2,password);
			        ps2.setString(3, emailid);
			        int kk=ps2.executeUpdate();
			        pw.println(k+"row inserted<br/>");
			        pw.println("USER'S PROFILE IS VERIFIED AND PERMANENTLY ACCEPTED<br/>");
			        pw.println("GO TO THE ADMIN USER HOME PAGE<br/>");
			        pw.println("<a href='adminfirstpage.html'>click here</a><br/>");
			        pw.println("<a href='login.html'>logout</a>");
			
			}
			}
			catch(Exception ee)
			{
			
			System.out.println(ee);
			}
			
			}		
		
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
}