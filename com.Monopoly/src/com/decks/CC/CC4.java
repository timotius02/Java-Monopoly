package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC4 implements Card{
  private String description;
  public CC4(){
    description = "Get out of Jail free- this card may be kept until needed";
  }
  public String getDescription(){
    return description;
  }
  
  public void Act(Player player, Board board){
    player.setCardHolder(true);
  }
  
}