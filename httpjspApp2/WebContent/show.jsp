<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%@ page isErrorPage="true"%>

<html>
<body bgcolor="pink">
<h1>Oops...</h1>
<font color="black" size="6">
<center>
<b>Sorry, A Runtime Exception Occured</b>

<%
exception.printStackTrace(response.getWriter());  //parameter is passed so that the output is printed in the browser.
%>

</center>
</font>
</body>
</html>