package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC9 implements Card{
  private String description; 
  public CC9() {
    description = "Life Insurance Matures – collect $100";
  }
  
  public String getDescription(){
    return description;
  }
  
  public void Act(Player player, Board board){
    player.setMoney(player.getMoney() + 100);
  }
}