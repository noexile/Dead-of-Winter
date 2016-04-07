<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="resources/preGame.css">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<title>Dead of Winter</title>
</head>
<body>
	<form action="ChosenSurvivorServlet" method="post">
		<div class="error">
			<c:out value="${sessionScope.survivorChoosingError}" />
		</div>
		<c:remove var="survivorChoosingError" scope="session" />
		<div class="position">
			<c:forEach items="${sessionScope.randomizedSurvivors}" var="surv">
				<label> <input type="checkbox" name="chosenSurvivor"
					value="${surv.name}"> <img src="${surv.link}" height="350"
					width="250">
				</label>
			</c:forEach>
			<div class="clear"></div>
			<a href="GenerateSecretObjectivesServlet" class="linkBtns"><input
				type="button" value="Back" class="btn"> <a
				href="GenerateSurvivorsServlet"><input type="button"
					value="Reset Survivors" class="btn"> <input type="submit"
					value="Next" class="btn"> </a>
		</div>
	</form>

</body>
</html>