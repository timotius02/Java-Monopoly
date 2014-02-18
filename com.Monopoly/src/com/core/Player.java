package com.core;

import java.util.ArrayList;

public class Player {

	private String name;
	private int money;
	private ArrayList<Location> deeds;
	private boolean inJail;
	private int doubles;

	private boolean cardHolder;
	private boolean lastRollWasDoubles;

	private int numRailroad;
	private int currLocation;
	private int jailTime;
	private Dice die;

	private Player[] otherPlayers;
	private Board board;

	// default constructors
	public Player(Board board) {

		this.money = 1500;
		this.inJail = false;
		this.doubles = 0;
		this.numRailroad = 0;
		this.currLocation = 0;
		this.deeds = new ArrayList<Location>();
		this.die = new Dice();
		this.cardHolder = false;
		this.lastRollWasDoubles = false;
		this.jailTime = 0;

		this.board = board;
		this.otherPlayers = null; // after creating the players we set this
									// equal to something

	}

	// overloaded constructors
	public Player(String name, Board board) {
		this.name = name;
		this.money = 1500;
		this.inJail = false;
		this.doubles = 0;
		this.numRailroad = 0;
		this.currLocation = 0;
		this.deeds = new ArrayList<Location>();
		this.die = new Dice();

		this.cardHolder = false;

		this.board = board;
		this.otherPlayers = null;
	}

	public String toString(){
		return this.name;
	}
	// get methods
	public boolean getOutJailFree() {
		return this.cardHolder;
	}

	public String getName() {
		if( this.name == null)
			return "No One";
		else
			return this.name;
	}

	public int getIntLocation() {
		return this.currLocation;
	}

	public Location getLocation(Board board) {
		return board.getLocation(this.getIntLocation());
	}

	public int getMoney() {
		return this.money;
	}

	public Location getDeed(int num) {
		return this.deeds.get(num);
	}

	public boolean getInJail() {
		return this.inJail;
	}

	public int getDoubles() {
		return this.doubles;
	}

	public int getNumPropOwned() {
		return deeds.size();
	}

	public int getNumRailroad() {
		return this.numRailroad;
	}

	public Board getBoard() {
		return this.board;
	}

	public Player[] getOtherPlayers() {
		return this.otherPlayers;
	}

	public int getJailTime() {
		return this.jailTime;
	}

	// set method
	public void setCardHolder(boolean ans) {
		this.cardHolder = ans;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setInJail(boolean temp) {
		this.inJail = temp;
	}

	public void setDoubles(int doubles) {
		this.doubles = doubles;
	}

	public void setNumRailRoad(int num) {
		this.numRailroad = num;
	}

	public void setLocation(int location) {
		this.currLocation = location;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setOtherPlayers(Player[] otherPlayers) {
		this.otherPlayers = otherPlayers;
	}

	public void setJailTime(int n) {
		this.jailTime = n;
	}
	public void setLastRoll(boolean ans){
		this.lastRollWasDoubles = ans;
	}

	// misc methods

	public void buyProperty(Property property, int price) {
		this.money -= property.getPropertyPrice();
		deeds.add(property);
		property.setPropertyOwner(this);
	}

	public void payRent(Property property) {
		this.money -= property.getRent();
	}

	public void Mortgage(Property property) {
		this.money += property.getMortgageValue();
		property.setMortgage(true);
	}

	public void move() {
		if (this.currLocation < 39)
			this.currLocation++;
		else
			this.currLocation = 0;
	}

	public int roll() {
		int r1 = die.roll();
		int r2 = die.roll();

		if (r1 == r2) {
			this.doubles++;
			lastRollWasDoubles = true;
		}
		return r1 + r2;
	}
	


	public boolean lastRollWasDoubles() {
		return lastRollWasDoubles;
	}

	public void resetPlayer() {
		doubles = 0;
		lastRollWasDoubles = false;
	}

}
