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
import com.ai.takeaway.dao.RestaurantDAO;
import com.ai.takeaway.model.Dish;
import com.ai.takeaway.model.Restaurant;
import com.ai.takeaway.model.User;

@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddOrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("test add");
		User user = new User();
		user = (User) request.getSession().getAttribute("user");
		System.out.println("User ID = " + user.getUser_id());

		Dish dish = new Dish();
		dish.setDish_name(request.getParameter("dish_name"));
		dish.setDish_cost(Float.parseFloat(request.getParameter("dish_cost")));
		dish.setDish_order_id(1);
		dish.setDish_paid("N");
		dish.setDish_paid_money(0);
		dish.setDish_user_id(user.getUser_id());

		System.out.println("User dish ID = " + dish.getDish_user_id());
		/**
		 * pobranie usera do zapisuID, w ten sposób mogê pobieraæ inne parametry
		 * pytanie: czy jest sens zapisywaæ wszystko w sesji?? do poprawy:
		 * pobieram u¿ytkownika po imieniu zapisanym w sesji... taki u¿ytkownik
		 * nie ma id: b³¹d klucza obcego:id u¿ytkownika to 0!
		 */
		// System.out.println(" userID: "+ user.getUser_id());
		// System.out.println(" userName: "+ user.getUser_name());

		// dish.setDish_user_id(user.getUser_id());

		DishDAO dishDAO = new DishDAO();
		dishDAO.create(dish);
		getDish(request.getSession(),user);

		response.sendRedirect("dodaj_zamowienie.jsp");

	}

	private void getDish(HttpSession session, User user) {
		// User user = (User) session.getAttribute("user");
		DishDAO dishDAO = new DishDAO();
		if (user.getUser_role_id() == 2) {
			System.out.println("UserRoleID == 2");
			List<Dish> dishList = dishDAO.read();
			session.setAttribute("dishList", dishList);
		} else if (user.getUser_role_id() == 1) {
			List<Dish> dishList = dishDAO.read(user.getUser_id());
			System.out.println("UserRoleID == 1");

			session.setAttribute("dishList", dishList);

		}

	}
}
