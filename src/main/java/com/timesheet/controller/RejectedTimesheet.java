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

import com.timesheet.daoimpl.RejecttimesheetDAOimpl;
import com.timesheet.model.Rejecttimesheet;

@WebServlet("/RejectedTimesheet")
public class RejectedTimesheet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			RejecttimesheetDAOimpl rejecttimesheetdao = new RejecttimesheetDAOimpl();
			String username = (String) session.getAttribute("username");
			List<Rejecttimesheet> rejectlist = rejecttimesheetdao.showRejecttimesheet(username);
			boolean flag=rejectlist.isEmpty();
			if(!flag)
			{
				request.setAttribute("rejectedtimesheet", rejectlist);
				RequestDispatcher rd = request.getRequestDispatcher("rejectedTimesheet.jsp");
				rd.forward(request, response);	
			}
			else
			{
			 session.setAttribute("message", "No Rejected Timesheet To View");
			 response.sendRedirect("timesheet.jsp");
			}
			

		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}

	}

}
