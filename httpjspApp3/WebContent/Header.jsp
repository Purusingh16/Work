<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.*"%>

<marquee behaviour="alternate">
<font color="yellow" size="5">
Lakshya
</font>
</marquee>

<%
Date d=new Date();
int date=d.getDate();
int month=d.getMonth();
int year=d.getYear(); //calculated from 1990 as java was introduced in 1991. will return 114 for 2014.
%>

<p align="right">
<b>Date </b>
<%=date%>/
<b>Month </b>
<%=month%>/
<b>Year </b>
<%=year%>

</p>
</body>
</html>