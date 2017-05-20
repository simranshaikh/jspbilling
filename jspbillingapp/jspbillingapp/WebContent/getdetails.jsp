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
	<form method="post" action="BillDetailsServlet">
		<table border="2">
			<tr><td>Cell No.</td><td><input type="text" name="billedCellNo"></td></tr>
			<tr><td>Minutes </td><td><input type="text" name="minutes"></td></tr>
			<tr><td><input type="submit" value="CALCULATE BILL"></td><td><input type="reset" value="CLEAR"></td></tr>
		</table>
	</form>
</center>
</body>
</html>