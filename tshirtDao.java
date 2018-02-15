package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.tshirtDTO;

public class tshirtDao {


public ArrayList<tshirtDTO> getTshirts() throws ClassNotFoundException, SQLException{
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<tshirtDTO> tshirtList = new ArrayList<>();
	String sql = "select id , name, img, type , price from pro";
	
	
	try
	{
		connection = getConnection();
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			
    	tshirtDTO tshirtDTO = new tshirtDTO();
		
    	
    	tshirtDTO.setId(rs.getInt("id"));
		tshirtDTO.setName(rs.getString("name"));
		tshirtDTO.setImg(rs.getString("img"));
		tshirtDTO.setType(rs.getString("type"));
		tshirtDTO.setPrice(rs.getInt("price"));
		
		tshirtList.add(tshirtDTO);
		
		}
	}
	 finally{
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(connection!=null){
			connection.close();
		}
	}
	return tshirtList;
}

private Connection getConnection() throws ClassNotFoundException, SQLException{
	Class.forName(ResourceBundleReader.getValue("drivername"));
	Connection connection =
			DriverManager.getConnection(
					ResourceBundleReader.getValue("url"),ResourceBundleReader.getValue("username"),ResourceBundleReader.getValue("password"));
	return connection;
}

}
