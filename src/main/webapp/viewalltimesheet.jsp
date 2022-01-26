
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>All Timesheets</title>
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
       .center
     {
      width: 90%;
      padding:20px;
      margin-left:50px;
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
        <c:if test="${sessionScope.adminuser!=null}">
      <h4 class="signout">login as : &nbsp;${sessionScope.adminuser}</h4>
       </c:if>
    </nav><br><br>
    <div class="center">
<h2><b> Timesheet Status</b></h2><br>
<a href="TimesheetStatus"><button type="button" class="btn btn-primary btn-lg">Add Status</button></a><br><br>
<table class="table table-hover table-striped">
	
	<thead>
	<tr>
		<th>User Name</th>
		<th>Comments</th>
		<th>Spending Time Hrs</th>
		<th>Timesheet Id</th>
		<th>Timesheet Date</th>
		<th>Task Id</th>
		<th>Status</th>
		<th>Edit status</th>
	</tr>
	</thead>
<tbody>
 <c:forEach items="${showalltimesheet}" var="viewtimesheet">
<tr>

<td>${viewtimesheet.username}</td>
<td>${viewtimesheet.comments}</td>
<td>${viewtimesheet.spendtimehrs}</td>
<td>${viewtimesheet.timesheetid}</td>
<td><fmt:parseDate value="${viewtimesheet.timesheetdate}" pattern="yyyy-MM-dd" var="timesheetDate" type="date"/>
<fmt:formatDate pattern="dd-MM-yyyy" value="${timesheetDate}"/></td>
<td>${viewtimesheet.taskid}</td>
<td>${viewtimesheet.status}</td>
<td><a href="updatestatus.jsp?timesheetid=${viewtimesheet.timesheetid}"><button type="button" class="btn btn-primary btn-sm">Edit</button></a></td>
</tr>
</c:forEach>
</tbody>
</table>

</div>
</body>
</html>