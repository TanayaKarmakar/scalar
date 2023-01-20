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

@Getter
@SuperBuilder
public class ParkingLot extends BaseModel {
  private String name;
  private String address;

  @Builder.Default
  private List<ParkingFloor> floors =  new ArrayList<>();

  @Builder.Default
  private List<EntryGate> entryGates = new ArrayList<>();

  @Builder.Default
  private List<ExitGate> exitGates = new ArrayList<>();
}
