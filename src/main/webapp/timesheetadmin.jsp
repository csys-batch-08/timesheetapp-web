<%@page import="com.timesheet.model.ViewTimesheets"%>
<%@page import="java.util.*"%>
<%@page import="com.timesheet.daoimpl.ViewTimesheetsDAOimpl"%>
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
<title>Timesheet Status Admin</title>
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
        table{
          background-color:rgb(188, 210, 243);
      }
       thead{
        background-color:rgb(14, 32, 56);
      }
       th
      { color:honeydew;

      }
      fieldset
          {
              position:absolute;
              border-radius: 5px;
              top: 850px;
              left: 500px;
              background:rgb(188, 210, 243);
              padding: 30px;
          }
           body
       {
          background-color:rgb(107, 173, 235);
       }
</style>
</head>
<%String adminuser=(String)session.getAttribute("adminuser"); %>
<body>
<h1 align="center">TRACK YOUR TIME</h1>
    <nav> 
        <a href="adminindex.jsp"><img class="a" src="images/Home.jpg" alt="Home"width="42px" height="42px" title="Home"></a>
        <a href="timesheetstatus.jsp"><img src="images/timeshet.jpg" alt="Timesheet"width="42px" height="42px" title="Timesheet"></a>
        <a href="addtask.jsp"><img src="images/addtask.jpg" alt="addtask"width="42px" height="42px" title="Add Task"></a>
        <a href="#report.jsp"><img src="images/1report.jpg" alt="report"width="42px" height="42px" title="Report"></a>
        <a href="adminuser.jsp"><img src="images/user1.jpg" alt="user"width="42px" height="42px" title="user"></a>
        <a href="Logout"><img class="signout" src="images/signout.png" alt="signout"width="42px" height="42px" title="Signout"></a>
    </nav><br><br>
<% ViewTimesheetsDAOimpl viewtimesheetdao=new ViewTimesheetsDAOimpl();
   List<ViewTimesheets> timesheetlist=new ArrayList<ViewTimesheets>();
   timesheetlist=viewtimesheetdao.showAllTimesheet();
%>
<table class="table table-hover table-striped">
	<h2><b> Timesheet List</b></h2>
	<thead>
	<tr>
  		<th >S.no</th>
		<th>User Name</th>
		<th>Comments</th>
		<th>Spending Time Hrs</th>
		<th>Timesheet Id</th>
		<th>Timesheet Date</th>
		<th>Task Id</th>
		<th>Status</th>
	</tr>
	</thead>
<tbody>
<%
int i = 0;
for (ViewTimesheets viewtimesheet: timesheetlist ) {
i++;

%>
<tr>


<td><%=i%></td>
<td> <%=viewtimesheet.getUsername()%></td>
<td> <%=viewtimesheet.getComments()%></td>
<td> <%=viewtimesheet.getSpendtimehrs()%></td>
<td> <%=viewtimesheet.getTimesheetid()%></td>
<td> <%=viewtimesheet.getTimesheetdate()%></td>
<td> <%=viewtimesheet.getTaskid()%></td>
<td> <%=viewtimesheet.getStatus()%></td>
</tr>

<%
}
%>
</tbody>
</table><br><br>
<div>
<fieldset>
<form action="addstatus" method="post">
<table>
  <tr>
 <td><label for="username">Enter User Name</label></td>
  <td><input type="email" name="username" required></td>
  </tr>
<tr>
 <td><label for="timesheetdate">Enter Timesheet Date</label></td>
  <td><input type="date" name="timesheetdate" required></td>
  </tr>
  <tr>
 <td><label for="status">Enter Status</label></td>
  <td><select name="status" required>
       <option>Approved</option>
       <option>Rejected</option>
       <option>Not Approved</option>
       </select></td>
  </tr>
  <tr>
 <td><label for="approvedby">Approved By</label></td>
  <td><input type="text" name="approvedby" value="<%=adminuser%>" readonly required></td>
  </tr>
  </table>
  <br>
   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input type="submit" class="btn btn-primary btn-sm" value="Submit">
   &nbsp; &nbsp; <input type="reset" class="btn btn-secondary btn-sm" value="Clear">
</form>
</fieldset></div>
 <%!
String flag;
%>
<%
if(request.getAttribute("status") != null){
flag = request.getAttribute("status").toString();
%>
<h4><%= flag%></h4>
<% }%>  
</body>
</html>