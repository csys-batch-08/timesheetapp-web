package com.timesheet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminUserUpdate")
public class AdminUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminUserUpdate() {
        super();
    }
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username=request.getParameter("username");
		 session.setAttribute("username",username);
		 RequestDispatcher rd=request.getRequestDispatcher("updateUserAdmin.jsp");
		    rd.forward(request, response);
	}

}
