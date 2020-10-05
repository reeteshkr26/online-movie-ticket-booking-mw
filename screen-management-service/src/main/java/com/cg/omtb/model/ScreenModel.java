package com.cg.omtb.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ScreenModel {

	private Integer screenId;
	
	@NotBlank(message="Screen Name is mandatory")
	private String screenName;

	@NotBlank(message="City Name is mandatory")
	private String city;
	
	@NotNull(message="Theater Id is mandatory")
	private Integer theaterId;
	
	@NotNull(message="Number of seats is mandatory")
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
