package com.scalar.design.lld.lockermanagement.controller;

import com.scalar.design.lld.lockermanagement.model.Locker;
import com.scalar.design.lld.lockermanagement.model.Size;
import com.scalar.design.lld.lockermanagement.model.Slot;
import com.scalar.design.lld.lockermanagement.services.LockerService;
import com.scalar.design.lld.lockermanagement.services.OtpService;
import java.util.List;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class LockerController {
  private final LockerService lockerService;
  private final OtpService otpService;

  public LockerController(LockerService lockerService, OtpService otpService) {
    this.lockerService = lockerService;
    this.otpService = otpService;
  }

  public Locker createLocker(String lockerId) {
    return lockerService.createLocker(lockerId);
  }

  public Slot createSlot(final Locker locker, final Size slotSize) {
    return lockerService.createSlot(locker, slotSize);
  }

  public List<Slot> getAvailableSlots() {
    return lockerService.getAllAvailableSlots();
  }

  public boolean unlockSlot(final Slot slot, final String otp) {
    return otpService.validateOtp(slot, otp);
  }

  public void deallocateSlot(final Slot slot) {
    lockerService.deallocateSlot(slot);
  }
}
