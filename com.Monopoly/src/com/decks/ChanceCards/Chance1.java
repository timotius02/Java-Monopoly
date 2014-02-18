package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance1 implements Card{
	private String description;	
	public Chance1() {
		description = "Advance To GO (Collect $200)";
	}
	
	public String getDescription(){
		return description;
	}
	
	public void Act(Player player, Board board){
		player.setLocation(0);
		player.setMoney( player.getMoney() + 200);
	}
}
