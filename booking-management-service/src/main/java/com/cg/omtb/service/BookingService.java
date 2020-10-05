
/**********************************************************************************************************************************
 -File Name         :   BookingService.class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   Service interface to declare all methods of service implementation class
 **********************************************************************************************************************************/

package com.cg.omtb.service;

import com.cg.omtb.entity.BookingEntity;
import com.cg.omtb.exception.BookingException;
import com.cg.omtb.model.BookingModel;

public interface BookingService {

	public BookingModel bookTicket(BookingEntity bookingEntity) throws BookingException;
	public double calculateTotalTicketCost(int noOfTicket, double ticketPrice);
	public Integer makePaymet(double totalTicketCost);
	public Long generateBookingId();
	public BookingEntity of(BookingModel source);
	public BookingModel of(BookingEntity source);
}
