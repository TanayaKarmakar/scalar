package com.scalar.design.lld.parkinglotv2.services;

import com.scalar.design.lld.parkinglotv2.models.ParkingLot;
import com.scalar.design.lld.parkinglotv2.repositories.ParkingLotRepository;

/**
 * @author t0k02w6 on 18/01/23
 * @project scalar-ds
 */
public class ParkingLotService {
  private ParkingLotRepository parkingLotRepository;
  private ParkingSpotService parkingSpotService;

  public ParkingLotService(ParkingLotRepository parkingLotRepository, ParkingSpotService parkingSpotService) {
    this.parkingLotRepository = parkingLotRepository;
    this.parkingSpotService = parkingSpotService;
  }

  public ParkingLot createParkingLot(ParkingLot parkingLot) {
    // create the parking lot
    ParkingLot savedParkingLot = parkingLotRepository.save(parkingLot);

    // create associated entities - Floors, Spots, Gates
    parkingSpotService.createParkingSpots(savedParkingLot);

    return savedParkingLot;
  }
}
