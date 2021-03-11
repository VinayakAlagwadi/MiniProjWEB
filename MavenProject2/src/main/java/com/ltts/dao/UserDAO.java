package com.ltts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ltts.configuration.MyConnection;
import com.ltts.model.User;


public class UserDAO {

	
	
	public boolean insertUser(User u) throws Exception {
		
		//Player pla = new Player();
		Connection mc=MyConnection.getConnection();
		Statement stmt = mc.createStatement();
		
		PreparedStatement ps=mc.prepareStatement("insert into user values(?,?);");
		  ps.setString(1,u.getUserName());
		  ps.setString(2,u.getPassword()); 
		  
		
		 
		  return ps.execute();	
		 
	
	
}

	
	
	public boolean checkUser(User v) throws Exception {
		
		//Player pla = new Player();
		Connection mc=MyConnection.getConnection();
		Statement stmt = mc.createStatement();
		
		PreparedStatement ps=mc.prepareStatement("select * from user where (username=? && password=?);");
		  
			ps.setString(1,v.getUserName());
		  
			ps.setString(2,v.getPassword()); 
		  
			ResultSet rs = ps.executeQuery();
			boolean status = rs.next();
			
		 
		  return status;	
		 
	
	
}
	
	
	
	
	
}


