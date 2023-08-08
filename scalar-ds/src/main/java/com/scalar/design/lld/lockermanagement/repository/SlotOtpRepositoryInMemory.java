package com.scalar.design.lld.lockermanagement.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class SlotOtpRepositoryInMemory implements ISlotOtpRepository{
  private final Map<String, String> slotIdToOtpMap;

  public SlotOtpRepositoryInMemory() {
    this.slotIdToOtpMap = new HashMap<>();
  }


  @Override
  public void addOtp(String otp, String slotId) {
    slotIdToOtpMap.put(slotId, otp);
  }

  @Override
  public String getOtp(String slotId) {
    return slotIdToOtpMap.get(slotId);
  }
}
