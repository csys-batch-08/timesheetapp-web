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
import com.timesheet.exception.InvalidUserException;
import com.timesheet.model.User;
@WebServlet("/log")


public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDAOimpl userdao=new UserDAOimpl();
		AdminDAOimpl admindao=new AdminDAOimpl();
		User validuser=userdao.validateUser(username, password);
		User validadmin=admindao.validateAdmin(username, password);
		if(validuser!=null)
		{
			session.setAttribute("username",validuser.getUsername());
		RequestDispatcher reqdis=request.getRequestDispatcher("userIndex.jsp");
		reqdis.forward(request, response);
		}
		else if(validadmin!=null)
		{

		  session.setAttribute("adminuser",validadmin.getFirstname());
		    RequestDispatcher reqdis=request.getRequestDispatcher("adminIndex.jsp");
			reqdis.forward(request, response);
		}
		else
		{
			try
			{
			throw new InvalidUserException();
			}
			catch(InvalidUserException e)
			{
				session.setAttribute("login", "! Invalid Username or Password");
				String value=e.validateUser();
				response.sendRedirect(value);
			}
		}
		
	}

}

