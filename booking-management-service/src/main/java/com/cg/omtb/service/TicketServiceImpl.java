/**********************************************************************************************************************************
 -File Name         :   TicketServiceImpl.class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   The implementation of the TicketService interface and to write business logic in this class
 **********************************************************************************************************************************/

package com.cg.omtb.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.omtb.dao.TicketRepository;
import com.cg.omtb.entity.TicketEntity;
import com.cg.omtb.exception.TicketException;
import com.cg.omtb.model.TicketModel;

@Service
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepository ticketRepo;
	

	
	/*
	 * Convert TicketEntity into TicketModel
	 */
	@Override
	public TicketModel of(TicketEntity source) {
		TicketModel result=null;
		if(source!=null) {
			result=new TicketModel();
			result.setTicketId(source.getTicketId());
			result.setBookingId(source.getBookingId());
			result.setCustomerId(source.getCustomerId());
			result.setNoOfSeats(source.getNoOfSeats());
			result.setBookingDate(source.getBookingDate());
			result.setCity(source.getCity());
			result.setDateOfShow(source.getDateOfShow());
			result.setMovieName(source.getMovieName());
			result.setTheatreName(source.getTheatreName());
			result.setShowName(source.getShowName());
			result.setTicketStatus(source.getTicketStatus());
			result.setTotalTicketPrice(source.getTotalTicketPrice());
		}
		return result;
	}
	
	/*
	 * Convert TicketModel into TicketEntity
	 */
	@Override
	public TicketEntity of(TicketModel source) {
		TicketEntity result=null;
		if(source!=null) {
			result=new TicketEntity();
			result.setTicketId(source.getTicketId());
			result.setBookingId(source.getBookingId());
			result.setCustomerId(source.getCustomerId());
			result.setNoOfSeats(source.getNoOfSeats());
			result.setBookingDate(source.getBookingDate());
			result.setCity(source.getCity());
			result.setDateOfShow(source.getDateOfShow());
			result.setMovieName(source.getMovieName());
			result.setTheatreName(source.getTheatreName());
			result.setShowName(source.getShowName());
			result.setTicketStatus(source.getTicketStatus());
			result.setTotalTicketPrice(source.getTotalTicketPrice());
		}
		return result;
	}
	
	/*
	 * To save ticket details into ticket_table
	 */
	@Override
	public TicketModel saveTicket(TicketEntity ticket) throws TicketException {
		
		if(ticket==null) {
			throw new TicketException("Ticket Object Should not be null");
		}
		if(ticketRepo.existsById(ticket.getTicketId())){
			throw new TicketException("Ticket Id already exist");
		}
		return of(ticketRepo.save(ticket));
	}

	/*
	 * To fetch the ticket_table by customerId and return the list of tickets
	 */
	@Override
	public List<TicketModel> viewTicket(Integer customerId) throws TicketException {
		if(customerId==null) {
			throw new TicketException("Customer Id should not be null");
		}
		return ticketRepo.findByCustomerId(customerId).stream().map(entity->of(entity)).collect(Collectors.toList());
	}

	/*
	 * To update the ticket status
	 */
	@Override
	public TicketModel cancelTicket(TicketModel ticket) throws TicketException {
		
		if(ticket!=null) {
			TicketModel oldTicket=of(ticketRepo.findById(ticket.getTicketId()).orElse(null));
			if(oldTicket==null) {
				throw new TicketException("There does not exists a ticket with the given ID");
			}
			else {
				ticket=of(ticketRepo.save(of(ticket)));
				
				//update No. of available seats
			}
		}
		return ticket;
	}

	/*
	 * To generate the ticket id
	 */
	@Override
	public Integer generateTicketId() {
		int m = (int) Math.pow(10, 8-1);
	    return (m + new Random().nextInt(9 * m));
	}

}
