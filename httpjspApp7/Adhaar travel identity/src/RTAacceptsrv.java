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


public class RTAacceptsrv extends HttpServlet 
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

		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String email=req.getParameter("accept");
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from RTAtable where emailid=?");
		    ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				
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
				String age =rs.getString(16);
				String bloodgroup =rs.getString(17);
				String educationalqualification=rs.getString(18);
				String vehicle=rs.getString(19);
		
				PreparedStatement ps1=con.prepareStatement("insert into RTAtablepermanent values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
		        ps1.setString(16,age);
		        ps1.setString(17,bloodgroup);
		        ps1.setString(18,educationalqualification);
		        ps1.setString(19,vehicle);
		        
		        int k=ps1.executeUpdate();
			    pw.println(k+"row inserted<br/>");
			    pw.println("ALL THE DATAS ARE PERMANENTLY ACCEPTED<br/>");
			    pw.println("<a href='RTAofficerhome.html'>GO TO HOME PAGE</a><br/>");
			    pw.println("<a href='login.html'>LOGOUT</a>");
			}
		}
		catch(Exception ee)
		{
		System.out.println(ee);	
		}
	}
}
		
		
	

