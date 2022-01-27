package com.timesheet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.timesheet.daoimpl.TimesheetDAOimpl;
import com.timesheet.daoimpl.UserDAOimpl;

@WebServlet("/TimesheetMain")
public class TimesheetMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public TimesheetMain() {
        super();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDAOimpl userdao = new UserDAOimpl();
		TimesheetDAOimpl timesheetdao=new TimesheetDAOimpl();
		String sysDate=timesheetdao.getDate();
		   String username=(String)session.getAttribute("username");
		   int uid=userdao.findUserId(username);
		   String taskname=request.getParameter("taskName");
		   String taskdate=request.getParameter("taskDate");
		   session.setAttribute("taskname", taskname);
		   session.setAttribute("userid", uid);
		   session.setAttribute("taskdate", taskdate);
		   session.setAttribute("sysdate", sysDate);
			 RequestDispatcher rd=request.getRequestDispatcher("timesheetmain.jsp");
			    rd.forward(request, response);
		   
	}

}
