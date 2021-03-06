
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
<title>Update Status</title>
<style>
* {
	margin: 0px;
	padding: 0px;
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

input {
	padding: 4px 15px;
	border-radius: 5px;
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
	width: 380px;
	height: 200px;
	position: relative;
	margin: 6% auto;
	background: transparent;
	padding: 5px;
	color: #070202;
}
</style>

</head>
<body>
	<h1>TRACK YOUR TIME</h1>
	<nav>

		<a class="a" href="adminIndex.jsp"><img class="a"
			src="images/Home.jpg" alt="Home" width="42px" height="42px"
			title="Home"></a> <a class="a" href="timesheetStatus.jsp"><img
			src="images/timeshet.jpg" alt="Timesheet" width="42px" height="42px"
			title="Timesheet"></a> <a class="a" href="addTask.jsp"><img
			src="images/addtask.jpg" alt="addtask" width="42px" height="42px"
			title="Add Task"></a> <a class="a" href="#report.jsp"><img
			src="images/1report.jpg" alt="report" width="42px" height="42px"
			title="Report"></a> <a class="a" href="adminUser.jsp"><img
			src="images/user1.jpg" alt="user" width="42px" height="42px"
			title="user"></a> <a class="a" href="Logout"><img
			class="signout" src="images/signout.png" alt="signout" width="42px"
			height="42px" title="Signout"></a>
	</nav>
	<div class="sidebar">
		<ul>
			<li><a href="TimesheetStatus">Add Timesheet status</a><br>
				<br></li>
		</ul>
	</div>
	<div class="box">
		<form method="post" action="updateStatus">
			<table>
				<caption></caption>
				<c:forEach items="${viewstatus}" var="viewStatus">
					<tr>
						<th id="tblhead"><label for="timesheetid">Enter
								Timesheet Id</label></th>
						<td><input id="timesheetid" type="number" name="timesheetid"
							value="${viewStatus.timesheetId}" readonly required></td>
					</tr>
					<tr>
						<th id="tblhead"><label for="userid">User Id</label></th>
						<td><input id="userid" type="number" name="userid"
							value="${viewStatus.userId}" readonly required></td>
					</tr>
					<tr>
						<th id="tblhead"><label for="status">Enter Status</label></th>
						<td><select id="status" name="status" required>
								<option value="Select" disabled>--Select--</option>
								<option value="Approved">Approved</option>
								<option value="Rejected">Rejected</option>
								<option value="NotApproved">Not Approved</option>
						</select></td>
					</tr>
					<tr>
						<th id="tblhead"><label for="approvedby">Approvedb By</label></th>
						<td><input id="approvedby" type="text" name="approvedby"
							value="${viewStatus.approvedBy}" readonly required></td>
					</tr>
				</c:forEach>
			</table>
			<br> <br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<label for="Submit"></label> <input
				id="Submit" type="submit" value="Submit">



		</form>
	</div>
</body>
</html>