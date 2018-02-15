package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SignupDao {

	
	public int  signup(String username,String email,String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			
			Connection connection=DriverManager.getConnection( "jdbc:mysql://localhost:3306/project","root","alok");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into signuptable values(?,?,?)");
			   preparedStatement.setString(1, username);
			   preparedStatement.setString(2,email);
			   preparedStatement.setString(3, password);
			   
			    int i= preparedStatement.executeUpdate();
			    if(i>0)
			     {
			    	System.out.print("You are successfully registered...");	
			    	
			     }
		} catch (Exception e) {
			System.out.println(e);
		}
		
	return 1;
}
	}