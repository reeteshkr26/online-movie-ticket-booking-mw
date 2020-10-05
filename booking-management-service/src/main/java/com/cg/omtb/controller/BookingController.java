
/**********************************************************************************************************************************
 -File Name         :   BookingController.class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   Controller to produce the Booking Management Service.
 **********************************************************************************************************************************/
package com.cg.omtb.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.omtb.entity.BookingEntity;
import com.cg.omtb.entity.TicketEntity;
import com.cg.omtb.exception.BookingException;
import com.cg.omtb.exception.TicketException;
import com.cg.omtb.model.BookingModel;
import com.cg.omtb.model.MovieModel;
import com.cg.omtb.model.ShowModel;
import com.cg.omtb.model.TicketModel;
import com.cg.omtb.service.BookingService;
import com.cg.omtb.service.MovieProxyService;
import com.cg.omtb.service.ShowProxyService;
import com.cg.omtb.service.TicketService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private MovieProxyService movieProxyService;
	
	@Autowired
	private ShowProxyService showProxyService;

	static final double TICKET_PRICE = 100.0;
	
	/**********************************************************************************************************************************
	 -Method Name       :   createBooking
	 -Input Parameters  :   BookingModel bookingModel
	 -Return Type       :	ResponseEntity<TicketModel>
	 -Description       :   Method to add booking details into booking_table, add ticket details in ticket_table 
	 **********************************************************************************************************************************/
	@PostMapping
	public ResponseEntity<TicketModel> createBooking(@Valid @RequestBody BookingModel bookingModel)
			throws BookingException, TicketException {

		/**
		 * After integration
		 * check seat is available or not for particular show
		 * if seat is not available then booking will not performed 
		 * if seat is available then booking will happen by following code
		 */
		TicketModel ticket = new TicketModel();

		double totalTicketCost = bookingService.calculateTotalTicketCost(bookingModel.getNoOfSeats(), TICKET_PRICE);
		long transactionId = bookingService.makePaymet(totalTicketCost);// make payment after calculating cost
		Long bookingId = bookingService.generateBookingId();
		Integer ticketId = ticketService.generateTicketId();
		
		BookingEntity booking = bookingService.of(bookingModel);
		booking.setBookingId(bookingId);
		booking.setTicketId(ticketId);
		booking.setBookingDate(LocalDate.now());
		booking.setTotalCost(totalTicketCost);
		booking.setTransactionId(transactionId);

		bookingModel = bookingService.bookTicket(booking);

		if (bookingModel != null) {
			//MovieModel movie=movieProxyService.getMovie(bookingModel.getMovieId());
			ShowModel show=showProxyService.getShow(bookingModel.getShowId());
			if(show!=null) {
				TicketEntity entity = new TicketEntity();
				entity.setTicketId(ticketId);
				entity.setBookingId(bookingId);
				entity.setCustomerId(bookingModel.getCustomerId());// Customer Id
				entity.setNoOfSeats(bookingModel.getNoOfSeats());
				entity.setTotalTicketPrice(bookingModel.getTotalCost());
				entity.setTicketStatus(1);
				entity.setTheatreName(show.getTheaterName());
				entity.setBookingDate(bookingModel.getBookingDate());
				entity.setDateOfShow(bookingModel.getDateOfShow());
				entity.setMovieName(show.getMovieName());
				entity.setShowName(show.getShowName());
				entity.setCity(bookingModel.getCity());
				
				ticket = ticketService.saveTicket(entity);
			}

		}

		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}

	/**********************************************************************************************************************************
	 -Method Name       :   viewTicket
	 -Input Parameters  :   Integer customerId
	 -Return Type       :	ResponseEntity<TicketModel>
	 -Description       :   Method to return list of movie which contains same customer Id
	 **********************************************************************************************************************************/
	@GetMapping("/tickets/{customerId}")
	public ResponseEntity<List<TicketModel>> viewTicket(@PathVariable("customerId") Integer customerId)
			throws TicketException {
		ResponseEntity<List<TicketModel>> response = null;

		List<TicketModel> listOfTickets = ticketService.viewTicket(customerId);

		if (listOfTickets == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(listOfTickets, HttpStatus.OK);
		}

		return response;
	}
	
	/**********************************************************************************************************************************
	 -Method Name       :   updateTicketStatus
	 -Input Parameters  :   TicketModel ticket
	 -Return Type       :	ResponseEntity<TicketModel>
	 -Description       :   Method to update status of ticket
	 **********************************************************************************************************************************/
	@PutMapping("/tickets")
	public ResponseEntity<TicketModel> updateTicketStatus(@RequestBody TicketModel ticket) throws TicketException {
		ResponseEntity<TicketModel> response = null;
		ticket.setTicketStatus(0);
		ticket = ticketService.cancelTicket(ticket);
		if (ticket == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			// call update screen
			response = new ResponseEntity<>(ticket, HttpStatus.OK);
		}
		return response;
	}
}
