package com.seat.code.challenge.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seat.code.challenge.enumerations.Orientation;
import com.seat.code.challenge.enumerations.Turn;

public class DefaultNavigationController extends NavigationController {
	
	private static final Logger log = LoggerFactory.getLogger(DefaultNavigationController.class);

	protected void initChangeMatrix() {
		super.changeMatrix.put(Orientation.N + ":" + Turn.R, Orientation.E);
		super.changeMatrix.put(Orientation.N + ":" + Turn.L, Orientation.W);
		super.changeMatrix.put(Orientation.W + ":" + Turn.R, Orientation.N);
		super.changeMatrix.put(Orientation.W + ":" + Turn.L, Orientation.S);
		super.changeMatrix.put(Orientation.S + ":" + Turn.R, Orientation.W);
		super.changeMatrix.put(Orientation.S + ":" + Turn.L, Orientation.E);
		super.changeMatrix.put(Orientation.E + ":" + Turn.R, Orientation.S);
		super.changeMatrix.put(Orientation.E + ":" + Turn.L, Orientation.N);
	}

	protected Position goForward(Position initialPosition) {
		Position finalPosition = initialPosition;
		
		if(initialPosition != null) {
			switch(finalPosition.getOrientation()) {
				case N:
					finalPosition.setY(finalPosition.getY()+1);
					break;

				case S:
					finalPosition.setY(finalPosition.getY()-1);
					break;

				case W:
					finalPosition.setX(finalPosition.getX()+1);
					break;
				
				case E:
					finalPosition.setX(finalPosition.getX()-1);
					break;
				
				default:
					log.error("ERROR: [" + finalPosition.getOrientation() + "]: Not recognized orientation. Ignoring it...");
			}
			
		}

		log.debug("finalPosition: " + finalPosition.toString());
		return finalPosition;
	}
}
