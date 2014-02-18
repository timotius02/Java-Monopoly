package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance13 implements Card{
	
	private String description;	
	public Chance13() {
		description = "Take a trip to Reading Railroad- if you pass Go, collect $200";
	}
		
	public String getDescription(){
		return description;
	}
		
		
	public void Act(Player player, Board board){
	    if (player.getIntLocation() > 5)
		player.setMoney(player.getMoney() + 200);
	    player.setLocation(5);
	}
}