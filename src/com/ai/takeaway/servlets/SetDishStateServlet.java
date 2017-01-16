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
import com.ai.takeaway.model.Dish;

@WebServlet("/SetDishStateServlet")
public class SetDishStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SetDishStateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dish dish = new Dish();
		DishDAO dishDao = new DishDAO();
		
		//pobranie z zapytania parametów
		int dish_id = Integer.parseInt(request.getParameter("dish_id"));
		//System.out.println(dish_id);
		String dish_paid = request.getParameter("status");
		//System.out.println(dish_paid);
		
		//aktualizacja
		int result = dishDao.update(dish_id, dish_paid);
		System.out.println(result);
		List<Dish> dishList = dishDao.read();
		//List<Dish> dishList = (List<Dish>) request.getSession().getAttribute("dishList");
		//request.getSession().setAttribute("dishList", dishList);

		
		//dishList.add(dish);
		HttpSession session = request.getSession();
		session.setAttribute("dishList", dishList);
		response.sendRedirect("admin_panel.jsp");

	}
	
	

}
