package com.scalar.design.lld.parkinglotv2.repositories;

import com.scalar.design.lld.parkinglotv2.models.ParkingLot;
import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 19/01/23
 * @project scalar-ds
 */
public class ParkingLotRepository {
  private List<ParkingLot> parkingLots = new ArrayList<>();

  public ParkingLot save(ParkingLot parkingLot) {
    parkingLots.add(parkingLot);
    return parkingLot;
  }
}
