<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<title>View Task</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

.home {
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

a {
	text-decoration: none
}

.sidebar {
	position: fixed;
	width: 300px;
	height: 100%;
	background: #0f6a94;
	color: white;
}

.sidebar ul a {
	display: block;
	height: 100%;
	width: 100%;
	line-height: 65px;
	font-size: 20px;
	padding-left: 50px;
	box-sizing: border-box;
	color: white;
}

ul {
	list-style-type: none;
}

ul li:hover a {
	color: #070808;
}

.box {
	width: 70%;
	height: 200px;
	position: relative;
	margin: 6% auto;
	margin-right: 50px;
	background: transparent;
	padding: 4px;
	color: #070202;
}
</style>
</head>
<body>
	<h1 class="h1">TRACK YOUR TIME</h1>
	<nav>
		<a class="a" href="userIndex.jsp"><img class="home"
			src="images/Home.jpg" alt="Home" width="42px" height="42px"
			title="Home"></a> <a class="a" href="timesheet.jsp"><img
			src="images/timeshet.jpg" alt="Timesheet" width="42px" height="42px"
			title="Timesheet"></a> <a class="a" href="#"><img
			src="images/addtask.jpg" alt="addtask" width="42px" height="42px"
			title="Add Task"></a> <a class="a" href="report.jsp"><img
			src="images/1report.jpg" alt="report" width="42px" height="42px"
			title="Report"></a> <a class="a" href="ShowUser"><img
			src="images/user1.jpg" alt="user" width="42px" height="42px"
			title="user"></a> <a href="Logout"><img class="signout"
			src="images/signout.png" alt="signout" width="42px" height="42px"
			title="Signout"></a>
	</nav>
	<div class="sidebar">
		<ul>
			<li><a href="ShowTask">Add Timesheet</a><br> <br></li>
			<li><a href="updateTimesheet.jsp">Edit Timesheet</a><br> <br></li>
			<li><a href="RejectedTimesheet">Rejected Timesheet</a><br>
				<br></li>
			<li><a href="showUserStatusMain.jsp">View Timesheet Status</a><br>
				<br></li>
			<li><a href="ViewTimesheet">View Timesheet</a><br> <br></li>
		</ul>
	</div>
	<div class="box">
		<h2>
			<strong> Tasks List</strong>
		</h2>
		<table class="table table-hover table-striped">
			<caption></caption>
			<thead>
				<tr>
					<th id="tblhead">Task Name</th>
					<th id="tblhead">Priority</th>
					<th id="tblhead">Task Starting Date</th>
					<th id="tblhead">Task Ending Date</th>
					<th id="tblhead">Assigned To</th>
					<th id="tblhead">Total Hrs</th>
					<th id="tblhead">Add Timesheet</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${showtask}" var="showtask">
					<tr>
						<td>${showtask.task}</td>
						<td>${showtask.taskpriority}</td>
						<td><fmt:parseDate value="${showtask.dateassigned}"
								pattern="yyyy-MM-dd" var="assignDate" type="date" /> <fmt:formatDate
								pattern="dd-MM-yyyy" value="${assignDate}" /></td>
						<td><fmt:parseDate value="${showtask.enddate}"
								pattern="yyyy-MM-dd" var="endDate" type="date" /> <fmt:formatDate
								pattern="dd-MM-yyyy" value="${endDate}" /></td>
						<td>${showtask.assignedto}</td>
						<td>${showtask.totalhrs}</td>
						<td><a
							href="TimesheetMain?taskName=${showtask.task}&taskDate=${showtask.dateassigned}"><button
									type="button" class="btn btn-primary btn-sm">ADD</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>