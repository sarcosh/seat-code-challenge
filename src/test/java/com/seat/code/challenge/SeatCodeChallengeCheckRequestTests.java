package com.seat.code.challenge;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.seat.code.challenge.bean.ExecuteRequest;
import com.seat.code.challenge.exceptions.CommandVerificationException;

public class SeatCodeChallengeCheckRequestTests {
	
	ArrayList<String> commands = new ArrayList<>();

	ExecuteRequest request = null;

	@Before
	public void init() {
		commands.add("5 5");
		commands.add("1 2 N");
		commands.add("L M L M L M L M M");
		commands.add("3 3 N");
		commands.add("M M R M M R M R R M");
		
		request = new ExecuteRequest();
	}

	@Test
	public void checkRequest_OK() {
		boolean isOK = false;
		
		try {
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			
		} catch(CommandVerificationException ex) { }
		
		assertTrue(isOK);
	}
	
	@Test
	public void checkRequest_fault_missing_commands() {
		boolean isOK = false;
		
		try {
			
			commands.remove(3);
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
	}
	
	@Test
	public void checkRequest_fault_0_not_informed() {
		boolean isOK = false;
		
		try {
			
			commands.set(0, "");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
	}
	
	@Test
	public void checkRequest_fault_0_characters_not_permitted() {
		boolean isOK = false;
		
		try {
			
			commands.set(0, "A B");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
	}

	@Test
	public void checkRequest_fault_1_not_informed() {
		boolean isOK = false;
		
		try {
			
			commands.set(1, "");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
	}
	
	@Test
	public void checkRequest_fault_1_characters_not_permitted() {
		boolean isOK = false;
		
		try {
			
			commands.set(1, "D 2 N");
			
			request.setCommands(commands);
			request.verifyCommands();

			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
		
		try {
			
			commands.set(1, "1 2 R");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
	}
	
	@Test
	public void checkRequest_fault_2_not_informed() {
		boolean isOK = false;
		
		try {
			
			commands.set(2, "");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
	}
	
	@Test
	public void checkRequest_fault_2_characters_not_permitted() {
		boolean isOK = false;
		
		try {
			
			commands.set(2, "1 M L M L M L R M");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
		
		try {
			
			commands.set(2, "L M L F L M L M M");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
		
		try {
			
			commands.set(2, "L-M L F L M L M M");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
	}
	
	@Test
	public void checkRequest_fault_3_not_informed() {
		boolean isOK = false;
		
		try {
			
			commands.set(3, "");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
	}
	
	@Test
	public void checkRequest_fault_3_characters_not_permitted() {
		boolean isOK = false;
		
		try {
			
			commands.set(3, "D 2 N");
			
			request.setCommands(commands);
			request.verifyCommands();

			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
		
		try {
			
			commands.set(3, "1 2 R");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
	}
	
	@Test
	public void checkRequest_fault_4_not_informed() {
		boolean isOK = false;
		
		try {
			
			commands.set(4, "");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
	}
	
	@Test
	public void checkRequest_fault_4_characters_not_permitted() {
		boolean isOK = false;
		
		try {
			
			commands.set(4, "1 M L M L M L R M");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
		
		try {
			
			commands.set(4, "L M L F L M L M M");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
		
		try {
			
			commands.set(4, "L-M L F L M L M M");
			
			request.setCommands(commands);
			request.verifyCommands();
			
			isOK = true;
			 
		} catch(CommandVerificationException ex) { }
		
		assertFalse(isOK);
	}


}
