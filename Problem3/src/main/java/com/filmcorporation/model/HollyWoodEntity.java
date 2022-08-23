package com.filmcorporation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class HollyWoodEntity {
	@Id
	private String movieId;
	private String movieName;
	private String language;
	private Integer releasedIn;
	private Integer revenueDollers;
	@ManyToOne(cascade = CascadeType.ALL,targetEntity = DirectorEntity.class)
	@JoinColumn(name = "directorId")
	DirectorEntity directorEntity;
	public HollyWoodEntity(String movieId, String movieName, String language, Integer releasedIn,
			Integer revenueDollers, DirectorEntity directorEntity) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.language = language;
		this.releasedIn = releasedIn;
		this.revenueDollers = revenueDollers;
		this.directorEntity = directorEntity;
	}
	public HollyWoodEntity() {
		super();
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
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
	public DirectorEntity getDirectorEntity() {
		return directorEntity;
	}
	public void setDirectorEntity(DirectorEntity directorEntity) {
		this.directorEntity = directorEntity;
	}
	@Override
	public String toString() {
		return "HollyWoodEntity [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language
				+ ", releasedIn=" + releasedIn + ", revenueDollers=" + revenueDollers + ", directorEntity="
				+ directorEntity + "]";
	}
	

}
