
<%@page import="com.timesheet.model.Task"%>
<%@page import="java.util.*"%>
<%@page import="com.timesheet.daoimpl.TaskDAOimpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>View Task</title>
<style>
*
    {
    margin:0px;
    padding:0px;
    }
        a
        {
            
            margin-left: 30px;
        }
        .a
        {
            
            margin-left: 30px;
        }
        img
        {
         border-radius:45px;

        }
        body{
            background-size:cover;
        }
        h1{
            margin:0px;
            padding: 20px;
            background-color: rgb(127, 202, 231);
        }
        nav{
            background-color: rgb(127, 202, 231);
        }
       .signout
       {
           float : right;
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
      table
      {
          background-color:rgb(188, 210, 243);
      }
       thead{
        background-color:rgb(14, 32, 56);
      }
       th
      { color:honeydew;

      }
       body
       {
          background-color:rgb(107, 173, 235);
       }
</style>
</head>
<body>
<h1 align="center">TRACK YOUR TIME</h1>
    <nav>
        <a href="adminindex.jsp"><img class="a" src="images/Home.jpg" alt="Home"width="42px" height="42px" title="Home"></a>
        <a href="timesheetstatus.jsp"><img src="images/timeshet.jpg" alt="Timesheet"width="42px" height="42px" title="Timesheet"></a>
        <a href="addtask.jsp"><img src="images/addtask.jpg" alt="addtask"width="42px" height="42px" title="Add Task"></a>
        <a href="#report.jsp"><img src="images/1report.jpg" alt="report"width="42px" height="42px" title="Report"></a>
        <a href="adminuser.jsp"><img src="images/user1.jpg" alt="user"width="42px" height="42px" title="user"></a>
        <a href="Logout"><img class="signout" src="images/signout.png" alt="signout"width="42px" height="42px" title="Signout"></a>
    </nav>
    <br><br>
<% TaskDAOimpl taskdao = new TaskDAOimpl();
   List<Task> taskList = new ArrayList<Task>();
   taskList = taskdao.showallTask();
%>


<table class="table table-hover table-striped">
	<h2><b> Tasks List</b></h2>
	<thead>
	<tr>
  		<th >S.no</th>
		<th>Task Name</th>
		<th>Priority</th>
		<th>Task Starting Date</th>
		<th>Task Ending Date</th>
		<th>Assigned To</th>
		<th>Total Hrs</th>
		<th>Edit Task</th>
	</tr>
	</thead>
<tbody>
<%
int i = 0;
for (Task viewtask: taskList ) {
i++;
%>
<tr>


<td><%=i%></td>
<td><%=viewtask.getTask()%></td>
<td><%=viewtask.getTaskpriority()%></td>
<td><%=viewtask.getDateassigned()%></td>
<td><%=viewtask.getEnddate()%></td>
<td><%=viewtask.getAssignedto()%></td>
<td><%=viewtask.getTotalhrs() %></td>
<td><a href="updatetask.jsp?taskname=<%=viewtask.getTask()%>"><button type="button" class="btn btn-primary btn-sm">Edit</button></a></td>
</tr>

<%
}
%>
</tbody>
</table>

</body>
</html>
