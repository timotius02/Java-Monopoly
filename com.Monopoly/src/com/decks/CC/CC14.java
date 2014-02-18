package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC14 implements Card{
  private String description; 
  public CC14() {
    description = "You have won second prize in a beauty contest– collect $10";
  }
  
  public String getDescription(){
    return description;
  }
  
  public void Act(Player player, Board board){
    player.setMoney(player.getMoney() + 10);
  }
}