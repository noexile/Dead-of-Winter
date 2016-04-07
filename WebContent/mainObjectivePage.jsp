<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
--!>

<html>
<head>
<link rel="stylesheet" href="resources/preGame.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<<<<<<< HEAD
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
=======
>>>>>>> parent of 4da6622... Added no cache on the JSP's

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
			<label> <input type="radio" name="mode" value="normal_mode">
				<img src="resources/we_need_more_samples_normal.png"
				alt="we need more samples" height="350" width="250">
			</label> <label> <input type="radio" name="mode"
				value="hardcore_mode"> <img
				src="resources/we_need_more_samples_hardcore.png"
				alt="we need more samples" height="350" width="250">
			</label>
			<div class="clear">
				<a href="mainPage.jsp" class="linkBtns"> <input type="button"
					value="Back" class="btn"> <input type="submit" name="Next"
					class="btn">
				</a>
			</div>
		</div>
	</form>
</body>
</html>