package com.cts.bean;

import java.util.List;

public class ShowDisplayImpl implements ShowDisplay {
	@Override
	public void displayAllShows(List<Show> list) {
		System.out.println("Please find the list of all the shows\nShow Name   Time   Seats Available");
		list.stream().forEach(System.out::println);
		System.out.println("=============================\n");
	}

}
