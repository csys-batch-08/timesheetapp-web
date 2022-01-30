package com.timesheet.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.User;

@WebServlet("/Registerservlet")

public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		User user=new User(firstname,lastname,username,password);
		UserDAOimpl userdao=new UserDAOimpl();
		userdao.insertUser(user);
		RequestDispatcher reqdis=request.getRequestDispatcher("index.jsp");
			reqdis.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
