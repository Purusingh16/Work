<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="black">
<font color="yellow" size="5">
<center>

<%
String s1=request.getParameter("t3");
String s2=request.getParameter("t4");
out.println("<center>");
Cookie aa[]=request.getCookies();
if(aa!=null)
        {
        for(int i=0;i<aa.length;i++)
                {
                out.println(aa[i].getName()+"\t"+aa[i].getValue());
                }
        }
%>

</center>
</font>

</body>
</html>