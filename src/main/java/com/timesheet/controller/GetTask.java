package com.timesheet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetTask")
public class GetTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String taskName = request.getParameter("task");
		request.setAttribute("taskNameValue", taskName);
		String taskAssignDate=request.getParameter("taskAssignedDate");
		request.setAttribute("taskAssignDateValue", taskAssignDate);
		String taskEndingDate=request.getParameter("taskEndDate");
		request.setAttribute("taskEndingDate",taskEndingDate);
		String taskPriority= request.getParameter("priority");
		request.setAttribute("priorityValue",taskPriority);
		String taskAssigned= request.getParameter("taskAssignedTo");
		request.setAttribute("assignedTo", taskAssigned);
		RequestDispatcher rd = request.getRequestDispatcher("updateTaskMain.jsp");
		rd.forward(request, response);
	}

}
