package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
   
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session = request.getSession();
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDAOimpl userdao=new UserDAOimpl();
		AdminDAOimpl admindao=new AdminDAOimpl();
		User validuser=userdao.validateUser(username, password);
		User validadmin=admindao.validateAdmin(username, password);
//		System.out.println(validuser.getUsername());
		if(validuser!=null)
		{
			//out.println("Login as "+validuser.getFirstname());
			session.setAttribute("username",validuser.getUsername());
		RequestDispatcher reqdis=request.getRequestDispatcher("index.jsp");
		reqdis.forward(request, response);
		}
		else if(validadmin!=null)
		{
//		  out.println("Login as "+validadmin.getFirstname()+" Admin");
		  session.setAttribute("adminuser",validadmin.getFirstname());
		    RequestDispatcher reqdis=request.getRequestDispatcher("adminindex.jsp");
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
//HttpSession session=request.getSession();
//session.setAttribute("adminuser",validadmin.getUsername());
