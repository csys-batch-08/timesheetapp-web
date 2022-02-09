package com.timesheet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateUserProfile")
public class UpdateUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String userName = request.getParameter("username");
		String lastName = request.getParameter("lastname");
		request.setAttribute("firstNameValue", firstName);
		request.setAttribute("userNameValue", userName);
		request.setAttribute("lastNameValue", lastName);
		RequestDispatcher rd = request.getRequestDispatcher("updateUser.jsp");
		rd.forward(request, response);
	}

}
