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
     .home
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
        .h1{
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
         table{
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
        a{
       text-decoration:none
       }
        .sidebar{
       position:fixed;
       width:300px;
       height:100%;
       background:#0f6a94;
       color:white;
       }
       .sidebar ul a{
    display:block;
    height:100%;
    width:100%;
    line-height: 65px;
    font-size: 20px;
    padding-left:50px;
    box-sizing: border-box;
    color:white; 
    }
        ul{
        list-style-type: none;
         }
       ul li:hover a{
        color: #070808;
        }
        
        .box{
            width:70%;
            height:200px;
            position:relative;
            margin:6% auto; 
            margin-right:50px;
            background: transparent;
            padding:4px;
            color: #070202;
        }
       
</style>
</head>
<body>
<% TaskDAOimpl taskdao = new TaskDAOimpl();
   List<Task> taskList = new ArrayList<Task>();
   String username=(String)session.getAttribute("username");
   taskList = taskdao.showTask(username);
%>
 <h1 class="h1" align="center">TRACK YOUR TIME</h1>
    <nav>
        <a class="a" href="index.jsp"><img class="home" src="images/Home.jpg" alt="Home"width="42px" height="42px" title="Home"></a>
        <a class="a" href="timesheet.jsp"><img src="images/timeshet.jpg" alt="Timesheet"width="42px" height="42px" title="Timesheet"></a>
        <a class="a" href="#"><img src="images/addtask.jpg" alt="addtask"width="42px" height="42px" title="Add Task"></a>
        <a class="a" href="report.jsp"><img src="images/1report.jpg" alt="report"width="42px" height="42px" title="Report"></a>
        <a class="a" href="showuser.jsp"><img src="images/user1.jpg" alt="user"width="42px" height="42px" title="user"></a>
        <a href="Logout"><img class="signout" src="images/signout.png" alt="signout"width="42px" height="42px" title="Signout"></a>
    </nav>
     <div class="sidebar"> 
        <ul>
        <li><a href="showtask.jsp">Add Timesheet</a><br><br></li>
        <li><a href="Updatetimesheet.jsp">Edit Timesheet</a><br><br></li>
        <li><a href="rejectedtimesheet.jsp">Rejected Timesheet</a><br><br></li>
        <li><a href="showuserstatus1.jsp">View Timesheet Status</a><br><br></li>
        <li><a href="viewtimesheet.jsp">View Timesheet</a><br><br></li>
        </ul>
    </div>
    <div class="box">
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
		<th>Add Timesheet</th>
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
<td> <%=viewtask.getDateassigned()%></td>
<td> <%=viewtask.getEnddate()%></td>
<td> <%=viewtask.getAssignedto()%></td>
<td><%=viewtask.getTotalhrs()%></td>
<td><a href="timesheetmain.jsp?taskName=<%=viewtask.getTask()%>&taskDate=<%=viewtask.getDateassigned() %>" ><button type="button" class="btn btn-primary btn-sm">ADD</button></a></td>
</tr>

<%
}
%>
</tbody>
</table>
</div>
</body>
</html>