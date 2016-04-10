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
	<p>"Sed ut perspiciatis unde omnis iste natus error sit voluptatem
		accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae
		ab illo inventore veritatis et quasi architecto beatae vitae dicta
		sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
		aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos
		qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui
		dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed
		quia non numquam eius modi tempora incidunt ut labore et dolore magnam
		aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum
		exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex
		ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in
		ea voluptate velit esse quam nihil molestiae consequatur, vel illum
		qui dolorem eum fugiat quo voluptas nulla pariatur?"</p>
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