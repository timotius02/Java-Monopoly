package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC15 implements Card{
  private String description; 
  public CC15() {
    description = "You inherit $100!";
  }
  
  public String getDescription(){
    return description;
  }
  
  public void Act(Player player, Board board){
    player.setMoney(player.getMoney() + 100);
  }
}