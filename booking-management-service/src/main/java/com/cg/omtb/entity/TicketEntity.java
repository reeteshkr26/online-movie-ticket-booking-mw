
/**********************************************************************************************************************************
 -File Name         :   TicketEntity.class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   Entity class used to create the table instance of object 
 **********************************************************************************************************************************/

package com.cg.omtb.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="ticket_table")
public class TicketEntity {

	@Id
	@Column(name="ticket_id")
	private Integer ticketId;
	
	@Column(name="no_of_seats", nullable=false)
	@NotNull(message = "no. of seats is mandatory")
	private Integer noOfSeats;
	
	@Column(name="booking_id",nullable=false)
	@NotNull(message = "Booking id is mandatory")
	private Long bookingId;
	
	@Column(name="ticket_status",nullable=false)
	@NotNull(message = "ticket status is mandatory")
	private Integer ticketStatus;
	
	@Column(name="movie_name",nullable=false)
	@NotBlank(message = "Movie Name is mandatory")
	private String movieName;
	
	@Column(name="theatre_name",nullable=false)
	@NotBlank(message = "Theatre Name is mandatory")
	private String theatreName;
	
	@Column(name="show_name",nullable=false)
	@NotBlank(message = "Show Name is mandatory")
	private String showName;
	
	@Column(name="city_name",nullable=false)
	@NotBlank(message = "City Name is mandatory")
	private String city;
	
	@Column(name="show_date",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Date of Show is mandatory")
	private LocalDate dateOfShow;
	
	@Column(name="bookking_date",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Booking Date is mandatory")
	private LocalDate bookingDate;
	
	@Column(name="customer_id",nullable=false)
	@NotNull(message = "Customer is mandatory")
	private Integer customerId;
	
	@Column(name="total_ticket_price",nullable=false)
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

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId2) {
		this.bookingId = bookingId2;
	}
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(Integer ticketStatus) {
		this.ticketStatus = ticketStatus;
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
