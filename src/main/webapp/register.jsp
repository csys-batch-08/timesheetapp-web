<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
<style>
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
	top: 80px;
	left: 500px;
	background: rgb(169, 226, 228);
	padding: 30px 80px;
}

input {
	padding: 4px 15px;
	border-radius: 5px;
}

button {
	padding: 4px 15px;
	border-radius: 5px;
}
</style>
<script>
	function myfunction() {
		var pswd = document.getElementById("password");
		var cpswd = document.getElementById("Confirm_password");
		if (pswd.value != cpswd.value) {
			document.getElementById("password").style.borderColor = "#E34234";
			document.getElementById("Confirm_password").style.borderColor = "#E34234";
			document.getElementById("message").innerHTML = "Password must be same";
			return false;
		} else {
			return true;
		}
	}
</script>

</head>
<body style="background-image: url(images/Time1.jpg)">
	<form action="Registerservlet" method="post"
		onsubmit="return myfunction()" id="regForm">
		<fieldset>
			<legend>
				<strong>Sign Up</strong>
			</legend>
			<label for="firstname">First Name</label><br> <input type="text"
				id="firstname" name="firstname" pattern="[A-Za-z]{3,}" required
				autofocus><br> <br> <label for="lastname">Last
				Name</label><br> <input type="text" id="lastname" name="lastname"
				pattern="[A-Za-z]{3,}" required><br> <br> <label
				for="username">User Name</label><br> <input type="email"
				id="username" name="username"
				pattern="[a-z][a-z0-9_.]+@[a-z0-9.]+[.][a-z]+"
				title="Sample xyz12@gmail.com" required><br> <br>
			<label for="password">Password</label><br> <input
				type="password" id="password" name="password"
				pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}"
				title="Sample Xyz12@" required><br> <br> <label
				for="Confirm_password">Confirm Password</label><br> <input
				type="password" id="Confirm_password" name="Confirm_password"
				pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}"
				title="Enter confirm password same as password " required><br>
			<br>
			<p style="color: red;" id="message"></p>
			&nbsp;&nbsp;
			<button type="submit">Submit</button>
			&nbsp; &nbsp;<label for="clear"></label> <input id="clear"
				type="reset" value="Reset"><br> <br> Have already
			an account?<a href="index.jsp">Login here</a>
		</fieldset>
	</form>

</body>
</html>