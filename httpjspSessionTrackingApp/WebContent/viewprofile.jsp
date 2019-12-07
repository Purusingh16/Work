<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="black">
<font color="yellow" size="4">
<center>

<%@page import="java.sql.*"%>

<%
String email=(String)session.getAttribute("msg1");
String password=(String)session.getAttribute("msg2");
if(email==null && password==null)
        {
%>

<jsp:forward page="index.jsp"/>

<%
        }
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
PreparedStatement ps=cn.prepareStatement("select * from userinfo1 where email=? and password=?");
ps.setString(1,email);
ps.setString(2,password);
ResultSet rs=ps.executeQuery();
if(rs.next())
        {
%>

<b>User Name: </b><%=rs.getString(1)%><br>
<b>Email Id </b><%=rs.getString(2)%><br>
<b>Password: </b><%=rs.getString(3)%><br>
<b>Address: </b><%=rs.getString(4)%><br>
<b>Security Code: </b><%=rs.getString(5)%><br>

<%
        }
ps.close();
cn.close();
}catch(Exception ee){}
%>

<ul>
<a href="profile.jsp">Back</a></ul>
</center>
</font>

</body>
</html>