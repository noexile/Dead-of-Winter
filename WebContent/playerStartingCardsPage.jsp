<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<link rel="stylesheet" href="resources/preGame.css">
<title>Dead of Winter</title>
</head>
<body>
	<div class="position">
		<form action="GameBeginServlet" method="post">
			<c:out value="${sessionScope.survivorChoosingError}" />
			<c:remove var="survivorChoosingError" scope="session" />
			<c:forEach
				items="${sessionScope.randomizedPlayerStartingCardsPartOne}"
				var="player_card">
				<img src="${player_card.link}" height="350" width="250">
			</c:forEach>
			<c:forEach
				items="${sessionScope.randomizedPlayerStartingCardsPartTwo}"
				var="player_card">
				<img src="${player_card.link}" height="350" width="250">
			</c:forEach>
			<br> <a href="GenerateSurvivorsServlet"><input type="button"
				value="Back" class="btn"> <input type="submit" value="Begin"
				class="btn"> </a>

		</form>
	</div>
</body>
</html>