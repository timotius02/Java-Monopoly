package com.core;

public class Dice {
	private int _sides;
	   // constructor
    public Dice(){
	_sides = 6;
    }

    // overloaded constructor
    public Dice(int numSides){
	_sides = numSides;
    }


    // mutator methods
    public int roll(){
	return  (int)( Math.random() *_sides) + 1;
    }
}
