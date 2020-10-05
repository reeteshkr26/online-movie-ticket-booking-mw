/**********************************************************************************************************************************
 -File Name         :   Movie Model
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   23-09-2020
 -Description       :   Modal class of Movie management service
 **********************************************************************************************************************************/
package com.cg.omtb.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


public class MovieModel {

	private Integer movieId;

	@NotBlank(message = "Movie Name is mandatory")
	private String movieName;

	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "movie released date is mandatory")
	private LocalDate releasedDate;
	
	@NotBlank(message = "Movie director name is mandatory")
	private String movieDirector;

	@NotNull(message = "Movie length name is mandatory")
	private Integer movieLength;
	
	@NotNull(message = "Movie language is mandatory")
	private List<String> movieLanguage; 
	
	@NotNull(message = "Movie Rating is mandatory")
	private Integer movieRating;

	@NotNull(message = "Movie Actoris mandatory")
	private String movieActor;
	
	@NotNull(message = "Movie Actress is mandatory")
	private String movieActress;

	@NotNull(message = "Movie Type is mandatory")
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
