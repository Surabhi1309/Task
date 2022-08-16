package com.cts.bean;

import java.util.List;

import com.cts.exception.UnknownShowException;

public interface ShowManager {
	 public List<Show> populate(String fileName);
	 public void bookShow(List<Show> showList, String showName,
				String show_time, int noOfSeats) throws UnknownShowException, Exception;

}
