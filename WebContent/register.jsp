<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/login.css">
<title>Dead of Winter</title>
</head>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header"></div>
	<br>
	<div class="login">
		<form action="RegistrationServlet" method="post">
			<div class="error">
				<c:out value="${sessionScope.error }" />
			</div>
			<c:remove var="error" scope="session" />
			<input type="text" placeholder="username" name="user"><br>
			<input type="text" placeholder="email" name="email"><br>
			<input type="password" placeholder="password" name="password"><br>
			<input type="password" placeholder="re-password" name="re-password"><br>
			<input type="submit" value="Register"><br> <a
				href="index.jsp"><input type="button" value="Back"></a>
		</form>
	</div>
</body>
</html>