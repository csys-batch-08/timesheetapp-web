package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.User;

@WebServlet("/updateuser")

public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try (PrintWriter out = response.getWriter()) {
			HttpSession session = request.getSession();
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String username = request.getParameter("username");
			String password = request.getParameter("newPassword");
			String userPassword =session.getAttribute("userPassword").toString();
			String oldPassword=request.getParameter("oldPassword");
			UserDAOimpl userdao = new UserDAOimpl();
			if(oldPassword.equals(userPassword))
			{
			User user = new User(firstname, lastname, username, password);
			boolean flag = userdao.updateUser(user);
			if (flag) {
				session.setAttribute("userPassword", password);
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Changes Updated Successfully');");
				out.println("location='ShowUser';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Changes not Updated');");
				out.println("location='ShowUser';");
				out.println("</script>");
			}
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Old password does not match');");
				out.println("location='updateUser.jsp';");
				out.println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
