package com.core;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import com.decks.*;
import com.imports.ALQueue;

public class Monopoly extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public Board board;
	private ALQueue<Player> players;
	private Chance chance;
	private CommunityChest cChest;
	public static final int WIDTH = 500, HEIGHT = WIDTH / 12 * 9;
	public static final String NAME = "Monopoly";

	private JFrame frame;
	private JPanel sidePanel;
	private JPanel overPanel;
	private Thread thread;
	private ImagePanel panel;
	private JButton newGame, buy, payRent, draw, nextTurn;
	private JTextArea scoreBoard;

	private Player currPlayer;
	private ArrayList<Integer> locP; // locations of players;
	private int turns;// turns left in the game
	private int numPlayers;

	public Monopoly(int numPlayers) {// for now we have 4 players
		board = new Board();
		players = new ALQueue<Player>();

		for (int i = 1; i <= numPlayers; i++) {
			players.enqueue(new Player("Player " + i, board));
		}

		for (int i = 0; i < players.getSize(); i++) { // creates the list of
														// otherplayers known to
														// each players
			Player temp = players.dequeue();

			Player[] otherPlayers = new Player[players.getSize()];

			for (int k = 0; k < players.getSize(); k++) {
				otherPlayers[k] = players.dequeue();
				players.enqueue(otherPlayers[k]);
			}

			temp.setOtherPlayers(otherPlayers);
			players.enqueue(temp);

		}

		chance = new Chance();
		cChest = new CommunityChest();
		chance.shuffle();
		cChest.shuffle();

		locP = new ArrayList<Integer>();
		for (int i = 0; i < players.getSize(); i++) {
			locP.add(0);
		}

		this.screenSetUp();
		this.turns = 15; // turns of play
		this.numPlayers = numPlayers;

	}

	public synchronized void start() {
		panel.update(locP);

		thread = new Thread(this);

		thread.start();
	}

	public synchronized void stop() {
		ArrayList<Player> temp = new ArrayList<Player>();
		temp.add(players.dequeue());
		int size = players.getSize();
		for (int i = 0; i < size; i++) { // figuring out who won
			Player temp2 = players.dequeue();
			if (temp2.getMoney() > temp.get(0).getMoney())
				temp.set(0, temp2);
			else if (temp2.getMoney() == temp.get(0).getMoney())
				temp.add(temp2);
		}
		if (temp.size() == 1)
			JOptionPane.showMessageDialog(null, "GAME OVER" + "\n"
					+ " The Winner is " + temp.get(0).getName(), "Monopoly",
					JOptionPane.PLAIN_MESSAGE);
		else {
			String winners = "";

			winners += temp.get(0).getName();
			for (int i = 1; i < temp.size(); i++)
				winners += " and " + temp.get(i).getName();
			System.out.println(winners);
			JOptionPane.showMessageDialog(null, "GAME OVER" + "\n"
					+ " There was a TIE" + "\n" + "The Winners are " + winners,
					"Monopoly", JOptionPane.PLAIN_MESSAGE);
		}

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		if (turns == 0) {// ends if there are no more moves left
			this.stop();
			return;
		}

		this.currPlayer = players.dequeue();

		JOptionPane.showMessageDialog(null, currPlayer.getName() + "'s Turn",
				"Monopoly", JOptionPane.PLAIN_MESSAGE);

		if (currPlayer.getInJail() == true && currPlayer.getJailTime() == 0) {
			JOptionPane.showMessageDialog(null,
					"You waited too Long. You were forced to pay $50",// <--
																		// explains
																		// this
																		// part
					"Monopoly", JOptionPane.PLAIN_MESSAGE);
			currPlayer.setMoney(currPlayer.getMoney() - 50);
			currPlayer.setJailTime(0);
			currPlayer.setInJail(false);
			makeMove(currPlayer.roll());
		}

		else if (currPlayer.getInJail() == true) { // WHat happens in jail

			String[] possibilities = { "Use a Get Out Of Jail Free Card",
					"Try Throw Doubles", "Pay $50", "Wait" };

			String s = (String) JOptionPane.showInputDialog(null,
					"You are In Jail. What Do You Want To Do?", "Monopoly",
					JOptionPane.PLAIN_MESSAGE, null, possibilities, null);

			if (s.equals("Use a Get Out Of Jail Free Card")) {
				if (currPlayer.getOutJailFree() == true) {
					currPlayer.setCardHolder(false);
					makeMove(currPlayer.roll());
				} else {
					JOptionPane.showMessageDialog(null,
							"Liar! You Don't Have a" + "\n"
									+ " Get Out of Jail Free Card", "Monopoly",
							JOptionPane.PLAIN_MESSAGE);
					currPlayer.setJailTime(currPlayer.getJailTime() - 1);
				}
			} else if (s.equals("Try Throw Doubles")) {
				int roll = currPlayer.roll();
				boolean ans = currPlayer.lastRollWasDoubles();
				if (ans == true) {
					JOptionPane.showMessageDialog(null,
							"Success! You threw Doubles" + "\n" + "Advance "
									+ roll + " spaces", "Monopoly",
							JOptionPane.PLAIN_MESSAGE);
					currPlayer.setDoubles(0);
					currPlayer.setLastRoll(false);
					makeMove(roll);
				} else
					JOptionPane.showMessageDialog(null,
							"Sorry! Try again Later", "Monopoly",
							JOptionPane.PLAIN_MESSAGE);
				currPlayer.setJailTime(currPlayer.getJailTime() - 1);
			}

			else if (s.equals("Pay $50")) {
				JOptionPane.showMessageDialog(null, "You paid $50", "Monopoly",
						JOptionPane.PLAIN_MESSAGE);
				currPlayer.setMoney(currPlayer.getMoney() - 50);
				currPlayer.setJailTime(0);
				currPlayer.setInJail(false);
				makeMove(currPlayer.roll());
			} else
				currPlayer.setJailTime(0);
		}

		else {
			int roll = currPlayer.roll();
			makeMove(roll);
		}

		updateScore();

	}

	public void makeMove(int num) {// move around the board
		int roll = num;

		String n = currPlayer.getName();
		n = n.substring(n.length() - 1);
		int playerNum = Integer.parseInt(n) - 1;

		if (currPlayer.getDoubles() >= 3) {
			JOptionPane.showMessageDialog(null,
					"Three Doubles, You land in JAIL!", "Monopoly",
					JOptionPane.PLAIN_MESSAGE);
			currPlayer.setInJail(true);
			currPlayer.setJailTime(3);
			currPlayer.setLocation(10);

			locP.set(playerNum, currPlayer.getIntLocation());
			update();
			return;

		}

		JOptionPane.showMessageDialog(null, "You rolled a " + roll, "Monopoly",
				JOptionPane.PLAIN_MESSAGE);

		for (int i = 0; i < roll; i++) {

			currPlayer.move();

			locP.set(playerNum, currPlayer.getIntLocation());
			update();

			if (currPlayer.getLocation(board).getName().equals("Go")) {
				JOptionPane.showMessageDialog(null,
						"You passed GO! You Received $200", "Monopoly",
						JOptionPane.PLAIN_MESSAGE);
				currPlayer.setMoney(currPlayer.getMoney() + 200);
			}

			try {
				thread.sleep(500); // pauses for dramatic effect
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (currPlayer.getIntLocation() == 30) {// each of these check for
												// different things
												// you might land on
			JOptionPane.showMessageDialog(null, "OH OH, You landed in JAIL!",
					"Monopoly", JOptionPane.PLAIN_MESSAGE);
			currPlayer.setInJail(true);
			currPlayer.setJailTime(3);
			currPlayer.setLocation(10);

			locP.set(playerNum, currPlayer.getIntLocation());
			update();
			return;

		} else if (currPlayer.getLocation(board).getName().equals("Chance")) {
			JOptionPane.showMessageDialog(null, "Draw a Chance Card",
					"Monopoly", JOptionPane.PLAIN_MESSAGE);
		} else if (currPlayer.getLocation(board).getName()
				.equals("Community Chest")) {
			JOptionPane.showMessageDialog(null, "Draw a Community Chest Card",
					"Monopoly", JOptionPane.PLAIN_MESSAGE);
		} else if (currPlayer.getLocation(board) instanceof Tax) {
			Tax tax = (Tax) currPlayer.getLocation(board);
			JOptionPane.showMessageDialog(null, "Pay " + tax.getAmount()
					+ " for Tax", "Monopoly", JOptionPane.PLAIN_MESSAGE);
			tax.payTax(currPlayer);
		} else if (currPlayer.getLocation(board) instanceof Property) {
			Property prop = (Property) currPlayer.getLocation(board);
			if (prop.getPropertyOwner() != null) {
				JOptionPane.showMessageDialog(null,
						"You landed in Somone's Property" + "\n" + "Pay "
								+ prop.getRent() + " For Rent", "Monopoly",
						JOptionPane.PLAIN_MESSAGE);
			}
		}
		if (currPlayer.getMoney() <= 0) {// checks if youve gone bankrupt
			JOptionPane.showMessageDialog(null,
					"You are out of Money. You Lose! ", "Monopoly",
					JOptionPane.PLAIN_MESSAGE);
			run();

		}

		if (currPlayer.lastRollWasDoubles()) {

			JOptionPane.showMessageDialog(null,
					"You roll Doubles, Roll Again!", "Monopoly",
					JOptionPane.PLAIN_MESSAGE);
			try {
				thread.sleep(20000); // waits for 20s to give player time to buy
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			makeMove(currPlayer.roll());
		}

	}

	public void update() {// updates graphics
		Graphics g = panel.getGraphics();
		panel.update(locP);
		panel.paintComponent(g);

	}

	public void updateScore() {// updates scoreboard
		String score = "Turns Left: " + turns + "\n";
		score += "\n";

		score += "ScoreBoard: " + "\n";

		score += currPlayer.getName() + "'s Money: " + currPlayer.getMoney()
				+ "\n";
		for (int i = 0; i < players.getSize(); i++) {// score part

			Player player = players.dequeue();
			score += player.getName() + "'s Money: " + player.getMoney() + "\n";
			players.enqueue(player);
		}
		score += "\n";
		score += "Location: " + "\n"; // location part
		score += currPlayer.getName() + "'s Space: "
				+ currPlayer.getIntLocation() + "\n";
		for (int i = 0; i < players.getSize(); i++) {
			Player player = players.dequeue();
			score += player.getName() + "'s Space: " + player.getIntLocation()
					+ "\n";
			players.enqueue(player);
		}

		scoreBoard.setText(score);

	}

	public void screenSetUp() {
		frame = new JFrame("Monopoly");
		frame.setLayout(new FlowLayout());
		panel = new ImagePanel(board);
		overPanel = new JPanel();
		overPanel.setLayout(new BorderLayout());

		sidePanel = new JPanel();
		sidePanel.setLayout(new GridLayout(5, 5));

		frame.add(panel);
		frame.add(overPanel);
		overPanel.add(sidePanel, BorderLayout.SOUTH);

		String score = "Turns Left: " + turns + "\n"; // setup scoreboard
		score += "\n";

		score += "ScoreBoard: " + "\n";
		;
		for (int i = 0; i < players.getSize(); i++) {// score part
			Player player = players.dequeue();
			score += player.getName() + "'s Money: " + player.getMoney() + "\n";
			players.enqueue(player);
		}
		score += "\n";
		score += "Location: " + "\n";// location part
		for (int i = 0; i < players.getSize(); i++) {
			Player player = players.dequeue();
			score += player.getName() + "'s Space: " + player.getIntLocation()
					+ "\n";
			players.enqueue(player);
		}

		scoreBoard = new JTextArea(score);
		scoreBoard.setForeground(Color.BLACK);
		scoreBoard.setEditable(false);

		overPanel.add(scoreBoard, BorderLayout.NORTH);

		newGame = new JButton("New Game");
		sidePanel.add(newGame);
		Action action = new Action();
		newGame.addActionListener(action);

		buy = new JButton("Buy");
		sidePanel.add(buy);
		BuyAction action2 = new BuyAction();
		buy.addActionListener(action2);

		payRent = new JButton("Pay Rent");
		sidePanel.add(payRent);
		RentAction action3 = new RentAction();
		payRent.addActionListener(action3);

		draw = new JButton("Draw");
		sidePanel.add(draw);
		DrawAction action4 = new DrawAction();
		draw.addActionListener(action4);

		nextTurn = new JButton("Next Turn");
		sidePanel.add(nextTurn);
		TurnAction action5 = new TurnAction();
		nextTurn.addActionListener(action5);

		frame.pack();

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void reset() {
		board = new Board();
		players = new ALQueue<Player>();

		for (int i = 1; i <= numPlayers; i++) {
			players.enqueue(new Player("Player " + i, board));
		}

		for (int i = 0; i < players.getSize(); i++) { // creates the list of
														// otherplayers known to
														// each players
			Player temp = players.dequeue();

			Player[] otherPlayers = new Player[players.getSize()];

			for (int k = 0; k < players.getSize(); k++) {
				otherPlayers[k] = players.dequeue();
				players.enqueue(otherPlayers[k]);
			}

			temp.setOtherPlayers(otherPlayers);
			players.enqueue(temp);

		}

		chance = new Chance();
		cChest = new CommunityChest();
		chance.shuffle();
		cChest.shuffle();

		locP = new ArrayList<Integer>();
		for (int i = 0; i < players.getSize(); i++) {
			locP.add(0);
		}

		frame.getContentPane().removeAll();
		frame.setLayout(new FlowLayout());
		panel = new ImagePanel(board);
		overPanel = new JPanel();
		overPanel.setLayout(new BorderLayout());

		sidePanel = new JPanel();
		sidePanel.setLayout(new GridLayout(5, 5));

		frame.add(panel);
		frame.add(overPanel);
		overPanel.add(sidePanel, BorderLayout.SOUTH);

		String score = "Turns Left: " + turns + "\n";
		score += "\n";

		score += "ScoreBoard: " + "\n";
		;
		for (int i = 0; i < players.getSize(); i++) {
			Player player = players.dequeue();
			score += player.getName() + "'s Money: " + player.getMoney() + "\n";
			players.enqueue(player);
		}
		score += "\n";
		score += "Location: " + "\n";
		for (int i = 0; i < players.getSize(); i++) {
			Player player = players.dequeue();
			score += player.getName() + "'s Space: " + player.getIntLocation()
					+ "\n";
			players.enqueue(player);
		}

		scoreBoard = new JTextArea(score);
		scoreBoard.setForeground(Color.BLACK);
		scoreBoard.setEditable(false);
		// scoreBoard.setEnabled(false);

		overPanel.add(scoreBoard, BorderLayout.NORTH);

		newGame = new JButton("New Game");
		sidePanel.add(newGame);
		Action action = new Action();
		newGame.addActionListener(action);

		buy = new JButton("Buy");
		sidePanel.add(buy);
		BuyAction action2 = new BuyAction();
		buy.addActionListener(action2);

		payRent = new JButton("Pay Rent");
		sidePanel.add(payRent);
		RentAction action3 = new RentAction();
		payRent.addActionListener(action3);

		draw = new JButton("Draw");
		sidePanel.add(draw);
		DrawAction action4 = new DrawAction();
		draw.addActionListener(action4);

		nextTurn = new JButton("Next Turn");
		sidePanel.add(nextTurn);
		TurnAction action5 = new TurnAction();
		nextTurn.addActionListener(action5);

		frame.pack();

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		turns = 15; // turns of play
	}

	private class Action implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			reset();
			start();
		}
	}

	private class BuyAction implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (currPlayer.getLocation(board) instanceof Property
					&& ((Property) currPlayer.getLocation(board))
							.getPropertyOwner() == null) {
				Property prop = (Property) currPlayer.getLocation(board);
				if (currPlayer.getMoney() > prop.getPropertyPrice()) {
					currPlayer.buyProperty(prop, prop.getPropertyPrice());
					JOptionPane.showMessageDialog(null,
							"Congrats! You just Bought " + prop.getName(),
							"Monopoly", JOptionPane.PLAIN_MESSAGE);
					updateScore();
				} else
					JOptionPane.showMessageDialog(null, "Insufficient Funds",
							"Monopoly", JOptionPane.PLAIN_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "You can't do that",
						"Monopoly", JOptionPane.PLAIN_MESSAGE);
		}

	}

	private class RentAction implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (currPlayer.getLocation(board) instanceof Property
					&& !((Property) currPlayer.getLocation(board))
							.getPropertyOwner().equals(currPlayer)) {
				currPlayer.payRent((Property) currPlayer.getLocation(board));
				JOptionPane.showMessageDialog(null, "You just paid rent to "
						+ ((Property) currPlayer.getLocation(board))
								.getPropertyOwner().getName(), "Monopoly",
						JOptionPane.PLAIN_MESSAGE);
				((Property) currPlayer.getLocation(board)).payRent(currPlayer);
				updateScore();
			} else
				JOptionPane.showMessageDialog(null, "You can't do that",
						"Monopoly", JOptionPane.PLAIN_MESSAGE);
		}

	}

	private class DrawAction implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			if (currPlayer.getLocation(board).getName().equals("Chance")) {

				chance.Draw(currPlayer, board);

			} else if (currPlayer.getLocation(board).getName()
					.equals("Community Chest")) {

				cChest.Draw(currPlayer, board);

			}

			else
				JOptionPane.showMessageDialog(null, "You can't do that",
						"Monopoly", JOptionPane.PLAIN_MESSAGE);

			updateScore();

			String n = currPlayer.getName();
			n = n.substring(n.length() - 1);
			int playerNum = Integer.parseInt(n) - 1;
			locP.set(playerNum, currPlayer.getIntLocation());
			update();

			if (currPlayer.getLocation(board) instanceof Property) {
				Property prop = (Property) currPlayer.getLocation(board);
				if (prop.getPropertyOwner() != null) {
					JOptionPane.showMessageDialog(null,
							"You landed in Somone's Property" + "\n" + "Pay "
									+ prop.getRent() + " For Rent", "Monopoly",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
			if (currPlayer.getMoney() <= 0) { // check if you've gone bankrupt
				JOptionPane.showMessageDialog(null,
						"You are out of Money. You Lose! ", "Monopoly",
						JOptionPane.PLAIN_MESSAGE);
				run();

			}

		}
	}

	private class TurnAction implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			updateScore();
			currPlayer.resetPlayer();
			players.enqueue(currPlayer);

			if (currPlayer.getName().equals("Player " + players.getSize()))
				turns--;
			
			run();

		}

	}

	public static void main(String[] args) {
		new Monopoly(4);

		// monopoly.start();
	}
}
