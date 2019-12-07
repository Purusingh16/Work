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
<font color="yellow" size="5">

<%
String name=request.getParameter("t1");
String status=request.getParameter("t2");
Cookie ck=new Cookie("name", name);
Cookie cc=new Cookie("status", status);
response.addCookie(ck);
response.addCookie(cc);
if(status==null)
        {
        status="M";
        }
else if(status.equals("M"))
        {
        out.println("<form action='second.jsp'><br>");
        out.println("Spouse: <input type='text' name='t3'><br>");
        out.println("number of children: <input type='text' name='t4'><br><br>");
        out.println("<input type='submit' value='submit'>");
        out.println("</form>");
        }
else if(status.equals("UM"))
        {
        out.println("<form action='second.jsp'>");
        out.println("Where You want to Marry: <input type='text' name='t3'><br>");
        out.println("Whom You want to Marry: <input type='text' name='t4'><br><br>");
        out.println("<input type='submit' value='submit'>");
        out.println("</form>");
        }
%>

</font>
</center>

</body>
</html>