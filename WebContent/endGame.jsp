<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.button{
	background-color: #000099;
	position: absolute;
	top: 10px;
	left: 1700px;
	border: none;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.result }">
		<img src="resources/victory.jpg">
	</c:when>
	<c:otherwise>
		<img src="resources/lose.jpg">
	</c:otherwise>
</c:choose>
	<a href="index.jsp"><input type="button" value="Back To Main Page" class="button"></a>
</body>
</html>