package com.ltts.model;

public class Team {
	
	private int teamId;
	private String teamName;
	private String ownerName;
	private String coach;
	private int captainId;
	
	
	
	
	
	

	
	public Team() {
		super();
	}
	public Team(int teamId, String teamName, String ownerName, String coach, int captainId) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.ownerName = ownerName;
		this.coach = coach;
		this.captainId = captainId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public int getCaptainId() {
		return captainId;
	}

	public void setCaptainId(int captainId) {
		this.captainId = captainId;
	}
	
	
	
	

}
