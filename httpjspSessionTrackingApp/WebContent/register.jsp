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
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
String name=request.getParameter("name");
String password=request.getParameter("password");
String email=request.getParameter("email");
String addr=request.getParameter("addr");
String code=request.getParameter("code");
PreparedStatement ps=cn.prepareStatement("insert into userinfo1 values(?,?,?,?,?)");
ps.setString(1,name);
ps.setString(2,email);
ps.setString(3,password);
ps.setString(4,addr);
ps.setString(5,code);
int i=ps.executeUpdate();
if(i==1)
        {
%>

<jsp:forward page="index.jsp"/>

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
}catch(Exception e){e.printStackTrace();}

%>

</body>
</html>