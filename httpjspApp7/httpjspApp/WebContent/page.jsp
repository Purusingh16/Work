<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body bgcolor="black">
<center>
<font color="yellow" size="5">

<%
ServletConfig sc=getServletConfig();
String s1=sc.getInitParameter("user");
out.println("User Name is - "+s1);
%>

<br><br>
</font>

<br>
<font color="white" size="6">

<%=config.getInitParameter("user")%>

</font>
</center>
</body>
</html>