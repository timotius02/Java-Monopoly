package com.decks.CC;

import com.core.Board;
import com.core.Player;
import com.decks.Card;


public class CC6 implements Card{
  private String description; 
  public CC6() {
    description = "It's your birthday! Collect $10 from each person.";
  }
  
  public String getDescription(){
    return description;
  }
  
    public void Act(Player player, Board board){
     //unsure of how to do. Queue iteration ... 
      //need a new instan var for queue of players? maybe. input? 
    	
    	Player[] others = player.getOtherPlayers();
    	for(int i = 0; i < others.length; i++){
    		Player temp = others[i];
    		temp.setMoney( temp.getMoney() - 10);
    		player.setMoney( player.getMoney() + 10);
    	}
    }
    
}