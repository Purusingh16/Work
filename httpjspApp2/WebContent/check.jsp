<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%@ page isThreadSafe="false"%>

<html>
<body bgcolor="pink">
<center>
<font color="black" size="6">

<%!
String name;
int roll;
%>

<%
name=request.getParameter("name");
roll=Integer.parseInt(request.getParameter("roll"));
try{
Thread.sleep(3000);  //is in millisecond
}catch(Exception ee){}
out.println("<b>Name is "+name+"<br> Roll number is "+roll);
out.println("</b>");
%>

</font>
</center>
</body>
</html>