package com.timesheet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateUserProfile")
public class UpdateUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateUserProfile() {
        super();
    }
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		   String firstname=request.getParameter("firstname");
		   String username=request.getParameter("username");
		   String lastname=request.getParameter("lastname");
		   session.setAttribute("firstname", firstname);
		   session.setAttribute("username",username);
		   session.setAttribute("lastname",lastname);
		   RequestDispatcher rd=request.getRequestDispatcher("updateUser.jsp");
		    rd.forward(request, response);
 }

}
