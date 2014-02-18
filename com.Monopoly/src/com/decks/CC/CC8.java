package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC8 implements Card{
  private String description; 
  public CC8() {
    description = "Income Tax refund – collect $20";
  }
  
  public String getDescription(){
    return description;
  }
  
  public void Act(Player player, Board board){
       player.setMoney( player.getMoney() + 20);
  }
}