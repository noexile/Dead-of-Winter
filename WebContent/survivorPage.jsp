<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<form action="ChosenSurvivorServlet" method="post">
		<tr>
			<td colspan = "4" align="center">
				<c:out value="${sessionScope.survivorChoosingError}"/>
				<c:remove var="survivorChoosingError" scope="session"/>
			</td>
		</tr>
		<tr>
			<c:forEach items="${sessionScope.randomizedSurvivors}" var="surv">
				<td>
					<img src="${surv.link}" height="350" width="250">
				<td>
			</c:forEach>
		</tr>
		<tr align="center">
			<c:forEach items="${sessionScope.randomizedSurvivors}" var="surv">
				<td>
					<input type="checkbox" name="chosenSurvivor" value="${surv.name}">
				</td>
			</c:forEach>
		</tr>
		<tr align="center">
			<td>
				<a href="GenerateSecretObjectivesServlet"><input type="button" value="Back">
			</td>
			<td>
				<a href="GenerateSurvivorsServlet"><input type="button" value="Reset Survivors">
			</td>
			<td>
				<input type="submit" value="Next">
			</td>
		</tr>
	</form>
	</table>
</body>
</html>