package com.timesheet.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.timesheet.daoimpl.TimesheetDAOimpl;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.Timesheet;

@WebServlet("/SearchTimesheet")
public class SearchTimesheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchTimesheet() {
        super();
    }
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
		HttpSession session = request.getSession();
		String timedate=request.getParameter("timesheetdate");
		LocalDate timesheetdate=LocalDate.parse(timedate);
		String username=(String)session.getAttribute("username");
		UserDAOimpl userdao=new UserDAOimpl();
		int uid=userdao.findUserId(username);
		TimesheetDAOimpl timesheetdao=new TimesheetDAOimpl();
		List<Timesheet> timesheets=timesheetdao.searchTimesheet(timesheetdate, uid);
		request.setAttribute("showtimesheet", timesheets);
		RequestDispatcher rd=request.getRequestDispatcher("updatetimesheet1.jsp");
	    rd.forward(request, response);
	    
			} catch (ServletException | IOException e) {
		
				e.printStackTrace();
			}
	}

}
