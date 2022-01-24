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
      
        input
          {
            padding: 4px 15px;
            border-radius: 5px;
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
            width:380px;
            height:200px;
            position:relative;
            margin:6% auto; 
            background: transparent;
            padding:5px;
            color: #070202;
        }  
    </style>
</head>
<body>
 <h1 align="center">TRACK YOUR TIME</h1>
    <nav>
        
        <a class="a" href="adminindex.jsp"><img class="a" src="images/Home.jpg" alt="Home"width="42px" height="42px" title="Home"></a>
        <a class="a" href="timesheetstatus.jsp"><img src="images/timeshet.jpg" alt="Timesheet"width="42px" height="42px" title="Timesheet"></a>
        <a class="a" href="addtask.jsp"><img src="images/addtask.jpg" alt="addtask"width="42px" height="42px" title="Add Task"></a>
        <a class="a" href="#report.jsp"><img src="images/1report.jpg" alt="report"width="42px" height="42px" title="Report"></a>
        <a class="a" href="adminuser.jsp"><img src="images/user1.jpg" alt="user"width="42px" height="42px" title="user"></a>
        <a class="a" href="Logout"><img class="signout" src="images/signout.png" alt="signout"width="42px" height="42px" title="Signout"></a>
    </nav>
    <div class="sidebar"> 
        <ul>
        <li><a href="showalluser.jsp">View Users</a><br><br></li>
        </ul>
    </div>
    <div class="box">
<% String username=(String)request.getParameter("username");%>
<form action="updateuseradmin" method="post">
<table cellspacing="15px">
<tr><th><label for="username">User Name</label></th>
<td><input type="text" name="username" value="<%=username%>" required readonly></td></tr>
<tr><th><label for="role">Role</label></th>
<td><select  name="role" required>
       <option>TEAM MEMBER</option>
       <option>IN ACTIVE</option>
       </select>
       </td></tr>
</table>
<br><br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<input type="submit"value="Submit">
</form><br>
<%!
String flag;
%>
<%
if(request.getAttribute("updateuseradmin") != null){
flag = request.getAttribute("updateuseradmin").toString();
%>
<h4><%= flag%></h4>
<% }%> 
</div>
</body>
</html>