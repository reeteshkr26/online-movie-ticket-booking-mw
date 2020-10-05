/**********************************************************************************************************************************
 -File Name         :   BookingServiceImpl.class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   The implementation of the BookingService interface and to write business logic in this class
 **********************************************************************************************************************************/

package com.cg.omtb.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omtb.dao.BookingRepository;
import com.cg.omtb.entity.BookingEntity;
import com.cg.omtb.exception.BookingException;
import com.cg.omtb.model.BookingModel;


@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepo;
	

	
	/*
	 * Convert BookingModel into BookingEntity
	 */
	@Override
	public BookingEntity of(BookingModel source) {
		
		BookingEntity result=null;
		if(source!=null) {
			result=new BookingEntity();
			result.setMovieId(source.getMovieId());
			result.setBookingId(source.getBookingId());
			result.setBookingDate(source.getBookingDate());
			result.setNoOfSeats(source.getNoOfSeats());
			result.setShowId(source.getShowId());
			result.setTicketId(source.getTicketId());
			result.setTotalCost(source.getTotalCost());
			result.setTransactionId(source.getTransactionId());
			result.setCustomerId(source.getCustomerId());
			result.setCity(source.getCity());
			result.setDateOfShow(source.getDateOfShow());
			result.setTheaterId(source.getTheaterId());
			
		}
		return result;
	}
	
	/*
	 * Convert BookingEntity into BookingModel
	 */
	@Override
	public BookingModel of(BookingEntity source) {
		
		BookingModel result=null;
		if(source!=null) {
			result=new BookingModel();
			result.setMovieId(source.getMovieId());
			result.setBookingId(source.getBookingId());
			result.setBookingDate(source.getBookingDate());
			result.setNoOfSeats(source.getNoOfSeats());
			result.setShowId(source.getShowId());
			result.setTicketId(source.getTicketId());
			result.setTotalCost(source.getTotalCost());
			result.setTransactionId(source.getTransactionId());
			result.setCustomerId(source.getCustomerId());
			result.setCity(source.getCity());
			result.setDateOfShow(source.getDateOfShow());
			result.setTheaterId(source.getTheaterId());
			
		}
		return result;
	}
	
	/*
	 * To save booking details into booking_table
	 */
	@Override
	public BookingModel bookTicket(BookingEntity bookingEntity) throws BookingException {
		if(bookingEntity==null) {
			throw new BookingException("Booking Object Should not be null");
		}
		if(bookingRepo.existsById(bookingEntity.getBookingId())){
			throw new BookingException("Booking Id already exist");
		}
		return of(bookingRepo.save(bookingEntity));
	
	}

	/*
	 * To calculate total cost of ticket
	 */
	@Override
	public double calculateTotalTicketCost(int noOfTicket, double ticketPrice) {		
		return noOfTicket*ticketPrice;
	}

	/*
	 * To pay the total cost of ticket and return transaction id
	 */
	@Override
	public Integer makePaymet(double totalTicketCost) {
		System.out.println("Payment Sucessfully..");
		System.out.println("Now processing your ticket");
		int m = (int) Math.pow(10, 6-1);
	    return m + new Random().nextInt(9 * m);
	
	}

	/*
	 * To generate booking id
	 */
	@Override
	public Long generateBookingId() {
		int m = (int) Math.pow(10, 10-1);
	    return (long) (m + new Random().nextInt(9 * m));	
		
	}

}
