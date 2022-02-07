package com.timesheet.controller;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.TaskDAOimpl;
import com.timesheet.daoimpl.TimesheetDAOimpl;
import com.timesheet.model.Timesheet;

@WebServlet("/timesheet")

public class Timesheetservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try{
			TimesheetDAOimpl timesheetdao = new TimesheetDAOimpl();
			int id = Integer.parseInt(request.getParameter("userid"));
			String timedate = request.getParameter("timesheetdate");
			LocalDate timesheetdate = LocalDate.parse(timedate);
			String taskname = request.getParameter("taskname");
			TaskDAOimpl taskdao = new TaskDAOimpl();
			int id1 = taskdao.findtaskId(taskname);
			int spendinghrs = Integer.parseInt(request.getParameter("spendinghrs"));
			String comments = request.getParameter("comments");
			int hours = taskdao.getTotalhrs(id, taskname);
			int result = 0;
			if (hours > spendinghrs) {
				Timesheet timesheet = new Timesheet(id, id1, spendinghrs, comments, timesheetdate);
				boolean flag1 = timesheetdao.checkDate(id, timesheetdate);
				if (!flag1) {
					result = taskdao.updatehrs(spendinghrs, id, id1);
					if (result > 0) {

						boolean flag = timesheetdao.insertTimesheet(timesheet);
						if (flag) {
							response.sendRedirect("ShowTask?infoMsg=Timesheet Added Successfully");
						} else {
							response.sendRedirect("ShowTask?errorMsg1=Timesheet Not Added");
						}
					} else {
						response.sendRedirect("ShowTask?errorMsg2=Not updated");
					}

				} else {
					response.sendRedirect("ShowTask?warningMsg1=Timesheet already Exist");
				}
			} else {
				response.sendRedirect("ShowTask?warningMsg2=Timesheet Hrs Not Available");
			}
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
