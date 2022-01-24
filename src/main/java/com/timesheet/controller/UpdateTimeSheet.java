package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.timesheet.daoimpl.TaskDAOimpl;
import com.timesheet.daoimpl.TimesheetDAOimpl;
import com.timesheet.model.Timesheet;

@WebServlet("/updateTime")
public class UpdateTimeSheet extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session=request.getSession();
//		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String timedate=request.getParameter("timesheetdate");
		LocalDate timesheetdate=LocalDate.parse(timedate);
		int userid=Integer.parseInt(request.getParameter("userid"));
		int spendhrs=Integer.parseInt(request.getParameter("spendinghrs"));
		String comments=request.getParameter("comments");
		int taskId=Integer.parseInt(session.getAttribute("taskId").toString());
		TimesheetDAOimpl timesheetdao=new TimesheetDAOimpl();
		Timesheet timesheet=new Timesheet(userid,0,spendhrs,comments,timesheetdate);
//		System.out.println(timesheet);
		int result=0,hours=0;
		result=timesheetdao.getSpendhrs(timesheetdate);
		hours=spendhrs-result;
		TaskDAOimpl taskdao=new TaskDAOimpl();
		taskdao.updatehrs(hours, userid,taskId);
		boolean flag=timesheetdao.updateTimesheet(timesheet);
		PrintWriter out=response.getWriter();
		if(flag)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Timesheet updated Successfully');");
			out.println("location='Updatetimesheet.jsp';");
			out.println("</script>");
//			request.setAttribute("timesheet","Timesheet updated Successfully");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Timesheet not updated');");
			out.println("location='Updatetimesheet.jsp';");
			out.println("</script>");
//			request.setAttribute("timesheet","Timesheet not updated");
		}
		
//		request.getRequestDispatcher("updatetimesheet1.jsp").forward(request, response);
	}
	}


