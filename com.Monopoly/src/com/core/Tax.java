package com.core;

public class Tax extends Location{
	
	//Variable
	private int amount;
	
	//constructor 
	public Tax(String name, int amount){
		super(name);
		this.amount = amount;
	}
	
	//get Methods
	public int getAmount(){
		return this.amount;
	}
	
	//set methods
	public void setAmount(int amount){
		this.amount = amount;
	}
	
	//pay method
	public void payTax(Player player){
		player.setMoney(player.getMoney() - amount);
	}
	
}
