package com.seat.code.challenge.bean;

import com.seat.code.challenge.enumerations.Orientation;

public class RoverFactory {
	
	public static Rover getRover(int x, int y, Orientation orientation, boolean hasMalfunctionalMC) {
		Rover rover = null;
		
		if(hasMalfunctionalMC) {
			rover = new Rover(x, y, orientation, new FaultyMovementController());
			
		} else {
			rover = new Rover(x, y, orientation, new CorrectMovementController());
		}
		
		return rover;
	}
}
