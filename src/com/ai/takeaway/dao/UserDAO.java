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
    private final static String READ = "SELECT * FROM user_ WHERE user_name = ?;";
    
    private final static String UPDATE = "UPDATE user_ SET pass=?, WHERE user_id = ?;";
    private final static String DELETE = "DELETE FROM user WHERE user_id=?;";
    
    
    public User read(String name) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet resultSet = null;
        User resultUser = null;
        try {
            conn = ConnectionProvider.getConnection();
            prepStmt = conn.prepareStatement(READ);
            prepStmt.setString(1, name);
            resultSet = prepStmt.executeQuery();
            if(resultSet.next()) {
                resultUser = new User();
                resultUser.setUser_name(resultSet.getString("user_name"));
                resultUser.setUser_email(resultSet.getString("user_email"));
                resultUser.setUser_lastname(resultSet.getString("user_lastname"));
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
