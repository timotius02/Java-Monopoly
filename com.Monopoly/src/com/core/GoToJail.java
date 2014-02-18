package com.core;

public class GoToJail extends Location{
	public GoToJail(){
		super("Go To Jail");
	}
	
	public void sendToJail(Player player){
		player.setLocation(10);
		player.setInJail(true);
	}
}
