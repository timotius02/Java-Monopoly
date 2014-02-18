package com.decks.ChanceCards;

import javax.swing.JOptionPane;

import com.core.*;
import com.core.Board;
import com.core.Player;
import com.decks.Card;

public class Chance3 implements Card {
	private String description;

	public Chance3() {
		description = "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.";
	}

	public String getDescription() {
		return description;
	}

	public void Act(Player player, Board board) {
		while (!(player.getLocation(board) instanceof Utility)) {
			player.move();
			if (player.getIntLocation() == 0) {
				JOptionPane.showMessageDialog(null,
						"You passed GO! You Received $200", "Monopoly",
						JOptionPane.PLAIN_MESSAGE);
				player.setMoney(player.getMoney() + 200);
			}
		}
	}
}