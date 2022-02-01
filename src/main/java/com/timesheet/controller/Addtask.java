package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.TaskDAOimpl;
import com.timesheet.daoimpl.UserDAOimpl;
import com.timesheet.model.Task;
@WebServlet("/addtask")

public class Addtask extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Addtask() {
        super();
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try(PrintWriter out = response.getWriter()) {
		String taskname=request.getParameter("taskname");
		String assigningdate=request.getParameter("assigningdate");
		LocalDate assdate=LocalDate.parse(assigningdate);
		String endingdate=request.getParameter("endingdate");
		LocalDate enddate=LocalDate.parse(endingdate);
		long totalhrs = ChronoUnit.DAYS.between(assdate,enddate)*8;
		String priority=request.getParameter("priority");
		String username=request.getParameter("username");
		UserDAOimpl userdao=new UserDAOimpl();
		TaskDAOimpl taskdao=new TaskDAOimpl();
		int id=userdao.findUserId(username);
		Task task=new Task(id,taskname,assdate,enddate,priority,username,totalhrs);
		boolean flag1=taskdao.validateTask(taskname, username);
		if(!flag1)
		{
		boolean flag=taskdao.insertTask(task);
		if(flag)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Task Added Successfully');");
			out.println("location='addTaskMain.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Task Not Added');");
			out.println("location='addTaskMain.jsp';");
			out.println("</script>");
		}
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Task Already Exist');");
			out.println("location='addTaskMain.jsp';");
			out.println("</script>");	
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
