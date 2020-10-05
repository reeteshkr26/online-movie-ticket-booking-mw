
/**********************************************************************************************************************************
 -File Name         :   BookingModel.class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   Modal class of Booking management service
 **********************************************************************************************************************************/

package com.cg.omtb.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingModel {

	private Long bookingId;
	
	@NotNull(message = "Customer id is mandatory")
	private Integer customerId;
	
	@NotNull(message = "Movie id is mandatory")
	private Integer movieId;

	@NotNull(message = "Theater Id is mandatory")
	private Integer theaterId;
	
	@NotBlank(message = "City is mandatory")
	private String city;
	
	@NotNull(message = "Show id is mandatory")
	private Integer showId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Date of Show is mandatory")
	private LocalDate dateOfShow;

	private Long transactionId;

	private Integer ticketId;
	
	@NotNull(message = "no. of seats is mandatory")
	private Integer noOfSeats;

	private Double totalCost;
	
	

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getDateOfShow() {
		return dateOfShow;
	}

	public void setDateOfShow(LocalDate dateOfShow) {
		this.dateOfShow = dateOfShow;
	}
	
	
	
}
