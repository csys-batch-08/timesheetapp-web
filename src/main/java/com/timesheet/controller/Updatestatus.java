package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.StatusDAOimpl;
import com.timesheet.model.Status;
@WebServlet("/updateStatus")

public class Updatestatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Updatestatus() {
        super(); 
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int timesheetid=Integer.parseInt(request.getParameter("timesheetid"));
		String status=request.getParameter("status");
		StatusDAOimpl statusdao=new StatusDAOimpl();
		Status statusobj=new Status(0,timesheetid,status,null);
		boolean flag=statusdao.updateStatus(statusobj);
		PrintWriter out=response.getWriter();
		if(flag)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Timesheet status updated Successfully');");
			out.println("location='ShowAllTimesheet';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Timesheet status not updated');");
			out.println("location='ShowAllTimesheet';");
			out.println("</script>");
		}
		
	}
		
	}

