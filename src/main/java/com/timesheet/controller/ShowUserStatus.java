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

import com.timesheet.daoimpl.ViewTimesheetsDAOimpl;
import com.timesheet.logger.Logger;
import com.timesheet.model.ViewTimesheets;

@WebServlet("/ShowUserStatus")
public class ShowUserStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			ViewTimesheetsDAOimpl viewtimesheetdao = new ViewTimesheetsDAOimpl();
			String username = (String) session.getAttribute("username");
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			List<ViewTimesheets> timesheetlist = viewtimesheetdao.showTimesheet(username, startdate, enddate);
			request.setAttribute("showuserstatus", timesheetlist);

			RequestDispatcher rd = request.getRequestDispatcher("showUserStatus.jsp");
			rd.forward(request, response);

		} catch (ServletException | IOException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}

}
