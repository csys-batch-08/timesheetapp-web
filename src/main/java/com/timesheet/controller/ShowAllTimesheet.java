package com.timesheet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.ViewTimesheetsDAOimpl;
import com.timesheet.model.ViewTimesheets;

@WebServlet("/ShowAllTimesheet")
public class ShowAllTimesheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowAllTimesheet() {
        super();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
		ViewTimesheetsDAOimpl viewtimesheetdao=new ViewTimesheetsDAOimpl();
		   List<ViewTimesheets> timesheetlist=viewtimesheetdao.showAllTimesheet();
		   request.setAttribute("showalltimesheet", timesheetlist);
		   
			RequestDispatcher rd=request.getRequestDispatcher("viewAllTimesheet.jsp");
		    rd.forward(request, response);
		    
				} catch (ServletException | IOException e) {
			
					e.printStackTrace();
				}
		
	}

}
