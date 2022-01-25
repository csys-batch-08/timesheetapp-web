package com.timesheet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timesheet.daoimpl.AdminDAOimpl;
import com.timesheet.model.AdminUser;

@WebServlet("/ShowAllUser")
public class ShowAllUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowAllUser() {
        super();
    }
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
		AdminDAOimpl admindao = new AdminDAOimpl();
		   List<AdminUser> userList = admindao.showalluser();
		request.setAttribute("showallusers", userList);
		RequestDispatcher rd=request.getRequestDispatcher("showalluser.jsp");
		
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
 }

}
