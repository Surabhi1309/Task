package com.movie;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookMyMovie booking1 = new BookMyMovie(101, 5);
		System.out.println("Total amount for booking: "+booking1.calculateTicketAmount());
		BookMyMovie booking2 = new BookMyMovie(102, 4);
		System.out.println("Total amount for booking: "+booking2.calculateTicketAmount());
		BookMyMovie booking3 = new BookMyMovie(103, 8);
		System.out.println("Total amount for booking: "+booking3.calculateTicketAmount());

	}

}
