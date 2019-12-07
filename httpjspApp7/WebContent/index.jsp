<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<font color="red" size="5">
<b>Add an applet in jsp page</b>
<br><br>

<jsp:plugin type="applet" code="First.class" codebase="/plug" width="300" height="300">
<jsp:fallback><b><center>Sorry but your browser isn't supporting the code.</center></b></jsp:fallback>
</jsp:plugin>

</font>

</body>
</html>