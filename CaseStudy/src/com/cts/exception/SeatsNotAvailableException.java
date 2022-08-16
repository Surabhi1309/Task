package com.cts.exception;

public class SeatsNotAvailableException extends Exception {
	public SeatsNotAvailableException(int availableSeat) throws Exception {
		String msg = "Only "+availableSeat+" seats are available, so can't process the booking";
		throw new Exception(msg);
		
	}
}
