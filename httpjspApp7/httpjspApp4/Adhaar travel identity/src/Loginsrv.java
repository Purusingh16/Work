import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Loginsrv extends HttpServlet 
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
			
	    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	    {
	    	PrintWriter pw=res.getWriter();
	    	try{
	    		String Userid=req.getParameter("t1");
	    		String Password=req.getParameter("t2");
	    		String Type=req.getParameter("t3");
	    		
	    		if(Type.equals("admin"))
	    		{
	    			PreparedStatement ps=con.prepareStatement("select * from AdminLogin where Username=? and Password=?");
	    			ps.setString(1,Userid);
	    			ps.setString(2,Password);
	    			ResultSet rs=ps.executeQuery();
	    			if(rs.next())
	    			{
	    			RequestDispatcher rd=req.getRequestDispatcher("adminfirstpage.html");
	    			rd.forward(req,res);
	    			}
	    			else
	    			{
	    		     pw.println("invalid user");
	    		    }
	    		}
	    		else if(Type.equals("user"))
	    		{
	    			PreparedStatement ps1=con.prepareStatement("select * from UserLogin where Username=? and password=?");
	    			System.out.println("khkh");
	    			ps1.setString(1,Userid);
	    			ps1.setString(2,Password);
	    			ResultSet rs=ps1.executeQuery();
	    			if(rs.next())
	    			{
	    				RequestDispatcher rd1=req.getRequestDispatcher("citizenhome.html");
	    				rd1.forward(req,res);
	    			}
	    			else
	    			{
	    		     pw.println("invalid user");
	    		    }
	    		}
	    		else if(Type.equals("passportofficer"))
	    		{
	             PreparedStatement ps2=con.prepareStatement("select * from PassportLogin where Username=? and password=?");
	    			
	    		ps2.setString(1,Userid);
	    		ps2.setString(2,Password);
	    		ResultSet rs2=ps2.executeQuery();
	    		if(rs2.next())
	    		{
	    			RequestDispatcher rd2=req.getRequestDispatcher("passportofficerhome.html");
	    			rd2.forward(req,res);
	    		}
	    			else
	    			{
	    		     pw.println("invalid user");
	    		    }
	    		}
	    		
	    		else if(Type.equals("police"))
	    		{
	             PreparedStatement ps3=con.prepareStatement("select * from PoliceLogin where Username=? and passwod=?");
	    			
	    		ps3.setString(1,Userid);
	    		ps3.setString(2,Password);
	    		ResultSet rs3=ps3.executeQuery();
	    		if(rs3.next())
	    		{
	    			RequestDispatcher rd3=req.getRequestDispatcher("police.html");
	    			rd3.forward(req,res);
	    		}
	    			else
	    			{
	    		     pw.println("invalid user");
	    		    }
	    		}
	    		else if(Type.equals("RTA"))
	    		{
	             PreparedStatement ps4=con.prepareStatement("select * from RTALogin where Username=? and password=?");
	    		System.out.println("jhjh");	
	    		ps4.setString(1,Userid);
	    		ps4.setString(2,Password);
	    		ResultSet rs4=ps4.executeQuery();
	    		if(rs4.next())
	    		{
	    			RequestDispatcher rd4=req.getRequestDispatcher("RTAofficerhome.html");
	    			rd4.forward(req,res);
	    		}
	    			else
	    			{
	    		     pw.println("invalid user");
	    		    }
	    		}
	    	}
	    
	    		catch(Exception ee)
	    		{
	    			System.out.println(ee);
	    		}
	    }
}
	
	    		
	    		
	    			

	    		
	    		
	    			


	