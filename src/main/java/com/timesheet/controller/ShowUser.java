package com.timesheet.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.User;


@WebServlet("/ShowUser")
public class ShowUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
		HttpSession session = request.getSession();
		UserDAOimpl userdao = new UserDAOimpl();
		 String username=(String)session.getAttribute("username");
		   List<User> userList =userdao.showuser(username);
		   request.setAttribute("showuser", userList);
		   
			RequestDispatcher rd=request.getRequestDispatcher("showUser.jsp");
		    rd.forward(request, response);
		    
				} catch (ServletException | IOException e) {
			
					e.printStackTrace();
				}

		
	}

}
