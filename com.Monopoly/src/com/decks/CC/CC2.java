package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC2 implements Card{
  private String description; 
  
  public CC2(){
    description = "Bank Error in Your Favor - Collect $75";
  }
   
 public String getDescription(){
  return description;
 }
 
 public void Act(Player player, Board board){
  player.setMoney( player.getMoney() + 75);
 }
}
