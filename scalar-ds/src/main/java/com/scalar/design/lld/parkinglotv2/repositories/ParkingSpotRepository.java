package com.scalar.design.lld.parkinglotv2.repositories;


import com.scalar.design.lld.parkinglotv2.exceptions.ElementNotFoundException;
import com.scalar.design.lld.parkinglotv2.models.ParkingSpot;
import com.scalar.design.lld.parkinglotv2.models.SpotStatus;
import com.scalar.design.lld.parkinglotv2.models.VehicleType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author t0k02w6 on 19/01/23
 * @project scalar-ds
 */
public class ParkingSpotRepository {
  private List<ParkingSpot> spots = new ArrayList<>();

  public ParkingSpot save(ParkingSpot parkingSpot) {
    spots.add(parkingSpot);
    return parkingSpot;
  }

  public void saveAll(List<ParkingSpot> createdSpots) {
    spots.addAll(createdSpots);
  }

  public ParkingSpot update(ParkingSpot parkingSpot) {
    Optional<ParkingSpot> currentSpot = spots.stream()
        .filter(spot -> spot.getId().equals(parkingSpot.getId()))
        .findFirst();

    if(currentSpot.isEmpty())
      throw new ElementNotFoundException("Parking spot not found");
    spots.remove(currentSpot.get());
    spots.add(parkingSpot);
    return parkingSpot;
  }

  public ParkingSpot findOneByVehicleTypeAndStatusAvailable(VehicleType type) {
    for(ParkingSpot spot: spots) {
      if(spot.getSpotStatus() == SpotStatus.AVAILABLE && spot.getSpotType() == type.toSpotType()) {
        return spot;
      }
    }
    return null;
  }
}
