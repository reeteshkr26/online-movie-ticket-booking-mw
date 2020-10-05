
/**********************************************************************************************************************************
 -File Name         :   TicketService.class
 -Author            :   Reetesh Kumar Mandal
 -Creation Date     :   24-09-2020
 -Description       :   Service interface to declare all methods of service implementation class
 **********************************************************************************************************************************/

package com.cg.omtb.service;

import java.util.List;

import com.cg.omtb.entity.TicketEntity;
import com.cg.omtb.exception.TicketException;
import com.cg.omtb.model.TicketModel;

public interface TicketService {

	public TicketModel saveTicket(TicketEntity ticket) throws TicketException;
	public List<TicketModel> viewTicket(Integer customerId) throws TicketException;
	public TicketModel cancelTicket(TicketModel ticket) throws TicketException;
	public Integer generateTicketId();
	
	public TicketModel of(TicketEntity source);
	public TicketEntity of(TicketModel source);
	
}
