package com.ai.takeaway.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ai.takeaway.model.User;
import com.ai.takeaway.util.ConnectionProvider;

public class UserDAO {

	private final static String CREATE = "INSERT INTO user_(user_role_id, user_name, user_lastname, user_email, user_pass) VALUES(?, ?, ?, ?, ?);";
    //private final static String READ = "SELECT * FROM user_ WHERE user_name = ?;";
    private final static String READ = "select * from user_ where user_email = ?;";
    private final static String UPDATE = "UPDATE user_ SET pass=?, WHERE user_id = ?;";
    private final static String DELETE = "DELETE FROM user WHERE user_id=?;";
    
    public boolean create(User user) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        boolean result = false;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(CREATE);
            prepStmt.setInt(1, user.getUser_role_id());
            prepStmt.setString(2, user.getUser_name());
            prepStmt.setString(3, user.getUser_lastname());
            prepStmt.setString(4, user.getUser_email());
            prepStmt.setString(5, user.getUser_pass());
            //resultSet = prepStmt.executeQuery();
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
    
    public User read(String email) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        User resultUser = null;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(READ);
            prepStmt.setString(1, email);
            resultSet = prepStmt.executeQuery();
            if(resultSet.next()) {
                resultUser = new User();
                resultUser.setUser_name(resultSet.getString("user_name"));
                resultUser.setUser_email(resultSet.getString("user_email"));
                resultUser.setUser_lastname(resultSet.getString("user_lastname"));
                resultUser.setUser_pass(resultSet.getString("user_pass"));
                resultUser.setUser_role_id(resultSet.getInt("user_role_id"));
                //System.out.println("user name: " + resultUser.getUser_name());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseResources(prepStmt, resultSet, conn);
        }
        return resultUser;
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
