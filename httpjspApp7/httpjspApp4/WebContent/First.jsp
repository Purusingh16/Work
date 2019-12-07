<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<center>

<%
String name=request.getParameter("t1");
Double price=Double.parseDouble(request.getParameter("t2"));
Double qty=Double.parseDouble(request.getParameter("t3"));
double bamt=price*qty;
if(bamt<=3000)
        {
%>

<b><i>Item Name: <%=name%></i></b><br>
<b><i>Bill Amount: <%=bamt%></i></b><br>

<%
        }
        else
        {
%>

<jsp:forward page="Second.jsp">
<jsp:param name="item" value="<%=name%>"/>
<jsp:param name="amt" value="<%=bamt%>"/>
</jsp:forward>

<%
        }
%>



</body>
</html>