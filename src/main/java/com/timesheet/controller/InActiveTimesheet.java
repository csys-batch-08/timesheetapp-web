package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timesheet.daoimpl.TimesheetDAOimpl;
import com.timesheet.logger.Logger;

@WebServlet("/InActiveTimesheet")
public class InActiveTimesheet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try (PrintWriter out = response.getWriter()) {
			String timesheetDate = request.getParameter("timesheetDate");
			String timesheetStatus = request.getParameter("timesheetStatus");
			TimesheetDAOimpl timedao = new TimesheetDAOimpl();
			boolean flag = timedao.removeTimesheet(timesheetDate, timesheetStatus);
			if (flag) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Timesheet InActive Successfully');");
				out.println("location='ViewTimesheet';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Timesheet Status Not Updated');");
				out.println("location='ViewTimesheet';");
				out.println("</script>");
			}
		} catch (IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}

	}

}
