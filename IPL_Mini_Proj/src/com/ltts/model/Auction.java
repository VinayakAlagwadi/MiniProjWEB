package com.ltts.model;

public class Auction {
	
	private int auctionId;
	private int playerID;
	private int teamId;
	private String year;
	private double price;
	
	
	
	
	public Auction() {
		super();
	}
	public Auction(int auctionId, int playerID, int teamId, String year, double price) {
		super();
		this.auctionId = auctionId;
		this.playerID = playerID;
		this.teamId = teamId;
		this.year = year;
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
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Auction [auctionId=" + auctionId + ", playerID=" + playerID + ", teamId=" + teamId + ", year=" + year
				+ ", price=" + price + "]";
	}
	
	
	
	
	

}
