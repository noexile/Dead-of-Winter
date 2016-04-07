<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="resources/preGame.css">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dead of Winter</title>
</head>
<body>
	<form action="ChosenSurvivorServlet" method="post">
			<div class ="error">
				<c:out value="${sessionScope.survivorChoosingError}"/>
			</div>
				<c:remove var="survivorChoosingError" scope="session"/>
			<div class = "position">
			<c:forEach items="${sessionScope.randomizedSurvivors}" var="surv">
				<label>
					<input type="checkbox" name="chosenSurvivor" value="${surv.name}">
					<img src="${surv.link}" height="350" width="250">
				</label>
			</c:forEach>
			</div>
				<a href="GenerateSecretObjectivesServlet"><input type="button" value="Back" class="btn">
				<a href="GenerateSurvivorsServlet"><input type="button" value="Reset Survivors" class="btn">
				<input type="submit" value="Next" class="btn">
	</form>
</body>
</html>