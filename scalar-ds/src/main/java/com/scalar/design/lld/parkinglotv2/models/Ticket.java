package com.scalar.design.lld.parkinglotv2.models;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author t0k02w6 on 18/01/23
 * @project scalar-ds
 */

@SuperBuilder
@Getter
public class Ticket extends BaseModel {
  private Long vehicleId;
  private Vehicle vehicle;


  private Long parkingSpotId;
  //private ParkingSpot parkingSpot;

  private LocalDateTime entryTime;

  private Long issuerId;
  //private ParkingAttendant issuedBy;

  private Long entryGateId;
}
