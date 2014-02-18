package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance8 implements Card{
    private String description;
    public Chance8(){
    	description = "Get out of Jail free- this card may be kept until needed";
    }
    public String getDescription(){
	return description;
    }

    public void Act(Player player, Board board){
	player.setCardHolder(true);
    }
    
}