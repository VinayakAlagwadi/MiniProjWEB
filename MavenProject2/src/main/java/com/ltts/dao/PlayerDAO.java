package com.ltts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.configuration.MyConnection;
import com.ltts.model.Player;



public class PlayerDAO {
	
	public Player getPlayerById(int id) throws Exception {
		Player p=new Player();
		List<Player> li=getAllPlayers();
		for(Player p1:li) {
			if(p1.getPlayerId() == id) {
				p.setPlayerId(id);
				p.setNumberOfMatches(p1.getNumberOfMatches());
				p.setRuns(p1.getRuns());
				p.setWickets(p1.getWickets());
				
			}
		}
		
		return p;
	}
	
	public boolean insertPlayer(Player p) throws Exception 
	{
		//fill your code
		Connection mc=MyConnection.getConnection(); // TRanfers control to another 
		PreparedStatement ps=mc.prepareStatement("insert into player values(?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, p.getPlayerId());
		ps.setString(2, p.getName());
		ps.setString(3, p.getDateOfBirth());
		ps.setString(4, p.getSkill());
		ps.setInt(5, p.getNumberOfMatches());
		ps.setInt(6, p.getRuns());
		ps.setInt(7, p.getWickets());
		ps.setString(8, p.getNationality());
		ps.setDouble(9, p.getPowerRating());
		ps.setInt(10,p.getTeamId());
		

		return ps.execute();
		//return false;

		
	}
	
	public boolean updatePlayerRunsandWik(Player p) throws Exception {
		Connection mc=MyConnection.getConnection();
		
		Statement s = mc.createStatement();
		
		PreparedStatement ps=mc.prepareStatement("update player set  noOfmatches = (?), runs = (?), wickets = (?)  where playerId = (?); ");
		
		//ResultSet rs = s.executeQuery("select * from Team");
	
		ps.setInt(1,p.getNumberOfMatches());
		ps.setInt(2,p.getRuns());
		ps.setInt(3,p.getWickets());
		ps.setInt(4, p.getPlayerId());
		return ps.execute();
	
}
	
	public List<Player> getAllPlayers() throws Exception{
		List<Player> li=new ArrayList<Player>();
		
		Connection mc=MyConnection.getConnection();
		Statement ps = mc.createStatement();
		

		ResultSet rs = ps.executeQuery("select * from player;");
		
		while(rs.next()){
			li.add(new Player(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getDouble(9),rs.getInt(10)));
		}
		
		
		return li;
		
	}
		
		
	
	
	

}
