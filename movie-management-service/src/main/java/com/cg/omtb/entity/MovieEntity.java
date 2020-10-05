
/**********************************************************************************************************************************
 -File Name         :   Movie Entity
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   23-09-2020
 -Description       :   Entity class used to create the table instance of object Movie
 **********************************************************************************************************************************/
package com.cg.omtb.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="movie_table")
public class MovieEntity {

	@Id
	@Column(name="movie_id")
	private Integer movieId;
	
	@Column(name="movie_name",nullable=false)
	@NotBlank(message = "Movie Name is mandatory")
	private String movieName;
	
	@Column(name="movie_release_date",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "movie released date is mandatory")
	private LocalDate releasedDate;
	
	@Column(name="movie_director",nullable=false)
	@NotBlank(message = "Movie director name is mandatory")
	private String movieDirector;
	
	@Column(name="movie_length",nullable=false)
	@NotNull(message = "Movie length is mandatory")
	private Integer movieLength;
	
    @ElementCollection
	@Column(name="movie_language",nullable=false)
	@NotNull(message = "Movie language is mandatory")
	private List<String> movieLanguage; 
	
	@Column(name="movie_rating",nullable=false)
	@NotNull(message = "Movie Rating is mandatory")
	private Integer movieRating;
	
	@Column(name="movie_actor",nullable=false)
	@NotNull(message = "Movie Actoris mandatory")
	private String movieActor;
	
	@Column(name="movie_actress",nullable=false)
	@NotNull(message = "Movie Actress is mandatory")
	private String movieActress;
	
    @ElementCollection
	@Column(name="movie_type",nullable=false)
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
