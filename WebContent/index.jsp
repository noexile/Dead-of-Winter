<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dead of Winter</title>
</head>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header"></div>
	<br>
	<div class="login">
	<div class ="msg">
		<c:out value="${sessionScope.logoutMsg}" />
		<c:remove var="logoutMsg" scope="session" />
		<c:out value="${sessionScope.profileMsg}" />
		<c:remove var="profileMsg" scope="session" />
	</div>
		<form action="CreatePlayerServlet" method="post">
			<input type="submit" value="New Game">
		</form>	
		<form action="StatisticServlet" method="post">
			<input type="submit" value="New Game">
		</form>	
		<a href="profile.jsp"><input type="button" value="Change Profile"></a>
		<a href="static/pdf/rules.pdf"><input type="button" value="Rules"></a>
		<form action="LogoutServlet" method="post">
			<input type="submit" value="Log out">
		</form>
	</div>
</body>
</html>