
/**********************************************************************************************************************************
 -File Name         :   TicketModel.class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   Modal class of Booking management service
 **********************************************************************************************************************************/

package com.cg.omtb.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TicketModel {

	private Integer ticketId;
	
	@NotNull(message = "no. of seats is mandatory")
	private Integer noOfSeats;

	@NotNull(message = "Booking id is mandatory")
	private long bookingId;
	
	@NotNull(message = "ticket status is mandatory")
	private Integer ticketStatus;
	
	@NotBlank(message = "Movie Name is mandatory")
	private String movieName;

	@NotBlank(message = "Movie Name is mandatory")
	private String theatreName;
	
	@NotBlank(message = "Show Name is mandatory")
	private String showName;
	
	@NotBlank(message = "City Name is mandatory")
	private String city;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Date of Show is mandatory")
	private LocalDate dateOfShow;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Booking Date is mandatory")
	private LocalDate bookingDate;
	
	@NotNull(message = "Customer is mandatory")
	private Integer customerId;
	
	private Double totalTicketPrice;

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

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(Integer ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Double getTotalTicketPrice() {
		return totalTicketPrice;
	}

	public void setTotalTicketPrice(Double totalTicketPrice) {
		this.totalTicketPrice = totalTicketPrice;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
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

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}
	
	
	
}
