package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance10 implements Card{
	
	private String description;	
	public Chance10() {
	    description = "Go directly to Jail- do not pass Go, do not colect $200";
	}
		
	public String getDescription(){
		return description;
	}
		
		
	public void Act(Player player, Board board){
		player.setLocation(10);
		player.setInJail(true);
	}
}