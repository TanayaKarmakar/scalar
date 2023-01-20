package com.scalar.design.lld.parkinglotv2.dtos;

import com.scalar.design.lld.parkinglotv2.generators.ParkingFloorIDGenerator;
import com.scalar.design.lld.parkinglotv2.generators.ParkingSpotIDGenerator;
import com.scalar.design.lld.parkinglotv2.models.EntryGate;
import com.scalar.design.lld.parkinglotv2.models.ExitGate;
import com.scalar.design.lld.parkinglotv2.models.ParkingFloor;
import com.scalar.design.lld.parkinglotv2.models.ParkingLot;
import com.scalar.design.lld.parkinglotv2.models.ParkingSpot;
import com.scalar.design.lld.parkinglotv2.models.PaymentCounter;
import java.util.Collections;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

/**
 * @author t0k02w6 on 18/01/23
 * @project scalar-ds
 */
@Builder
@Getter
public class ParkingLotRequest {
  private Long id;
  private String name;
  private String address;
  private Integer numberOfGates;
  private Integer numberOfFloors;
  private Integer numberOfSpotsPerFloor;


  public ParkingLot toParkingLot() {
    List<ParkingSpot> parkingSpots = Collections.nCopies(numberOfSpotsPerFloor, ParkingSpot.mediumAvailable());
    parkingSpots.forEach(parkingSpot -> parkingSpot.setId(ParkingSpotIDGenerator.nextId()));

    List<ParkingFloor> parkingFloors = Collections.nCopies(numberOfFloors,
        ParkingFloor.builder()
        .parkingSpots(parkingSpots)
        .paymentCounter(PaymentCounter.builder().build())
        .build());

    parkingFloors.forEach(parkingFloor -> parkingFloor.setId(ParkingFloorIDGenerator.nextId()));

    return ParkingLot.builder()
        .id(id)
        .name(name)
        .address(address)
        .floors(parkingFloors)
        .entryGates(Collections.nCopies(numberOfFloors, EntryGate.builder().build()))
        .exitGates(Collections.nCopies(numberOfFloors, ExitGate.builder().build()))
        .build();
  }
}
