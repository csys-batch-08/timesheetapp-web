<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
    <style>
   
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
              top: 80px;
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
<body style="background-image:url(images/Time1.jpg)">   
    <form action="Registerservlet" method="post" id="regForm">
        <fieldset>
            <legend ><b>Sign Up</b></legend>
            <label for="firstname">First Name</label><br>
            <input type="text" id="First_Name" name="firstname" pattern="[A-Za-z]{3,}" required autofocus><br><br>
            <label for="lastname">Last Name</label><br>
            <input type="text" id="Last_Name" name="lastname" pattern="[A-Za-z]{3,}" required><br><br>
            <label for="username">User Name</label><br>
            <input type="email" id="User_Name" name="username" pattern="[a-z][a-z0-9_.]+@[a-z0-9.]+[.][a-z]+"  title="Sample xyz12@gmail.com" required><br><br>
            <label for="password">Password</label><br>
            <input type="password" id="password" name="password" pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Sample Xyz12@" required><br><br>
            <label for="password">Confirm Password</label><br>
            <input type="password" id="Confirm_password" name="Confirm_password" pattern="(?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Enter confirm password same as password " required><br><br>
            &nbsp;&nbsp;<button type="submit" onclick="myfunction()">Submit</button>&nbsp; &nbsp;
           <input type="reset" value="Reset"><br><br>
           Have already an account?<a href="login.jsp">Login here</a> 
        </fieldset>
    </form>  
    
</body>
</html>