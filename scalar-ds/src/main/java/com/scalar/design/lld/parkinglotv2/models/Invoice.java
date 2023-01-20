package com.scalar.design.lld.parkinglotv2.models;

import java.util.Date;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author t0k02w6 on 18/01/23
 * @project scalar-ds
 */

@SuperBuilder
@Getter
public class Invoice extends BaseModel{
  private Date exitTime;
  private double amount;

  private Long ticketId;
  private Long paymentId;

}
