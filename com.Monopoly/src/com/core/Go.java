package com.core;

public class Go extends Location{
	public Go(){
		super("Go");
	}
	
	public void giveMoney(Player player){
		player.setMoney( player.getMoney() + 200);
	}
}
