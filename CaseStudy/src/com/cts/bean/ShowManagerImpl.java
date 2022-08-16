package com.cts.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.cts.exception.SeatsNotAvailableException;
import com.cts.exception.UnknownShowException;

public class ShowManagerImpl implements ShowManager {
	public List<Show> populate(String fileName) {
		// should handle FileNotFoundException, IOException, ClassNotFoundException
		List<Show> list = new ArrayList<Show>();

		try {
			File file = new File(fileName);
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String[] row = sc.nextLine().split(",");
				LocalTime localTime = LocalTime.parse(row[1]);//to check if date is in required format otherwise it will through DateTimeParseException 
				String showName = row[0];
				String showTime = row[1];
				int seatsAvailable = Integer.parseInt(row[2]);
				list.add(new Show(showName, showTime, seatsAvailable));
			}
			sc.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DateTimeParseException dtpe) {
			System.out.println("The Time should be in these formats HH:MM or HH:MM:SS (24 hour system)");
		}

		return list;
	}

	public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats) throws Exception
	{
		ListIterator<Show> itr = showList.listIterator();
		boolean checkShowName=false;
		boolean checkShowTime=false;
		while(itr.hasNext()) {
			Show show = itr.next();
			if(show.getShowName().equalsIgnoreCase(showName)) {
				checkShowName=true; //Show name found
				LocalTime actualShowTime = LocalTime.parse(show.getShowTime());
				LocalTime givenShowTime = LocalTime.parse(show_time);
				if(actualShowTime.compareTo(givenShowTime)==0) {
					checkShowTime=true;//As show matched with the given timings
					if(show.getSeatsAvailable()>noOfSeats) {						 
						int remainingSeats = show.getSeatsAvailable()-noOfSeats;
						show.setSeatsAvailable(remainingSeats);
						itr.set(show);
						System.out.println("Booking Confirmed");
					}
					else 
						throw new SeatsNotAvailableException(noOfSeats-show.getSeatsAvailable());
				}
			}
			
		}
		if(checkShowName==false) {
			throw new UnknownShowException(showName);
		}
			
	}

}
