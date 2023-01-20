package com.scalar.design.lld.parkinglotv2.models;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author t0k02w6 on 18/01/23
 * @project scalar-ds
 */
@SuperBuilder
@Getter
public class ParkingFloor extends BaseModel {
  @Builder.Default
  private List<ParkingSpot> parkingSpots = new ArrayList<>();

  private PaymentCounter paymentCounter;
}
