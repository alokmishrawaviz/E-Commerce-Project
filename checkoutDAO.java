package com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class checkoutDAO {

	
	public int  checkout(String displayName,String userName,String password,String conformPassword,String companyName,String email,String title,String firstName,String middleName,
			String lastName,String address1,String address2,String postalCode,String phone,String mobilePhone,String fax) {
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			
			Connection connection=DriverManager.getConnection( "jdbc:mysql://localhost:3306/project","root","alok");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into checkouttable values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			   preparedStatement.setString(1, displayName);
			   preparedStatement.setString(2,userName);
			   preparedStatement.setString(3, password);
			   preparedStatement.setString(4, conformPassword);
			   preparedStatement.setString(5, companyName);
			   preparedStatement.setString(6, email);
			   preparedStatement.setString(7, title);
			   preparedStatement.setString(8, firstName);
			   preparedStatement.setString(9, middleName);
			   preparedStatement.setString(10, lastName);
			   preparedStatement.setString(11, address1);
			   preparedStatement.setString(12, address2);
		
			   preparedStatement.setString(13, phone);
			   preparedStatement.setString(14, mobilePhone);
			   preparedStatement.setString(15, fax);
			   preparedStatement.setString(16,postalCode);
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