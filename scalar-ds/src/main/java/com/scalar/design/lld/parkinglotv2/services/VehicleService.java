package com.scalar.design.lld.parkinglotv2.services;

import com.scalar.design.lld.parkinglotv2.models.Vehicle;
import com.scalar.design.lld.parkinglotv2.models.VehicleType;

/**
 * @author t0k02w6 on 19/01/23
 * @project scalar-ds
 */
public class VehicleService {

  public Vehicle findOrCreate(String vehicleNumber, VehicleType type) {
    return Vehicle.builder()
        .licenseNumber(vehicleNumber)
        .type(type)
        .build();
  }
}
