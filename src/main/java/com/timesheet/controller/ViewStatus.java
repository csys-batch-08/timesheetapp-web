package com.timesheet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timesheet.daoimpl.StatusDAOimpl;
import com.timesheet.model.Status;

@WebServlet("/ViewStatus")
public class ViewStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ViewStatus() {
        super();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response){
		try {
		 StatusDAOimpl statusdao = new StatusDAOimpl();
		   List<Status> statusList = statusdao.showallStatus();
		   request.setAttribute("showstatus", statusList);
		   RequestDispatcher rd=request.getRequestDispatcher("viewstatus.jsp");
		    rd.forward(request, response);
		    
				} catch (ServletException | IOException e) {
			
					e.printStackTrace();
				}
	}

}
