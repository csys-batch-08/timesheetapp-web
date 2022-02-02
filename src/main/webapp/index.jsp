
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
			User Name<br> <input type="text" id="User_Name" name="username"
				pattern="[a-z0-9.]+[@][a-z]+[.][]a-z]+"
				placeholder="Enter your Email" required><br>
			<br> Password<br> <input type="password" id="password"
				name="password"
				pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}"
				placeholder="Enter valid password" title="Sample Xyz12@" required><br>
			<br> &nbsp;&nbsp;<input type="submit" name="submit">
			&nbsp; <a href="register.jsp"><input type="button"
				value="Sign Up"></a>&nbsp; <input type="reset" value="Reset"><br>
			<br>
			<c:if test="${sessionScope.login!=null}">
				<h4>${sessionScope.login}</h4>
			</c:if>
			<c:remove var="login" scope="session" />
		</fieldset>
	</form>

</body>
</html>