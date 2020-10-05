/**********************************************************************************************************************************
 -File Name         :   BookingManagementServiceApplicationTests.class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   This class is to test all the test cases.
 **********************************************************************************************************************************/

package com.cg.omtb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.omtb.dao.BookingRepository;
import com.cg.omtb.dao.TicketRepository;
import com.cg.omtb.entity.BookingEntity;
import com.cg.omtb.entity.TicketEntity;
import com.cg.omtb.exception.BookingException;
import com.cg.omtb.exception.TicketException;
import com.cg.omtb.model.BookingModel;
import com.cg.omtb.model.TicketModel;
import com.cg.omtb.service.BookingService;
import com.cg.omtb.service.TicketService;

@SpringBootTest
@RunWith(SpringRunner.class)
class BookingManagementServiceApplicationTests {

	@Autowired
	private BookingService bookingService;
	@Autowired
	private TicketService ticketService;
	
	@MockBean
	private TicketRepository ticketRepo;
	@MockBean
	private BookingRepository bookingRepo;
	
	@Test
	public void bookTicketTest() throws BookingException {
		BookingEntity bookingEntity=bookingService.of(getBookingModel());
		when(bookingRepo.save(bookingEntity)).thenReturn(bookingEntity);
	
		BookingModel bookingModel=bookingService.bookTicket(bookingEntity);
		assertEquals(bookingEntity.getBookingId(),bookingModel.getBookingId());
	}
	
	@Test
	public void bookTicketTest_NullPointerException() {
		BookingException ex=assertThrows(BookingException.class, ()->{
			bookingService.bookTicket(null);
		});
		assertEquals("Booking Object Should not be null",ex.getMessage());
	}
	
	@Test
	public void bookTicketTest_BookingIdAlreadyExist() {
		BookingEntity bookingEntity=bookingService.of(getBookingModel());
		
		
		BookingException ex=assertThrows(BookingException.class, ()->{
			when(bookingRepo.existsById(anyLong())).thenReturn(true);
			bookingService.bookTicket(bookingEntity);
		});
		assertEquals("Booking Id already exist",ex.getMessage());
	}
	
	@Test
	public void saveTicketTest() throws BookingException, TicketException {
		TicketEntity ticketEntity=ticketService.of(getTicketModel());
		when(ticketRepo.save(ticketEntity)).thenReturn(ticketEntity);
	
		TicketModel ticketModel=ticketService.saveTicket(ticketEntity);
		assertEquals(ticketEntity.getTicketId(),ticketModel.getTicketId());
	}
	
	@Test
	public void saveTicketTest_NullPointerException() {
		TicketException ex=assertThrows(TicketException.class, ()->{
			ticketService.saveTicket(null);
		});
		assertEquals("Ticket Object Should not be null",ex.getMessage());
	}
	
	@Test
	public void saveTicketTest_TicketIdAlreadyExist() {
		TicketEntity ticketEntity=ticketService.of(getTicketModel());
		
		
		TicketException ex=assertThrows(TicketException.class, ()->{
			when(ticketRepo.existsById(anyInt())).thenReturn(true);
			ticketService.saveTicket(ticketEntity);
		});
		assertEquals("Ticket Id already exist",ex.getMessage());
	}
	
	@Test
	public void viewTicketTest() throws TicketException {
		
		when(ticketRepo.findByCustomerId(anyInt())).thenReturn(Stream.of(ticketService.of(getTicketModel()),ticketService.of(getTicketModel())).collect(Collectors.toList()));
	
		assertEquals(2,ticketService.viewTicket(12345).size());
	}
	@Test
	public void viewTicketTest_NullPointerException() {
		TicketException ex=assertThrows(TicketException.class, ()->{
			ticketService.viewTicket(null);
		});
		assertEquals("Customer Id should not be null",ex.getMessage());
	}

	public BookingModel getBookingModel() {
		BookingModel bookingModel=new BookingModel();
		bookingModel.setBookingId((long) 2135784298);
		bookingModel.setBookingDate(LocalDate.now());
		bookingModel.setMovieId(3421);
		bookingModel.setNoOfSeats(2);
		bookingModel.setShowId(3321234);
		bookingModel.setTicketId(87424);
		bookingModel.setTotalCost(200.0);
		bookingModel.setTransactionId((long) 500053);
		return bookingModel;
	}
	
	public TicketModel getTicketModel() {
		TicketModel ticketModel=new TicketModel();
		ticketModel.setBookingId((long) 2135784298);
		ticketModel.setNoOfSeats(2);
		ticketModel.setTheatreName("PVR Ansal");
		ticketModel.setTicketId(87424);
		ticketModel.setTotalTicketPrice(200.0);
		ticketModel.setTicketStatus(1);
		return ticketModel;
	}

}
