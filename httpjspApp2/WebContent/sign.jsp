<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*"%>
<html>
<body bgcolor="pink">
<center>
<font color="black" size="5">

<%
String fname=request.getParameter("fname");
String lname=request.getParameter("lname");
String course=request.getParameter("course");
String email=request.getParameter("email");
String contact=request.getParameter("contact");
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
PreparedStatement ps=cn.prepareStatement("insert into stud_data values(?,?,?,?,?)");
ps.setString(1,fname);
ps.setString(2,lname);
ps.setString(3,course);
ps.setString(4,email);
ps.setString(5,contact);
int a=ps.executeUpdate();
if(a>0)
        {
        out.println("<b>Registered Successfully.</b>");
        }
else
        {
        out.println("<b>Operation Failed.</b>");
        }
}catch(Exception ee)
        {
        ee.printStackTrace();
        }
%>

</font>
</center>
</body>
</html>