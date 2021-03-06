package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.TaskDAOimpl;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.logger.Logger;
import com.timesheet.model.Task;

@WebServlet("/UpdateTask")
public class UpdateTask extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String taskname = request.getParameter("taskname");
		String assigningdate = request.getParameter("assigningdate");
		LocalDate assdate = LocalDate.parse(assigningdate);
		String endingdate = request.getParameter("endingdate");
		LocalDate enddate = LocalDate.parse(endingdate);
		long totalhrs = ChronoUnit.DAYS.between(assdate, enddate) * 8;
		String priority = request.getParameter("priority");
		String username = request.getParameter("username");
		UserDAOimpl userdao = new UserDAOimpl();
		TaskDAOimpl taskdao = new TaskDAOimpl();
		int id = userdao.findUserId(username);
		Task task = new Task(id, taskname, assdate, enddate, priority, username, totalhrs);
		boolean flag = taskdao.updateTask(task);
		try (PrintWriter out = response.getWriter()) {
			if (flag) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Task Updated Successfully');");
				out.println("location='Showalltask';");
				out.println("</script>");

			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Task Not Updated');");
				out.println("location='Showalltask;");
				out.println("</script>");

			}
		} catch (IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}

}
