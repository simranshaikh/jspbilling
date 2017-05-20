<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>billingapp-Register Page</title>
</head>
<body bgcolor="cyan">
<form method="post" action="RegisterServlet">
<center>
	<h1>My Billing Application</h1>
	<table border="2">
		<tr>
			<td>First Name :</td>
			<td><input type="text" name="firstName"></td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td><input type="text" name="lastName"></td>
		</tr>
		<tr>
			<td>Username :</td>
			<td><input type="text" name="userName"></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>Cell No. :</td>
			<td><input type="text" name="cellNo"></td>
		</tr>
		<tr>
			<td>Email ID :</td>
			<td><input type="text" name="email"></td>
		</tr>
		
		<tr>
			<td>Age :</td>
			<td><input type="text" name="age"></td>
		</tr>
		<tr>
			<td><input type="submit" value="REGISTER"></td>
			<td><input type="reset" value="CLEAR"></td>
		</tr>
	</table>
	<A href="login.html">Already Registered ? Login Now !</A>
</center>
</form>
</body>
</html>