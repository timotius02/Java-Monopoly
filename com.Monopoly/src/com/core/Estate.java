package com.core;

public class Estate extends Property {

	// VARIABLES
	private String color;
	private boolean buildable;
	private boolean sellable;
	private int houses;
	private boolean hotel;
	private int housePrice;
	private int hotelPrice;
	private int rentHouse1;
	private int rentHouse2;
	private int rentHouse3;
	private int rentHouse4;
	private int rentHotel;

	// CONSTRUCTOR
	public Estate(String name, int propertyPrice, int mortgageValue, int rent,
			String color, int housePrice, int hotelPrice, int rentHouse1,
			int rentHouse2, int rentHouse3, int rentHouse4, int rentHotel) {
		super(name, propertyPrice, mortgageValue, rent);
		this.color = color;
		this.buildable = false;
		this.sellable = false;
		this.houses = 0;
		this.hotel = false;
		this.housePrice = housePrice;
		this.hotelPrice = hotelPrice;
		this.rentHouse1 = rentHouse1;
		this.rentHouse2 = rentHouse2;
		this.rentHouse3 = rentHouse3;
		this.rentHouse4 = rentHouse4;
		this.rentHotel = rentHotel;
	}

	// GETTERS
	public String getColor() {
		return this.color;
	}

	public boolean getBuildable() {
		return this.buildable;
	}

	public boolean getSellable() {
		return this.sellable;
	}

	public int getHouses() {
		return this.houses;
	}

	public boolean getHotel() {
		return this.hotel;
	}

	public int getHousePrice() {
		return this.housePrice;
	}

	public int getHotelPrice() {
		return this.hotelPrice;
	}

	public int getRentHouse1() {
		return this.rentHouse1;
	}

	public int getRentHouse2() {
		return this.rentHouse2;
	}

	public int getRentHouse3() {
		return this.rentHouse3;
	}

	public int getRentHouse4() {
		return this.rentHouse4;
	}

	public int getRentHotel() {
		return this.rentHotel;
	}

	// SETTERS
	public void setColor(String color) {
		this.color = color;
	}

	public void setBuildable(boolean buildable) {
		this.buildable = buildable;
	}

	public void setSellable(boolean sellable) {
		this.sellable = sellable;
	}

	public void setHouses(int houses) {
		this.houses = houses;
	}

	public void setHotel(boolean hotel) {
		this.hotel = hotel;
	}

	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}

	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	public void setRentHouse1(int rentHouse1) {
		this.rentHouse1 = rentHouse1;
	}

	public void setRentHouse2(int rentHouse2) {
		this.rentHouse2 = rentHouse2;
	}

	public void setRentHouse3(int rentHouse3) {
		this.rentHouse3 = rentHouse3;
	}

	public void setRentHouse4(int rentHouse4) {
		this.rentHouse4 = rentHouse4;
	}

	public void setRentHotel(int rentHotel) {
		this.rentHotel = rentHotel;
	}
}
