<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page errorPage="show.jsp"%>
<html>
<body bgcolor="yellow">
<center>
<font color="black" size="5">

<%
int x=1;
if(x==1)
        {
        throw new RuntimeException("Error Generated");  //uncheck exception. if not handled then program terminates at runtime.
        }
%>


</font>
</center>
</body>
</html>