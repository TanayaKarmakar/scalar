package com.scalar.design.lld.parkinglotv2.dtos;

import com.scalar.design.lld.parkinglotv2.models.VehicleType;
import lombok.Builder;
import lombok.Getter;

/**
 * @author t0k02w6 on 19/01/23
 * @project scalar-ds
 */
@Builder
@Getter
public class TicketRequest {
  private String vehicleNumber;
  private Long parkingLotId;
  private VehicleType type;
  private Long entryGateId;
  private Long issuerId;


}
