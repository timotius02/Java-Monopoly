package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC10 implements Card{
  private String description; 
  public CC10() {
    description = "Pay Hospital Fees of $100";
  }
  
  public String getDescription(){
    return description;
  }
  
  public void Act(Player player, Board board){
    player.setMoney(player.getMoney() - 100);
  }
}