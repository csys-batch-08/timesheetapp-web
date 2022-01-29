package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.TaskDAOimpl;
import com.timesheet.daoimpl.TimesheetDAOimpl;
import com.timesheet.model.Timesheet;

@WebServlet("/updateTime")
public class UpdateTimeSheet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		try {
		String timedate=request.getParameter("timesheetdate");
		LocalDate timesheetdate=LocalDate.parse(timedate);
		int userid=Integer.parseInt(request.getParameter("userid"));
		int spendhrs=Integer.parseInt(request.getParameter("spendinghrs"));
		String comments=request.getParameter("comments");
		int taskId=Integer.parseInt(request.getParameter("taskid"));
		TimesheetDAOimpl timesheetdao=new TimesheetDAOimpl();
		Timesheet timesheet=new Timesheet(userid,0,spendhrs,comments,timesheetdate);
		int result=0;
		int hours=0;
		result=timesheetdao.getSpendhrs(timesheetdate);
		hours=spendhrs-result;
		TaskDAOimpl taskdao=new TaskDAOimpl();
		taskdao.updatehrs(hours, userid,taskId);
		boolean flag=timesheetdao.updateTimesheet(timesheet);
		PrintWriter out;
			out = response.getWriter();
		if(flag)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Timesheet updated Successfully');");
			out.println("location='Updatetimesheet.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Timesheet not updated');");
			out.println("location='Updatetimesheet.jsp';");
			out.println("</script>");
		}
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
     }
	}
	


