package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance11 implements Card{
	
	private String description;	
	public Chance11() {
		description = "Make general repairs on all your property- pay $150";
	}
		
	public String getDescription(){
		return description;
	}
		
		
	public void Act(Player player, Board board){
	    player.setMoney(player.getMoney() - 150);
	}
}