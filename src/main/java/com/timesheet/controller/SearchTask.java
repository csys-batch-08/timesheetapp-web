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
import com.timesheet.model.Task;

@WebServlet("/SearchTask")
public class SearchTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response){
		 try {
		String task=request.getParameter("taskname");
		TaskDAOimpl taskdao=new TaskDAOimpl();
		List<Task> tasklist=taskdao.searchTask(task);
		request.setAttribute("showTask", tasklist);
		RequestDispatcher rd=request.getRequestDispatcher("updateTaskMain.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
