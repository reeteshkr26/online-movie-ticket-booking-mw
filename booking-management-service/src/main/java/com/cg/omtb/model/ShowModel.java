package com.cg.omtb.model;

public class ShowModel {
	private Integer showId;
	private String startTime;
	private String endTime;
	private String showName;
	private Integer movieId;
	private Integer screenId;
	private Integer theaterId;
	private String movieName;
	private String screenName;
	private String theaterName;
	
	public ShowModel() {
		super();
	
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

	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public ShowModel(Integer showId, String startTime, String endTime, String showName, Integer movieId, Integer screenId,
			Integer theaterId) {
		super();
		this.showId = showId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.showName = showName;
		this.movieId = movieId;
		this.screenId = screenId;
		this.theaterId = theaterId;
	}


}
