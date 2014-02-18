package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC3 implements Card{
  private String description; 
  
  public CC3(){
    description = "Doctor's fees – Pay $50";
  }
   
 public String getDescription(){
  return description;
 }
 
  public void Act(Player player, Board board){
    player.setMoney(player.getMoney() - 50);
  }
}
 