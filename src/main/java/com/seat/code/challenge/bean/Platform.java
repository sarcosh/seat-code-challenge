package com.seat.code.challenge.bean;

public class Platform {
	
	private static Platform instance = null;
	
	private int maxY = 0;
	private int maxX = 0;
		
	private Platform() { }
	
	public static Platform getInstance() {
		if(instance == null) instance = new Platform();
		
		return instance;
	}
	
	public void setSize(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	public boolean isAllowedMovement(Position destPosition) {
		boolean movementAllowed = true;
		
		if(destPosition.getX() > maxX || destPosition.getY() > maxY || destPosition.getX() < 0 || destPosition.getY() < 0) {
			movementAllowed = false;
		}
		
		return movementAllowed;
	}

}
