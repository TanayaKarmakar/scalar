package com.scalar.design.lld.parkinglotv2.repositories;

import com.scalar.design.lld.parkinglotv2.models.Ticket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 20/01/23
 * @project scalar-ds
 */
public class TicketRepository {
  private List<Ticket> tickets = new ArrayList<>();

  public Ticket save(Ticket ticket) {
    tickets.add(ticket);
    return ticket;
  }
}
