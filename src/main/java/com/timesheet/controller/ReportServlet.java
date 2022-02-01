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
import com.timesheet.daoimpl.ReportDAOimpl;
import com.timesheet.model.Report;

@WebServlet("/Report")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try{
			HttpSession session = request.getSession();
			String timedate=request.getParameter("timesheetdate");
			LocalDate timesheetdate=LocalDate.parse(timedate);
			String username=(String)session.getAttribute("username");
			ReportDAOimpl reportdao=new ReportDAOimpl();
			List<Report> showReport=reportdao.findreport(timesheetdate, username);
			request.setAttribute("report", showReport);
			   
			RequestDispatcher rd=request.getRequestDispatcher("reportMain.jsp");
		    rd.forward(request, response);
		    
				} catch (ServletException | IOException e) {
			
					e.printStackTrace();
				}
			
		}
	}
	
