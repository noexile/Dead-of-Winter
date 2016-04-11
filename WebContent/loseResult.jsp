<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dead of Winter</title>
<link rel="stylesheet" href="css/loseResult.css">
</head>
<body style="background-image:url(resources/background.jpg)">

	
	<form action="CleanSavedInfoServlet" method="post">
		<input type="submit" value="Back to Main Page">
	</form>
	
	
		<p style="text-align: center;">	
			<font size="6" color="black">
				<b>
					<br /><br /><br /><br />
					<c:out value="${sessionScope.game_result}" />
				</b>
			</font>
		</p>
		
	<div id="round_summary">
		<c:if test="${sessionScope.player.getLog().size() > 0}">
			<c:forEach var="i" begin="0" end="${sessionScope.player.getLog().size() - 1}">
				<font size="2" color="black">- <c:out value="${sessionScope.player.getLog().get(i)}" /></font><br />
			</c:forEach>
		</c:if>
	</div>
	
</body>
</html>