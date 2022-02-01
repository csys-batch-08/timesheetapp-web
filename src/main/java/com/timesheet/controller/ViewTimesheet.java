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

import com.timesheet.daoimpl.TimesheetDAOimpl;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.Timesheet;

@WebServlet("/ViewTimesheet")
public class ViewTimesheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
		TimesheetDAOimpl timesheetdao=new TimesheetDAOimpl();
		UserDAOimpl userdao = new UserDAOimpl();
		String username=(String)session.getAttribute("username");
		int userid=userdao.findUserId(username);
		List<Timesheet> timesheetlist=timesheetdao.showTimesheet(userid);
		request.setAttribute("showtimesheet", timesheetlist);
		   
		RequestDispatcher rd=request.getRequestDispatcher("viewTimesheet.jsp");
	    rd.forward(request, response);
	    
			} catch (ServletException | IOException e) {
		
				e.printStackTrace();
			}

	}

}
