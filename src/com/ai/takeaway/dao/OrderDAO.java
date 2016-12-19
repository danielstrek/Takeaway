package com.ai.takeaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ai.takeaway.model.Order;
import com.ai.takeaway.model.Restaurant;
import com.ai.takeaway.util.ConnectionProvider;

public class OrderDAO {

	private final static String CREATE = "insert into order (order_res_id, order_fullcost, order_user_id) values(?,?,?);";
	private final static String READ = "SELECT * FROM order_;";
	private final static String READ1 = "Select * from order_ where order_user_id = ?;";
	private final static String DELETE = "DELETE * from order_ where order_user_id = ?;";

	// private final static String UPDATE = "UPDATE user SET pass=?, WHERE
	// user_id = ?;";
	// private final static String DELETE = "DELETE FROM user WHERE user_id=?;";

	public List<Order> read() {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet resultSet = null;
		Order resultOrder = null;
		try {
			conn = ConnectionProvider.getConnection();
			prepStmt = conn.prepareStatement(READ);
			resultSet = prepStmt.executeQuery();
			List<Order> orderList = new ArrayList<>();
			while (resultSet.next()) {
				resultOrder = new Order();
				resultOrder.setOrder_id(resultSet.getInt("order_id"));
				resultOrder.setOrder_res_id(resultSet.getInt("order_res_id"));
				resultOrder.setOrder_fullcost(resultSet.getFloat("order_fullcost"));
				resultOrder.setOrder_user_id(resultSet.getInt("order_user_id"));
				orderList.add(resultOrder);
			}
			return orderList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseResources(prepStmt, resultSet, conn);
		}
		return null;
	}

	public  boolean create(Order order) {
		Connection conn = null;
		PreparedStatement prepStmt = null;
		ResultSet resultSet = null;
		boolean result = false;
		
		try {
			conn = ConnectionProvider.getConnection();
			prepStmt = conn.prepareStatement(CREATE);
			prepStmt.setInt(1, order.getOrder_res_id());
			prepStmt.setFloat(2, order.getOrder_fullcost());
			prepStmt.setInt(3, order.getOrder_user_id());
			int rowsAffected =  prepStmt.executeUpdate();
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
