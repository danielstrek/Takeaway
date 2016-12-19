package com.ai.takeaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ai.takeaway.model.Dish;
import com.ai.takeaway.util.ConnectionProvider;

public class DishDAO {

	private final static String CREATE = "insert into  dish(dish_name, dish_cost, dish_paid,dish_paid_money, dish_user_id, dish_order_id) values(?, ?, ?, ?, ?, ?);";
	private final static String READ = "SELECT * FROM dish;";
	private final static String DELETE = "DELETE * from dish where dish_id = ?;";

	public List<Dish> read() {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet resultSet = null;
		Dish resultDish = null;
		try {
			conn = ConnectionProvider.getConnection();
			prepStmt = conn.prepareStatement(READ);

			resultSet = prepStmt.executeQuery();
			List<Dish> dishList = new ArrayList<>();
			while (resultSet.next()) {
				resultDish = new Dish();
				resultDish.setDish_name(resultSet.getString("dish_name"));
				resultDish.setDish_order_id(resultSet.getInt("dish_order_id"));
				resultDish.setDish_cost(resultSet.getFloat("dish_cost"));
				resultDish.setDish_paid(resultSet.getString("dish_paid"));
				resultDish.setDish_paid_money(resultSet.getFloat("dish_paid_money"));
				resultDish.setDish_user_id(resultSet.getInt("dish_paid_money"));

				dishList.add(resultDish);
			}
			return dishList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseResources(prepStmt, resultSet, conn);
		}
		return null;
	}

	// private final static String CREATE = "insert into dish(dish_name,
	// dish_cost, dish_paid,dish_paid_money, dish_user_id, dish_order_id)
	// values(?, ?, ?, ?, ?, ?);";

	public boolean create(Dish dish) {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet resultSet = null;
		boolean result = false;

		try {
			conn = ConnectionProvider.getConnection();
			prepStmt = conn.prepareStatement(CREATE);
			prepStmt.setString(1, dish.getDish_name());
			prepStmt.setFloat(2, dish.getDish_cost());
			prepStmt.setString(3, dish.getDish_paid());
			prepStmt.setFloat(4, dish.getDish_paid_money());
			prepStmt.setInt(5, dish.getDish_user_id());
			prepStmt.setInt(6, dish.getDish_order_id());

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