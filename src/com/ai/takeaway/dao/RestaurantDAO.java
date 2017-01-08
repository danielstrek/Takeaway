package com.ai.takeaway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ai.takeaway.model.Restaurant;
import com.ai.takeaway.util.ConnectionProvider;

public class RestaurantDAO {
	
	private final static String CREATE = "insert into restaurant (res_name, res_menu_link, res_info) values(?,?,?);";
    private final static String READ = "SELECT * FROM restaurant ;";
    private final static String READ1 = "SELECT * FROM restaurant where res_name =?;";

    //private final static String UPDATE = "UPDATE user SET pass=?, WHERE user_id = ?;";
    //private final static String DELETE = "DELETE FROM user WHERE user_id=?;";
    
    
    public List<Restaurant> read() {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        Restaurant resultRestaurant = null;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(READ);
            //prepStmt.setString(1, name);
            resultSet = prepStmt.executeQuery();
            List<Restaurant> restList = new ArrayList<>();
           while(resultSet.next()) {
                resultRestaurant = new Restaurant();
                resultRestaurant.setRes_name(resultSet.getString("res_name"));
                resultRestaurant.setRes_info(resultSet.getString("res_info"));
                resultRestaurant.setRes_menu_link(resultSet.getString("res_menu_link"));
                System.out.println("Restaurant name:: " + resultRestaurant.getRes_name());
                restList.add(resultRestaurant);
                System.out.println(restList.get(0).getRes_name());
            }
           return restList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, resultSet, conn);
        }
        return null;
    }
    
    
    public Restaurant read(String restaurantName) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        Restaurant resultRestaurant = null;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(READ1);
            prepStmt.setString(1, restaurantName);

            resultSet = prepStmt.executeQuery();
            
            while(resultSet.next()) {
                resultRestaurant = new Restaurant();
                resultRestaurant.setRes_name(resultSet.getString("res_name"));
                resultRestaurant.setRes_info(resultSet.getString("res_info"));
                resultRestaurant.setRes_menu_link(resultSet.getString("res_menu_link"));
                resultRestaurant.setRes_id(resultSet.getInt("res_id"));
            }
           return resultRestaurant;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, resultSet, conn);
        }
        return null;
    }

    
    
    
	
    private void releaseResources(PreparedStatement prepStmt, ResultSet res,
            Connection conn) {
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
