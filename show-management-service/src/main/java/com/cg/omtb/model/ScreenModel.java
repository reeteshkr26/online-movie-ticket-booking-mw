package com.cg.omtb.model;

public class ScreenModel {
	
	private Integer screenId;

	private String screenName;

	private String city;

	private Integer theaterId;

	private Integer totalSeats;
	
	private Integer availableSeats;
	
	private String theaterName;

	public Integer getScreenId() {
		return screenId;
	}

	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

}
