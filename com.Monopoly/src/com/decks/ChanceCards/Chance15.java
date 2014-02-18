package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance15 implements Card{
	
	private String description;	
	public Chance15() {
		description = "You have been elected chairman of the board- pay each player $50";
	}
		
	public String getDescription(){
		return description;
	}
		
		
	public void Act(Player player, Board board){
		player.setLocation(24);
	}
}