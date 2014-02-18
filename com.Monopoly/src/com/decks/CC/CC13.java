package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC13 implements Card{
  private String description; 
  public CC13() {
    description = "You are assessed for street repairs – $75 each property you own";
  }
  
  public String getDescription(){
    return description;
  }
  
  public void Act(Player player, Board board){
    player.setMoney(player.getMoney() - (player.getNumPropOwned()*75));
  }
}