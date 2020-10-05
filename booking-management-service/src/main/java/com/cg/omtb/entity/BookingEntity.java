
/**********************************************************************************************************************************
 -File Name         :   BookingEntity.class
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
@Table(name="booking_table")
public class BookingEntity {

	@Id
	@Column(name="booking_id",nullable=false)
	private Long bookingId;
	
	@Column(name="customer_id",nullable=false)
	@NotNull(message = "Customer id is mandatory")
	private Integer customerId;

	@Column(name="movie_id",nullable=false)
	@NotNull(message = "Movie id is mandatory")
	private Integer movieId;
	
	@Column(name="city",nullable=false)
	@NotBlank(message = "City is mandatory")
	private String city;
	
	@Column(name="theater_id",nullable=false)
	@NotNull(message = "Theater Id is mandatory")
	private Integer theaterId;
	
	@Column(name="show_id",nullable=false)
	@NotNull(message = "Show id is mandatory")
	private Integer showId;
	
	@Column(name="booking_date",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingDate;
	
	@Column(name="show_date",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message = "Date of Show is mandatory")
	private LocalDate dateOfShow;
	
	@Column(name="transaction_id",nullable=false)
	private Long transactionId;
	
	@Column(name="ticket_id",nullable=false)
	private Integer ticketId;
	
	@Column(name="no_of_seats",nullable=false)
	@NotNull(message = "no. of seat is mandatory")
	private Integer noOfSeats;
	
	@Column(name="total_cost",nullable=false)
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

	public LocalDate getDateOfShow() {
		return dateOfShow;
	}

	public void setDateOfShow(LocalDate dateOfShow) {
		this.dateOfShow = dateOfShow;
	}
	
	
	
	
	
}
