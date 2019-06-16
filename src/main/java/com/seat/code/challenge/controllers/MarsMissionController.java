package com.seat.code.challenge.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.seat.code.challenge.bean.ExecuteRequest;
import com.seat.code.challenge.bean.ExecuteResponse;
import com.seat.code.challenge.bean.NASAOrchestrator;
import com.seat.code.challenge.constants.ExecuteResponseCodes;
import com.seat.code.challenge.exceptions.CommandVerificationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping({ "/api/v1/mars" })
@Api(value = "Mars", description = "Rest API for Mars Mission Operations", tags = "Mars API")
public class MarsMissionController {

	private static final Logger log = LoggerFactory.getLogger(MarsMissionController.class);
	
	@RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Display greeting message to admin user", response = ExecuteResponse.class)
    public ExecuteResponse execute(@RequestBody ExecuteRequest execute) {
		ExecuteResponse msg = null; 
				
		try {

			execute.verifyCommands();
			
			NASAOrchestrator or = new NASAOrchestrator(execute.getCommands());
			List<String> results = or.executeCommands();
			
	    	msg = new ExecuteResponse(ExecuteResponseCodes.OK, "", results.get(0), results.get(1));
		
		} catch(CommandVerificationException ex) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getErrorMessage(), ex);
		}
		
        return msg;
    }

}
