package com.ltts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltts.configuration.MyConnection;
import com.ltts.model.Team;


public class TeamDAO {
	
	public Team getTeamById(int id) throws Exception {
		Team t=new Team();
		List<Team> li = getAllTeams();
		for(Team p1:li) {
			if(p1.getTeamId() == id) {
				p1.setTeamId(id);
				p1.setOwnerName(p1.getOwnerName());
				p1.setCoach(p1.getCoach());
			}
		}
		
		return t;
	}
	
public boolean insertTeams(Team t) throws Exception {
	Connection mc=MyConnection.getConnection();
	
	Statement s = mc.createStatement();
	
	PreparedStatement ps=mc.prepareStatement("insert into team values (?,?,?,?,?);");
	
	//ResultSet rs = s.executeQuery("select * from Team");
	ps.setInt(1, t.getTeamId());
	ps.setString(2, t.getTeamName());
	ps.setString(3, t.getOwnerName());
	ps.setString(4, t.getCoach());
	ps.setInt(5, t.getCaptainId());
	

	return ps.execute();
	//ps.setInt(1,getPlayUerId());
	//ps.setString(2,getPlayerName());
	//ResultSet rs =s.executeQuery(null);
	//return s.execute(null);
	
}

public boolean updateTeams(Team t) throws Exception {
	Connection mc=MyConnection.getConnection();
	
	Statement s = mc.createStatement();
	
	PreparedStatement ps=mc.prepareStatement("update team set  ownerName = (?), coach = (?) where teamId = (?) && captainId = (?); ");
	
	//ResultSet rs = s.executeQuery("select * from Team");

	ps.setString(1,t.getOwnerName());
	ps.setString(2,t.getCoach());
	ps.setInt(3,t.getTeamId());
	ps.setInt(4, t.getCaptainId());
	return ps.execute();

}

public List<Team> getAllTeams() throws Exception{
	List<Team> li=new ArrayList<Team>();
	
	Connection mc=MyConnection.getConnection();
	Statement ps = mc.createStatement();
	

	ResultSet rs = ps.executeQuery("select * from team;");
	
	while(rs.next()){
		li.add(new Team(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
	}
	
	
	return li;
	
}
	
	


}