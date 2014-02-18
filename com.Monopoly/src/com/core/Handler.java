package com.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Handler implements ActionListener {
	public int rent, price, locationOnBoard;
	private Location location;

	public Handler(int price, int rent, Location location, int locationOnBoard,
			Board board) {
		this.price = price;
		this.rent = rent;
		this.location = location;
		this.locationOnBoard = locationOnBoard;

	}

	public void actionPerformed(ActionEvent event) {
		if (location instanceof Property) {
			Player player = ((Property) location).getPropertyOwner();
			
			JOptionPane.showMessageDialog(null, String.format(
					location.getName() + "\n" + "Price: " + this.price + "\n"
							+ "Rent: " + this.rent + "\n" + "Owner: " + player,
					"Monopoly", JOptionPane.PLAIN_MESSAGE));

		} else
			JOptionPane.showMessageDialog(null,
					String.format(location.getName()), "Monopoly",
					JOptionPane.PLAIN_MESSAGE);

	}

}
