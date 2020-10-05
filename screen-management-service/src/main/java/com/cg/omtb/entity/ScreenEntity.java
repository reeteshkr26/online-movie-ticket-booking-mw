package com.cg.omtb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="screen_table")
public class ScreenEntity {

	@Id
	@Column(name="screen_id")
	private Integer screenId;
	
	@Column(name="screen_name",nullable=false)
	@NotBlank(message="Screen Name is mandatory")
	private String screenName;
	
	@Column(name="city",nullable=false)
	@NotBlank(message="City Name is mandatory")
	private String city;
	
	@Column(name="theater_id",nullable=false)
	@NotNull(message="Screen Name is mandatory")
	private Integer theaterId;
	
	@Column(name="total_seats",nullable=false)
	@NotNull(message="Number of seats is mandatory")
	private Integer totalSeats;
	
	@Column(name="available_seats",nullable=false)
	private Integer availableSeats;

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

	public Integer getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(Integer totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	
}
