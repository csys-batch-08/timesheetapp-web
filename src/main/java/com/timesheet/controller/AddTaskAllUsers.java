package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.AdminDAOimpl;
import com.timesheet.daoimpl.TaskDAOimpl;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.AdminUser;
import com.timesheet.model.Task;

@WebServlet("/addtaskalluser")

public class AddTaskAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try (PrintWriter out = response.getWriter()) {
			String taskname = request.getParameter("taskname");
			String assigningdate = request.getParameter("assigningdate");
			LocalDate assdate = LocalDate.parse(assigningdate);
			String endingdate = request.getParameter("endingdate");
			LocalDate enddate = LocalDate.parse(endingdate);
			long totalhrs = ChronoUnit.DAYS.between(assdate, enddate) * 8;
			String priority = request.getParameter("priority");
			UserDAOimpl userdao = new UserDAOimpl();
			TaskDAOimpl taskdao = new TaskDAOimpl();
			AdminDAOimpl admindao = new AdminDAOimpl();
			List<AdminUser> userList = admindao.showusers();
			int id = 0;
			boolean flag = false;
			for (AdminUser viewUser : userList) {
				id = userdao.findUserId(viewUser.getUserName());
				Task task = new Task(id, taskname, assdate, enddate, priority, viewUser.getUserName(), totalhrs);
				flag = taskdao.insertTask(task);
			}
			if (flag) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Task Added Successfully');");
				out.println("location='addTaskMain.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Task Not Added');");
				out.println("location='addTaskMain.jsp';");
				out.println("</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
