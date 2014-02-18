package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC7 implements Card{
  private String description; 
  public CC7() {
    description = "Grand Opera Night – collect $50 from every player for opening night seats";
  }
  
  public String getDescription(){
    return description;
  }
  
  public void Act(Player player, Board board){
    //same issue with CC6 - how to get $ from everyone?
    //does not necessarily need to "take" $ from everyone
    //could just be a queue iteration that -50 money from everyone,
    //then add $(numPlayers*50) to THIS player.
    //so, two new instan vars?
	  
	  
  }
  
}