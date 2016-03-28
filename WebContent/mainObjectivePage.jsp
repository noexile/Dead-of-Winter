<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dead of Winter</title>
</head>
<body>
	<p>
		"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, 
		eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam 
		voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione 
		voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci 
		velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim 
		ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi 
		consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, 
		vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"
	</p>
	<p></p>
	<table align="center">
	<form action="ChooseMainObjectiveServlet" method="post">
		<tr>
			<td colspan = "2" align="center">
				<c:out value="${sessionScope.mainObjectiveError}"/>
				<c:remove var="mainObjectiveError" scope="session"/>
			</td>
		</tr>
		<tr>
			<td>
				<img src="resources/we_need_more_samples_normal.png" alt="we need more samples" height="350" width="250">
			</td>
			<td>
				<img src="resources/we_need_more_samples_hardcore.png" alt="we need more samples" height="350" width="250">
			</td>
		</tr>	
		<tr align="center">
			<td>
				<input type="radio" name="mode" value="normal_mode">
			</td>
			<td>
				<input type="radio" name="mode" value="hardcore_mode">
			</td>
		</tr>	
		<tr>
			<td>
				<a href="mainPage.jsp"><input type="button" value="Back">
			</td>
			<td>
				<input type="submit" name="Next">
			</td>
		</tr>
	</form>
	</table>
</body>
</html>