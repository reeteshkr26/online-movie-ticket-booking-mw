package com.cg.omtb.model;

import java.time.LocalDate;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonFormat;

public class MovieModel {
	
	private Integer movieId;

	private String movieName;

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate releasedDate;

	private String movieDirector;

	private Integer movieLength;
	
	private List<String> movieLanguage; 
	
	private Integer movieRating;

	private String movieActor;

	private String movieActress;

	private List<String> movieType;


	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public LocalDate getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}

	public String getMovieDirector() {
		return movieDirector;
	}
	
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public Integer getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(Integer movieLength) {
		this.movieLength = movieLength;
	}

	public List<String> getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(List<String> movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public Integer getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(Integer movieRating) {
		this.movieRating = movieRating;
	}

	public String getMovieActor() {
		return movieActor;
	}

	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}

	public String getMovieActress() {
		return movieActress;
	}

	public void setMovieActress(String movieActress) {
		this.movieActress = movieActress;
	}

	public List<String> getMovieType() {
		return movieType;
	}

	public void setMovieType(List<String> movieType) {
		this.movieType = movieType;
	}

}
