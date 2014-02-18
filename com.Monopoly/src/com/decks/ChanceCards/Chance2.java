package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance2 implements Card{
	
	private String description;	
	public Chance2() {
		description = "Advance To Illinois Ave";
	}
		
	public String getDescription(){
		return description;
	}
		
		
	public void Act(Player player, Board board){
		player.setLocation(24);
	}
}
