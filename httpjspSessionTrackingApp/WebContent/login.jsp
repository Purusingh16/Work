<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.*"%>

<%
try{
String email=request.getParameter("email");
String password=request.getParameter("password");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection

("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
PreparedStatement ps=cn.prepareStatement("select * from userinfo1 where email=? and password=?");
ps.setString(1,email);
ps.setString(2,password);
ResultSet rs=ps.executeQuery();
if(rs.next())
        {
        session.setAttribute("msg1",email);
        session.setAttribute("msg2",password);
%>

<jsp:forward page="profile.jsp"/>

<%
        }
else
        {
%>

<jsp:forward page="failure.jsp"/>

<%
	}
ps.close();
cn.close();
}catch(Exception e){}
%>

</body>
</html>