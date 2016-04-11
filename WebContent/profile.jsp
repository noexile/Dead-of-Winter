<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dead of Winter</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header"></div>
				<div class="login">
					<h1>Edit Profile</h1>
					<form action="ProfileServlet" method="post">
						<div class="error">
							<c:out value="${sessionScope.error }" />
						</div>
						<h2>Hello, <c:out value="${sessionScope.loggedUser.getUsername() }" /></h2><input type="hidden" name="user" id="user" class="text">
						<br>
						<input type="password"name="password" value="${sessionScope.loggedUser.getPassword() }" class="text">
						<input type="text" name="email" value="${sessionScope.loggedUser.getEmail() }" class="text">

						<input type="submit" value="Save Changes" class="submitBtn">
						<a href="index.jsp" class="backBtn"><input type="button"
							value="Back"></a>
						<c:remove var="error" scope="session" />
					</form>
				</div>
</body>
</html>