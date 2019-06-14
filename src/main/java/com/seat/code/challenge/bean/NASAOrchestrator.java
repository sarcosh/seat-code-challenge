package com.seat.code.challenge.bean;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seat.code.challenge.enumerations.Orientation;

public class NASAOrchestrator {
	
	private static final Logger log = LoggerFactory.getLogger(NASAOrchestrator.class);
	
	private ArrayList<String> commands = new ArrayList<String>();
	
	public NASAOrchestrator(ArrayList<String> commands) {
		this.commands = commands;
	}
	
	public ArrayList<String> executeCommands() {
		
		ArrayList<String> results = new ArrayList<>();
		
		initPlatformConfiguration(commands.get(0));
		
		Rover rover1 = initRover1(commands.get(1));

		if(rover1 != null)
			results.add(rover1.executeEncodedMovement(commands.get(2)).toString());
			log.info("RESULT ROVER 1:" + results.get(0));
			

		Rover rover2 = initRover2(commands.get(3));
		
		if(rover2 != null)
			results.add(rover2.executeEncodedMovement(commands.get(4)).toString());
			log.info("RESULT ROVER 2:" + results.get(0));
		
		return results;

	}
	
	
	private Rover initRover1(String command) {
		int x = 0;
		int y = 0;
		Orientation orientation = Orientation.N;
		
		StringTokenizer st = new StringTokenizer(command, " ");

		while(st.hasMoreTokens()) {
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			orientation = Orientation.valueOf(st.nextToken());
		}
		
		return RoverFactory.getRover(x, y, orientation, false);
	}

	private Rover initRover2(String command) {
		int x = 0;
		int y = 0;
		Orientation orientation = Orientation.N;
		
		StringTokenizer st = new StringTokenizer(command, " ");

		while(st.hasMoreTokens()) {
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			orientation = Orientation.valueOf(st.nextToken());
		}
		
		return RoverFactory.getRover(x, y, orientation, true);
	}

	
	private void initPlatformConfiguration(String command) {
		int pMaxX = 0;
		int pMaxY = 0;

		StringTokenizer st = new StringTokenizer(command, " ");

		while(st.hasMoreTokens()) {
			pMaxX = Integer.parseInt(st.nextToken());
			pMaxY = Integer.parseInt(st.nextToken());
		}
		
		if(pMaxX > 0 && pMaxY > 0) {
			Platform.getInstance().setSize(pMaxX, pMaxY);		
		
		} else {
			log.error("[ERROR]: Error al inicializar la Plataforma. Coordenadas iniciales incorrectas");
		}
	}
	

}
