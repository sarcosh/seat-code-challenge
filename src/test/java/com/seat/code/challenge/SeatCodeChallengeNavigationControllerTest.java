package com.seat.code.challenge;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.seat.code.challenge.bean.DefaultNavigationController;
import com.seat.code.challenge.bean.FaultyNavigationController;
import com.seat.code.challenge.bean.NavigationController;
import com.seat.code.challenge.bean.Platform;
import com.seat.code.challenge.bean.Position;
import com.seat.code.challenge.enumerations.Orientation;

public class SeatCodeChallengeNavigationControllerTest {
	
	NavigationController okController = null;
	NavigationController koController = null;
	
	@Before
	public void init() {
		okController = new DefaultNavigationController();
		koController = new FaultyNavigationController();
		
		Platform.getInstance().setSize(5, 5);
	}
	
	@Test
	public void check_default_controller() {
		boolean isOK = false;
		
		Position end = okController.executeEncodedMovement(new Position(1, 2, Orientation.N), "M L M L M L M R");
		
		if(end.getX() == 1 && end.getY() == 2 && end.getOrientation() == Orientation.S) {
			isOK = true;
		}
		
		assertTrue(isOK);
	}
	
	@Test
	public void check_faulty_controller_test_error_E_W() {
		boolean isOK = false;
		
		Position end = koController.executeEncodedMovement(new Position(3, 3, Orientation.E), "M L M L M L M R");
		
		if(end.getX() == 3 && end.getY() == 3 && end.getOrientation() == Orientation.W) {
			isOK = true;
		}
		
		assertTrue(isOK);
	}
	
	@Test
	public void check_faulty_controller_test_error_L_R() {
		boolean isOK = false;
		
		Position end = koController.executeEncodedMovement(new Position(3, 3, Orientation.E), "M L M");
		
		if(end.getX() == 4 && end.getY() == 4 && end.getOrientation() == Orientation.N) {
			isOK = true;
		}
		
		assertTrue(isOK);
	}

}
