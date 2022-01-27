
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Users</title>
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
       h3 {
         background:lightslategray;
         color: rgb(248, 245, 245);
         padding: 5px 15px;
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
          .table
          {
          margin-left:20px;
          }
</style>
</head>
<body>
<h1 class="h1" align="center">TRACK YOUR TIME</h1>
    <nav>
        
        <a href="index.jsp"><img class="a" src="images/Home.jpg" alt="Home"width="42px" height="42px" title="Home"></a>
        <a href="timesheet.jsp"><img src="images/timeshet.jpg" alt="Timesheet"width="42px" height="42px" title="Timesheet"></a>
        <a href="#"><img src="images/addtask.jpg" alt="addtask"width="42px" height="42px" title="Add Task"></a>
        <a href="report.jsp"><img src="images/1report.jpg" alt="report"width="42px" height="42px" title="Report"></a>
        <a href="ShowUser"><img src="images/user1.jpg" alt="user"width="42px" height="42px" title="user"></a>
        <a href="Logout"><img class="signout" src="images/signout.png" alt="signout"width="42px" height="42px" title="Signout"></a>
    </nav>
 <fieldset>
<h3 align="center">User Profile</h3>
<c:forEach items="${showuser}" var="viewUser">
<table class="table table-borderless">
<tbody>

<tr>
<td><b>First Name</b> </td>
<td>${viewUser.getFirstname()}</td>
</tr>
<tr>
<td><b>Last Name</b> </td>
<td>${viewUser.getLastname()}</td>
</tr>
<tr>
<td><b>User Name</b> </td>
<td>${viewUser.getUsername()}</td>
</tr>
<tr>
<td><b>Password</b> </td>
<td>${viewUser.getPassword()}</td>
</tr>
</tbody>
</table>
<p align="center"><a href="UpdateUserProfile?firstname=${viewUser.getFirstname()}&lastname=${viewUser.getLastname()}&username=${viewUser.getUsername()}"><button  type="button" class="btn btn-primary btn-lg">Edit</button></a></p>
</c:forEach>
</fieldset>
</body>
</html>