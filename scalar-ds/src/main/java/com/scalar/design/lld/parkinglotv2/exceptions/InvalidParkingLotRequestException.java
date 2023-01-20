package com.scalar.design.lld.parkinglotv2.exceptions;

/**
 * @author t0k02w6 on 18/01/23
 * @project scalar-ds
 */
public class InvalidParkingLotRequestException extends RuntimeException {
  public InvalidParkingLotRequestException(String message) {
    super(message);
  }
}
