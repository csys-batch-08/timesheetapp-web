<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.timesheet.daoimpl.ReportDAOimpl"%>
<%@page import="com.timesheet.model.Report"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
       body
       {
          background-color:rgb(107, 173, 235);
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
        <a href="showuser.jsp"><img src="images/user1.jpg" alt="user"width="42px" height="42px" title="user"></a>
        <a href="Logout"><img class="signout" src="images/signout.png" alt="signout"width="42px" height="42px" title="Signout"></a>
    </nav>
    <br><br>
<%
DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
String timedate=request.getParameter("timesheetdate");
LocalDate timesheetdate=LocalDate.parse(timedate);
String username=(String)session.getAttribute("username");
ReportDAOimpl reportdao=new ReportDAOimpl();
List<Report> showReport=reportdao.findreport(timesheetdate, username);

%>
<fieldset>
<h3 align="center">Report</h3>
<table class="table table-borderless">
<tbody>
<%

for (int i=0; i<showReport.size(); i++ ) {

Report view = showReport.get(i);
//System.out.println("jsp page "+view.getTimesheetid());
%>
<tr>
<td><b>Timesheet Date</b> </td><td><%=view.getTimesheetdate()%></td>
</tr> 
<tr>
<td><b>Timesheet Id</b> </td><td><%=view.getTimesheetid()%></td>
</tr>
<tr>
<td><b>User Name</b> </td><td><%=view.getUsername()%></td>
</tr>
<tr>
<td><b>User Role </b></td><td><%=view.getRole()%></td>
</tr>
<tr>
<td><b>Task Name</b> </td><td>
<%=view.getTask()%></td>
</tr>
<tr>
<td><b>User Name</b> </td><td><%=view.getUsername()%></td>
</tr>
<tr>
<td><b>Spending Hrs</b> </td><td><%=view.getSpendhrs()%></td>
</tr>
<tr>
<td><b>Timesheet Status</b> </td><td><%=view.getStatus()%></td>
</tr>
<tr>
<td><b>Approved By</b> </td><td><%=view.getApprovedby()%></td>
</tr>
<tr>
<td><b>Approved On</b> </td><td><%=view.getApprovedon()%></td>
</tr>
<%
}
%>
</tbody>
</table>
</fieldset>
</body>
</html>