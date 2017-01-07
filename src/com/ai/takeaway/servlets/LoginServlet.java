package com.ai.takeaway.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ai.takeaway.dao.DishDAO;
import com.ai.takeaway.dao.OrderDAO;
import com.ai.takeaway.dao.RestaurantDAO;
import com.ai.takeaway.dao.UserDAO;
import com.ai.takeaway.model.Dish;
import com.ai.takeaway.model.Order;
import com.ai.takeaway.model.Restaurant;
import com.ai.takeaway.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String USEREMAIL = "jan.nowak1@mail.com";
	private static final String PASS = "user";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("index.html");

		System.out.println("LoginServlet doPost()");
		String userEmail = request.getParameter("email");
		String passParam = request.getParameter("pass");
		//if (validate(userEmail, passParam)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", userEmail);
			User user = (User) getUser(session);
			if (user.getUser_pass().equals(request.getParameter("pass"))){
			getRestaurant(session);
			getOrder(session);
			getDish(session);
			// response.sendRedirect("RestaurantServlet");
			response.sendRedirect("index.jsp");
			}
			else{
				response.sendRedirect("login.htm");
			}

		}
		// else
//	}

	private boolean validate(String username, String password) {
		return USEREMAIL.equals(username) && PASS.equals(password);
	}
	
	

	private User getUser(HttpSession session) {
		UserDAO userDAO = new UserDAO();
		String userEmail = session.getAttribute("email").toString();
		User user = userDAO.read(userEmail);
		session.setAttribute("user", user);
		return user;
	}

	private void getRestaurant(HttpSession session) {
		RestaurantDAO resDAO = new RestaurantDAO();
		List<Restaurant> res = resDAO.read();
		session.setAttribute("restaurantList", res);
	}
	

	private void getOrder(HttpSession session) {
		OrderDAO orderDAO = new OrderDAO();
		List<Order> orderList = orderDAO.read();
		session.setAttribute("orderList", orderList);
	}
	
	private void getDish(HttpSession session) {
		DishDAO dishDAO = new DishDAO();
		List<Dish> dishList = dishDAO.read();
		session.setAttribute("dishList", dishList);
	}



}
