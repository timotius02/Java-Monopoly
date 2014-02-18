package com.core;

import java.awt.Image;

public class Sprite {
	
	private Image img; 
	private int x, y;
	public Sprite(Image img, int x, int y){
		this.img = img;
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Image getImage(){
		return this.img;
	}
	
	public void setX(int x2){
		this.x = x2;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setImage(Image newImage){
		this.img = newImage;
	}
}
