package com.scalar.design.lld.parkinglotv2.models;

import lombok.experimental.SuperBuilder;

/**
 * @author t0k02w6 on 18/01/23
 * @project scalar-ds
 */

@SuperBuilder
public class Payment extends BaseModel{
  private Double amount;
  private Long ticket;
  private PaymentType mode;
  private PaymentStatus status;
}
