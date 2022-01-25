package com.timesheet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.timesheet.daoimpl.AdminDAOimpl;
@WebServlet("/updateuseradmin")

public class UpdateUserAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateUserAdmin() {
        super();
        
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username=request.getParameter("username");
		String role=request.getParameter("role");
		AdminDAOimpl admindao=new AdminDAOimpl();
		boolean flag=admindao.removeUser(username, role);
		PrintWriter out=response.getWriter();
		if(flag)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Status updated Successfully');");
			out.println("location='ShowAllUser';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Status Not Updated');");
			out.println("location='ShowAllUser';");
			out.println("</script>");
		}
	}

}
