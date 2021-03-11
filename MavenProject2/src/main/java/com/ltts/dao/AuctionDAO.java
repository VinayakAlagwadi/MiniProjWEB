package com.ltts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.*;
import com.ltts.configuration.MyConnection;
import com.ltts.model.Auction;
import com.ltts.model.Player;
import com.ltts.model.Team;


public class AuctionDAO {
	public List<Auction> getAllTeams(){
		List<Auction> li=new ArrayList<Auction>();
		
		return li;

}
	
//public Auction getTeamById(int id) {
//	Auction t = new Auction(id, 0,0, 0, 0);
//	
//	return t;
//}

//public boolean createAuction() throws Exception {
//	Connection mc=MyConnection.getConnection();
//	
//	PreparedStatement ps=mc.prepareStatement("create table auction(auctionId int primary key, playerID int,teamId int,ayear date,price double,FOREIGN KEY (playerID) REFERENCES player(playerId),FOREIGN KEY(teamId) references team(teamId));");
//	
//	//ps.setInt(1,getPlayerId());
//	//ps.setString(2,getPlayerName());
//	return ps.execute();
//	
//}



public boolean insertAuction(Auction a,Player p,Team t) throws Exception {
	Connection mc=MyConnection.getConnection();
	
	Statement s = mc.createStatement();
	
	PreparedStatement ps=mc.prepareStatement("insert into auction values (?,?,?,?,?)");
	
	//ResultSet rs = s.executeQuery("select * from Team");
	
	System.out.println("Auction Id is inserted");
	 //ps.executeUpdate();
	
	ps.setInt(1,a.getAuctionId());
	ps.setInt(2,p.getPlayerId());
	ps.setInt(3,t.getTeamId());
	ps.setString(4,a.getYear());
	ps.setDouble(5,a.getPrice());
	
	
	//ResultSet rs =s.executeQuery(null);
	//return s.execute(null);
	return ps.execute();
	
}

public void updateTOwner(Team t) throws Exception {
	Connection mc=MyConnection.getConnection();
	
	Statement s = mc.createStatement();
	
	PreparedStatement ps=mc.prepareStatement("update team  set ownername = (?)  where teamId = (?); ");
	
	//ResultSet rs = s.executeQuery("select * from Team");
	ps.setString(1,t.getOwnerName());
	ps.setInt(2,t.getTeamId());
	
	boolean rs = ps.execute();
    
	if(rs)
	{}
	else{
		System.out.println("Team Owner successfully updated.");
	}

}

public void updateTCoach(Team t) throws Exception {
	Connection mc=MyConnection.getConnection();
	
	Statement s = mc.createStatement();
	
	PreparedStatement ps=mc.prepareStatement("update team set coachname = (?)  where teamid = (?); ");
	
	//ResultSet rs = s.executeQuery("select * from Team");
	ps.setString(1,t.getCoach());
	ps.setInt(2,t.getTeamId());
	boolean rs = ps.execute();
	
	boolean rs1 = ps.execute();
    
	if(rs1)
	{}
	else{
		System.out.println("Team Coach successfully updated.");
	}
}



public void displayTeams() throws Exception {
	Connection mc=MyConnection.getConnection();
	
	Statement s = mc.createStatement();
	
	PreparedStatement ps = mc.prepareStatement("select * from Team");
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()){
		System.out.println(rs.getString(1)+" " + rs.getString(2));
	}
	
	mc.close();
	
}









private int getPlayerId() {
	// TODO Auto-generated method stub
	return 0;
}
private String getPlayerName() {
	// TODO Auto-generated method stub
	return null;
}
public boolean updatePlayer(int id) {
	return true;
}

}