<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%! int eid;
		String ename;
		double esal;
	%>
	<% eid = Integer.parseInt(request.getParameter("eid"));
		ename = request.getParameter("ename");
		esal = Double.parseDouble(request.getParameter("esal"));
	%>
	
	<!--<jsp:useBean id="eb" class="bean.EmpBean" scope="application"/>
	
	<jsp:setProperty property="eid" name="eb" value="<%=eid %>"/>
	<jsp:setProperty property="ename" name="eb" value="<%=ename %>"/>
	<jsp:setProperty property="esal" name="eb" value="<%=esal %>"/>-->
	
	<h5>***************Employee Details********************</h5>
	Employee id : <jsp:getProperty property="eid" name="eb"/>
	Employee name : <jsp:getProperty property="ename" name="eb"/>
	Employee salary : <jsp:getProperty property="esal" name="eb"/>
</body>
</html>