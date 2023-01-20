package com.scalar.design.lld.parkinglotv2.services;

import com.scalar.design.lld.parkinglotv2.dtos.TicketRequest;
import com.scalar.design.lld.parkinglotv2.exceptions.SpotNotAvailableException;
import com.scalar.design.lld.parkinglotv2.models.ParkingSpot;
import com.scalar.design.lld.parkinglotv2.models.SpotStatus;
import com.scalar.design.lld.parkinglotv2.models.Ticket;
import com.scalar.design.lld.parkinglotv2.repositories.TicketRepository;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author t0k02w6 on 19/01/23
 * @project scalar-ds
 */
public class TicketService {
  private ParkingSpotService parkingSpotService;
  private VehicleService vehicleService;
  private TicketRepository ticketRepository;

  public TicketService(ParkingSpotService parkingSpotService, VehicleService vehicleService, TicketRepository ticketRepository) {
    this.parkingSpotService = parkingSpotService;
    this.vehicleService = vehicleService;
    this.ticketRepository = ticketRepository;
  }

  public Ticket createTicket(TicketRequest request) {
    //check if parking lot is full

    ParkingSpot spot = parkingSpotService.allocateSpot(request.getParkingLotId(), request.getType());
    if(Objects.isNull(spot)) {
      throw new SpotNotAvailableException("Spot not available");
    }

    //update spot status
    spot.setSpotStatus(SpotStatus.FILLED);

    // persist the spot
    parkingSpotService.update(spot);

    // create the ticket
    Ticket ticket = Ticket.builder()
        .entryTime(LocalDateTime.now())
        .parkingSpotId(spot.getId())
        .entryGateId(request.getEntryGateId())
        .issuerId(request.getIssuerId())
        .vehicle(vehicleService.findOrCreate(request.getVehicleNumber(), request.getType()))
        .build();
    return ticketRepository.save(ticket);
  }
}
