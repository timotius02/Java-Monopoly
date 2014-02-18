package com.decks.ChanceCards;

	import com.core.Board;
import com.core.Player;
import com.core.Railroad;
import com.decks.Card;


	public class Chance5 implements Card{
		private String description;	
		public Chance5() {
			description = "Advance to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank. (There are two of these.)";
		}
		
		public String getDescription(){
			return description;
		}
		
		public void Act(Player player, Board board){
			while(player.getIntLocation() % 10 != 5)
				player.move();
			
			Railroad rail = (Railroad)player.getLocation(board);
			player.setMoney( player.getMoney() - 2 * rail.getRent());
		}
	

}
