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


public class passportaccept extends HttpServlet 
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
		String email=req.getParameter("passportaccept");
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from passporttablepermanent where emailid=?");
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
					String placeofbirth=rs.getString(16);
					String state=rs.getString(17);
					String country=rs.getString(18);
					String height=rs.getString(19);
					String statement1=rs.getString(20);
					String statement2=rs.getString(21);
					String statement3=rs.getString(22);
					String statement4=rs.getString(23);
					String statement5=rs.getString(24);
					String fillupdate=rs.getString(25);
					String place=rs.getString(26);
					String statementaddress=rs.getString(27);
					String statementname=rs.getString(28);
					String birthproofcertificate=rs.getString(29);
					String eductionalcertificate=rs.getString(30);
					String addressproof=rs.getString(31);
					String policestationname=rs.getString(32);
					String policeinchargename=rs.getString(33);
					
					PreparedStatement ps1=con.prepareStatement("insert into passporttablepermanent1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			        ps1.setString(16,placeofbirth);
			        ps1.setString(17,state);
			        ps1.setString(18,country);
			        ps1.setString(19,height);
			        ps1.setString(20,statement1);
			        ps1.setString(21,statement2);
			        ps1.setString(22,statement3);
			        ps1.setString(23,statement4);
			        ps1.setString(24,statement5);
			        ps1.setString(25,fillupdate);
			        ps1.setString(26,place);
			        ps1.setString(27,statementaddress);
			        ps1.setString(28,statementname);
			        ps1.setString(29,birthproofcertificate);
			        ps1.setString(30,eductionalcertificate);
			        ps1.setString(31,addressproof);
			        ps1.setString(32,policestationname);
			        ps1.setString(33,policeinchargename);
			        
			        
			        
			        int k=ps1.executeUpdate();
				    pw.println(k+"row inserted<br/>");
				    pw.println("ALL THE DATAS ARE INSERTED PERMANENTLY<br/>");
				    pw.println("<a href='passportofficerhome.html'>GO TO HOMEPAGE</a><br/>");
				    pw.println("<a href='login.html'>LOGOUT</a>");
				    
				    }
			}
		catch(Exception ee)
		{
			System.out.println(ee);
		}

}
}
