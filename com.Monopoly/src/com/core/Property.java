package com.core;

public abstract class Property extends Location {

	// VARIABLES
	private boolean monopoly;// if you own all of the same colors
	private boolean mortgage;
	private Player propertyOwner;
	private int propertyPrice;
	private int mortgageValue;
	private int rent;

	// CONSTRUCTOR
	public Property(String Name, int propertyPrice, int mortgageValue, int rent) {
		// explicit call to superclass Location constructor
		super(Name);
		this.monopoly = false;
		this.mortgage = false;
		this.propertyOwner = null;
		this.propertyPrice = propertyPrice;
		this.mortgageValue = mortgageValue;
		this.rent = rent;
	}

	// GETTERS
	public boolean getMonopoly() {
		return this.monopoly;
	}

	public boolean getMortgage() {
		return this.mortgage;
	}

	public Player getPropertyOwner() {
		return this.propertyOwner;
	}

	public int getPropertyPrice() {
		return this.propertyPrice;
	}

	public int getMortgageValue() {
		return this.mortgageValue;
	}

	public int getRent() {
		return this.rent;
	}

	public String getOwnerName() {
		if (propertyOwner.equals(null))
			return "none";
		else {
			return propertyOwner.getName();
		}
	}

	// SETTERS
	public void setMonopoly(boolean monopoly) {
		this.monopoly = monopoly;
	}

	public void setMortgage(boolean mortgage) {
		this.mortgage = mortgage;
	}

	public void setPropertyOwner(Player propertyOwner) {
		this.propertyOwner = propertyOwner;
	}

	public void setPropertyPrice(int propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public void setMortgageValue(int mortgageValue) {
		this.mortgageValue = mortgageValue;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}
	
	//misc methods
	public void payRent(Player player){
		player.setMoney(player.getMoney() - rent);
		propertyOwner.setMoney(propertyOwner.getMoney() + rent);
	}
}
