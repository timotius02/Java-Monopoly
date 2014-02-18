package com.decks;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.core.Board;
import com.core.Player;
import com.decks.ChanceCards.*;
import com.imports.ALQueue;

public class Chance {
	private ALQueue<Card> deck;

	public Chance() {
		deck = new ALQueue<Card>();

		deck.enqueue(new Chance1());
		deck.enqueue(new Chance2());
		deck.enqueue(new Chance3());
		deck.enqueue(new Chance4());
		deck.enqueue(new Chance5());
		deck.enqueue(new Chance6());
		deck.enqueue(new Chance7());
		deck.enqueue(new Chance8());
		deck.enqueue(new Chance9());
		deck.enqueue(new Chance10());
		deck.enqueue(new Chance11());
		deck.enqueue(new Chance12());
		deck.enqueue(new Chance13());
		deck.enqueue(new Chance14());
		deck.enqueue(new Chance15());
		deck.enqueue(new Chance16());
		deck.enqueue(new Chance17());
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
