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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String username=request.getParameter("username");
		String role=request.getParameter("role");
		AdminDAOimpl admindao=new AdminDAOimpl();
		boolean flag=admindao.removeUser(username, role);
		PrintWriter out=response.getWriter();
		if(flag)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Status updated Successfully');");
			out.println("location='showalluser.jsp';");
			out.println("</script>");
//			request.setAttribute("updateuseradmin","User Details Updated Successfully");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Status Not Updated');");
			out.println("location='showalluser.jsp';");
			out.println("</script>");
//			request.setAttribute("updateuseradmin","User Details not Updated ");
		}
//		request.getRequestDispatcher("updateUserAdmin.jsp").forward(request, response);
	}

}
