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
<%
String sn=request.getParameter("t1");
int roll=Integer.parseInt(request.getParameter("t2"));
out.println("<center><form action='second.jsp'>");
out.println("Address <input type='text' name='t3'>");
out.println("<input type='submit' value='submit'>");
out.println("<input type='hidden' name='t4' value='"+sn+"'>");
out.println("<input type='hidden' name='t5' value='"+roll+"'>");
out.println("</form></center>");
%>

</center>

</body>
</html>