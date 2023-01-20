package com.scalar.design.lld.parkinglotv2.controllers;

import com.scalar.design.lld.parkinglotv2.dtos.TicketRequest;
import com.scalar.design.lld.parkinglotv2.models.Ticket;
import com.scalar.design.lld.parkinglotv2.services.TicketService;

/**
 * @author t0k02w6 on 19/01/23
 * @project scalar-ds
 */
public class TicketController {
  private TicketService ticketService;

  public Ticket createTicket(TicketRequest ticketRequest) {
    return ticketService.createTicket(ticketRequest);
  }
}
