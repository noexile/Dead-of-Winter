<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="resources/preGame.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dead of Winter</title>
</head>
<body>
	<div class="error">
		<c:out value="${sessionScope.secretObjectiveError}" />
	</div>
	<c:remove var="secretObjectiveError" scope="session" />
	<form action="ChosenSecretObjective" method="post">
		<div class="position">
			<c:forEach items="${sessionScope.randomizedObjectives}" var="obj">
				<label> <input type="radio" name="secret"
					value="${obj.secretObjectiveGoal.name}"> <img
					src="${obj.secretObjectiveGoal.link}" height="250" width="350"
					align="">
				</label>
			</c:forEach>
			<div class="clear">
				<a href="mainObjectivePage.jsp" class="linkBtns"><input
					type="button" value="Back" class="btn"> <a
					href="GenerateSecretObjectivesServlet"><input type="button"
						value="Reset Secrets" class="btn"> <input type="submit"
						name="Next" class="btn"> </a>
			</div>

		</div>
	</form>
</body>
</html>