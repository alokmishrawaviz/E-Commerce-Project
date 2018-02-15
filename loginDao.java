package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginDao {
	
	public	int  connectionCode(String username,String password){
		ResultSet rs=null;
		
		
		try{  
			   Class.forName("com.mysql.jdbc.Driver");  
			   
			   System.out.println("Connecting to a selected database...");
			   Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","alok");  
			     
			   System.out.println("Connected database successfully...");	
			   
			   PreparedStatement ps=con.prepareStatement("select * from signuptable where username=?  and password=?  ");  
			   ps.setString(1,username);  
			   ps.setString(2,password);
			   
			   rs=ps.executeQuery();
			   
			   if(rs.next())
			   {  System.out.println("Reg success full");
			   return 1;
			   }
			   else return 0;
			  }catch(Exception e){e.printStackTrace();
			  
				 System.out.println(e);  
				return 0; 
			  } 
	}



}
