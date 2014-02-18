package com.decks;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.core.Board;
import com.core.Player;
import com.decks.CC.*;
import com.imports.ALQueue;

public class CommunityChest {
	private ALQueue<Card> deck;

	public CommunityChest() {
		deck = new ALQueue<Card>();

		deck.enqueue(new CC1());
		deck.enqueue(new CC2());
		deck.enqueue(new CC3());
		deck.enqueue(new CC4());
		deck.enqueue(new CC5());
		deck.enqueue(new CC6());
		deck.enqueue(new CC7());
		deck.enqueue(new CC8());
		deck.enqueue(new CC9());
		deck.enqueue(new CC10());
		deck.enqueue(new CC11());
		deck.enqueue(new CC12());
		deck.enqueue(new CC13());
		deck.enqueue(new CC14());
		deck.enqueue(new CC15());
		deck.enqueue(new CC16());
		deck.enqueue(new CC17());
	}

	public void Draw(Player player, Board board) {
		Card c = deck.dequeue();

		JOptionPane.showMessageDialog(null, c.getDescription(), "Monopoly",
				JOptionPane.PLAIN_MESSAGE);
		c.Act(player, board);

		deck.enqueue(c);
	}

	public void shuffle() {
		ArrayList<Card> shuffler = new ArrayList<Card>();
		while (deck.getSize() != 0) {
			shuffler.add(deck.dequeue());
		}

		while (shuffler.size() != 0) {
			int n = shuffler.size();
			int randIndex = (int) (n * Math.random());
			deck.enqueue(shuffler.remove(randIndex));
		}

	}
}
