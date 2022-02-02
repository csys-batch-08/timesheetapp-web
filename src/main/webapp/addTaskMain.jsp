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
<title>Add Task</title>
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
</style>
</head>
<body>

	<h1 style="color: #0a3549;">TRACK YOUR TIME</h1>
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
			<li><a href="addTaskMain.jsp">Add Task</a><br>
			<br></li>
			<li><a href="Showalltask">View &amp; Edit Task</a><br>
			<br></li>
		</ul>
	</div>
	<div class="box">
		<a href="addTaskAllUser.jsp"><button type="button"
				class="btn btn-primary btn-lg">To All Users</button></a><br>
		<br>
		<form method="post" action="addtask">
			<table>
				<caption></caption>
				<tr>
					<th id="tblhead"><label for="taskname">Enter Task Name</label></th>
					<td><input type="text" name="taskname" required></td>
				</tr>
				<tr>
					<th id="tblhead"><label for="assigningdate">Enter Task
							Assigning Date</label></th>
					<td><input type="date" name="assigningdate" required></td>
				</tr>
				<tr>
					<th id="tblhead"><label for="endingdate">Enter Task
							Ending Date</label></th>
					<td><input type="date" name="endingdate" required></td>
				</tr>
				<tr>
					<th id="tblhead"><label for="priority">Enter Task
							Priority</label></th>
					<td><select name="priority" required>
							<option>Low</option>
							<option>Medium</option>
							<option>High</option>
					</select></td>
				</tr>
				<tr>
					<th id="tblhead"><label for="assignedto">Task Assigned
							To</label></th>
					<td><input type="email" name="username" required></td>
				</tr>
			</table>
			<br>
			<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; <input type="submit"
				class="btn btn-primary btn-sm" value="Submit"> &nbsp; &nbsp;
			<input type="reset" class="btn btn-primary btn-sm" value="Clear">
		</form>

	</div>
</body>
</html>