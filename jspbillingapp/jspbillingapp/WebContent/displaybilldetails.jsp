<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get details</title>
</head>
<body bgcolor="cyan">
	
<h2>Welcome <I>${sessionScope.sessUser.userName}</I></h2>  <A href="LogoutServlet">Logout</A>
<center>
	<form method="post" action="PopulateAllDetailsServlet">
		<table border="2">
			<tr><td>Billed Cell No.</td><td>${sessionScope.billedCellNo}</td></tr>
			<tr><td>Minutes </td><td>${sessionScope.minutes}</td></tr>
			<tr><td>Amount </td><td><b>Rs ${sessionScope.billAmount} /- </b></td></tr>
			<tr><td>Options </td><td><input type="checkbox" name="options" value="Print Bill">Print Bill<br>
			<input type="checkbox" name="options" value="Email Bill">Email Bill
			 </td></tr>
			<tr><td><input type="submit" value="PROCEED"></td><td><input type="reset" value="CLEAR"></td></tr>
		</table>
	</form>
</center>
</body>
</html>