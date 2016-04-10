<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dead of Winter</title>
<link href="css/profile.css" rel="stylesheet" type="text/css" />
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,600,700&amp;subset=latin,latin-ext,cyrillic-ext,cyrillic'
	rel='stylesheet' type='text/css'>
</head>

<body>
	<div id="main">
		<div class="wrapper">
			<div class="mainContent">
				<h1>Edit Profile</h1>
				<div class="login">
					<form action="ProfileServlet" method="post">
						<div class="error">
							<c:out value="${sessionScope.error }" />
						</div>
						<label for="user" class="username"><c:out
								value="${sessionScope.loggedUser.getUsername() }" /></label> <input
							type="hidden" name="user" id="user" class="text">

						<div class="clear"></div>

						<label for="password">Password</label> <input type="password"
							name="password" value="${sessionScope.loggedUser.getPassword() }"
							class="text">

						<div class="clear"></div>

						<label for="email">Email</label> <input type="text" name="email"
							value="${sessionScope.loggedUser.getEmail() }" class="text">

						<div class="clear"></div>

						<input type="submit" value="Save Changes" class="submitBtn">
						<a href="index.jsp" class="backBtn"><input type="button"
							value="Back"></a>
						<c:remove var="error" scope="session" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>