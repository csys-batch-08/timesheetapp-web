package com.timesheet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Logout")

public class Logout extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		session.invalidate();
		try {
			RequestDispatcher reqdis=request.getRequestDispatcher("login.jsp");
			reqdis.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
