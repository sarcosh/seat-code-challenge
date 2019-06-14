package com.seat.code.challenge.bean;

import com.seat.code.challenge.bean.Position;
import com.seat.code.challenge.enumerations.Orientation;

public class Rover {
	
	private MovementController mc = null;
	private Position actualPosition = null;
	
	public Rover(int x, int y, Orientation orientation, MovementController mc) {
		actualPosition = new Position(x, y, orientation);
		this.mc = mc;
	}
	
	public Position executeEncodedMovement(String encodedMovement) {
		return mc.executeEncodedMovement(actualPosition, encodedMovement);
	}

	public Position getActualPosition() {
		return actualPosition;
	}

	public void setActualPosition(Position actualPosition) {
		this.actualPosition = actualPosition;
	}
}
