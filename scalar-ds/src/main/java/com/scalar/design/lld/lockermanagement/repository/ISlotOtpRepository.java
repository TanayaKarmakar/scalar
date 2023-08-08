package com.scalar.design.lld.lockermanagement.repository;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public interface ISlotOtpRepository {
  void addOtp(String otp, String slotId);

  String getOtp(String slotId);
}
