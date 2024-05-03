package com.company.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.util.DBUtil;

public class UserDaoImp1 implements UserDao{

	@Override
	public boolean isValidUser(String username, String password) {
	  String query = "SELECT * FROM user WHERE username = ? AND pwd = ?";
	    	 try (Connection connection = DBUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	           // System.out.println("Query runned");
	            return resultSet.next();
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	          		return false;
	}
  
	
}
    @Override
    public boolean addUser(User register) {
        String query = "INSERT INTO user (username, email, pwd) VALUES (?, ?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, register.getUsername());
            preparedStatement.setString(2, register.getEmail());
            preparedStatement.setString(3, register.getPwd());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }    	
	}
	}