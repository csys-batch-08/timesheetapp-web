package com.timesheet.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.TaskDAOimpl;
import com.timesheet.logger.Logger;
import com.timesheet.model.Task;

@WebServlet("/Showalltask")
public class ShowAllTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			TaskDAOimpl taskdao = new TaskDAOimpl();
			List<Task> taskList = taskdao.showallTask();
			request.setAttribute("showalltask", taskList);

			RequestDispatcher rd = request.getRequestDispatcher("showAllTask.jsp");
			rd.forward(request, response);

		} catch (ServletException | IOException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}

	}

}
