package com.timesheet.controller;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.TaskDAOimpl;
import java.io.PrintWriter;
import com.timesheet.daoimpl.TimesheetDAOimpl;
import com.timesheet.logger.Logger;
import com.timesheet.model.Timesheet;

@WebServlet("/timesheet")

public class Timesheetservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String SCRIPT = "<script type=\"text/javascript\">";
	private static final String LOCATION = "location='ShowTask';";
	private static final String SCRIPTEND = "</script>";
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try(PrintWriter out = response.getWriter()){
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
							out.println(SCRIPT);
							out.println("alert('Timesheet Added Successfully');");
							out.println(LOCATION);
							out.println(SCRIPTEND);
						} else {
							out.println(SCRIPT);
							out.println("alert('Timesheet Not Added');");
							out.println(LOCATION);
							out.println(SCRIPTEND);
						}
					} else {
						out.println(SCRIPT);
						out.println("alert('Not updated');");
						out.println(LOCATION);
						out.println(SCRIPTEND);
					}

				} else {
					out.println(SCRIPT);
					out.println("alert('Timesheet already Exist');");
					out.println(LOCATION);
					out.println(SCRIPTEND);
				}
			} else {
				out.println(SCRIPT);
				out.println("alert('Timesheet Hrs Not Available');");
				out.println(LOCATION);
				out.println(SCRIPTEND);
			}
		} catch (IOException | NumberFormatException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}
}
