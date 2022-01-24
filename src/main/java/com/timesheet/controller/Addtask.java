package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
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
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		String dateStr = request.getParameter("date");
//		DateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
//			Date timesheetdate1 = parser.parse(dateStr);
//			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//			String timesheetdate=(formatter.format(timesheetdate1));
		
		PrintWriter out=response.getWriter();
		String taskname=request.getParameter("taskname");
		
//		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String assigningdate=request.getParameter("assigningdate");
//		System.out.println(assigningdate+"helo");
		LocalDate assdate=LocalDate.parse(assigningdate);
		String endingdate=request.getParameter("endingdate");
		LocalDate enddate=LocalDate.parse(endingdate);
//		System.out.println(assdate+"helo"+enddate);
		long totalhrs = ChronoUnit.DAYS.between(assdate,enddate)*8;
		String priority=request.getParameter("priority");
		String username=request.getParameter("username");
		UserDAOimpl userdao=new UserDAOimpl();
		TaskDAOimpl taskdao=new TaskDAOimpl();
		int id=userdao.findUserId(username);
//	  System.out.println(id+taskname+assigningdate+endingdate+priority+username);
		Task task=new Task(id,taskname,assdate,enddate,priority,username,totalhrs);
		boolean flag1=taskdao.validateTask(taskname, username);
		if(flag1==false)
		{
		boolean flag=taskdao.insertTask(task);
		if(flag)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Task Added Successfully');");
			out.println("location='addtaskmain.jsp';");
			out.println("</script>");
//		HttpSession session=request.getSession();
//		session.setAttribute("task","Task Added Successfully");
//		session.removeAttribute("task");
//			int taskid=taskdao.findtaskId(taskname);
//			request.setAttribute("taskid", taskid);
//			request.setAttribute("task","Task Added Successfully");
//			request.setAttribute("taskname",taskname);
//			request.setAttribute("assigningdate",assigningdate);
//			request.getRequestDispatcher("addtaskmain.jsp").forward(request, response);
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Task Not Added');");
			out.println("location='addtaskmain.jsp';");
			out.println("</script>");
//			request.setAttribute("task","Task not Added");
//			request.getRequestDispatcher("addtaskmain.jsp").forward(request, response);
		}
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Task Already Exist');");
			out.println("location='addtaskmain.jsp';");
			out.println("</script>");
//			request.setAttribute("task","Already Exist");
//			request.getRequestDispatcher("addtaskmain.jsp").forward(request, response);	
		}
//		RequestDispatcher reqdis=request.getRequestDispatcher("addtaskmain.jsp");
//		reqdis.forward(request, response);
//		out.println("task successfully added");
	}

}
