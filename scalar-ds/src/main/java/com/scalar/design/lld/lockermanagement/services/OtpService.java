package com.scalar.design.lld.lockermanagement.services;

import com.scalar.design.lld.lockermanagement.model.Slot;
import com.scalar.design.lld.lockermanagement.repository.ISlotOtpRepository;
import com.scalar.design.lld.lockermanagement.strategies.IOtpGeneratorStrategy;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class OtpService {
  private final ISlotOtpRepository slotOtpRepository;
  private final IOtpGeneratorStrategy otpGeneratorStrategy;

  public OtpService(ISlotOtpRepository slotOtpRepository, IOtpGeneratorStrategy iOtpGeneratorStrategy) {
    this.slotOtpRepository = slotOtpRepository;
    this.otpGeneratorStrategy = iOtpGeneratorStrategy;
  }

  public boolean validateOtp(Slot slot, String otp) {
    final String savedOtp = slotOtpRepository.getOtp(slot.getSlotId());
    return savedOtp != null && savedOtp.equals(otp);
  }

  public String generateOtp(Slot slot) {
    final String otp = otpGeneratorStrategy.generateOtp();
    slotOtpRepository.addOtp(otp, slot.getSlotId());
    return otp;
  }
}
