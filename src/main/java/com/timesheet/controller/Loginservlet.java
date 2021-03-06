package com.timesheet.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.timesheet.daoimpl.AdminDAOimpl;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.logger.Logger;
import com.timesheet.model.User;

@WebServlet("/log")

public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 {
		try {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAOimpl userdao = new UserDAOimpl();
		AdminDAOimpl admindao = new AdminDAOimpl();
		User validuser = userdao.validateUser(username, password);
		User validadmin = admindao.validateAdmin(username, password);
		if (validuser != null) {
			session.setAttribute("username", validuser.getUserUserName());
			session.setAttribute("userPassword", validuser.getPassword());
			RequestDispatcher reqdis = request.getRequestDispatcher("userIndex.jsp");
				reqdis.forward(request, response);
		} else if (validadmin != null) {

			session.setAttribute("adminuser", validadmin.getUserFirstName());
			RequestDispatcher reqdis = request.getRequestDispatcher("adminIndex.jsp");
			reqdis.forward(request, response);
		} else {
				session.setAttribute("login", "! Invalid Username or Password");
				response.sendRedirect("index.jsp");
		}
		} catch (ServletException | IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}

}
