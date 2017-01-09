package com.ai.takeaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ai.takeaway.model.Dish;
import com.ai.takeaway.model.Menu;
import com.ai.takeaway.util.ConnectionProvider;

public class MenuDAO {
	private final static String CREATE = "insert into menu(menu_value, cost) values (?, ?);";
	private final static String READ = "select * from menu;";
	private final static String DELETE = "delete from menu;";

	public List<Menu> read() {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet resultSet = null;
		Menu resultMenu = null;
		try {
			conn = ConnectionProvider.getConnection();
			prepStmt = conn.prepareStatement(READ);

			resultSet = prepStmt.executeQuery();
			List<Menu> menuList = new ArrayList<>();
			while (resultSet.next()) {
				resultMenu = new Menu();
				resultMenu.setMenu_value(resultSet.getString("menu_value"));
				resultMenu.setCost(resultSet.getFloat("cost"));
				resultMenu.setMenu_id(resultSet.getInt("menu_id"));

				menuList.add(resultMenu);
			}
			return menuList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseResources(prepStmt, resultSet, conn);
		}
		return null;
	}
	
	
	public boolean create(Menu menu) {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet resultSet = null;
		boolean result = false;

		try {
			conn = ConnectionProvider.getConnection();
			prepStmt = conn.prepareStatement(CREATE);
			prepStmt.setString(1, menu.getMenu_value());			//System.out.println("<<<<<<<<<<<<<<<<<," + dish.getDish_user_id()+ "s>>>>>>>>>>>>>>>>>>>>>>>>");
			prepStmt.setFloat(2, menu.getCost());
			int rowsAffected = prepStmt.executeUpdate();
			if (rowsAffected > 0) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseResources(prepStmt, resultSet, conn);
		}
		return result;
	}


	public boolean delete() {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet resultSet = null;
		boolean result = false;

		try {
			conn = ConnectionProvider.getConnection();
			prepStmt = conn.prepareStatement(DELETE);

			int rowsAffected = prepStmt.executeUpdate();
			if (rowsAffected > 0) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseResources(prepStmt, resultSet, conn);
		}
		return result;
	}

	
	
	
	private void releaseResources(PreparedStatement prepStmt, ResultSet res, Connection conn) {
		try {
			if (prepStmt != null && !prepStmt.isClosed()) {
				prepStmt.close();
			}
			if (res != null && !res.isClosed()) {
				res.close();
			}
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
