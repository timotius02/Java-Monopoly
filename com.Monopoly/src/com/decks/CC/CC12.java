package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC12 implements Card{
  private String description; 
  public CC12() {
    description = "Receive $25 Consultancy Fee";
  }
  
  public String getDescription(){
    return description;
  }
  
  public void Act(Player player, Board board){
    player.setMoney(player.getMoney() + 25);
  }
}