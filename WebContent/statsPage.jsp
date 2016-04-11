<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body{
	background-image: url('resources/background.jpg');
}
.font{
	font-family: "Lucida Console", Monaco, monospace;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Statistic</title>
</head>
<body>
	<div class = "font">
		<h1>Games Played: </h1><h1><c:out value="${sessionScope.gamePlayed }"/></h1>
		<h1>Games Won:</h1><h1><c:out value="${sessionScope.gameWon }"/></h1>
	</div>
</body>
</html>