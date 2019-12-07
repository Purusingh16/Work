<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Apply for passport</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-titillium-250.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript">
	  function valid()
	  	{
		    if(frm.t1.value=="")
			   {
			      alert("Please enter the User id");
				  document.frm.t1.focus() ;
				  return false;
			   }
			    
			     return true;
		}
		
	</script>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="login.html">ADHAR Travel Identity<span></span> </a></h1>
      </div>
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="index.html"><span>Home Page</span></a></li>
          <li><a href="support.html"><span>Support</span></a></li>
          <li><a href="about.html"><span>About Us</span></a></li>
          <li><a href="blog.html"><span>Blog</span></a></li>
          <li><a href="contact.html"><span>Contact Us</span></a></li>
        </ul>
      </div>
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"><a href="#"><img src="images/slide1.jpg" width="935" height="307" alt="" /></a> <a href="#"><img src="images/slide2.jpg" width="935" height="307" alt="" /></a> <a href="#"><img src="images/slide3.jpg" width="935" height="307" alt="" /></a></div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="content">
    <div class="content_resize">
      <p>&nbsp;</p>
      <center>
      
     <h1>
     
     <%@ page import="java.sql.*,java.io.*" %> 
	<%!
	Connection con;
	public void jspInit()
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
%>
	<%
HttpServletRequest req=request;
HttpServletResponse res=response;
		try{
			res.setContentType("text/html");
			PrintWriter pw = res.getWriter();
			String uid=req.getParameter("t1");
			System.out.println("khk"+uid);
			PreparedStatement ps=con.prepareStatement("select emailid from uidgenerate where username=?");
			ps.setString(1,uid);
			ResultSet rs1=ps.executeQuery();
			rs1.next();
			String emailid=rs1.getString(1);
			System.out.println("mailid"+emailid);
			PreparedStatement ps1=con.prepareStatement("select * from citizenpermanentregister where emailid=?");
			ps1.setString(1,emailid);
			ResultSet rs=ps1.executeQuery();
			pw.println("<body bgcolor='cyan'>");
				if(rs.next())
				{
				pw.println("<center><table bgcolor='red'>");
				pw.println("<tr><td>Emailid</td>");
				pw.println("<td>"+rs.getString(1)+"</td></tr><br/>");
				pw.println("<tr><td>Registration date</td>");
				pw.println("<td>"+rs.getString(2)+"</td></tr><br/>");
				pw.println("<tr><td>Citizen name</td>");
				pw.println("<td>"+rs.getString(3)+"</td></tr><br/>");
				pw.println("<tr><td>birth date</td>");
				pw.println("<td>"+rs.getString(4)+"</td></tr><br/>");
				pw.println("<tr><td>Contactno</td>");
				pw.println("<td>"+rs.getString(5)+"</td></tr><br/>");
				pw.println("<tr><td>Gender</td>");
				pw.println("<td>"+rs.getString(6)+"</td></tr><br/>");
				pw.println("<tr><td>Martial Status</td>");
				pw.println("<td>"+rs.getString(7)+"</td></tr><br/>");
				pw.println("<tr><td>Permanent Address</td>");
				pw.println("<td>"+rs.getString(8)+"</td></tr><br/>");
				pw.println("<tr><td>Current Address</td>");
				pw.println("<td>"+rs.getString(9)+"</td></tr><br/>");
				pw.println("<tr><td>Father name</td>");
				pw.println("<td>"+rs.getString(10)+"</td></tr><br/>");
				pw.println("<tr><td>Mother name</td>");
				pw.println("<td>"+rs.getString(11)+"</td></tr><br/>");
				pw.println("<tr><td>Occupation</td>");
				pw.println("<td>"+rs.getString(12)+"</td></tr><br/>");
				pw.println("<tr><td>Pincode</td>");
				pw.println("<td>"+rs.getString(13)+"</td></tr><br/>");
				pw.println("<tr><td>PAN no</td>");
				pw.println("<td>"+rs.getString(14)+"</td></tr><br/>");
			    pw.println("<tr><td>photo</td>");
			    pw.println("<td><img src='"+rs.getString(15)+"' width=100 height=100/></td></tr><br/>");
			    pw.println("</center></table>");
			    pw.println("<form action='applyforpassportform1' method='post' enctype='multipart/form-data'>");
				pw.println("Place of birth:<textarea name='t0'></textarea><br/>");
				pw.println("State:<input type='text' name='t1'><br/>");
				pw.println("country:<select name='country'>");
				pw.println("<option selected='' value='Default'>(Please select a country)</option>");  
                pw.println("<option>Australia</option>"); 
                pw.println("<option>Canada</option>");  
                pw.println("<option>India</option>");  
                pw.println("<option>Russia</option>");
                pw.println("<option>USA</option>");
                pw.println("</selected><br/>");
                pw.println(" </select><br/>");
				pw.println("<input type='hidden' value='"+rs.getString(1)+"' name='processpassport'>");
				pw.println("Height(in cm):<input type='number' name='t2'><br/> ");
			
                pw.println("Are any criminal proceedings pending against you before a court in India?if so,give name of court,case number and offence<textarea name='t5'></textarea><br/>");
				pw.println("have you been ever refused/denied passport?if yes give details:<textarea name='t6'></textarea><br/>");
				pw.println("Has your passport been ever impounded/revoked?if yes give details<textarea name='t7'></textarea><br/>");
				pw.println("<hr/>");
				pw.println("Date<input type='date' name='t8'><br/>");
				pw.println("place<input type='text' name='t9'><br/>");
				pw.println("particular of person to be intimated in the event of death or accident,so his name<textarea name='t10'></textarea><br/>");
				pw.println("his address<textarea name='t11'></textarea>");
				pw.println("<hr/>");
				pw.println("Attach Birth proof certificate<input type='file' name='t12'><br/>");
		        pw.println("Attach Eductional certificate<input type='file' name='t13' ><br/>");
		        pw.println("Attach Address proof<input type='file' name='t14' ><br/>");
		        pw.println("<input type='submit' value='submit'>");
				pw.println("</form>");
				
			}
				pw.println("</body>");
		}
				catch(Exception ee)
				{
					System.out.println(ee);
				}
				
		
%>

     
     
     &nbsp;</h1>
     <font color="#000000">
<hr/><br />
<form action="applyforpassport" method="get" name="frm" onsubmit="return valid()">
</form>
</font>
      </center>
      <div class="clr"></div>
    </div>
  </div>
  <div class="footer">
    <div class="footer_resize">
      <p class="lf">Copyright &copy; <a href="#">GITA</a>. All Rights Reserved</p>
      <div style="clear:both;"></div>
    </div>
  </div>
</div>
</body>
</html>
