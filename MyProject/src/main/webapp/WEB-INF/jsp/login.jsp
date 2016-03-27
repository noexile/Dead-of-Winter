<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/starting.css">
<title>Dead of Winter</title>
</head>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header"></div>
	<br>
	<div class="login">
		<form action="LoginServlet" method="post">
			<input type="text" placeholder="username" name="username"><br>
			<input type="password" placeholder="password" name="password"><br>
			<input type="button" value="Log In"> <br>
		</form>
			<a href="register.jsp"><input type="button" value="Sign In"></a>
	</div>
</body>
</html>