package com.scalar.design.lld.parkinglotv2.controllers;

import com.scalar.design.lld.parkinglotv2.dtos.ParkingLotRequest;
import com.scalar.design.lld.parkinglotv2.exceptions.InvalidParkingLotRequestException;
import com.scalar.design.lld.parkinglotv2.models.ParkingLot;
import com.scalar.design.lld.parkinglotv2.services.ParkingLotService;
import java.util.Objects;

/**
 * @author t0k02w6 on 18/01/23
 * @project scalar-ds
 */
public class ParkingLotController {
  private ParkingLotService parkingLotService;

  public ParkingLotController(ParkingLotService parkingLotService) {
    this.parkingLotService = parkingLotService;
  }

  public ParkingLot createParkingLot(ParkingLotRequest parkingLotRequest) {
    validate(parkingLotRequest);
    return parkingLotService.createParkingLot(parkingLotRequest.toParkingLot());
  }

  private void validate(ParkingLotRequest parkingLotRequest) {
    if(Objects.isNull(parkingLotRequest.getNumberOfFloors()))
      throw new InvalidParkingLotRequestException("No number of floors");

  }
}
