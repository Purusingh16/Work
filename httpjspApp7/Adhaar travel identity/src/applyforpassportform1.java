import java.io.*;
import java.sql.Connection;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javazoom.upload.*;


public class applyforpassportform1 extends HttpServlet 
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
	
	public void doPost(HttpServletRequest request, HttpServletResponse res)
			throws ServletException, IOException 
			{
		try{
			String filepath1="D:/projectfile1";
			String filepath2="D:/projectfile2";
			String filepath3="D:/projectfile3";
			System.out.println("khgjkxfhgh");
			MultipartFormDataRequest req=new MultipartFormDataRequest(request);
			 UploadBean upb=new UploadBean();
		
				
			    upb.setFolderstore(filepath1);
			    upb.setOverwrite(false);
			    upb.store(req,"t12");
			    System.out.println("khgjkx098808fhgh");
				
				upb.setFolderstore(filepath2);
				upb.setOverwrite(false);
				upb.store(req,"t13");
				System.out.println("7878khgjkxfhgh");
				upb.setFolderstore(filepath3);
				upb.setOverwrite(false);
				upb.store(req,"t14");
				
				System.out.println("khg90909090jkxfhgh");
				Vector history=upb.getHistory();
				ArrayList filesName=new ArrayList();
				for(int i=0;i<history.size();i++)
				{
					UploadParameters up=(UploadParameters)history.elementAt(i);
					filesName.add(up.getFilename());
					
				}
				String file1=(String)filesName.get(0);
				String filepath4=filepath1+"/"+file1;
				String file2=(String)filesName.get(1);
				String filepath5=filepath2+"/"+file2;
				String file3=(String)filesName.get(2);
				String filepath6=filepath3+"/"+file3;
				
				
				

		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String email=req.getParameter("processpassport");
		System.out.println("ghhhhh");
		PreparedStatement ps=con.prepareStatement("select * from citizenpermanentregister where emailid=?");
	    ps.setString(1,email);
		ResultSet rs=ps.executeQuery();
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
		
		String placeofbirth=req.getParameter("t0");
		String state=req.getParameter("t1");
		String country=req.getParameter("country");
		String height=req.getParameter("t2");
		String statement1=req.getParameter("radio22");
		String statement2=req.getParameter("t4");
		String statement3=req.getParameter("t5");
		String statement4=req.getParameter("t6");
		String statement5=req.getParameter("t7");
		String fillupdate=req.getParameter("t8");
		String place=req.getParameter("t9");
		String statementaddress=req.getParameter("t10");
		String statementname=req.getParameter("t11");
		
		   PreparedStatement ps1=con.prepareStatement("insert into userpassport values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
	        ps1.setString(29,filepath4);
	        ps1.setString(30,filepath5);
	        ps1.setString(31,filepath6);
	       			
		
	        int k=ps1.executeUpdate();
		    pw.println(k+"row inserted<br/>");
		    pw.println("YOUR DATAS IS SUCCESFULLY INSERTED AND FORWARDED FOR FURTHER VERIFICATION<br/>THANK YOU<br/>");
		    pw.println("<a href='citizenhome.html'>GO TO HOME PAGE</a>");
		    pw.println("<a href='login.html'>LOGOUT</a>");
		   
		}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
			}
}
	        
		
		
		
		
		
		
		
		
           

			
