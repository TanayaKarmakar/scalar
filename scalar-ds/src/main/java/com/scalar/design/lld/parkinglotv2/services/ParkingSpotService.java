package com.scalar.design.lld.parkinglotv2.services;

import com.scalar.design.lld.parkinglotv2.models.ParkingLot;
import com.scalar.design.lld.parkinglotv2.models.ParkingSpot;
import com.scalar.design.lld.parkinglotv2.models.VehicleType;
import com.scalar.design.lld.parkinglotv2.repositories.ParkingSpotRepository;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author t0k02w6 on 19/01/23
 * @project scalar-ds
 */
public class ParkingSpotService {
  private ParkingSpotRepository parkingSpotRepository;

  public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
    this.parkingSpotRepository = parkingSpotRepository;
  }

  public void createParkingSpots(ParkingLot parkingLot) {
    List<ParkingSpot> spots = parkingLot.getFloors()
        .stream()
        .flatMap(floor -> floor.getParkingSpots().stream())
        .collect(Collectors.toList());

    parkingSpotRepository.saveAll(spots);
  }



  public ParkingSpot allocateSpot(Long parkingLotId, VehicleType type) {
    return parkingSpotRepository.findOneByVehicleTypeAndStatusAvailable(type);
  }

  public ParkingSpot update(ParkingSpot spot) {
    return parkingSpotRepository.update(spot);
  }
}
