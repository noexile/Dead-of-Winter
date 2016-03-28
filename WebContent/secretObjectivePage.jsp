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
		<col width="350">
		<col width="350">
		<col width="350">
		<tr>
			<td colspan = "3" align="center">
				<c:out value="${sessionScope.secretObjectiveError}"/>
				<c:remove var="secretObjectiveError" scope="session"/>
			</td>
		</tr>
		<form action="ChosenSecretObjective" method="post">
			<tr>
				<c:forEach items="${sessionScope.randomizedObjectives}" var="obj">
					<td>
						<img src="${obj.secretObjectiveGoal.link}" height="250" width="350">
					<td>
				</c:forEach>
			</tr>
			<tr align="center">
				<c:forEach items="${sessionScope.randomizedObjectives}" var="obj">
					<td>
						<input type="radio" name="secret" value="${obj.secretObjectiveGoal.name}">
					</td>
				</c:forEach>
			</tr>
			<tr align="center">
				<td>
					<a href="mainObjectivePage.jsp"><input type="button" value="Back">
				</td>
				<td>
					<a href="GenerateSecretObjectivesServlet"><input type="button" value="Reset Secrets">
				</td>
				<td>
					<input type="submit" name="Next">
				</td>
			</tr>
		</form>
	</table>
</body>
</html>