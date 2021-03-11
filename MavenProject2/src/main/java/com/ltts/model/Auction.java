package com.ltts.model;

public class Auction {
	
	private int auctionId;
	private int playerID;
	private int teamId;
	private String ayear;
	private double price;
	
	
	
	
	public Auction() {
		super();
	}
	public Auction(int auctionId, int playerID, int teamId, String year, double price) {
		super();
		this.auctionId = auctionId;
		this.playerID = playerID;
		this.teamId = teamId;
		this.ayear = year;
		this.price = price;
	}
	public int getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getYear() {
		return ayear;
	}
	public void setYear(String year) {
		this.ayear = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Auction [auctionId=" + auctionId + ", playerID=" + playerID + ", teamId=" + teamId + ", year=" + ayear
				+ ", price=" + price + "]";
	}
	
	
	
	
	

}