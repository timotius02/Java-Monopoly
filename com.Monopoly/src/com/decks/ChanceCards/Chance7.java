package com.decks.ChanceCards;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class Chance7 implements Card{
    
    private String description;
    public Chance7(){
	description = "Bank pays you dividend of $50";
    }
    
    public String getDescription(){
	return description;
    }
    public void Act(Player player, Board board){
	player.setMoney(player.getMoney() + 50);
    }
}