package com.core;

public class Board {
	private Location[] board = new Location[40];

	public Board() {
		board[0] = new Go();
		board[1] = new Estate("Mediterranean Avenue", 60, 30, 2, "purple", 50,
				50, 10, 30, 90, 160, 250);
		board[2] = new Location("Community Chest");
		board[3] = new Estate("Baltic Avenue", 60, 30, 4, "purple", 50, 50, 20,
				60, 180, 320, 450);
		board[4] = new Tax("Income Tax", 200);
		board[5] = new Railroad("Reading Railroad", 200, 100, 20); 
		
		board[6] = new Estate("Oriental Avenue", 100, 50, 6, "cyan", 50, 50,
				30, 90, 270, 400, 550);
		board[7] = new Location("Chance");
		board[8] = new Estate("Vermont Avenue", 100, 50, 6, "cyan", 50, 50, 30,
				90, 270, 400, 550);
		board[9] = new Estate("Conneticut Avenue", 120, 60, 8, "cyan", 50, 50,
				40, 100, 300, 450, 600);
		board[10] = new Location("Jail");

		board[11] = new Estate("St. Charles Place", 140, 70, 10, "magenta",
				100, 100, 50, 150, 450, 625, 750);
		board[12] = new Utility("Electric Company", 150, 75, 20);
		board[13] = new Estate("States Avenue", 140, 70, 10, "magenta", 100,
				100, 50, 150, 450, 625, 750);
		board[14] = new Estate("Virginia Avenue", 160, 80, 12, "magenta", 100,
				100, 60, 180, 500, 700, 900);
		board[15] = new Railroad("Pensylvannia Railroad", 200, 100, 20);
		board[16] = new Estate("St. James's Place", 180, 90, 14, "orange", 100,
				100, 70, 200, 550, 750, 950);
		board[17] = new Location("Community Chest");
		board[18] = new Estate("Tennessee Avenue", 180, 90, 14, "orange", 100,
				100, 70, 200, 550, 750, 950);
		board[19] = new Estate("New York Avenue", 200, 100, 16, "orange", 100,
				100, 80, 220, 600, 800, 1000);
		board[20] = new Location("Free Parking");

		board[21] = new Estate("Kentucky Avenue", 220, 110, 18, "red", 150,
				150, 90, 250, 700, 875, 1050);
		board[22] = new Location("Chance");
		board[23] = new Estate("Indiana Avenue", 220, 110, 18, "red", 150, 150,
				90, 250, 700, 875, 1050);
		board[24] = new Estate("Illinois Avenue", 240, 120, 20, "red", 150,
				150, 100, 300, 750, 925, 1100);
		board[25] = new Railroad("B & O Railroad", 200, 100, 20);
		board[26] = new Estate("Atlantic Avenue", 260, 130, 22, "yellow", 150,
				150, 110, 330, 800, 975, 1150);
		board[27] = new Estate("Ventnor Avenue", 260, 130, 22, "yellow", 150,
				150, 110, 330, 800, 975, 1150);
		board[28] = new Utility("Water Works", 150, 75, 20);
		board[29] = new Estate("Marvin Gardens", 280, 140, 24, "yellow", 150,
				150, 120, 360, 850, 1025, 1200);
		board[30] = new GoToJail();

		board[31] = new Estate("Pacific Avenue", 300, 150, 26, "green", 200,
				200, 130, 390, 900, 1100, 1275);
		board[32] = new Estate("North Carolina Avenue", 300, 150, 26, "green",
				200, 200, 130, 390, 900, 1100, 1275);
		board[33] = new Location("Community Chest");
		board[34] = new Estate("Pennsylvania Avenue", 320, 160, 28, "green",
				200, 200, 150, 450, 1000, 1200, 1400);
		board[35] = new Railroad("Short Line", 200, 100, 20);
		board[36] = new Location("Chance");
		board[37] = new Estate("Park Place", 350, 175, 35, "blue", 200, 200,
				175, 500, 110, 1300, 1500);
		board[38] = new Tax("Super Tax", 100);
		board[39] = new Estate("BoardWalk", 400, 200, 50, "blue", 200, 200,
				200, 600, 1400, 1700, 2000);

	}

	public Location getLocation(int num) {
		return board[num];
	}

	/*
	 * public static void main(String[] args){ Board b = new Board(); for(int i
	 * = 0 ; i< 40; i++){ Location l = b.getLocation(i); if(l instanceof
	 * Property){ System.out.println(((Property) l).getRent()); } } }
	 */
}
