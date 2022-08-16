package com.moviecrud.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	private String movieId;
	private String name;
	private String language;
	private Integer releasedIn;
	private Integer revenueDollers;
	public Movie() {
		super();
	}
	public Movie(String movieId, String name, String language, Integer releasedIn, Integer revenueDollers) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.language = language;
		this.releasedIn = releasedIn;
		this.revenueDollers = revenueDollers;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getReleasedIn() {
		return releasedIn;
	}
	public void setReleasedIn(Integer releasedIn) {
		this.releasedIn = releasedIn;
	}
	public Integer getRevenueDollers() {
		return revenueDollers;
	}
	public void setRevenueDollers(Integer revenueDollers) {
		this.revenueDollers = revenueDollers;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", language=" + language + ", releasedIn=" + releasedIn
				+ ", revenueDollers=" + revenueDollers + "]";
	}
	
	

}
