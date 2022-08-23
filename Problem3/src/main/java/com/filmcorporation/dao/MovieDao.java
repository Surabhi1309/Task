package com.filmcorporation.dao;

import com.filmcorporation.model.MovieEntity;

public interface MovieDao {
	void getMovieDetails(String language);
	void getMovieByDirector(String directorName);
	void addMovie(MovieEntity movieEntity);
	void updateRevenue(String movieName);
	void deleteMovie(String movieName);
	void getDistinctLanguages();
}
