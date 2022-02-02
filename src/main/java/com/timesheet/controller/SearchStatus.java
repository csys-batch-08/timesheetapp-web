package com.timesheet.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.StatusDAOimpl;
import com.timesheet.model.Status;

@WebServlet("/SearchStatus")
public class SearchStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			int timesheetid = Integer.parseInt(request.getParameter("timesheetid"));
			StatusDAOimpl statusdao = new StatusDAOimpl();
			List<Status> statusList = statusdao.showStatus(timesheetid);
			request.setAttribute("viewstatus", statusList);
			RequestDispatcher rd = request.getRequestDispatcher("updateStatusMain.jsp");
			rd.forward(request, response);

		} catch (ServletException | IOException e) {

			e.printStackTrace();
		}
	}

}
