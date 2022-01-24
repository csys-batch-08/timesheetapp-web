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
<title>Update User</title>
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
         fieldset
          {
              position:absolute;
              border-radius: 5px;
              top: 150px;
              left: 500px;
              background:rgb(169, 226, 228);
              padding: 30px 80px;
          }
          input
          {
            padding: 4px 15px;
            border-radius: 5px;
          }
           button
          {
            padding: 4px 15px;
            border-radius: 5px;
          }
           body
       {
          background-color:rgb(107, 173, 235);
       }
</style>
<script>
    function myfunction()
    {
    	var pswd = document.getElementById("password");
    	var cpswd = document.getElementById("Confirm_password");
    	if(pswd!=cpswd)
    		{
    		document.getElementById("password").style.borderColor = "#E34234";
            document.getElementById("Confirm_password").style.borderColor = "#E34234";
    		}
    }
    </script>
</head>
<body>
<h1 class="h1" align="center">TRACK YOUR TIME</h1>
<nav>
        <a href="index.jsp"><img class="a" src="images/Home.jpg" alt="Home"width="42px" height="42px" title="Home"></a>
        <a href="timesheet.jsp"><img src="images/timeshet.jpg" alt="Timesheet"width="42px" height="42px" title="Timesheet"></a>
        <a href="#"><img src="images/addtask.jpg" alt="addtask"width="42px" height="42px" title="Add Task"></a>
        <a href="report.jsp"><img src="images/1report.jpg" alt="report"width="42px" height="42px" title="Report"></a>
        <a href="showuser.jsp"><img src="images/user1.jpg" alt="user"width="42px" height="42px" title="user"></a>
        <a href="Logout"><img class="signout" src="images/signout.png" alt="signout"width="42px" height="42px" title="Signout"></a>
    </nav>
    <br><br>
<% String firstname=request.getParameter("firstname");
   String username=request.getParameter("username");
   String lastname=request.getParameter("lastname");
%>
<form action="updateuser" method="post">
<fieldset>
<label for="firstname">First Name</label><br>
            <input type="text" id="First_Name" name="firstname" value="<%=firstname %>" pattern="[A-Za-z]{3,}" required autofocus><br><br>
            <label for="lastname">Last Name</label><br>
            <input type="text" id="Last_Name" name="lastname" value="<%=lastname %>" pattern="[A-Za-z]{3,}" required><br><br>
            <label for="username">User Name</label><br>
            <input type="email" id="User_Name" name="username" value="<%=username %>" pattern="[a-z][a-z0-9_.]+@[a-z0-9.]+[.][a-z]+"  title="Sample xyz12@gmail.com" readonly required><br><br>
            <label for="password">New Password</label><br>
            <input type="password" id="password" name="password" pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Sample Xyz12@" required><br><br>
            <label for="password">Confirm Password</label><br>
            <input type="password" id="Confirm_password" name="Confirm_password" pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Enter confirm password same as password " required><br><br>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" onclick="myfunction()">Submit</button>&nbsp; &nbsp;<input type="reset" value="clear">
            </fieldset>
            </form>
           
</body>
</html>