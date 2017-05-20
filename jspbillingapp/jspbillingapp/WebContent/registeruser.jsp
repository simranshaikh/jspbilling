<%@page import="com.techm.models.User"%>
<%@page import="com.techm.daos.impl.UserDAOImpl"%>
<%@page import="com.techm.daos.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%!
	private UserDAO userDao;
	public void jspInit(){
		System.out.println("++++++ Jsp page init Method ++++++");
		userDao=new UserDAOImpl();
	}
 %>
<jsp:useBean id="user" class="com.techm.models.User" scope="page"/>
<jsp:setProperty property="*" name="user"/>
<%
	boolean isAdded=userDao.addUser(user);
	if(isAdded){
 %>
	<body bgcolor="cyan">
	<center><h1>My Billing Application</h1></center>
	<h3>Successfuly Registerd User</h3>
	<h3><a href="login.jsp">Login Now</a></h3>
<%
	}else{
%>
	<body bgcolor="cyan">
	<center><h1>My Billing Application</h1></center>
	<h3>Error During Registration</h3>
	<h3><a href="register.jsp">Re-register</a></h3>
<%
}	
 %>
</body>
</html>