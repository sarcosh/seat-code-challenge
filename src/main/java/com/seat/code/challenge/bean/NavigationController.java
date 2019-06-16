package com.seat.code.challenge.bean;

import java.util.HashMap;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seat.code.challenge.enumerations.Orientation;
import com.seat.code.challenge.enumerations.Turn;

public abstract class NavigationController {

	private static final Logger log = LoggerFactory.getLogger(NavigationController.class);

	protected HashMap<String, Orientation> changeMatrix = new HashMap<>();
	
	public NavigationController() {
		initChangeMatrix();
	}
	
	public Position executeEncodedMovement(Position initialPosition, String encodedMovement) {
		Position finalPosition = new Position();
		
		StringTokenizer st = new StringTokenizer(encodedMovement," ");
		
		Turn step = null;
		while(st.hasMoreTokens()) {
			step = Turn.valueOf(st.nextToken());
			
			log.debug(">> step: " + step);
			
			switch(step) {
				case R:
					finalPosition = changePositionOrientation(initialPosition, step);
					break;

				case L:
					finalPosition = changePositionOrientation(initialPosition, step);
					break;
					
				case M:
					finalPosition = goForward(initialPosition);
					
					if(!Platform.getInstance().isAllowedMovement(finalPosition)) {
						log.error("ERROR: [" + step + "]: Position NOT ALLOWED. Ignoring it...");
						finalPosition = initialPosition;
					}
					
					break;
					
				default:
					log.error("ERROR: [" + step + "]: Not recognized movement. Ignoring it...");
			}
		}
		
		return finalPosition;
	}
	
	private Position changePositionOrientation(Position initialPosition, Turn turnTo) {
		Position finalPosition = initialPosition;

		if(turnTo != null) {
			finalPosition.setOrientation(changeMatrix.get(initialPosition.getOrientation() + ":" + turnTo));
		}

		log.debug("finalPosition.getOrientation(): " + finalPosition.getOrientation());
		return finalPosition;
	}
		
	protected abstract Position goForward(Position initialPosition);
	
	protected abstract void initChangeMatrix();
	
}
