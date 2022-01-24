package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.User;

@WebServlet("/Registerservlet")
/**
 * Servlet implementation class Registerservlet
 */
public class Registerservlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("hello");
//		PrintWriter print=response.getWriter();
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("hi"+firstname+lastname+username+password);
		User user=new User(firstname,lastname,username,password);
		UserDAOimpl userdao=new UserDAOimpl();
		userdao.insertUser(user);
		RequestDispatcher reqdis=request.getRequestDispatcher("login.jsp");
		reqdis.forward(request, response);
	}

}
