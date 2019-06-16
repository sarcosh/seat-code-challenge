package com.seat.code.challenge.bean;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seat.code.challenge.constants.ExecuteResponseCodes;
import com.seat.code.challenge.exceptions.CommandVerificationException;

public class ExecuteRequest {
	
	private static final Logger log = LoggerFactory.getLogger(ExecuteRequest.class);
	
	ArrayList<String> commands = new ArrayList<String>();

	public ArrayList<String> getCommands() {
		return commands;
	}

	public void setCommands(ArrayList<String> commands) {
		this.commands = commands;
	}
	
	public void verifyCommands() throws CommandVerificationException  {	
		
		String regex_0 = "\\d\\s+\\d";
		String regex_1 = "\\d\\s+\\d\\s+[NSEW]";
		String regex_2 = "[RLM]+";
		String regex_3 = "\\d\\s+\\d\\s+[NSEW]";
		String regex_4 = "[RLM]+";

		Pattern p = null;
		Matcher m = null;
		
		if(commands.size() != 5) {
			throw new CommandVerificationException(ExecuteResponseCodes.COMMANDS_VERIFICATION_ERROR, "Incorrect number of parameters (" + commands.size() + "/5). Please check commands");
		}
		
		for(int i=0; i<commands.size(); i++) {
			if("".equalsIgnoreCase(commands.get(i))) {
				throw new CommandVerificationException(ExecuteResponseCodes.COMMANDS_VERIFICATION_ERROR, "The command (" + i + ") is empty. Please check entered commands");
			}
		}
		
		p = Pattern.compile(regex_0);
		m = p.matcher(commands.get(0));

		if(m.find() && m.group().equals(commands.get(0))) {
			log.info("Formato de la cadena [0] es correcto...");
			
		} else {
			throw new CommandVerificationException(ExecuteResponseCodes.COMMANDS_VERIFICATION_ERROR, "Error in the command (0) format. It must be 'N_N'. Please check entered commands");
		}
		
		p = Pattern.compile(regex_1);
		m = p.matcher(commands.get(1));

		if(m.find() && m.group().equals(commands.get(1))) {
			log.info("Formato de la cadena [1] es correcto...");
			
		} else {
			throw new CommandVerificationException(ExecuteResponseCodes.COMMANDS_VERIFICATION_ERROR, "Error in the command (1) format. It must be 'N_N_S'. Please check entered commands");
		}
		
		p = Pattern.compile(regex_2);
		m = p.matcher(commands.get(2).replaceAll("\\s+", ""));
		
		if(m.find() && m.group().equals(commands.get(2).replaceAll("\\s+", ""))) {
			log.info("Formato de la cadena [2] es correcto...");
			
		} else {
			throw new CommandVerificationException(ExecuteResponseCodes.COMMANDS_VERIFICATION_ERROR, "Error in the command (2) format. It must be 'C_C_C...+'. Please check entered commands");
		}
		
		p = Pattern.compile(regex_3);
		m = p.matcher(commands.get(3));

		if(m.find() && m.group().equals(commands.get(3))) {
			log.info("Formato de la cadena [3] es correcto...");
			
		} else {
			throw new CommandVerificationException(ExecuteResponseCodes.COMMANDS_VERIFICATION_ERROR, "Error in the command (3) format. It must be 'N_N_S'. Please check entered commands");
		}
		
		p = Pattern.compile(regex_4);
		m = p.matcher(commands.get(4).replaceAll("\\s+", ""));
		
		if(m.find() && m.group().equals(commands.get(4).replaceAll("\\s+", ""))) {
			log.info("Formato de la cadena [4] es correcto...");
			
		} else {
			throw new CommandVerificationException(ExecuteResponseCodes.COMMANDS_VERIFICATION_ERROR, "Error in the command (4) format. It must be 'C_C_C...+'. Please check entered commands");
		}
	}
}
