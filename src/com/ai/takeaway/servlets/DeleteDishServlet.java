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
import com.ai.takeaway.model.Dish;
import com.ai.takeaway.model.User;

/**
 * Servlet implementation class DeleteOrdersServlet
 */
@WebServlet("/DeleteDishServlet")
public class DeleteDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteDishServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DishDAO dishDAO = new DishDAO();
		dishDAO.delete();
		getDish(request.getSession());
		response.sendRedirect("admin_panel.jsp");
	}

	private void getDish(HttpSession session) {
		// User user = (User) session.getAttribute("user");
		DishDAO dishDAO = new DishDAO();
		List<Dish> dishList = dishDAO.read();
		session.setAttribute("dishList", dishList);

	}

}
