package com.ai.takeaway.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ai.takeaway.model.User;

@WebServlet("/PrivilegesServlet")
public class PrivilegesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrivilegesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user = (User) request.getSession().getAttribute("user");
		
		if(user.getUser_role_id()==1){
			response.sendRedirect("index.jsp");
		}
		if(user.getUser_role_id()==2){
			response.sendRedirect("admin_panel.jsp");
		}

	}

}
