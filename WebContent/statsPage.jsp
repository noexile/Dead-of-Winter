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
	position: absolute;
	top: calc(40% - 75px);
	left: calc(45% - 50px);
	color: white;
}
.font input[type=button]:hover {
	opacity: 0.8;
}

.font input[type=button]:active {
	opacity: 0.6;
}

.font input[type=text]:focus {
	outline: none;
	border: 1px solid rgba(255, 255, 255, 0.9);
}
.font input[type=button] {
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Statistic</title>
</head>
<body>
	<div class = "font">
		<h1>Games Played: <c:out value="${sessionScope.gamePlayed }"/></h1>
		<h1>Games Won: <c:out value="${sessionScope.gameWon }"/></h1>
		<h1>Total Zombies Killed: <c:out value="${sessionScope.zombiesKilled }"/></h1>
		<a href="index.jsp"><input type="button" value="Back"></a>
	</div>	
</body>
</html>