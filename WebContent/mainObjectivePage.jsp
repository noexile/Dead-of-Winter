<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="css/preGame.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Dead of Winter</title>

</head>
<body>
	<p>
		In death, the city stirs. Its borders still locked down after a sudden government quarantine a decade ago, Malton's trapped civilians make their way through the derelict buildings, surviving the changing seasons to rebuild their fragmented society from the rubble upwards. Military cleanup squads patrol the empty streets, stationed in the city for the long haul, while embedded scientific groups continue the experiments that brought them here.

		And the dead rise up and thrive, trailing through the ruined streets of the city, milling between buildings and clawing through makeshift barricades and diversions, reclaiming the city as their own.
	</p>
	<p></p>

	<form action="ChooseMainObjectiveServlet" method="post">
		<div class="error">
			<c:out value="${sessionScope.mainObjectiveError}" />
		</div>
		<c:remove var="mainObjectiveError" scope="session" />
		<div class="position">
			<h1>Please choose an main objective for your game!</h1>
			<p>You need to complete the main objective in order to win the game!</p>
			<label> <input type="radio" name="mode" value="normal_mode">
				<img src="resources/we_need_more_samples_normal.png"
				alt="we need more samples" height="350" width="250">
			</label> <label> <input type="radio" name="mode"
				value="hardcore_mode"> <img
				src="resources/we_need_more_samples_hardcore.png"
				alt="we need more samples" height="350" width="250">
			</label>
			<div class="clear">
				<a href="index.jsp" class="linkBtns"> <input type="button"
					value="Back" class="btn"> <input type="submit" name="Next"
					class="btn">
				</a>
			</div>
		</div>
	</form>
</body>
</html>