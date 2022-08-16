package com.cts.exception;

public class UnknownShowException extends Exception {
	
	public UnknownShowException(String show) throws Exception {
		String msg = "No show found with the name"+show;
		throw new Exception(msg);
	}

}
