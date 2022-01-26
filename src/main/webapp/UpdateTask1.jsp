<%@page import="java.sql.*"%>
<%@page import="com.timesheet.util.Connectionutil"%>
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
<title>Update Task</title>
<style>
 *
    {
    margin:0px;
    padding:0px;
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
        <a class="a" href="login.jsp"><img class="signout" src="images/signout.png" alt="signout"width="42px" height="42px" title="Signout"></a>
    </nav>
    <div class="sidebar"> 
        <ul>
        <li><a href="addtaskmain.jsp">Add Task</a><br><br></li>
        <li><a href="Showalltask">View & Edit Task</a><br><br></li>
        </ul>
    </div>
    <%!String taskName; %>
<% 
 taskName=request.getParameter("taskname");
String query="select task_name,assigned_to_date,end_date,task_priority,assigned_to from task_details where task_name like '"+taskName+"%'";
Connectionutil conutil=new Connectionutil();
Connection con=conutil.getDbConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(query);
if(rs.next()){
%>
    <div class="box">
        <form method="post" action="UpdateTask">
            <table>
            <tr>
       <th><label for="taskname">Enter Task Name</label></th>
       <td><input type="text" name="taskname" value="<%=rs.getString(1) %>" readonly required></td>
    </tr>
           
    <tr>
       <th> <label for="assigningdate">Enter Task Assigning Date</label></th>
        <td><input type="date" name="assigningdate" value="<%=rs.getDate(2) %>" required></td>
    </tr>
    <tr>
       <th><label for="endingdate">Enter Task Ending Date</label></th>
       <td><input type="date" name="endingdate" value="<%=rs.getDate(3)%>" required></td>
    </tr>
     <tr>
       <th><label for="priority">Enter Task Priority</label></th>
       <td><input type="text" name="priority" value="<%=rs.getString(4)%>" required></td>
    </tr>
     <tr>
       <th><label for="assignedto">Task Assigned To</label></th>
       <td><input type="email" name="username" value="<%=rs.getString(5)%>" required></td>
    </tr>
    </table><br><br>
   &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
   <input type="submit" class="btn btn-primary btn-sm" value="Submit">
   
        <%} %>
        
        </form> 
    </div>
</body>
</html>