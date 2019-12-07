<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	This is info about main .jsp file<br><br><br>
	<jsp:include page="hello.jsp">
	<jsp:param name="a" value="10"/>
	</jsp:include>
</body>
</html>