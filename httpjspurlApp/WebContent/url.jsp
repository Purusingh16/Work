<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="black">
<center>
<font color="yellow" size="5">

<%
String s1=request.getParameter("t1");
String s2=request.getParameter("t2");
if(s1.equals("admin"))
        {
        out.println("<a href='profile.jsp?id="+s1+"'>Go to profile</a>");
        }
else
        {
%>

<b>!!!Please try again...</b>
<a href="home.html">Go</a>

<%
        }
%>

</font>
</center>

</body>
</html>