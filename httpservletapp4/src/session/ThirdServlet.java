package session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ThirdServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String city=request.getParameter("city");
        String salary=request.getParameter("salary");
        HttpSession session=request.getSession();
        String name=(String)session.getAttribute("name");
        String addr=(String)session.getAttribute("address");
        int age=(Integer)session.getAttribute("age");
        String exp=(String)session.getAttribute("exp");
        String skills=(String)session.getAttribute("skills");
        
        
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
	        PreparedStatement ps=cn.prepareStatement("insert into data11 values(?,?,?,?,?,?,?)");
	        ps.setString(1,name);
	        ps.setString(2,addr);
	        ps.setInt(3,age);
	        ps.setString(4,exp);
	        ps.setString(5,skills);
	        ps.setString(6,city);
	        ps.setString(7,salary);
	        ps.executeUpdate();
	        ps.close();
	        cn.close();
		} catch (ClassNotFoundException e) 
        {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
       
		
	}

}
