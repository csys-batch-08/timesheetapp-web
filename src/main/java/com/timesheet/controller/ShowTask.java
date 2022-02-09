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

import com.timesheet.daoimpl.TaskDAOimpl;
import com.timesheet.logger.Logger;
import com.timesheet.model.Task;

@WebServlet("/ShowTask")
public class ShowTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			TaskDAOimpl taskdao = new TaskDAOimpl();
			List<Task> taskList = taskdao.showTask(username);
			request.setAttribute("showtask", taskList);
			RequestDispatcher rd = request.getRequestDispatcher("showTask.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}

}
