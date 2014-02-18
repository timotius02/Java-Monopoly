package com.core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.Point;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image img = new ImageIcon(this.getClass().getResource(
			"monopoly.jpg")).getImage();
	private Board board;
	private Point[] points = new Point[40];// location of topleft corner of
											// buttons

	private ArrayList<Sprite> sprites;

	public ImagePanel(Board board) {
		this.board = board;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);

		setUpButtons();

		sprites = new ArrayList<Sprite>();
		for (int i = 1; i <= 4; i++) {
			String path = "piece" + i + ".jpg";
			Image img = new ImageIcon(this.getClass().getResource(path))
					.getImage();
			sprites.add(new Sprite(img, 602, 602));
		}
	}

	public void setUpButtons() {
		LocationButton b1 = new LocationButton("FreeParking", 20, board);
		this.add(b1);
		b1.setBounds(10, 10, 88, 88);// xStart, Ystart, width, height
		points[20] = new Point(10, 10);

		LocationButton b2 = new LocationButton("KentuckyAve", 21, board);
		this.add(b2);
		b2.setBounds(98, 10, 56, 88);// xStart, Ystart, width, height
		points[21] = new Point(98, 10);

		LocationButton b3 = new LocationButton("Chance", 22, board);
		this.add(b3);
		b3.setBounds(154, 10, 56, 88);// xStart, Ystart, width, height
		points[22] = new Point(154, 10);

		LocationButton b4 = new LocationButton("IndianaAve", 23, board);
		this.add(b4);
		b4.setBounds(210, 10, 56, 88);// xStart, Ystart, width, height
		points[23] = new Point(210, 10);

		LocationButton b5 = new LocationButton("IllinoisAve", 24, board);
		this.add(b5);
		b5.setBounds(266, 10, 56, 88);// xStart, Ystart, width, height
		points[24] = new Point(266, 10);

		LocationButton b6 = new LocationButton("B&oRail", 25, board);
		this.add(b6);
		b6.setBounds(322, 10, 56, 88);// xStart, Ystart, width, height
		points[25] = new Point(322, 10);

		LocationButton b7 = new LocationButton("AtlanticAve", 26, board);
		this.add(b7);
		b7.setBounds(378, 10, 56, 88);// xStart, Ystart, width, height
		points[26] = new Point(378, 10);

		LocationButton b8 = new LocationButton("VentnorAve", 27, board);
		this.add(b8);
		b8.setBounds(434, 10, 56, 88);// xStart, Ystart, width, height
		points[27] = new Point(434, 10);

		LocationButton b9 = new LocationButton("WaterWorks", 28, board);
		this.add(b9);
		b9.setBounds(490, 10, 56, 88);// xStart, Ystart, width, height
		points[28] = new Point(490, 10);

		LocationButton b40 = new LocationButton("MarvinGardens", 29, board);
		this.add(b40);
		b40.setBounds(546, 10, 56, 88);// xStart, Ystart, width, height
		points[29] = new Point(546, 10);

		LocationButton b10 = new LocationButton("GoToJail", 30, board);
		this.add(b10);
		b10.setBounds(602, 10, 88, 88);// xStart, Ystart, width, height
		points[30] = new Point(602, 10);

		LocationButton b11 = new LocationButton("PacificAve", 31, board);
		this.add(b11);
		b11.setBounds(602, 98, 88, 56);// xStart, Ystart, width, height
		points[31] = new Point(602, 98);

		LocationButton b12 = new LocationButton("NorthCarolinaAve", 32, board);
		this.add(b12);
		b12.setBounds(602, 154, 88, 56);// xStart, Ystart, width, height
		points[32] = new Point(602, 154);

		LocationButton b13 = new LocationButton("CChest", 33, board);
		this.add(b13);
		b13.setBounds(602, 210, 88, 56);// xStart, Ystart, width, height
		points[33] = new Point(602, 210);

		LocationButton b14 = new LocationButton("PennsylvaniaAve", 34, board);
		this.add(b14);
		b14.setBounds(602, 266, 88, 56);// xStart, Ystart, width, height
		points[34] = new Point(602, 266);

		LocationButton b15 = new LocationButton("ShortLine", 35, board);
		this.add(b15);
		b15.setBounds(602, 322, 88, 56);// xStart, Ystart, width, height
		points[35] = new Point(602, 322);

		LocationButton b16 = new LocationButton("Chance", 36, board);
		this.add(b16);
		b16.setBounds(602, 378, 88, 56);// xStart, Ystart, width, height
		points[36] = new Point(602, 378);

		LocationButton b17 = new LocationButton("ParkPlace", 37, board);
		this.add(b17);
		b17.setBounds(602, 434, 88, 56);// xStart, Ystart, width, height
		points[37] = new Point(602, 434);

		LocationButton b18 = new LocationButton("LuxuryTax", 38, board);
		this.add(b18);
		b18.setBounds(602, 490, 88, 56);// xStart, Ystart, width, height
		points[38] = new Point(602, 490);

		LocationButton b19 = new LocationButton("Boardwalk", 39, board);
		this.add(b19);
		b19.setBounds(602, 546, 88, 56);// xStart, Ystart, width, height
		points[39] = new Point(602, 546);

		LocationButton b20 = new LocationButton("Go", 0, board);
		this.add(b20);
		b20.setBounds(602, 602, 88, 88);// xStart, Ystart, width, height
		points[0] = new Point(602, 602);

		LocationButton b21 = new LocationButton("MediterraneanAve", 1, board);
		this.add(b21);
		b21.setBounds(546, 602, 56, 88);// xStart, Ystart, width, height
		points[1] = new Point(546, 602);

		LocationButton b22 = new LocationButton("CChest", 2, board);
		this.add(b22);
		b22.setBounds(490, 602, 56, 88);// xStart, Ystart, width, height
		points[2] = new Point(490, 602);

		LocationButton b23 = new LocationButton("BalticAve", 3, board);
		this.add(b23);
		b23.setBounds(434, 602, 56, 88);// xStart, Ystart, width, height
		points[3] = new Point(434, 602);

		LocationButton b24 = new LocationButton("IncomeTax", 4, board);
		this.add(b24);
		b24.setBounds(378, 602, 56, 88);// xStart, Ystart, width, height
		points[4] = new Point(378, 602);

		LocationButton b25 = new LocationButton("ReadingRailRoad", 5, board);
		this.add(b25);
		b25.setBounds(322, 602, 56, 88);// xStart, Ystart, width, height
		points[5] = new Point(322, 602);

		LocationButton b26 = new LocationButton("OrientalAve", 6, board);
		this.add(b26);
		b26.setBounds(266, 602, 56, 88);// xStart, Ystart, width, height
		points[6] = new Point(266, 602);

		LocationButton b27 = new LocationButton("Chance", 7, board);
		this.add(b27);
		b27.setBounds(210, 602, 56, 88);// xStart, Ystart, width, height
		points[7] = new Point(210, 602);

		LocationButton b28 = new LocationButton("VermontAve", 8, board);
		this.add(b28);
		b28.setBounds(154, 602, 56, 88);// xStart, Ystart, width, height
		points[8] = new Point(154, 602);

		LocationButton b29 = new LocationButton("ConneticutAve", 9, board);
		this.add(b29);
		b29.setBounds(98, 602, 56, 88);// xStart, Ystart, width, height
		points[9] = new Point(98, 602);

		LocationButton b30 = new LocationButton("Jail", 10, board);
		this.add(b30);
		b30.setBounds(10, 602, 88, 88);// xStart, Ystart, width, height
		points[10] = new Point(10, 602);

		LocationButton b31 = new LocationButton("StCharlesPlace", 11, board);
		this.add(b31);
		b31.setBounds(10, 546, 88, 56);// xStart, Ystart, width, height
		points[11] = new Point(10, 546);

		LocationButton b32 = new LocationButton("ElectricCompany", 12, board);
		this.add(b32);
		b32.setBounds(10, 490, 88, 56);// xStart, Ystart, width, height
		points[12] = new Point(10, 490);

		LocationButton b33 = new LocationButton("StatesAve", 13, board);
		this.add(b33);
		b33.setBounds(10, 434, 88, 56);// xStart, Ystart, width, height
		points[13] = new Point(10, 434);

		LocationButton b34 = new LocationButton("Virginia Ave", 14, board);
		this.add(b34);
		b34.setBounds(10, 378, 88, 56);// xStart, Ystart, width, height
		points[14] = new Point(10, 378);

		LocationButton b35 = new LocationButton("PenssylnvaniaRailRoad", 15,
				board);
		this.add(b35);
		b35.setBounds(10, 322, 88, 56);// xStart, Ystart, width, height
		points[15] = new Point(10, 322);

		LocationButton b36 = new LocationButton("StJamesPlace", 16, board);
		this.add(b36);
		b36.setBounds(10, 266, 88, 56);// xStart, Ystart, width, height
		points[16] = new Point(10, 266);

		LocationButton b37 = new LocationButton("CChest", 17, board);
		this.add(b37);
		b37.setBounds(10, 210, 88, 56);// xStart, Ystart, width, height
		points[17] = new Point(10, 210);

		LocationButton b38 = new LocationButton("TennesseeAve", 18, board);
		this.add(b38);
		b38.setBounds(10, 154, 88, 56);// xStart, Ystart, width, height
		points[18] = new Point(10, 154);

		LocationButton b39 = new LocationButton("NewYorkAve", 19, board);
		this.add(b39);
		b39.setBounds(10, 98, 88, 56);// xStart, Ystart, width, height
		points[19] = new Point(10, 98);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);

		for (int i = 0; i < sprites.size(); i++) {
			Sprite curr = sprites.get(i);
			g.drawImage(curr.getImage(), curr.getX(), curr.getY(), null);
		}

	}

	public void update(ArrayList<Integer> locP) {
		for (int i = 0; i < locP.size(); i++) {
			int x = (int) points[locP.get(i)].getX();
			int y = (int) points[locP.get(i)].getY();

			sprites.get(i).setX(x);
			sprites.get(i).setY(y);

		}

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Board b = new Board(); ImagePanel panel = new ImagePanel(b);
	 * 
	 * JFrame frame = new JFrame("Monopoly"); frame.getContentPane().add(panel);
	 * frame.pack(); frame.setVisible(true);
	 * 
	 * 
	 * 
	 * }
	 */
}
