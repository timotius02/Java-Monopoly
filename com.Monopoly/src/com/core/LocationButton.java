package com.core;

import java.awt.Graphics;

import javax.swing.JButton;

public class LocationButton extends JButton {

	private static final long serialVersionUID = 1L;
	private Location location;
	private int rent, price;

	public LocationButton(String name, int LocationOnBoard, Board board) {
		super(name);

		location = board.getLocation(LocationOnBoard);
		// this.setOpaque(false);
		this.setContentAreaFilled(false);
		// this.setBorderPainted(false);

		this.setInts();
		this.setVisible(true);
		Handler hand = new Handler(price, rent, location, LocationOnBoard,
				board);
		this.addActionListener(hand);

	}

	public void setInts() {
		if (this.location instanceof Property) {
			this.rent = ((Property) location).getRent();
			this.price = ((Property) location).getPropertyPrice();
		}

	}

	public void paint(Graphics g) { // Do nothing here }

	}

}
