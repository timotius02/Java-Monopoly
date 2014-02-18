package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance16 implements Card{
	
	private String description;	
	public Chance16() {
		description = "Your building loan matures- collect $150";
	}
		
	public String getDescription(){
		return description;
	}
		
		
	public void Act(Player player, Board board){
	    player.setMoney(player.getMoney() + 150);
	}
}