package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC5 implements Card{
  private String description;
  
  public CC5(){
    description = "Go directly to Jail - do not pass Go, do not collect $200";
  }
  public String getDescription(){
    return description;
  }
  
  public void Act(Player player, Board board){
    player.setLocation(10);
    player.setInJail(true);
  }
}