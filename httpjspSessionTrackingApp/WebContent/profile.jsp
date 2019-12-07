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

<%
String s=(String)session.getAttribute("msg1");
String s1=(String)session.getAttribute("msg2");
if((s!=null)&&(s1!=null))
        {
%>

<p align="right">
<a href="logout.jsp">Get Out.</a></p>

<ul><a href="viewprofile.jsp">View Profile</a></ul>
<ul><a href="index.jsp">Home Page.</a></ul>

<%
        }
else
        {
%>

<marquee>Login First.</marquee>

<jsp:include page="index.jsp"/>

<%
        }
%>

</center>
</font>

</body>
</html>