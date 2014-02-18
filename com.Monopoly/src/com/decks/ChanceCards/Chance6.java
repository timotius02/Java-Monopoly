package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.core.Railroad;
import com.decks.Card;


public class Chance6 implements Card{
    private String description;
    public Chance6(){
	description = "Advance to St. Charles Place - if you pass Go, collect $200";
    }
    
    public String getDescription(){
	return description;
    }
    
    public void Act(Player player, Board board){
	if (player.getIntLocation() > 11)
	    player.setMoney(player.getMoney() + 200);
	player.setLocation(11);

    }
}
	      

	      