package com.timesheet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetTimesheetid")
public class GetTimesheetId extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetTimesheetId() {
        super();
    }
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int timesheetid=Integer.parseInt(request.getParameter("timesheetid"));
		 session.setAttribute("timesheetid",timesheetid);
		   RequestDispatcher rd=request.getRequestDispatcher("updateStatus.jsp");
		    rd.forward(request, response);
	}

}
