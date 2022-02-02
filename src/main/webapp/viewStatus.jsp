
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Status</title>
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

h1 {
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

a:link {
	font-size: 20px;
	color: rgb(250, 252, 250);
	text-decoration: none;
}

a:hover {
	color: rgb(158, 250, 96);
	text-decoration: none;
}

a:active {
	color: rgb(245, 245, 91);
	text-decoration: underline;
}

table {
	background-color: rgb(188, 210, 243);
}

thead {
	background-color: rgb(14, 32, 56);
}

th {
	color: honeydew;
}

body {
	background-color: rgb(107, 173, 235);
}

.center {
	width: 90%;
	padding: 20px;
	margin-left: 50px;
}
</style>
</head>
<body>
	<h1>TRACK YOUR TIME</h1>
	<nav>
		<a href="adminIndex.jsp"><img class="a" src="images/Home.jpg"
			alt="Home" width="42px" height="42px" title="Home"></a> <a
			href="timesheetStatus.jsp"><img src="images/timeshet.jpg"
			alt="Timesheet" width="42px" height="42px" title="Timesheet"></a> <a
			href="addTask.jsp"><img src="images/addtask.jpg" alt="addtask"
			width="42px" height="42px" title="Add Task"></a> <a
			href="#report.jsp"><img src="images/1report.jpg" alt="report"
			width="42px" height="42px" title="Report"></a> <a
			href="adminUser.jsp"><img src="images/user1.jpg" alt="user"
			width="42px" height="42px" title="user"></a> <a href="Logout"><img
			class="signout" src="images/signout.png" alt="signout" width="42px"
			height="42px" title="Signout"></a>
	</nav>
	<div class="center">
		<h2>
			<strong>Status List</strong>
		</h2>
		<table class="table table-hover table-striped">
			<caption></caption>
			<thead>
				<tr>
					<th id="tblhead">User Id</th>
					<th id="tblhead">Timesheet Id</th>
					<th id="tblhead">Status</th>
					<th id="tblhead">Approved By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${showstatus}" var="viewstatus">
					<tr>
						<td>${viewstatus.userid}</td>
						<td>${viewstatus.timesheetid}</td>
						<td>${viewstatus.status}</td>
						<td>${viewstatus.approvedby}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>