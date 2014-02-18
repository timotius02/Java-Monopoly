package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance14 implements Card{
	
	private String description;	
	public Chance14() {
		description = "Take a walk on the Boardwalk - advance token to Boardwalk";
	}
		
	public String getDescription(){
		return description;
	}
		
		
	public void Act(Player player, Board board){
		player.setLocation(39);
	}
}