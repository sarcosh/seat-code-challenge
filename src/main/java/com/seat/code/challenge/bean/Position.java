package com.seat.code.challenge.bean;

import com.seat.code.challenge.enumerations.Orientation;

public class Position {
	
	private int x = 0;
	private int y = 0;
	private Orientation orientation = Orientation.N;
	
	public Position() { }
	
	public Position(int x, int y, Orientation orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	public String toString() {
		return "x: " + x + " - y: " + y + " - orientation: " + orientation;
	}
}
