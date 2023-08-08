package com.scalar.design.lld.lockermanagement.controller;

import com.scalar.design.lld.lockermanagement.model.Buyer;
import com.scalar.design.lld.lockermanagement.model.LockerItem;
import com.scalar.design.lld.lockermanagement.model.Slot;
import com.scalar.design.lld.lockermanagement.services.LockerService;
import com.scalar.design.lld.lockermanagement.services.NotificationService;
import com.scalar.design.lld.lockermanagement.services.OtpService;

/**
 * @author t0k02w6 on 07/08/23
 * @project scalar-ds
 */
public class OrderController {
  private final LockerService lockerService;
  private final OtpService otpService;
  private final NotificationService notificationService;

  public OrderController(final LockerService lockerService, final OtpService otpService,
                         final NotificationService notificationService) {
    this.lockerService = lockerService;
    this.otpService = otpService;
    this.notificationService = notificationService;
  }

  public Slot allocateLocker(final Buyer buyer, final LockerItem lockerItem) {
    final Slot slot = lockerService.allocateSlot(lockerItem);
    final String otp = otpService.generateOtp(slot);
    notificationService.notifyUser(buyer, otp, slot);
    return slot;
  }
}
