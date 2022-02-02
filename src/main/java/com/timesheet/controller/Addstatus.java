package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.StatusDAOimpl;
import com.timesheet.daoimpl.TimesheetDAOimpl;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.Status;

@WebServlet("/addstatus")

public class Addstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try (PrintWriter out = response.getWriter()) {
			StatusDAOimpl statusdao = new StatusDAOimpl();
			TimesheetDAOimpl timesheetdao = new TimesheetDAOimpl();
			UserDAOimpl userdao = new UserDAOimpl();
			String username = request.getParameter("username");
			String timedate = request.getParameter("timesheetdate");
			LocalDate timesheetdate = LocalDate.parse(timedate);
			String status = request.getParameter("status");
			String approvedby = request.getParameter("approvedby");
			int id = userdao.findUserId(username);
			int id1 = timesheetdao.findTimesheetId(timesheetdate, id);
			Status statusobj = new Status(id, id1, status, approvedby);
			boolean flag = statusdao.insertStatus(statusobj);
			if (flag) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Timesheet status Added Successfully');");
				out.println("location='ShowAllTimesheet';");
				out.println("</script>");

			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Timesheet status not Added');");
				out.println("location='ShowAllTimesheet';");
				out.println("</script>");

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
