package com.ai.takeaway.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import com.ai.takeaway.dao.UserDAO;
import com.ai.takeaway.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		//pobrane z zapytania
		user.setUser_name(request.getParameter("name"));
		user.setUser_lastname(request.getParameter("surname"));
		user.setUser_pass(request.getParameter("password"));
		user.setUser_email(request.getParameter("email"));
		
		//dodane automatycznie:
		user.setUser_role_id(1);
		//utworzenie nowego u¿ytkownika:
		UserDAO userDAO = new UserDAO();
		boolean status = userDAO.create(user);
		if(status){
			response.sendRedirect("login.html");
		}
		
	}

}
