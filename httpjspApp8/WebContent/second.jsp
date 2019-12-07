<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body bgcolor="yellow">
<font color="black" size="5">
<center>
<br><br>

<%
String address=request.getParameter("t3");
String name=request.getParameter("t4");
int roll=Integer.parseInt(request.getParameter("t5"));
out.println("<b>Name is "+name+" Roll is "+roll+" Address is "+address);
%>

</center>
</font>
</body>
</html>