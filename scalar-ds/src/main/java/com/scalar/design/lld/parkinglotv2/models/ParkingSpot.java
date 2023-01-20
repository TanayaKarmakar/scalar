package com.scalar.design.lld.parkinglotv2.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author t0k02w6 on 18/01/23
 * @project scalar-ds
 */
@Getter
@SuperBuilder
@Setter
public class ParkingSpot extends BaseModel {
  private SpotType spotType;

  private SpotStatus spotStatus;

  public static ParkingSpot mediumAvailable() {
    return ParkingSpot.builder()
        .spotType(SpotType.MEDIUM)
        .spotStatus(SpotStatus.AVAILABLE)
        .build();
  }

}
