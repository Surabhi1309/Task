package com.filmcorporation.dao;

import com.filmcorporation.model.MovieEntity;

public interface MovieDao {
	void addMovie(MovieEntity movie);
	void maxRevenueForLang(String language);
	void minRevenueForLang(String language);
	void noOfMoviesForLanguage(String language);
	Long sumOfRevenueForLanguage(String language);
	Double averageOfRevenueForLang(String language);
}
