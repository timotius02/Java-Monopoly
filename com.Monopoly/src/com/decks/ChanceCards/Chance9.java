package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance9 implements Card{
	
	private String description;	
	public Chance9() {
		description = "Go back 3 spaces";
	}
		
	public String getDescription(){
		return description;
	}
		
		
	public void Act(Player player, Board board){
		if (player.getIntLocation() < 3){
		    player.setLocation(40 - (3 - player.getIntLocation()));
		}
		else 
		    player.setLocation(player.getIntLocation() - 3);
	}
}