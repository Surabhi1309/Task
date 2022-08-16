package com.cts.bean;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<Show> list = new ArrayList<Show>(); 
		ShowManagerImpl smi = new ShowManagerImpl();
		list = smi.populate("show.txt");
		ShowDisplay showDisplay = new ShowDisplayImpl();
		showDisplay.displayAllShows(list);
		//smi.bookShow(list, "Anaconda", "15:00", 3);
		System.out.println("\nBooking for movie Avengers with the details--> (\"Avengers\", \"18:30\", 10)");
		smi.bookShow(list, "Avengers", "18:30", 10);
		
		System.out.println("\nBooking for movie Jadugar with the details--> (\"Jadugar\", \"13:00\", 3)");
		smi.bookShow(list, "Jadugar", "13:00", 3);
		System.out.println();
		
		
		showDisplay.displayAllShows(list);

	}

}
