
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
<title>View Timesheet</title>
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
		<a href="userIndex.jsp"><img class="a" src="images/Home.jpg"
			alt="Home" width="42px" height="42px" title="Home"></a> <a
			href="timesheet.jsp"><img src="images/timeshet.jpg"
			alt="Timesheet" width="42px" height="42px" title="Timesheet"></a> <a
			href="#"><img src="images/addtask.jpg" alt="addtask" width="42px"
			height="42px" title="Add Task"></a> <a href="report.jsp"><img
			src="images/1report.jpg" alt="report" width="42px" height="42px"
			title="Report"></a> <a href="ShowUser"><img
			src="images/user1.jpg" alt="user" width="42px" height="42px"
			title="user"></a> <a href="Logout"><img class="signout"
			src="images/signout.png" alt="signout" width="42px" height="42px"
			title="Signout"></a>
	</nav>
	<div class="center">
		<h2>
			<strong>Timesheet List</strong>
		</h2>
		<h5>User name :${sessionScope.username}</h5>
		<table class="table table-hover table-striped">
			<caption></caption>
			<thead>
				<tr>
				    <th id="tblhead">S.No</th>
					<th id="tblhead">User Id</th>
					<th id="tblhead">Task Id</th>
					<th id="tblhead">Spending Hrs</th>
					<th id="tblhead">Timesheet Date</th>
					<th id="tblhead">In Active Timesheet</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${showtimesheet}" var="timesheet">
				<c:set var="i" value="${i+1}" />
				<c:set var="inactive" value="InActive" scope="page" />
					<tr>
					    <td>${i}</td>
						<td>${timesheet.userId}</td>
						<td>${timesheet.taskId}</td>
						<td>${timesheet.spendTime}</td>
						<td><fmt:parseDate value="${timesheet.timesheetForDate}"
								pattern="yyyy-MM-dd" var="timesheetDate" type="date" /> <fmt:formatDate
								pattern="dd-MM-yyyy" value="${timesheetDate}" /></td>
						<td><a href="InActiveTimesheet?timesheetDate=${timesheet.timesheetForDate}&timesheetStatus=${inactive}"><button type="button" class="btn btn-secondary btn-sm">In Active</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>