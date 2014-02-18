package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance17 implements Card{
	
	private String description;	
	public Chance17() {
	    description = "You have won a crossword competition- collect $100";
	}
		
	public String getDescription(){
		return description;
	}
		
		
	public void Act(Player player, Board board){
	    player.setMoney(player.getMoney() + 100);
	}
}