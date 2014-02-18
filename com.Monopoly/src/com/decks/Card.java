package com.decks;

import com.core.Board;
import com.core.Player;

public interface Card {
	
	public String getDescription();
	public void Act(Player player, Board board);
	
}
