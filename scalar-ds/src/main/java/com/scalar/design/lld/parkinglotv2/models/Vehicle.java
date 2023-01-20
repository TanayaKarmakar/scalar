package com.scalar.design.lld.parkinglotv2.models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author t0k02w6 on 18/01/23
 * @project scalar-ds
 */

@SuperBuilder
@Getter
public class Vehicle extends BaseModel {
  private String licenseNumber;
  private VehicleType type;

}
