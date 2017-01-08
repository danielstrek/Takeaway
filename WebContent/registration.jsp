<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.ai.takeaway.model.User, java.util.List, com.ai.takeaway.model.Restaurant, com.ai.takeaway.model.Order, com.ai.takeaway.model.Dish"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rejestracja</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

</head>
<body>
	<div>
		<center>
			<h1>
				<font color="silver"> Podaj swoje dane:</font>
			</h1>
			<form action="RegistrationServlet" , method="post">
				<font color="silver">Imię: </font><br> <input type="text"
					name="name"><br> <font color="silver">Nazwisko:</font>
				<br> <input type="text" name="surname"><br> <font
					color="silver">Email: </font><br> <input type="text"
					name="email"><br> <font color="silver">Hasło: </font><br>
				<input type="password" name="password"><br> <input
					type="submit" value="Zarejestruj">
			</form>

			<br>
			<br>

		</center>
	</div>

</body>
</html>
