<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="abc" class="javabeans.Student" scope="session"/>
<jsp:setProperty name="abc" property="name" value="Java"/>
<jsp:setProperty name="abc" property="roll" value="56"/>

<font color="yellow" size="6">
<b>Property is Set.</b>



</body>
</html>