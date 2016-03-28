<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%! %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<form action="GameBeginServlet" method="post">
		<tr align="center">
			<td colspan = "${sessionScope.isHardMode}" align="center">
				<c:out value="${sessionScope.survivorChoosingError}"/>
				<c:remove var="survivorChoosingError" scope="session"/>
			</td>
		</tr>
		<tr align="center">
			<c:forEach items="${sessionScope.randomizedPlayerStartingCardsPartOne}" var="player_card">
				<td>
					<img src="${player_card.link}" height="350" width="250">
				<td>
			</c:forEach>
		</tr>
		<tr align="center">
			<c:forEach items="${sessionScope.randomizedPlayerStartingCardsPartTwo}" var="player_card">
				<td>
					<img src="${player_card.link}" height="350" width="250">
				<td>
			</c:forEach>
		</tr>
		<tr align="center">
			<td>
				<a href="GenerateSurvivorsServlet"><input type="button" value="Back">
			</td>
			<td>
				<input type="submit" value="Begin">
			</td>
		</tr>
	</form>
	</table>
</body>
</html>