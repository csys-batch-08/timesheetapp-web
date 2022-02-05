package com.timesheet.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.TaskDAOimpl;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.Task;

@WebServlet("/addtask")

public class Addtask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String taskName = request.getParameter("taskname");
		String assigningDate = request.getParameter("assigningdate");
		LocalDate assignDate = LocalDate.parse(assigningDate);
		String endingDate = request.getParameter("endingdate");
		LocalDate endDate = LocalDate.parse(endingDate);
		long totalhrs = ChronoUnit.DAYS.between(assignDate, endDate) * 8;
		String priority = request.getParameter("priority");
		String username = request.getParameter("username");
		UserDAOimpl userdao = new UserDAOimpl();
		TaskDAOimpl taskdao = new TaskDAOimpl();
		int id = userdao.findUserId(username);
		Task task = new Task(id, taskName, assignDate, endDate, priority, username, totalhrs);
		boolean flag1 = taskdao.validateTask(taskName, username);
		try{
			if (!flag1) {
				boolean flag = taskdao.insertTask(task);
				if (flag) {
					response.sendRedirect("addTaskMain.jsp?infomsg=Task Added Successfully");
				} else {
					response.sendRedirect("addTaskMain.jsp?errormsg=Task Not Added");
				}
			} else {
				response.sendRedirect("addTaskMain.jsp?warningmsg=Task Already Exist");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
