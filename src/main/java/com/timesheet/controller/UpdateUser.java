package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.User;
@WebServlet("/updateuser")

public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateUser() {
        super();
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDAOimpl userdao=new UserDAOimpl();
		User user=new User(firstname,lastname,username,password);
		PrintWriter out;
			out = response.getWriter();
		boolean flag=userdao.updateUser(user);
		if(flag)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Details Updated Successfully');");
			out.println("location='ShowUser';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Details not Updated');");
			out.println("location='ShowUser';");
			out.println("</script>");
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
