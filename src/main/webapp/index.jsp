
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

body {
	background-size: cover;
}

legend {
	background: lightslategray;
	color: rgb(248, 245, 245);
	padding: 5px 15px;
}

fieldset {
	position: absolute;
	border-radius: 5px;
	top: 150px;
	left: 500px;
	background: rgb(169, 226, 228);
	padding: 30px;
}

input {
	padding: 4px 15px;
	border-radius: 5px;
}

h4 {
	color: red;
}
</style>

</head>
<body style="background-image: url(images/Time1.jpg)">
	<form action="log" method="post">
		<fieldset>
			<legend>
				<strong>Login</strong>
			</legend>
			<label for="username"></label> User Name<br> <input
				id="username" type="text" id="User_Name" name="username"
				pattern="[a-z0-9.]+[@][a-z]+[.][]a-z]+"
				placeholder="Enter your Email" required><br> <label
				for="password"></label> <br> Password<br> <input
				type="password" id="password" name="password"
				pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}"
				placeholder="Enter valid password"
				title="The password length must be greater than or equal to 8 
			           and it must contain one or more uppercase characters
                       and it must contain one or more lowercase characters
                       and it must contain one or more numeric values
                       and it must contain one or more special characters Sample Xyz12@"
				required><br> <br> &nbsp;&nbsp;<input
				type="submit" name="submit"> &nbsp; <a href="register.jsp"><label
				for="register"></label><input id="register" type="button"
				value="Sign Up"></a>&nbsp;<label for="clear"></label> <input
				id="clear" type="reset" value="Reset"><br> <br>
			<c:if test="${sessionScope.login!=null}">
				<h4>${sessionScope.login}</h4>
			</c:if>
			<c:remove var="login" scope="session" />
		</fieldset>
	</form>

</body>
</html>