<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<center>

<%
String name=request.getParameter("item");
double amount=Double.parseDouble(request.getParameter("amt"));
double discount=amount*0.15;
double tamount=amount-discount;
%>

<b><i>You got the discount of :
<%=discount%> on <%=name%><br><br>

You have to pay Rs.<%=tamount%>
</i></b>
</center>
</body>

</body>
</html>