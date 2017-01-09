package com.ai.takeaway.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ai.takeaway.dao.MenuDAO;
import com.ai.takeaway.model.Menu;

@WebServlet("/MenuAddServlet")
public class MenuAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MenuAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Menu menu = new Menu();
		float dishCost = Float.parseFloat(request.getParameter("dish_cost"));
		menu.setCost(dishCost);
		menu.setMenu_value(request.getParameter("dish_name"));
		MenuDAO menuDAO = new MenuDAO();
		menuDAO.create(menu);
		
		getMenu(request.getSession());
		
		response.sendRedirect("admin_panel.jsp");
	
	}
	
	private void getMenu(HttpSession session){
		MenuDAO menuDAO = new MenuDAO();
		List <Menu> menuList = menuDAO.read();
		session.setAttribute("menuList", menuList);
	}


}
