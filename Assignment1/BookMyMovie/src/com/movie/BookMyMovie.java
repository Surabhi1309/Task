package com.movie;

public class BookMyMovie {
	private int movieId;
	private int noOfTickets;
	private double discount;
	private double totalAmount;
	public BookMyMovie(int movieId, int noOfTickets) {
		super();
		this.movieId = movieId;
		this.noOfTickets = noOfTickets;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void calculateDiscount() {
		if((movieId==101||movieId==102||movieId==103)&&noOfTickets<5)
			discount=0;
		else if(movieId==101||movieId==103) {
			if(noOfTickets<10)
				discount = 15;
			else if(noOfTickets<=15)
				discount = 20;
		}
		else if(movieId==102) {
			if(noOfTickets<10) 
				discount=10;
			else if(noOfTickets<=15)
				discount=15;
		}
		else
			System.out.println("Sorry! Invalid Movie ID!\nPlease check the Movie id and enter once again.");
		
	}
	public double calculateTicketAmount() {
		calculateDiscount();
		//Set base for the respective movie ID
		double baseFare = (movieId==101)?120:(movieId==102)?170:(movieId==103)?150:0;
		totalAmount=baseFare*noOfTickets-(baseFare*noOfTickets*(discount/100));
		return totalAmount;
	}
	
}
