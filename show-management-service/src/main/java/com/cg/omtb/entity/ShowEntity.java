package com.cg.omtb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Show_table")
public class ShowEntity {
	@Id
	@Column(name = "show_id")
	private Integer showId;
	
	@NotBlank(message = "enter the startTime")
	@Column(name = "start_time")
	private String  startTime;
	
	@NotBlank(message = "enter the endTime")
	@Column(name = "end_time")
	private String endTime;
	
	@NotBlank(message = "enter the showName")
	@Column(name = "show_name")
	private String showName;
	
	@NotNull(message="enter the movie id")
	@Column(name = "movie_id")
	private Integer movieId;

	@Column(name = "screen_id")
	private Integer screenId;
	
	@NotNull(message ="enter theater id")
	@Column(name = "theater_id")
	private Integer theaterId;

	public ShowEntity(String startTime, String endTime, String showName, Integer movieId,
			Integer screenId, Integer theaterId) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.showName = showName;
		this.movieId = movieId;
		this.screenId = screenId;
		this.theaterId = theaterId;
	}


	public ShowEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getScreenId() {
		return screenId;
	}

	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}

	public Integer getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}

	@Override
	public String toString() {
		return "ShowEntity [showId=" + showId + ", startTime=" + startTime + ", endTime=" + endTime + ", showName="
				+ showName + ", movieId=" + movieId + ", screenId=" + screenId + ", theaterId=" + theaterId + "]";
	}
	

}