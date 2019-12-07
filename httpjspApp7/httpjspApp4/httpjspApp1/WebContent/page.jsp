<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ServletContext application1=getServletContext();
application1.setAttribute("java","Lakshya");
%>
<body>
<font color="yellow" size="5">
<table border="2" align="center">
<%
out.println("<tr><td>Major Version.</td>");
out.println("<td>");
out.println(application.getMajorVersion());
out.println("</td></tr>");

out.println("<tr><td>Minor Version.</td>");
out.println("<td>");
out.println(application.getMinorVersion());
out.println("</td></tr>");

out.println("<tr><td>Server Info.</td>");
out.println("<td>");
out.println(application1.getServerInfo());
out.println("</td></tr>");

out.println("<tr><td>Java</td>");
out.println("<td>");
out.println(application1.getAttribute("java"));
out.println("</td></tr>");

out.println("<tr><td>Init Param is - </td>");
out.println("<td>");
out.println(application1.getInitParameter("user"));
out.println("</td></tr>");

%>

</table>
</font>

</body>
</html>