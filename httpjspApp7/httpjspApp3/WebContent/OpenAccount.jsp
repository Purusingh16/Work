<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.*"%>

<%!
Connection cn;
PreparedStatement ps;
public void jspInit()
        {

        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","aaravaahna");
        ps=cn.prepareStatement("insert into account values(?,?,?)");
        }catch(Exception e)
                {
                e.printStackTrace();
                }
        }

        public void jspDestroy()
                {

                try{
                ps.close();
                cn.close();
                }catch(Exception ee)
                        {
                        ee.printStackTrace();
                        }

                }
%>

<%
int accno=Integer.parseInt(request.getParameter("t1"));
String name=request.getParameter("t2");
double balance=Double.parseDouble(request.getParameter("t3"));
ps.setInt(1,accno);
ps.setString(2,name);
ps.setDouble(3,balance);
ps.executeUpdate();
out.println("<b>Balance is successfully Inserted.</b>");
%>

</body>
</html>