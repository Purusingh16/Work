import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javazoom.upload.*;


public class citizenregistersrv extends HttpServlet 
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
	public void doPost(HttpServletRequest request,HttpServletResponse res)throws ServletException,IOException
	{
		try
		{
		String photopath="D:/projectphoto";
		MultipartFormDataRequest req=new MultipartFormDataRequest(request);
		String Emailid=req.getParameter("t0");
		String Registrationdate=req.getParameter("t1");
		String Citizenname=req.getParameter("t2");
		String Birthdate=req.getParameter("t3");
		String Contactno=req.getParameter("t4");
		String Gender=req.getParameter("radio1");
		String MartialStatus=req.getParameter("radio2");
		String PermanentAddress=req.getParameter("t6");
		String CurrentAddress=req.getParameter("t7");
		String Fathername=req.getParameter("t8");
		String Mothername=req.getParameter("t9");
		String Occupation=req.getParameter("t10");
		String Pincode=req.getParameter("t11");
		String PANno=req.getParameter("t12");
		
		UploadBean upb=new UploadBean();
		upb.setFolderstore(photopath);
		upb.setOverwrite(false);
		upb.store(req,"t5");
		Vector history=upb.getHistory();
		ArrayList filesName=new ArrayList();
		for(int i=0;i<history.size();i++)
		{
			UploadParameters up=(UploadParameters)history.elementAt(i);
			filesName.add(up.getFilename());
			
		}
		
		String file=(String)filesName.get(0);
		String photopath1=photopath+"/"+file;
		
        PreparedStatement ps=con.prepareStatement("insert into citizenregister values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,Emailid );
        ps.setString(2,Registrationdate );
        ps.setString(3,Citizenname );
        ps.setString(4,Birthdate );
        ps.setString(5,Contactno );
        ps.setString(6,Gender );
        ps.setString(7,MartialStatus);
        ps.setString(8,PermanentAddress );
        ps.setString(9,CurrentAddress );
        ps.setString(10,Fathername);
        ps.setString(11,Mothername );
        ps.setString(12,Occupation );
        ps.setString(13,Pincode );
        ps.setString(14, PANno);
        ps.setString(15,photopath1);
       
        
        int k=ps.executeUpdate();
        PrintWriter pw=res.getWriter();
        pw.println(k+"row inserted<br/>");
        pw.println("ALL THE INFORMATION IS SUCCESFULLY INSERTED AND YOU WILL SOON GET A USER ID TO USE THIS APPLICATION<br/>THANK YOU");
		pw.println("<a href='login.html'>click here to go to login page</a>");
		}
        catch(Exception ee)
        {
        	System.out.println(ee);
        }
	}
	}
		


	