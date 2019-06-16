package com.seat.code.challenge.bean;

import io.swagger.annotations.ApiModelProperty;

public class ExecuteResponse {
	
    @ApiModelProperty(notes = "Execution result code", required =true)
    private int resultCode = 0;

    @ApiModelProperty(notes = "Execution result message", required =true)
    private String resultMessage = "OK";

    @ApiModelProperty(notes = "Execution result of Rover 1 movements" , readOnly =true)
    private String resultRover1 = "";
    
    @ApiModelProperty(notes = "Execution result of Rover 2 movements" , readOnly =true)
    private String resultRover2 = "";

    public ExecuteResponse(int resultCode, String errorMessage, String resultRover1, String resultRover2) {
    	this.resultCode = resultCode;
    	this.resultMessage = errorMessage;
    	this.resultRover1 = resultRover1;
    	this.resultRover2 = resultRover2;    	
    }
    
	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getResultRover1() {
		return resultRover1;
	}

	public void setResultRover1(String resultRover1) {
		this.resultRover1 = resultRover1;
	}

	public String getResultRover2() {
		return resultRover2;
	}

	public void setResultRover2(String resultRover2) {
		this.resultRover2 = resultRover2;
	}
}
