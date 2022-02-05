
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
<title>Timesheet</title>
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
	<div class="sidebar">
		<ul>
			<li><a href="ShowTask">Add Timesheet</a><br>
			<br></li>
			<li><a href="updateTimesheet.jsp">Edit Timesheet</a><br>
			<br></li>
			<li><a href="RejectedTimesheet">Rejected Timesheet</a><br>
			<br></li>
			<li><a href="showUserStatusMain.jsp">View Timesheet Status</a><br>
			<br></li>
			<li><a href="ViewTimesheet">View Timesheet</a><br>
			<br></li>
		</ul>
	</div>
	<div class="box">


		<form method="post" action="timesheet">
			<table>
				<caption></caption>
				<tr>
					<th id="tblhead"><label for="timesheetdate">Enter
							Timesheet Date</label></th>
					<td><input type="date" min="${taskdate}" max="${sysdate}"
						name="timesheetdate" required></td>
				</tr>
				<tr>
					<th id="tblhead"><label for="taskname">Enter Task Name</label></th>
					<td><input type="text" name="taskname" value="${taskname}"
						readonly required></td>
				</tr>
				<tr>
					<th id="tblhead"><label for="spendinghrs">User Id</label></th>
					<td><input type="number" name="userid" value="${userid}"
						readonly></td>
				</tr>
				<tr>
					<th id="tblhead"><label for="spendinghrs">Enter
							Spending Hrs</label></th>
					<td><input type="number" pattern="[1-9]{1+}" min="1" maxlength="2"
						name="spendinghrs" required></td>
				</tr>
				<tr>
					<th id="tblhead"><label for="comments">Enter Comments</label></th>
					<td><input type="text" name="comments" required></td>
				</tr>
				<tr>
					<th id="tblhead"><label for="status">Status</label></th>
					<td><input type="text" name="status"
						placeholder="not approved" readonly></td>
				</tr>
			</table>
			<br>
			<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; <input type="submit" value="Submit">
			&nbsp; &nbsp; <input type="reset" value="Reset">
		</form>
	</div>

</body>
</html>