<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Update User</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

a {
	margin-left: 30px;
}

.a {
	margin-left: 30px;
}

img {
	border-radius: 45px;
}

body {
	background-size: cover;
}

.h1 {
	text-align: center;
	margin: 0px;
	padding: 20px;
	background-color: rgb(127, 202, 231);
}

nav {
	background-color: rgb(127, 202, 231);
}

.signout {
	float: right;
	margin-right: 20px;
}

fieldset {
	position: absolute;
	border-radius: 5px;
	top: 150px;
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

body {
	background-color: rgb(107, 173, 235);
}
</style>
<script>
	function myfunction() {
		var pswd = document.getElementById("newPassword");
		var cpswd = document.getElementById("confirmPassword");
		if (pswd.value != cpswd.value) {
			document.getElementById("newPassword").style.borderColor = "#E34234";
			document.getElementById("confirmPassword").style.borderColor = "#E34234";
			document.getElementById("message").innerHTML = "Password must be same";
			return false;
		} else {
			return true;
		}
	}
</script>
</head>

<body>
	<h1 class="h1">TRACK YOUR TIME</h1>
	<nav>
		<a href="userIndex.jsp"><img class="a" src="images/Home.jpg"
			alt="Home" width="42px" height="42px" title="Home"></a> <a
			href="timesheet.jsp"><img src="images/timeshet.jpg"
			alt="Timesheet" width="42px" height="42px" title="Timesheet"></a> <a
			href="#addTask.jsp"><img src="images/addtask.jpg" alt="addtask"
			width="42px" height="42px" title="Add Task"></a> <a
			href="report.jsp"><img src="images/1report.jpg" alt="report"
			width="42px" height="42px" title="Report"></a> <a href="ShowUser"><img
			src="images/user1.jpg" alt="user" width="42px" height="42px"
			title="user"></a> <a href="Logout"><img class="signout"
			src="images/signout.png" alt="signout" width="42px" height="42px"
			title="Signout"></a>
	</nav>
	<br>
	<br>
	<form action="updateuser" method="post" onsubmit="return myfunction()">
		<fieldset>
			<legend></legend>
			<label for="First_Name">First Name</label><br> <input
				type="text" id="First_Name" name="firstname" value="${userFirstNameValue}"
				pattern="[A-Za-z]{3,}" required autofocus><br> <br>
			<label for="Last_Name">Last Name</label><br> <input type="text"
				id="Last_Name" name="lastname" value="${userLastNameValue}"
				pattern="[A-Za-z]{3,}" required><br> <br> <label
				for="User_Name">User Name</label><br> <input type="email"
				id="User_Name" name="username" value="${username}"
				pattern="[a-z][a-z0-9_.]+@[a-z0-9.]+[.][a-z]+"
				title="Sample xyz12@gmail.com" readonly required><br> <br>
			<label for="oldPassword">Old Password</label><br> <input
				type="password" id="oldPassword" name="oldPassword"
				pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}"
				title="The password length must be greater than or equal to 8 
				       and it must contain one or more uppercase characters
                       and it must contain one or more lowercase characters
                       and it must contain one or more numeric values
                       and it must contain one or more special characters Sample Xyz12@"
				required><br> <br> <label for="newPassword">New
				Password</label><br> <input type="password" id="newPassword"
				name="newPassword"
				pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}"
				title="The password length must be greater than or equal to 8 
				       and it must contain one or more uppercase characters
                       and it must contain one or more lowercase characters
                       and it must contain one or more numeric values
                       and it must contain one or more special characters Sample Xyz12@"
				required><br> <br> <label for="confirmPassword">Confirm
				Password</label><br> <input type="password" id="confirmPassword"
				name="confirmPassword"
				pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}"
				title="Enter confirm password same as password " required><br>
			<br>
			<p style="color: red;" id="message"></p>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="submit">Submit</button>
			&nbsp; &nbsp;<label for="clear"></label><input id="clear"
				type="reset" value="clear">
		</fieldset>
	</form>

</body>
</html>