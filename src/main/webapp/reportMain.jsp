
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Report</title>
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
        .h1{
        text-align: center;
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
       fieldset
          {
              position:absolute;
              border-radius: 5px;
              top: 180px;
              left: 450px;
              background:rgb(188, 210, 243);
              padding: 30px 80px;
          }
          
        h3 {
        text-align: center;
         background:lightslategray;
         color: rgb(248, 245, 245);
         padding: 5px 15px;
         }
         
          table{
          background-color:rgb(188, 210, 243);
      }
      td
      {
      font-size: 20px;
      }
      th
      {
      font-size: 20px;
      }
       body
       {
          background-color:rgb(107, 173, 235);
       }
</style>
</head>
<body>
<h1 class="h1" style="color:#0a3549;">TRACK YOUR TIME</h1>
    <nav>
        <a href="userIndex.jsp"><img class="a" src="images/Home.jpg" alt="Home"width="42px" height="42px" title="Home"></a>
        <a href="timesheet.jsp"><img src="images/timeshet.jpg" alt="Timesheet"width="42px" height="42px" title="Timesheet"></a>
        <a href="#addTask"><img src="images/addtask.jpg" alt="addtask"width="42px" height="42px" title="Add Task"></a>
        <a href="report.jsp"><img src="images/1report.jpg" alt="report"width="42px" height="42px" title="Report"></a>
        <a href="ShowUser"><img src="images/user1.jpg" alt="user"width="42px" height="42px" title="user"></a>
        <a href="Logout"><img class="signout" src="images/signout.png" alt="signout"width="42px" height="42px" title="Signout"></a>
    </nav>
<fieldset>
<legend></legend>
<h3>Report</h3>
<table class="table table-borderless">
<caption></caption>
<c:forEach items="${report}" var="view">
<tr>
<th id="tblhd"><strong>Timesheet Date</strong></th><td><fmt:parseDate value="${view.timesheetdate}" pattern="yyyy-MM-dd" var="timesheetDate" type="date"/>
<fmt:formatDate pattern="dd-MM-yyyy" value="${timesheetDate}"/></td>
</tr> 
<tr>
<td><strong>Timesheet Id</strong> </td><td>${view.timesheetid}</td>
</tr>
<tr>
<td><strong>User Name</strong></td><td>${view.username}</td>
</tr>
<tr>
<td><strong>User Role </strong></td><td>${view.role}</td>
</tr>
<tr>
<td><strong>Task Name</strong> </td><td>
${view.task}</td>
</tr>
<tr>
<td><strong>Spending Hrs</strong> </td><td>${view.spendhrs}</td>
</tr>
<tr>
<td><strong>Timesheet Status</strong> </td><td>${view.status}</td>
</tr>
<tr>
<td><strong>Approved By</strong> </td><td>${view.approvedby}</td>
</tr>
<tr>
<td><strong>Approved On</strong> </td><td><fmt:parseDate value="${view.approvedon}" pattern="yyyy-MM-dd" var="approveDate" type="date"/>
<fmt:formatDate pattern="dd-MM-yyyy" value="${approveDate}"/></td>
</tr>
</c:forEach>
</table>
</fieldset>
</body>
</html>