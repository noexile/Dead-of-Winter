<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<link rel="stylesheet" href="resources/login.css">
<title>Dead of Winter</title>
</head>
<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header"></div>
	<br>
	<div class="login">
		<form action="CreatePlayerServlet" method="post">
			<input type="submit" value="New Game">
		</form>
		<a href="statsPage.jsp"><input type="button" value="Statistics"></a>
		<!-- TODO STATS PAGE PAGE -->
		<a href="profile.jsp"><input type="button" value="Change Profile"></a>
		<form action="LogoutServlet" method="post">
			<input type="submit" value="Log out">
		</form>
	</div>
</body>
</html>