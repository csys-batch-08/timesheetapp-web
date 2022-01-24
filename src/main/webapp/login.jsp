<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Login</title>
    <style>
     *
    {
    margin:0px;
    padding:0px;
    }
        body
        
        {
          background-size:cover;
        }
        legend {
         background:lightslategray;
         color: rgb(248, 245, 245);
         padding: 5px 15px;
         }
         fieldset
          {
              position:absolute;
              border-radius: 5px;
              top: 150px;
              left: 500px;
              background:rgb(169, 226, 228);
              padding: 30px;
          }
          input
          {
            padding: 4px 15px;
            border-radius: 5px;
          }
           h4{
        color: red;
      }
          
    </style>
   
</head>
<body style="background-image:url(images/Time1.jpg)">
  <form action="log" method="post">
    <fieldset>
        <legend ><b>Login</b></legend>
        <lable for="username">User Name</lable><br>
        <input type="text" id="User_Name" name="username" pattern="[a-z0-9.]+[@][a-z]+[.][]a-z]+" placeholder="Enter your Email" required><br><br>
        <lable for="password">Password</lable><br>
        <input type="password" id="password" name="password" pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}" placeholder="Enter valid password" title="Sample Xyz12@" required><br><br>
        &nbsp;&nbsp;<input type="submit" name="submit"> &nbsp;
       <a href="Register.jsp"><input type="button" value="Sign Up"></a>  &nbsp;
       <input type="reset" value="Reset"><br>
       <%
       String login=(String)session.getAttribute("login");
       if(login!=null)
       {
       %>
       <br>
       <h4><%=login %></h4>
       <%} %>
       <%session.removeAttribute("login");%>
    </fieldset>
</form>  

</body>
</html>