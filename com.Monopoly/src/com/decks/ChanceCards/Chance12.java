package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance12 implements Card{
	
	private String description;	
	public Chance12() {
		description = "Pay poor tax of $15";
	}
		
	public String getDescription(){
		return description;
	}
		
		
	public void Act(Player player, Board board){
	    player.setMoney(player.getMoney() - 15);
	}
}