
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
<title>User Timesheet Status</title>
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

.center {
	width: 90%;
	padding: 20px;
	margin-left: 50px;
}
/* a:link {
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
        }    */
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
</style>

</head>
<body>
	<h1>TRACK YOUR TIME</h1>
	<nav>
		<a class="a" href="userIndex.jsp"><img class="a"
			src="images/Home.jpg" alt="Home" width="42px" height="42px"
			title="Home"></a> <a class="a" href="timesheet.jsp"><img
			src="images/timeshet.jpg" alt="Timesheet" width="42px" height="42px"
			title="Timesheet"></a> <a class="a" href="#addTask.jsp"><img
			src="images/addtask.jpg" alt="addtask" width="42px" height="42px"
			title="Add Task"></a> <a class="a" href="report.jsp"><img
			src="images/1report.jpg" alt="report" width="42px" height="42px"
			title="Report"></a> <a class="a" href="ShowUser"><img
			src="images/user1.jpg" alt="user" width="42px" height="42px"
			title="user"></a> <a class="a" href="Logout"><img
			class="signout" src="images/signout.png" alt="signout" width="42px"
			height="42px" title="Signout"></a>
	</nav>
	<div class="center">
		<h2>
			<strong> Timesheet Status</strong>
		</h2>
		<br>
		<h5>User name :${sessionScope.username}</h5>
		<br>
		<table class="table table-hover table-striped">
			<caption></caption>
			<thead>
				<tr>
					<th id="tblhead">Timesheet Date</th>
					<th id="tblhead">Spending Time Hrs</th>
					<th id="tblhead">Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${showuserstatus}" var="viewtimesheet">
					<tr>
						<td><fmt:parseDate value="${viewtimesheet.timesheetDate}"
								pattern="yyyy-MM-dd" var="timesheetDate" type="date" /> <fmt:formatDate
								pattern="dd-MM-yyyy" value="${timesheetDate}" /></td>
						<td>${viewtimesheet.spendtimeHrs}</td>
						<td>${viewtimesheet.status}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>